package practicaCasa;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import practica5.DAO.Empleado;
import practica5.DAO.MongoDBConnection;

public class AlumnoDAOImpl implements AlumnoDAO {

	private MongoCollection<Document> coleccion;

	public AlumnoDAOImpl() {
		 
		MongoDBConnection conexion = MongoDBConnection.getInstancia();
		MongoDatabase db = conexion.getDatabase();
	        
	        boolean coleccionExiste = db.listCollectionNames().into(new ArrayList<>()).contains("alumnos");

	        	if(!coleccionExiste) {
	        		db.createCollection("alumnos");
	        		System.out.println("Colección 'alumnos' creada.");
	        	}

	        coleccion = db.getCollection("alumnos");
	        //system.out.println("DEBUG: Colección asignada: " + (this.coleccion == null ? "null" : this.coleccion));
	    }

	@Override
	public boolean insertarAlumno(Alumno alumno) {
		
		Alumno existente = buscarPorNombre(alumno.getNombre());
		if (existente != null) {
            System.out.println("ERROR: Ya existe un alumno con el nombre " + alumno.getNombre());
            return false;
        }

        Document doc = new Document("nombre", alumno.getNombre())
                .append("telefono", alumno.getTelefono())
                .append("curso", alumno.getCurso())
                .append("nota", alumno.getNota())
                .append("edad", alumno.getEdad())
                .append("poblacion", alumno.getPoblacion());
                

        coleccion.insertOne(doc);
        System.out.println("Alumno insertado correctamente en la colección.");
        return true;
    }

	 @Override
	    public Alumno buscarPorNombre(String nombre) {
	        Document doc = coleccion.find(eq("nombre", nombre)).first();
	        if (doc != null) {
	            return documentToAlumno(doc);
	        }
	        return null;
	    }

	@Override
	public List<Alumno> buscarTodos() {
		List<Alumno> lista = new ArrayList<>();
		 for (Document doc : coleccion.find()) {
	            Alumno alum = documentToAlumno(doc);
	            lista.add(alum);
	        }
		return lista;
	}

	@Override
	public boolean actualizarNota(String nombre, int nuevanota) {
		 if (nuevanota < 0) {
	            System.out.println("ERROR: La nota no puede ser negativa.");
	            return false;
	        }
		 
		 Alumno alumno = buscarPorNombre(nombre);
	        if (alumno == null) {
	            System.out.println("No existe un alumno con el nombre " + alumno);
	            return false;
	        }
	        
	        Integer notaActual = alumno.getNota();
	        if (notaActual != null && notaActual == nuevanota) {
	            System.out.println("La nota es igual al actual. No se ha modificado.");
	            return false;
	        }
	        
	        Bson filtro = eq("nombre", nombre);
	        Bson operacion = set("nota", nuevanota);
	        UpdateResult resultado = coleccion.updateOne(filtro, operacion);
	        
	        if (resultado.getMatchedCount() == 0) {
	            System.out.println("No se encontró ningún documento para actualizar.");
	            return false;
	        } else {
	            if (resultado.getModifiedCount() == 0) {
	                System.out.println("La nota no cambió (posiblemente era el mismo).");
	                return false;
	            } else {
	                System.out.println("La nota ha sido modificada correctamente.");
	                return true;
	            }
	        }
	    }
	
	@Override
	public boolean eliminarAlumno(String nombre) {
		Bson filtro = eq("nombre", nombre);
		DeleteResult resultado = coleccion.deleteOne(filtro);
		if (resultado.getDeletedCount() > 0) {
            System.out.println("Alumno con nombre " + nombre + " eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se encontró un Alumno con nombre " + nombre + " para eliminar.");
            return false;
        }
    }
	
	private Alumno documentToAlumno(Document doc) {
        Alumno alum = new Alumno();
        alum.setNombre(doc.getString("nombre"));
        alum.setTelefono(doc.getString("telefono"));
        alum.setCurso(doc.getString("curso"));
        alum.setNota(doc.getInteger("nota", 0));
        alum.setEdad(doc.getInteger("edad", 0));
        alum.setPoblacion(doc.getString("poblacion"));
        return alum;
    }
	
	
}
