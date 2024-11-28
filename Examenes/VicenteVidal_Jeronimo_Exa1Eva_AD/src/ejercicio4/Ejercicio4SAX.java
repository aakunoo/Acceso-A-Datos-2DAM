package ejercicio4;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Ejercicio4SAX {

	public static void main(String[] args) {
		try {
	            // Crear una instancia de SAXParserFactory
	            SAXParserFactory factory = SAXParserFactory.newInstance();

	            // Crear un parser SAX
	            SAXParser saxParser = factory.newSAXParser();

	            // Crear una instancia del manejador
	            Manejadora handler = new Manejadora();

	            // Analizar el archivo XML
	            saxParser.parse("C:\\Users\\Manana.DESKTOP-0QML5MI\\Desktop\\Acceso a Datos\\VicenteVidal_Jeronimo_Exa1Eva_AD\\src\\ejercicio4\\pom.xml", handler);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}

	

	