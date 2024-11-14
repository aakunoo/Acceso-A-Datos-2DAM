package xmlSAX.ejercicio1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xmlSAX.ejercicio1.LibroHandler;


public class Ejercicio1 extends DefaultHandler{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Crear una instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Crear un parser SAX
            SAXParser saxParser = factory.newSAXParser();

            // Crear una instancia del manejador
            LibroHandler handler = new LibroHandler();

            // Analizar el archivo XML
            saxParser.parse("libros.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
 

	}

}
