package modelo.actividades;
import java.io.Serializable;

public class Curso extends Actividad implements Serializable {
    //atributos
    private int nivel;
    //constructor
    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "";
    }
}
