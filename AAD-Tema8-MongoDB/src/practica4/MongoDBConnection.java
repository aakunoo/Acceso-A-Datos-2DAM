package practica4;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection { // Clase singleton
	
	private static MongoDBConnection instancia;
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase; 
	 
	 private MongoDBConnection() {
	        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
	        this.mongoDatabase = mongoClient.getDatabase("mibasedatos");
	    }
	 
	 
	 public static synchronized MongoDBConnection getInstancia() { // IMPORTANTE SYNCHRONIZED.
	        if (instancia == null) {
	            instancia = new MongoDBConnection();
	        }
	        return instancia;
	    }
	 
	 public MongoCollection<Document> getCollection(String collectionName) {
		 if(mongoDatabase != null) {
			 return mongoDatabase.getCollection(collectionName);
		 } else {
			 throw new IllegalStateException("No se ha establecido la consexión con la base de datos.");
		 }    
}

	 
	 public void close() {
	    	if(mongoClient != null) {
	    		mongoClient.close();
	    		System.out.println("Conexión cerrada.");
	    	} else {
	    		System.out.println("Error. No se pudo cerrar la conexión.");
	    	}
	    }
	}
