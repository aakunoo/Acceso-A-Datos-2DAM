package xmlSAX.ejercicio2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Principal {

	public static void main(String[] args) {

        try {
            // Crear una instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Crear un parser SAX
            SAXParser saxParser = factory.newSAXParser();

            // Crear una instancia del manejador
            Manejadora handler = new Manejadora();

            // Analizar el archivo XML
            saxParser.parse("empleadosXMLSAX.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}