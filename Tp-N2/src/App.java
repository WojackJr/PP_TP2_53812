import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;

public class App {//este codigo crea un evento, a ese evento se crea un objeto actividad que es un array que a este por cada posicion de actividad se le crea un array que son las inscripciones que contienen los datos de los estudiantes
    public static void main(String[] args) {
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
        evento1.crearActividad("Charla", 1, "El futuro de la Inteligencia Artificial", 50, false);
        evento1.crearActividad("Taller", 2, "Desarrollo en Java", 30, true);

        //inscripciones
        evento1.getActividades().get(0).inscribir(estudiante1);//el numero dentro del get hace referencia al numero de actividad (el 0 es el primero que se creó en el bucle)
        evento1.getActividades().get(1).inscribir(estudiante2);
        evento1.getActividades().get(0).inscribir(estudiante3);

        //la copia va al final asi agarra todos los atributos que le asigne a la original
        EventoUniversitario copiaEvento1=new EventoUniversitario(evento1);
        copiaEvento1.asignarSala(sala1);


        //evento 2
        EventoUniversitario evento2=new EventoUniversitario("2", "Jornadas de Laboratorio", 2000.0, false);
        evento2.asignarSala(sala2);

        //actividades
        evento2.crearActividad("Taller", 3, "Examinacion de sustancias", 30, false);
        evento2.crearActividad("Taller", 4, "Destilado de liquidos", 25, false);

        //inscripciones
        evento2.getActividades().get(1).inscribir(estudiante1);
        evento2.getActividades().get(0).inscribir(estudiante2);
        evento2.getActividades().get(0).inscribir(estudiante3);

        //copia evento 2
        EventoUniversitario copiaEvento2=new EventoUniversitario(evento2);
        copiaEvento2.asignarSala(sala2);

        //evento 3
        EventoUniversitario evento3=new EventoUniversitario("3", "Competencia Gaming y Bienestar", 5000.0, false);
        evento3.asignarSala(sala3);

        //actividades
        evento3.crearActividad("Taller", 5, "Torneo CS2", 30, true);
        evento3.crearActividad("Charla", 6, "Herramientas para el manejo del estrés", 40, false);

        //inscripciones
        evento3.getActividades().get(0).inscribir(estudiante1);
        evento3.getActividades().get(1).inscribir(estudiante2);
        evento3.getActividades().get(1).inscribir(estudiante3);

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