import exepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;
import modelo.actividades.Actividad;
import modelo.actividades.Taller;
import modelo.certificacion.Certificable;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {//este codigo crea un evento, a ese evento se crea un objeto actividad que es un array que a este por cada posicion de actividad se le crea un array que son las inscripciones que contienen los datos de los estudiantes
    public static void main(String[] args) throws IOException {
        System.out.println("REGISTRO DE EVENTOS\n" + "===================");
        System.out.println("Inicializador estatico: se cargo la clase EventoUniversitario.");

        //se crean las salas
        Sala sala1=new Sala(1, "LISUN");
        Sala sala2=new Sala(2, "Laboratorio");
        Sala sala3=new Sala(3, "SUM");

        //creacion de estudiantes
        Estudiante estudiante1=new Estudiante("53812", "Brian vizzioli");
        Estudiante estudiante2=new Estudiante("53283", "Martin Martines");
        Estudiante estudiante3=new Estudiante("48294", "Pedro Gonzales");


        //evento 1
        EventoUniversitario evento1=new EventoUniversitario("1", "Informática", 1500.0, false);
        evento1.asignarSala(sala1);

        // actividades del evento 1
        evento1.crearActividad("Charla", 1, "El futuro de la Inteligencia Artificial", 1, false);
        evento1.crearActividad("Taller", 2, "Desarrollo en Java", 30, true);

        //inscripciones
        try {
            evento1.getActividades().get(0).inscribir(estudiante1);//el numero dentro del get hace referencia al numero de actividad (el 0 es el primero que se creó en el bucle)
            evento1.getActividades().get(1).inscribir(estudiante2);
            evento1.getActividades().get(0).inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("[ERROR DE INSCRIPCION]: "+e.getMessage()+" '"+evento1.getActividades().get(0).getTitulo()+"'");}//el sout es para que muestre el error, el e.getMessage() llama al texto.

        //genero certificados de inscripcion para el evento 1

        System.out.println("==========CERTIFICADOS==========\n"+Certificable.ENTIDAD_EMISORA);
        for (Actividad i : evento1.getActividades()) {//recorro las actividades de este evento
            if (i instanceof Certificable) {//debo buscar mejor como funciona este bloque
                Certificable certificable=(Certificable) i;
                String textoCertificado=certificable.generarCertificado(estudiante1);
                System.out.println(textoCertificado);
            }
        }

        //la copia va al final asi agarra todos los atributos que le asigne a la original
        EventoUniversitario copiaEvento1=new EventoUniversitario(evento1);
        copiaEvento1.asignarSala(sala1);

        //empieza el bloque de persistir evento

        try { //bloque de intento para persistir el evento.

            evento1.persistirEvento();

            EventoUniversitario copiaDesdeArchivo =
                    evento1.recuperarEvento(evento1.getId());

            System.out.println("\n\nDATOS DEL EVENTO");
            evento1.mostrarDatos();

            System.out.println(
                    "\nDatos del evento recuperado desde archivo:"
            );

            copiaDesdeArchivo.mostrarDatos();

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Error 01: No se encontró el archivo del evento: "
                            + e.getMessage()
            );

        } catch (IOException e) {

            System.out.println(
                    "Se produjo un error de entrada/salida: "
                            + e.getMessage()
            );
        }
        //termina el bloque de persistir el evento

        //evento 2
        EventoUniversitario evento2=new EventoUniversitario("2", "Jornadas de Laboratorio", 2000.0, false);
        evento2.asignarSala(sala2);

        //actividades
        evento2.crearActividad("Taller", 3, "Examinacion de sustancias", 30, false);
        evento2.crearActividad("Taller", 4, "Destilado de liquidos", 25, false);

        //inscripciones
        try {
            evento2.getActividades().get(1).inscribir(estudiante1);
            evento2.getActividades().get(0).inscribir(estudiante2);
            evento2.getActividades().get(0).inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("[ERROR DE INSCRIPCION]: "+e.getMessage());
        }

        //copia evento 2
        EventoUniversitario copiaEvento2=new EventoUniversitario(evento2);
        copiaEvento2.asignarSala(sala2);

        //evento 3
        EventoUniversitario evento3=new EventoUniversitario("3", "Competencia Gaming y Bienestar", 5000.0, false);
        evento3.asignarSala(sala3);

        //actividades
        evento3.crearActividad("Taller", 5, "Torneo CS2", 0, true);
        evento3.crearActividad("Charla", 6, "Herramientas para el manejo del estrés", 30, false);

        //inscripciones
        try {
            evento3.getActividades().get(0).inscribir(estudiante1);
            evento3.getActividades().get(1).inscribir(estudiante2);
            evento3.getActividades().get(1).inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("[ERROR DE INSCRIPCION]: "+e.getMessage()+" '"+evento3.getActividades().get(0).getTitulo()+"'");
        }
        //copia evento 3
        EventoUniversitario copiaEvento3=new EventoUniversitario(evento3);
        copiaEvento3.asignarSala(sala3);

        //mostrar todos los datos
        evento1.mostrarDatos();
        copiaEvento1.mostrarDatos();

        evento2.mostrarDatos();
        copiaEvento2.mostrarDatos();

        evento3.mostrarDatos();
        copiaEvento3.mostrarDatos();

        //aca se muestra la cantidaad total de eventos creados
        System.out.println("Cantidad de eventos creados: "+EventoUniversitario.getCantEventos());
    }
}