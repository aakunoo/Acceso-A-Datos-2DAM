package prog;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private List <Cliente> clientes;
	private List <Producto> productos;
	
	
	public Supermercado() {
		super();
		clientes = new ArrayList<>();	
		productos = new ArrayList<>();
		}
	
	public Supermercado(List<Cliente> clientes, List<Producto> productos) {
		super();
		this.clientes = new ArrayList<>();
		this.productos = new ArrayList<>();
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Cliente altaCliente(String dni, String nombre, String apellido, String direccion) {
		
		for(Cliente c : clientes) {
			if(c.getDni().equalsIgnoreCase(dni)) {
				
				return c;
			}
		}
		Cliente nuevo = new Cliente(dni, nombre, apellido, direccion);
		clientes.add(nuevo);
		return nuevo;
	}
}
