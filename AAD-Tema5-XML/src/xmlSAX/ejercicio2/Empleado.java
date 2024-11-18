package xmlSAX.ejercicio2;

public class Empleado {
	int id, edad;
	String nombre, genero, trabajo;

	@Override
	public String toString() {
		return "Empleado ID=" + this.id + " Nombre: " + this.nombre + ", Edad: " + this.edad + ", Genero: "
				+ this.genero + ", Trabajo: " + this.trabajo;
	}

	public Empleado(int id, int edad, String nombre, String genero, String trabajo) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.genero = genero;
		this.trabajo = trabajo;
	}

	public Empleado() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

}