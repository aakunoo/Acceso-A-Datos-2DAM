package practicas.practica9;

public class PartidoFutbol {

    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    // Constructor por defecto
    public PartidoFutbol() {
        this.equipoLocal = "";
        this.equipoVisitante = "";
        this.golesLocal = 0;
        this.golesVisitante = 0;
    }

    // Constructor con parámetros
    public PartidoFutbol(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    // Getters y Setters
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    @Override
    public String toString() {
        return equipoLocal + " " + golesLocal + " - " + equipoVisitante + " " + golesVisitante;
    }
}
