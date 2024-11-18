package jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
 
public class Grupo {
 
    private String nombre;
    private String tutor;
    private List<String> alumnos;  // Lista de DNI como String
 
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @XmlElement(name = "tutor")
    public String getTutor() {
        return tutor;
    }
 
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
 
    @XmlElementWrapper(name = "alumnos")  // Esta anotación crea un contenedor alrededor de la lista de alumnos
    @XmlElement(name = "dni")  // Cada <dni> dentro de <alumnos> será mapeado a un elemento en la lista
    public List<String> getAlumnos() {
        return alumnos;
    }
 
    public void setAlumnos(List<String> alumnos) {
        this.alumnos = alumnos;
    }
 
    @Override
    public String toString() {
        return "Grupo: " + nombre + ", Tutor: " + tutor + ", Alumnos: " + alumnos;
    }
}