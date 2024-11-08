package xmlDOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
Deberás crear una aplicación Java que permita obtener toda la información contenida en el XML adjunto.
Ten en cuenta que deberán mostrarse por pantalla todos los datos referentes a los atributos y elementos del fichero.
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			File archXML = new File("ciudades.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(archXML);
			
			doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            NodeList listaCiudades = doc.getElementsByTagName("ciudad");
            for (int i = 0; i < listaCiudades.getLength(); i++) {
            	Element ciudad = (Element) listaCiudades.item(i);
            		System.out.println("\nNombre Ciudad: " + ciudad.getElementsByTagName("nombre").item(0).getTextContent());
            		System.out.println("Continente del Pais ID: " + ciudad.getAttribute("continente"));
            		System.out.println("País: " + ciudad.getElementsByTagName("pais").item(0).getTextContent());
             
            }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
	}

}
