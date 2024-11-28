package ejercicio3;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio3DOM {

	public static void main(String[] args) {
		try {
			// Cargar el archivo XML
			File archXML = new File("hechos.xml");
			
			// Crear la fábrica de constructores de documentos XML
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			// Crear el constructor de documentos
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			// Parsear el archivo XML y cargarlo en un objeto Document
			Document doc = db.parse(archXML);
			
			// Normalizar el documento XML para eliminar nodos vacíos y asegurar consistencia
			doc.getDocumentElement().normalize();
			
			// Mostrar el nombre del elemento raíz del XML
			System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            // Obtener una lista de todos los nodos <hecho> en el documento
            NodeList listaHechos = doc.getElementsByTagName("hecho");
            
            // Iterar sobre cada nodo <hecho> en la lista
            for (int i = 0; i < listaHechos.getLength(); i++) {
            	
            	// Obtener el nodo actual
            	Node node = listaHechos.item(i);
            	
            	// Verificar si el nodo es de tipo ELEMENT_NODE (un nodo de elemento)
            	if (node.getNodeType() == Node.ELEMENT_NODE) {
            		
            		// Convertir el nodo a un elemento para trabajar con sus métodos específicos
            		Element hecho = (Element) listaHechos.item(i);
            		
            		// Obtener y mostrar el contenido del nodo 
            		System.out.println("\nDescripción: " + hecho.getAttribute("descripcion"));
            		System.out.println("Fecha: " + hecho.getElementsByTagName("fecha").item(0).getTextContent());
            		
            	}
            }
		} catch (Exception e) {
			// Capturar y mostrar cualquier error que ocurra durante la ejecución
			System.out.println("Ha ocurrido un error a la hora de leer el XML.");
			e.printStackTrace();
		}
	}
}