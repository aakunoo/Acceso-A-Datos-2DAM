package ModificarXML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ModificarXML {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File inputFile = new File("empleados.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
 
            // Obtener todos los elementos <empleado>
            NodeList nList = doc.getElementsByTagName("empleado");
 
            // Modificar el salario del empleado con id 1
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("id").equals("1")) {
                        eElement.getElementsByTagName("salario").item(0).setTextContent("6000");
                    }
                }
            }
 
            // Guardar los cambios en un nuevo archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("modificado_empleados.xml"));
            transformer.transform(source, result);
 
            System.out.println("El fichero XML ha sido modificado correctamente");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
