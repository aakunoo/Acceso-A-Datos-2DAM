package practicaCasa;

public class Alumno {

	private String nombre;
	private String telefono;
	private String curso;
	private int nota;
	private int edad;
	private String poblacion;
	
	
	
	public Alumno() {
		super();
	}



	public Alumno(String nombre, String telefono, String curso, int nota, int edad, String poblacion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.curso = curso;
		this.nota = nota;
		this.edad = edad;
		this.poblacion = poblacion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public int getNota() {
		return nota;
	}



	public void setNota(int nota) {
		this.nota = nota;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getPoblacion() {
		return poblacion;
	}



	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}



	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", telefono=" + telefono + ", curso=" + curso + ", nota=" + nota + ", edad="
				+ edad + ", poblacion=" + poblacion + "]";
	}
	
	
	
}
