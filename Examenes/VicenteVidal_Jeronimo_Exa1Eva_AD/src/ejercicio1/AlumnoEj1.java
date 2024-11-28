package ejercicio1;

public class AlumnoEj1 {

	
	String nombre;
	String grupo;
	double nota_media;
	double nota1eva;
	double nota2eva;
	
	
	public AlumnoEj1(String nombre, String grupo, double nota_media, double nota1eva, double nota2eva) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
		this.nota_media = nota_media;
		this.nota1eva = nota1eva;
		this.nota2eva = nota2eva;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public double getNota_media() {
		return nota_media;
	}

	public void setNota_media(double nota_media) {
		this.nota_media = nota_media;
	}

	public double getNota1eva() {
		return nota1eva;
	}

	public void setNota1eva(double nota1eva) {
		this.nota1eva = nota1eva;
	}

	public double getNota2eva() {
		return nota2eva;
	}

	public void setNota2eva(double nota2eva) {
		this.nota2eva = nota2eva;
	}

	@Override
	public String toString() {
		return "AlumnoEj1 [nombre=" + nombre + ", grupo=" + grupo + ", nota_media=" + nota_media + ", nota1eva="
				+ nota1eva + ", nota2eva=" + nota2eva + "]";
	}


	
	
	
	
}
