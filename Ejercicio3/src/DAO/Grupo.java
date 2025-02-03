package DAO;

import java.util.List;

public class Grupo {

	private String grupo;
	private String genero;
	private String decada;
	private List<String>discos;
	private List<String>giras;
	
	
	public Grupo(String grupo, String genero, String decada, List<String> discos, List<String> giras) {
		super();
		this.grupo = grupo;
		this.genero = genero;
		this.decada = decada;
		this.discos = discos;
		this.giras = giras;
	}
	
	
	public Grupo() {
		super();
	}




	public String getGrupo() {
		return grupo;
	}




	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}




	public String getDecada() {
		return decada;
	}




	public void setDecada(String decada) {
		this.decada = decada;
	}




	public List<String> getDiscos() {
		return discos;
	}




	public void setDiscos(List<String> discos) {
		this.discos = discos;
	}




	public List<String> getGiras() {
		return giras;
	}




	public void setGiras(List<String> giras) {
		this.giras = giras;
	}


	@Override
	public String toString() {
		return "Grupo [grupo=" + grupo + ", genero=" + genero + ", decada=" + decada + ", discos=" + discos + ", giras="
				+ giras + "]";
	}	
}

