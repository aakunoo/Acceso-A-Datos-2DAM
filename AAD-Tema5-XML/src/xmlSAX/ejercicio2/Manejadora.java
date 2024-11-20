package xmlSAX.ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// Clase manejadora que extiende DefaultHandler para procesar un archivo XML utilizando SAX.
public class Manejadora extends DefaultHandler {
	
	// Variables booleanas para identificar en qué elemento del XML se encuentra el parser.
	private boolean esEdad = false;
	private boolean esNombre = false;
	private boolean esGenero = false;
	private boolean esTrabajo = false;
	
	// Objeto Empleado que se crea y llena con datos al procesar cada elemento <empleado>.
	private Empleado emp;

	// Método llamado al inicio del documento XML.
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio del documento XML.");
	}

	// Método llamado al final del documento XML.
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fin del documento XML.");
	}

	// Método llamado al inicio de cada elemento en el XML.
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Si el elemento es <empleado>, se crea un nuevo objeto Empleado.
		if (qName.equalsIgnoreCase("empleado")) {
			emp = new Empleado(); // Crear una nueva instancia de Empleado.
			
			// Obtener el atributo "id" y establecerlo en el objeto Empleado.
			String id = attributes.getValue("id");
			emp.setId(Integer.parseInt(id)); // Convertir el atributo id a entero y asignarlo.
		
		// Marcar la posición actual según el elemento que se esté procesando.
		} else if (qName.equalsIgnoreCase("edad")) {
			esEdad = true; // Estamos dentro de un elemento <edad>.
		} else if (qName.equalsIgnoreCase("nombre")) {
			esNombre = true; // Estamos dentro de un elemento <nombre>.
		} else if (qName.equalsIgnoreCase("genero")) {
			esGenero = true; // Estamos dentro de un elemento <genero>.
		} else if (qName.equalsIgnoreCase("trabajo")) {
			esTrabajo = true; // Estamos dentro de un elemento <trabajo>.
		}
	}

	// Método llamado al final de cada elemento en el XML.
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// Si se cierra un elemento <empleado>, se imprime el objeto Empleado completo.
		if (qName.equalsIgnoreCase("empleado")) {
			System.out.println(emp); // Llamará al método toString() de Empleado para mostrar los datos.
		}
	}

	// Método llamado para procesar el contenido de texto dentro de los elementos del XML.
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// Si estamos dentro de un elemento <edad>, asignar el valor al objeto Empleado.
		if (esEdad) {
			emp.setEdad(Integer.parseInt(new String(ch, start, length))); // Convertir el texto a entero.
			esEdad = false; // Reiniciar el marcador para este elemento.
		// Si estamos dentro de un elemento <nombre>, asignar el valor al objeto Empleado.
		} else if (esNombre) {
			emp.setNombre(new String(ch, start, length)); // Asignar el texto al atributo nombre.
			esNombre = false; // Reiniciar el marcador para este elemento.
		// Si estamos dentro de un elemento <genero>, asignar el valor al objeto Empleado.
		} else if (esGenero) {
			emp.setGenero(new String(ch, start, length)); // Asignar el texto al atributo género.
			esGenero = false; // Reiniciar el marcador para este elemento.
		// Si estamos dentro de un elemento <trabajo>, asignar el valor al objeto Empleado.
		} else if (esTrabajo) {
			emp.setTrabajo(new String(ch, start, length)); // Asignar el texto al atributo trabajo.
			esTrabajo = false; // Reiniciar el marcador para este elemento.
		}
	}
}
