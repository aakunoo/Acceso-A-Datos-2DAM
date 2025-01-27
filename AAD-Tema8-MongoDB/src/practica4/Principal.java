package practica4;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoDBConnection conexion = MongoDBConnection.getInstancia();
		MongoCollection<Document> alumnos = conexion.getCollection("alumnos");
		
		 System.out.println("Lista de alumnos:");
		 for(Document d : alumnos.find()) {
			 	
			 	System.out.println("Nombre: " + d.getString("nombre"));
	            System.out.println("Teléfono: " + d.getInteger("telefono"));
	            System.out.println("Curso: " + d.getString("curso"));
	            System.out.println("Nota: " + d.getInteger("nota")); 
	            System.out.println("Edad: " + d.getInteger("edad", 0)); 
	            System.out.println("Población: " + d.getString("poblacion"));
	            System.out.println("----------------------------------");
	            
	        }
		 conexion.close();
	}

}
