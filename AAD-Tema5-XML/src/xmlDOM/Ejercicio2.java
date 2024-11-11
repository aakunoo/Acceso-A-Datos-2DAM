package xmlDOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
Deberás crear una aplicación Java que permita obtener toda la información contenida en el XML adjunto.
Ten en cuenta que deberán mostrarse por pantalla todos los datos referentes a los atributos y elementos del fichero.
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			File archXML = new File("ciudades.xml");
			// Instancia de DocumentBuilderFactory y DocumentBuilder para analizar el XML
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archXML); // Parsear el archivo XML y obtener el documento DOM
			
			doc.getDocumentElement().normalize(); // normalizar XML.
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            NodeList listaCiudades = doc.getElementsByTagName("ciudad"); // Sacar todos los nodos llamados ciudad.
            
            for (int i = 0; i < listaCiudades.getLength(); i++) {
            	
            	Node node = listaCiudades.item(i);
            	
            	if(node.getNodeType()==Node.ELEMENT_NODE) { // Verificar si el nodo es un nodo de elemento
            		
            		Element ciudad = (Element) listaCiudades.item(i); // Convierte cada elemento de la lista NodeList en un Element para poder trabajar con él.
            			System.out.println("\nNombre Ciudad: " + ciudad.getElementsByTagName("nombre").item(0).getTextContent());
            			System.out.println("Continente del Pais ID: " + ciudad.getElementsByTagName("pais").item(0).getAttributes().getNamedItem("continente").getTextContent());
            			System.out.println("País: " + ciudad.getElementsByTagName("pais").item(0).getTextContent());
            	}
            }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
	}

}
