package modelo.actividades;
import modelo.Estudiante;

import java.io.Serializable;
import modelo.certificacion.Certificable;
public class Curso extends Actividad implements Serializable, Certificable {
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
        return this.getClass().getSimpleName();
    }
    @Override
    public String generarCertificado(Estudiante estudiante){
        return "Se inscribio a la actividad "+this.getTitulo()+" al estudiante "+estudiante.getNombre()+" legajo "+estudiante.getLegajo();
    }
}
