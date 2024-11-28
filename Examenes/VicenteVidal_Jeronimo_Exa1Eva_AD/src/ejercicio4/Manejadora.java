package ejercicio4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejadora extends DefaultHandler{
	
	private boolean esVersion = false;
	private boolean esGroupId = false;
	private boolean esArtifactId = false;
	private boolean esSource = false;
	private boolean esTarget = false;
	
	
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
        if (qName.equalsIgnoreCase("plugin")) {
            System.out.println("Inicio de Plugin: ");
        } else if (qName.equalsIgnoreCase("groupId")) {
            esGroupId = true;
        } else if (qName.equalsIgnoreCase("artifactId")) {
        	esArtifactId = true;
        } else if (qName.equalsIgnoreCase("version")) {
        	esVersion = true;
        } else if (qName.equalsIgnoreCase("source")) {
        	esSource = true;
        } else if (qName.equalsIgnoreCase("target")) {
        	esTarget = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("plugin")) {
            System.out.println("Fin de Plugin.\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esGroupId) {
            System.out.println("Group ID: " + new String(ch, start, length));
            esGroupId = false;
        } else if (esArtifactId) {
            System.out.println("Artifact: ID: " + new String(ch, start, length));
            esArtifactId = false;
        } else if (esVersion) {
            System.out.println("Version: " + new String(ch, start, length));
            esVersion = false;
        } else if (esSource) {
            System.out.println("Source: " + new String(ch, start, length));
            esSource = false;
        } else if (esTarget) {
            System.out.println("Target: " + new String(ch, start, length));
            esTarget = false;
        }
    }

}
