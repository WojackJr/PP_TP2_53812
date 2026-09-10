package modelo;
import modelo.actividades.Actividad;

import java.time.LocalDate;
public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    //atributos que hace referencia a la asociacion
    private Actividad actividad;
    private Estudiante estudiante;
    //constructor

    public Inscripcion(LocalDate fecha, String estado, Actividad actividad, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.actividad = actividad;
        this.estudiante = estudiante;
    }

    //getter and setter

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
}
