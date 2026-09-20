package modelo;
import java.io.Serializable;
public class Estudiante implements Serializable{
    private String legajo;
    private String nombre;
    //constructores

    public Estudiante(String legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
    }

    //getters and setters

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
