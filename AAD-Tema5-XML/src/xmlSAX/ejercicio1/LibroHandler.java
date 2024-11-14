package xmlSAX.ejercicio1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LibroHandler extends DefaultHandler {
    private boolean esTitulo = false;
    private boolean esAutor = false;
    private boolean esPrecio = false;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Inicio del documento XML.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento XML.");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("libro")) {
            String id = attributes.getValue("id");
            System.out.println("ID del libro: " + id);
        } else if (qName.equalsIgnoreCase("titulo")) {
            esTitulo = true;
        } else if (qName.equalsIgnoreCase("autor")) {
            esAutor = true;
        } else if (qName.equalsIgnoreCase("precio")) {
            esPrecio = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("libro")) {
            System.out.println("Fin de libro\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esTitulo) {
            System.out.println("Título: " + new String(ch, start, length));
            esTitulo = false;
        } else if (esAutor) {
            System.out.println("Autor: " + new String(ch, start, length));
            esAutor = false;
        } else if (esPrecio) {
            System.out.println("Precio: " + new String(ch, start, length));
            esPrecio = false;
        }
    }
}
