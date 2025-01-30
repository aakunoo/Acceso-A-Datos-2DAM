package practica4;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Principal {

	public static void main(String[] args) {

		MongoDBConnection conexion = MongoDBConnection.getInstancia();
		MongoCollection<Document> alumnosColeccion = conexion.getCollection("alumnos");
		
		
		long count = alumnosColeccion.countDocuments();
		System.out.println("Cantidad de documentos en la colección: " + count);
		
		List<Document> alumnos = alumnosColeccion.find().into(new ArrayList<Document>());
		
		 System.out.println("\nLista de alumnos:");
		 for(Document alumno : alumnos) {
			 	
			 	System.out.println("\nNombre: " + alumno.getString("nombre"));
	            System.out.println("Teléfono: " + alumno.getInteger("telefono"));
	            System.out.println("Curso: " + alumno.getString("curso"));
	            System.out.println("Nota: " + alumno.getInteger("nota")); 
	            System.out.println("Edad: " + alumno.getInteger("edad", 0)); 
	            System.out.println("Población: " + alumno.getString("poblacion"));
	            System.out.println("----------------------------------");
	            
	        }
		 conexion.close();
	}

}
