package jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
 
@XmlRootElement(name = "grupos")
public class Grupos {
 
    private List<Grupo> grupos;
 
    @XmlElement(name = "grupo")  // Mapea cada <grupo> en el XML a un objeto Grupo
    public List<Grupo> getGrupos() {
        return grupos;
    }
 
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grupos:\n");
        for (Grupo grupo : grupos) {
            sb.append(grupo.toString()).append("\n");
        }
        return sb.toString();
    }
}