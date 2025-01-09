package DAO.Practica3;

public class Profesor {

	private int idProfesor;
    private int idDepartamento;

    public Profesor() {}

    // Constructor con parámetros
    public Profesor(int idProfesor, int idDepartamento) {
        this.idProfesor = idProfesor;
        this.idDepartamento = idDepartamento;
    }

    // Getters y setters
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}