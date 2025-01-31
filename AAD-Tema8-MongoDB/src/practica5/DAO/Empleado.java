package practica5.DAO;

public class Empleado {

    private int numEmp;
    private String nombre;
    private Integer dep;       
    private Double salario;
    private String fechaAlta;
    private String oficio;
    private Integer comision;
    private String nif;         

    public Empleado() {

    }

    public Empleado(int numEmp, String nombre, Integer dep, Double salario, String fechaAlta, String oficio, Integer comision, String nif) {
        this.numEmp = numEmp;
        this.nombre = nombre;
        this.dep = dep;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.oficio = oficio;
        this.comision = comision;
        this.nif = nif;
    }


    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDep() {
        return dep;
    }

    public void setDep(Integer dep) {
        this.dep = dep;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Integer getComision() {
        return comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "\nEmpleado número " + numEmp + "\nNombre: " + nombre + "\nDepartamento: " + dep + "\nSalario: " + salario + "\nFecha de Alta: " + fechaAlta + "\nOficio: " + oficio + "\nComisión: " + comision + "\nNIF: " + nif;
    }
}