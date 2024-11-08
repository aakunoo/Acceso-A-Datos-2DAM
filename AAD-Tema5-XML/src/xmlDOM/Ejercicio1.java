package xmlDOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

/*
  	Deberás crear una aplicación Java que permita obtener toda la información contenida en el XML adjunto.
	Ten en cuenta que deberán mostrarse por pantalla todos los datos referentes a los atributos y elementos del fichero.
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			File archXML = new File("coches.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(archXML);
			doc.getDocumentElement().normalize();
			
			Element elemraiz = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + elemraiz.getNodeName());
            NodeList listaCoches = doc.getElementsByTagName("coche");
			
            for(int i = 0; i < listaCoches.getLength(); i++ ) {
            	
            	Node nodoCoche = listaCoches.item(i);
           
            	if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
            		Element elemCoche = (Element) nodoCoche;
            		String idCoche = elemCoche.getAttribute("id");
                    System.out.println("\nCoche ID: " + idCoche);

                    NodeList listaElementos = elemCoche.getChildNodes();
                    for (int j = 0; j < listaElementos.getLength(); j++) {
                        Node nodoHijo = listaElementos.item(j);

                        if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoHijo = (Element) nodoHijo;
                            System.out.println(elementoHijo.getTagName() + ": " + elementoHijo.getTextContent());
                        }
                    }
            	}
            }
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

}
