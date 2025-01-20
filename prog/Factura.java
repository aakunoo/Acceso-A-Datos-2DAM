package prog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	private int identificador;
	private String DNI;
	private float importeTotal;
	private List <lineaVenta> detalle;
	
	
	public Factura() {
		super();
		detalle = new ArrayList<>();
	}


	public Factura(int identificador, String dNI) {
		super();
		this.identificador = identificador;
		DNI = dNI;
		this.detalle = new ArrayList<>();
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public float getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}


	public List<lineaVenta> getDetalle() {
		return detalle;
	}


	public void setDetalle(List<lineaVenta> detalle) {
		this.detalle = detalle;
	}
	
	public void addLineaVenta(lineaVenta lv) {
		
		this.detalle.add(lv);
		
	}
	
	
}
