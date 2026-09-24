package modelo.actividades;
import java.io.Serializable;
import modelo.certificacion.Certificable;//importo la intefaz para poder imprementarla a la clase
import modelo.Estudiante;
public class Taller extends Actividad implements Serializable, Certificable{
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
    @Override
    public String generarCertificado(Estudiante estudiante){
    return "Se inscribio a la actividad "+this.getTitulo()+" al estudiante "+estudiante.getNombre()+" legajo "+estudiante.getLegajo();
    }
}
