package DAO.Practica3;

public class Asignatura {
    private int id;
    private String nombre;
    private double creditos;
    private String tipo;
    private int curso;
    private int cuatrimestre;
    private Integer idProfesor; // Puede ser null
    private int idGrado;

    public Asignatura(int id, String nombre, double creditos, String tipo, int curso, int cuatrimestre, Integer idProfesor, int idGrado) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        this.curso = curso;
        this.cuatrimestre = cuatrimestre;
        this.idProfesor = idProfesor;
        this.idGrado = idGrado;
    }

    public Asignatura() {}

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
}
