package modelo.actividades;
import java.io.Serializable;
public class Taller extends Actividad implements Serializable{
    //atributos
    private boolean requiereNotebook;
    //constructor
    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);//usa el constructor de la calse Actividad
        this.requiereNotebook=requiereNotebook;
    }
    //metodos
    @Override
    public double calcularCostoMateriales() {
        return requiereNotebook? 5000.0 : 2000.0;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName(); //aca voy a la clase y luego extraigo su nombre
    }
}
