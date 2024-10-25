package Serializacion.Practica2Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    private String dni;
    private String nombre;
    private double notaAD;
    
    public Alumno(String dni, String nombre, double notaAD) {
        this.dni = dni;
        this.nombre = nombre;
        this.notaAD = notaAD;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(double notaAD) {
        this.notaAD = notaAD;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Nota AD: " + notaAD;
    }
}


