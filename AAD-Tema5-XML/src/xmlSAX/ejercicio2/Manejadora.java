package xmlSAX.ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejadora extends DefaultHandler {
	private boolean esEdad = false;
	private boolean esNombre = false;
	private boolean esGenero = false;
	private boolean esTrabajo = false;
	private Empleado emp;

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
		if (qName.equalsIgnoreCase("empleado")) {
			emp = new Empleado();
			String id = attributes.getValue("id");
			emp.setId(Integer.parseInt(id));
		} else if (qName.equalsIgnoreCase("edad")) {
			esEdad = true;
		} else if (qName.equalsIgnoreCase("nombre")) {
			esNombre = true;
		} else if (qName.equalsIgnoreCase("genero")) {
			esGenero = true;
		} else if (qName.equalsIgnoreCase("trabajo")) {
			esTrabajo = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("empleado")) {
			System.out.println(emp);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (esEdad) {
			emp.setEdad(Integer.parseInt(new String(ch, start, length)));
			esEdad = false;
		} else if (esNombre) {
			emp.setNombre(new String(ch, start, length));
			esNombre = false;
		} else if (esGenero) {
			emp.setGenero(new String(ch, start, length));
			esGenero = false;
		} else if (esTrabajo) {
			emp.setTrabajo(new String(ch, start, length));
			esTrabajo = false;

		}

	}
}