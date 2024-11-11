package crearXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Ejercicio1 {
	
	// Crear Documento XML. Jerónimo Vicente.

	public static void main(String[] args) {
		
		try {
			
			// Empleado 1
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.newDocument();
			
			Element raiz = doc.createElement("empleados");
			doc.appendChild(raiz);
			
			Element empleado = doc.createElement("empleado");
			raiz.appendChild(empleado);
			empleado.setAttribute("id", "1");
			
//			Attr atributo = doc.createAttribute("id");
//			atributo.setValue("1");
//			empleado.setAttributeNode(atributo);
			
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode("Juan Perez"));
			empleado.appendChild(nombre);
			
			Element departamento = doc.createElement("departamento");
			departamento.appendChild(doc.createTextNode("IT"));
			empleado.appendChild(departamento);
			
			Element salario = doc.createElement("salario");
			salario.appendChild(doc.createTextNode("5000"));
			empleado.appendChild(salario);
			
			// -----------------------------------------------------------------------
			
			// Empleado 2
			
			Element empleado2 = doc.createElement("empleado");
			raiz.appendChild(empleado2);
			empleado2.setAttribute("id", "2");
			
//			Attr atributo2 = doc.createAttribute("id");
//			atributo2.setValue("2");
//			empleado2.setAttributeNode(atributo2);
			
			Element nombre2 = doc.createElement("nombre");
			nombre2.appendChild(doc.createTextNode("Ana García"));
			empleado2.appendChild(nombre2);
			
			Element departamento2 = doc.createElement("departamento");
			departamento2.appendChild(doc.createTextNode("HR"));
			empleado2.appendChild(departamento2);
			
			Element salario2 = doc.createElement("salario");
			salario2.appendChild(doc.createTextNode("4500"));
			empleado2.appendChild(salario2);

			// -----------------------------------------------------------------------
			
			// Escribir XML.
			
			TransformerFactory tfactory = TransformerFactory.newInstance(); // Transformer se usa para escribir el contenido del Document en un archivo XML.
			Transformer transformer = tfactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("empleados.xml"));

			try {
			    transformer.transform(source, result);
			    System.out.println("Archivo XML guardado como empleados.xml");
			} catch (TransformerException e) {
			    e.printStackTrace();
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
