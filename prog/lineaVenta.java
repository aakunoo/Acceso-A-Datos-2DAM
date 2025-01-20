package prog;

import java.io.Serializable;

public class lineaVenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int unidadesVendidas;
	private float pvp;
	
	
	public lineaVenta() {
		super();
		
	}


	public lineaVenta(String nombre, int unidadesVendidas, float pvp) {
		super();
		this.nombre = nombre;
		this.unidadesVendidas = unidadesVendidas;
		this.pvp = pvp;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}


	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}


	public float getPvp() {
		return pvp;
	}


	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	
	
	
}
