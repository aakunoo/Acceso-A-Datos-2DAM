package DAO;

import java.sql.Date;

public class Multa {
	
	private int codMulta;
	private String descripcion;
	private int codPersonaMultada;
	private int codAgente;
	private int importeSancion;
	private int puntosSancion;
	private Date fechaMulta;
	
	
	public Multa(int codMulta, String descripcion, int codPersonaMultada, int codAgente, int importeSancion,
			int puntosSancion, Date fechaMulta) {
		super();
		this.codMulta = codMulta;
		this.descripcion = descripcion;
		this.codPersonaMultada = codPersonaMultada;
		this.codAgente = codAgente;
		this.importeSancion = importeSancion;
		this.puntosSancion = puntosSancion;
		this.fechaMulta = fechaMulta;
	}


	public Multa() {
		super();
	}


	public int getCodMulta() {
		return codMulta;
	}


	public void setCodMulta(int codMulta) {
		this.codMulta = codMulta;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCodPersonaMultada() {
		return codPersonaMultada;
	}


	public void setCodPersonaMultada(int codPersonaMultada) {
		this.codPersonaMultada = codPersonaMultada;
	}


	public int getCodAgente() {
		return codAgente;
	}


	public void setCodAgente(int codAgente) {
		this.codAgente = codAgente;
	}


	public int getImporteSancion() {
		return importeSancion;
	}


	public void setImporteSancion(int importeSancion) {
		this.importeSancion = importeSancion;
	}


	public int getPuntosSancion() {
		return puntosSancion;
	}


	public void setPuntosSancion(int puntosSancion) {
		this.puntosSancion = puntosSancion;
	}


	public Date getFechaMulta() {
		return fechaMulta;
	}


	public void setFechaMulta(Date fechaMulta) {
		this.fechaMulta = fechaMulta;
	}


	@Override
	public String toString() {
		return "Multa [codMulta=" + codMulta + ", descripcion=" + descripcion + ", codPersonaMultada="
				+ codPersonaMultada + ", codAgente=" + codAgente + ", importeSancion=" + importeSancion
				+ ", puntosSancion=" + puntosSancion + ", fechaMulta=" + fechaMulta + "]";
	}
	
	
	
	
	

}
