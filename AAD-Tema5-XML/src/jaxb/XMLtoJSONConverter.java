package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
 
public class XMLtoJSONConverter {
    public static void main(String[] args) {
        try {
            // Leer el archivo XML
            File file = new File("damVB.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Grupos.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            // Convertir el XML en un objeto de la clase Grupos
            Grupos grupos = (Grupos) unmarshaller.unmarshal(file);
            System.out.println("Contenido del XML como objeto Java:");
            System.out.println(grupos.toString());  // Mostrar el objeto deserializado
 
            // Verificar si los alumnos están siendo deserializados correctamente
            for (Grupo grupo : grupos.getGrupos()) {
                System.out.println("Grupo: " + grupo.getNombre());
                System.out.println("Alumnos: " + grupo.getAlumnos());  // Verificar los alumnos
            }
 
            // Convertir a JSON usando Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            File jsonFile = new File("resultado.json");
            objectMapper.writeValue(jsonFile, grupos);  // Esto generará el archivo JSON
 
            System.out.println("Archivo JSON generado exitosamente: resultado.json");
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}