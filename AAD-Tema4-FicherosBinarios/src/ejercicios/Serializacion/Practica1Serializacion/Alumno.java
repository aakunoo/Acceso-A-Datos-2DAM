package ejercicios.Serializacion.Practica1Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
    private String nombre;
    private String apellidos;
    private double notaAD;
    
    public Alumno(String nombre, String apellidos, double notaAD) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notaAD = notaAD;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(double notaAD) {
        this.notaAD = notaAD;
    }
    
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', apellidos= " + apellidos + ",notas= " + notaAD +'}';
    }

    
}
