package modelo;
import java.io.Serializable;
public class Sala implements Serializable{
    private int id;
    private String nombre;
    //getter and setter
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //construtor

    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
