package xmlDOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

/*
   Deberás crear una aplicación Java que permita obtener toda la información contenida en el XML adjunto.
   Ten en cuenta que deberán mostrarse por pantalla todos los datos referentes a los atributos y elementos del fichero.
 */

public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            File archivoXML = new File("coches.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(archivoXML);

            doc.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            NodeList listaCoches = doc.getElementsByTagName("coche");
            for (int i = 0; i < listaCoches.getLength(); i++) {
                Element coche = (Element) listaCoches.item(i);
                System.out.println("\nCoche ID: " + coche.getAttribute("id"));
                System.out.println("Marca: " + coche.getElementsByTagName("marca").item(0).getTextContent());
                System.out.println("Modelo: " + coche.getElementsByTagName("modelo").item(0).getTextContent());
                System.out.println("Cilindrada: " + coche.getElementsByTagName("cilindrada").item(0).getTextContent());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
