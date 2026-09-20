package modelo;
//if ternario, ejemplo: this.costoBase=gratuito ? 0 : costo;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Taller;
import java.util.ArrayList;
import java.util.List;
//persistir evento
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
//recuperar evento
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EventoUniversitario implements Serializable {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantEventos;
    //parametro de la sala (agregacion)
    private Sala sala;
    //cuando un elemento en el uml esta subrayado hace referencia a que el atributo es static
//array para crear actividades
    private List<Actividad> actividades; //como es una composicion con actiividad no ponog el 'new= ArrayList<>() ; solo va en el constructor

    //constructor
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        if (costoBase == 0) {
            gratuito = true;
        }
        this.gratuito = gratuito;
        cantEventos++;
        //inicializo el array de las actividades
        this.actividades = new ArrayList<>();
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id + "-COPIA";
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantEventos++;
        this.actividades = new ArrayList<>();//agrego a la copia tambien
        if (otro.actividades != null) {
            for (Actividad act : otro.actividades) {
                this.actividades.add(act);
            }
        }
    }
    //getter and setter

    public List<Actividad> getActividades() {//getter de actividades
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {//setter de actividades
        this.actividades = actividades;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public static int getCantEventos() {
        return cantEventos;
    }

    //metodos
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0.0;
        }
        double costoTotalActividades = 0;

        for (Actividad act : this.actividades) {//recorremos las actividades para saber si es charla o taller, y devolvera un valor distinto
            costoTotalActividades += act.calcularCostoMateriales();
        }
        return (this.costoBase + costoTotalActividades) * 1.21;
    }

    public void mostrarDatos() {
        //evento original
        System.out.println("\n=====================" + "\nID: EVT-" + id + "\nTítulo: " + titulo/*ahora concateno para mostrar la informacion de sala y las inscrpociones*/ + "\nSala: " + this.sala.getNombre() + "\n----------------------" + "\nInscripciones:");
        for (Actividad actividad : this.actividades) {//para mostrar las actividades del evento debo acceder al array actividades y dentro de la actividad entrar al array inscripciones llamando al metodo mostrarInscripciones() que esta enla clase Actividad
            actividad.mostrarInscripciones();
        }
        ;
        if (!gratuito) {
            System.out.println("Costo: $" + calcularCostoEstimado());
        } else {
            System.out.println("Es gratuito ");
        }
        System.out.println("------------------------------");
    }

    //metodo para asignar sala
    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    //metodo para crear actividad
    public void crearActividad(String tipo, int id, String titulo, int cupo, boolean notebook) {
        Actividad nuevaActividad = null;
        if (tipo.equalsIgnoreCase("Charla")) {//equalsIgnoreCase ignora si esta en mayusculkas o minusculas
            nuevaActividad = new Charla(id, titulo, cupo);
        } else if (tipo.equalsIgnoreCase("Taller")) {
            nuevaActividad = new Taller(id, titulo, cupo, notebook);
        }
        if (nuevaActividad != null) {
            this.actividades.add(nuevaActividad);
        }
    }

    //mostrar datos de la actividad creada
    public void mostrarDatosActividad() {
        for (Actividad k : this.actividades) {
            System.out.println("------------------------------\n" + "Nombre Actividad: " + k.getTitulo() + "\nID: " + k.getId() + "\nCantidad de cupos: " + k.getCupoMaximo());
        }
    }

    //metodo persistir evento
    public boolean persistirEvento() throws IOException {
        String nombreArchivo = "evento_" + this.id + ".telAviv"; //el nombre debe ser el mismo cuando lo reconstruyo en el metodo recuperarEvento
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(this);
            return true;
        }
    }
    //metodo recuperar evento
    public EventoUniversitario recuperarEvento(String id)  throws IOException, ClassNotFoundException {

        String nombreArchivo = "evento_" + id + ".telAviv";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (EventoUniversitario) ois.readObject();
        }
    }
}

