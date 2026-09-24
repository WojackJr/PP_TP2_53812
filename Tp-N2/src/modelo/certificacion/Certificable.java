package modelo.certificacion;

import modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA="UTN-FRM";//atributo que es public static final por defecto
    String generarCertificado(Estudiante estudiante);//solo se especifica qué devuelve, cómo se llama y qué parámetros recibe, no lleva llaves {} porque no tiene implementación.
}
