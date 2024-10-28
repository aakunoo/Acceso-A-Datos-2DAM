package Serializacion.Practica2Serializacion;

public class DNIException extends Exception {
    public static final String LONGITUD_NO_CORRECTA = "La longitud debe estar entre 8 y 9 caracteres";
    public static final String PARTE_NUMERICA_NO_CORRECTA = "La parte numérica del DNI debe ser un número";
    public static final String PARTE_LETRA_NO_CORRECTA = "La letra del DNI debe estar entre A y Z";
    public static final String FORMATO_NO_CORRECTO = "El formato del DNI es incorrecto";

    public DNIException(String mensaje) {
        super(mensaje);
    }
}
