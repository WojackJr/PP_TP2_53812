package modelo.actividades;
import exepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public abstract class Actividad implements Serializable{
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int cupoMinimo = 2;
    //relacion 0 a muchos con estudiante para inscripcion
    private List<Inscripcion> inscripcion=new ArrayList<>();
    //constructores

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
    //metodos
    public Inscripcion inscribir (Estudiante estudiante) throws CupoExcedidoException {//throws es para llamar la clase de excepcion y dropear el mensaje de error
        if(inscripcion.size() == cupoMaximo){
            throw new CupoExcedidoException("No se puede inscribir al almuno "+estudiante.getNombre()+" porque se alcanzó el cupo máximo para esta actividad");
        }
        Inscripcion nuevaInscripcion=new Inscripcion(LocalDate.now(), "Inscripto", this, estudiante);//pongo 'this' donde va la actividad para enviarse a si mismo.
        this.inscripcion.add(nuevaInscripcion);
        return nuevaInscripcion;
    }
    public void mostrarInscripciones(){
        for (Inscripcion i : this.inscripcion){
            System.out.println("----------------------\n"+"Estudiante: "+i.getEstudiante().getNombre()+" - Legajo: "+i.getEstudiante().getLegajo()+" - Estado: "+i.getEstado() + "\nFecha: "+i.getFecha());
            mostrarIdentificacion();
        }
    }
    //metodo final de la actividad 3
    final public void mostrarIdentificacion(){
        System.out.println("Actividad ID: "+this.id+" | Tipo: "+getTipo()+" | Título: "+this.titulo);
    }
    //metodos para que hereden las subclases
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();
}
