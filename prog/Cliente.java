package prog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private List <Factura> factura;
	
	
	public Cliente() {
		super();
		factura = new ArrayList<>();
	}


	public Cliente(String dni, String nombre, String apellido, String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.factura = new ArrayList<>();
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<Factura> getFactura() {
		return factura;
	}


	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}

	public void addFactura(Factura f) {

		this.factura.add(f);
	}
	
	
}
