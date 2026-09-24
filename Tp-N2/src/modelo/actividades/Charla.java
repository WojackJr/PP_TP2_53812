package modelo.actividades;
import java.io.Serializable;
public class Charla extends Actividad implements Serializable{
    //atributos
    private String disertante;//deberia agregarlo al constrructor, debajo de la declaracion del super
    public Charla(int id, String titulo, int cupoMaximo) {
        super(id, titulo, cupoMaximo);
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0;
    }

    @Override
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
