package ejercicio2;

import java.io.Serializable;

public class CFEj2 implements Serializable{

	
	String nombreCiclo;
	String grado;
	int horasCiclo;
	
	
	@Override
	public String toString() {
		return "Ciclo Formativo: " + nombreCiclo + ", Grado: " + grado + ", Horas: " + horasCiclo;
	}
	
	public CFEj2(String nombreCiclo, String grado, int horasCiclo) {
		super();
		this.nombreCiclo = nombreCiclo;
		this.grado = grado;
		this.horasCiclo = horasCiclo;
		
	}
	
	public String getNombreCiclo() {
		return nombreCiclo;
	}
	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public int getHorasCiclo() {
		return horasCiclo;
	}
	public void setHorasCiclo(int horasCiclo) {
		this.horasCiclo = horasCiclo;
	}
	
	
	
}
