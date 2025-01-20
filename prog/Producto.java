package prog;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private float precio;
	private float tipoIVA;
	private int unidadesDisponibles;
	
	
	public Producto() {
		super();
	}

	
	

	public Producto(String nombre, float precio, float tipoIVA, int unidadesDisponibles) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.tipoIVA = tipoIVA;
		this.unidadesDisponibles = unidadesDisponibles;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public float getTipoIVA() {
		return tipoIVA;
	}


	public void setTipoIVA(float tipoIVA) {
		this.tipoIVA = tipoIVA;
	}


	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}


	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	
	
	
}
