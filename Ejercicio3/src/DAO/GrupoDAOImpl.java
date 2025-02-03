package DAO;

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


public class GrupoDAOImpl implements GrupoDAO {

	private MongoCollection<Document> coleccion;
	
	public GrupoDAOImpl() {

        MongoDBConnection conexion = MongoDBConnection.getInstancia();
        MongoDatabase db = conexion.getDatabase();
        
        boolean coleccionExiste = db.listCollectionNames().into(new ArrayList<>()).contains("grupos");

    	if(!coleccionExiste) {
    		db.createCollection("grupos");
    		System.out.println("Colección 'grupos' creada.");
    	}

    coleccion = db.getCollection("grupos");
        
    }
	
	@Override
	public boolean insertarGrupo(Grupo grupo) {
		Grupo existente = buscarGrupoPorNombre(grupo.getGrupo());
        if (existente != null) {
            System.out.println("ERROR: Ya existe un empleado con el nombre " + grupo.getGrupo());
            return false;
        }


        Document doc = new Document("grupo", grupo.getGrupo())
                .append("genero", grupo.getGenero())
                .append("década", grupo.getDecada())
                .append("discos", grupo.getDiscos())
                .append("giras", grupo.getGiras());

        coleccion.insertOne(doc);
        System.out.println("Grupo insertado correctamente en la colección.");
        return true;
    }

	@Override
	public List<Grupo> listarTodosGrupos() {
		List<Grupo> lista = new ArrayList<>();
		 for (Document doc : coleccion.find()) {
	            Grupo grupo = documentToGrupo(doc);
	            lista.add(grupo);
	        }
		return lista;
	}

	@Override
	public boolean actualizarGrupo(String nombre, String generoNuevo) {
	
	 
	 Grupo grupo = buscarGrupoPorNombre(nombre);
        if (grupo == null) {
            System.out.println("No existe un grupo con el nombre " + grupo);
            return false;
        }
        
        String generoActual = grupo.getGenero();
        if (generoActual != null && generoActual == generoNuevo) {
            System.out.println("El genero es igual al actual. No se ha modificado.");
            return false;
        }
        
        Bson filtro = eq("grupo", nombre);
        Bson operacion = set("genero", generoNuevo);
        UpdateResult resultado = coleccion.updateOne(filtro, operacion);
        
        if (resultado.getMatchedCount() == 0) {
            System.out.println("No se encontró ningún documento para actualizar.");
            return false;
        } else {
            if (resultado.getModifiedCount() == 0) {
                System.out.println("El genero no cambió (posiblemente era el mismo).");
                return false;
            } else {
                System.out.println("El genero ha sido modificado correctamente.");
                return true;
            }
        }
    }

	@Override
	public boolean eliminarGrupo(String nombre) {
		Bson filtro = eq("grupo", nombre);
		DeleteResult resultado = coleccion.deleteOne(filtro);
		if (resultado.getDeletedCount() > 0) {
            System.out.println("Grupo con nombre " + nombre + " eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se encontró un grupo con nombre " + nombre + " para eliminar.");
            return false;
        }
    }

	@Override
	public Grupo buscarGrupoPorNombre(String nombre) {
		Document doc = coleccion.find(eq("grupo", nombre)).first();
        if (doc != null) {
            return documentToGrupo(doc);
        }
        return null;
    }
	
	private Grupo documentToGrupo(Document doc) {
        Grupo grp = new Grupo();
        grp.setGrupo(doc.getString("grupo"));
        grp.setGenero(doc.getString("genero"));
        grp.setDecada(doc.getString("década"));
        grp.setDiscos(doc.getList("discos", null ));
        grp.setGiras(doc.getList("oficio", null));
        return grp;
    }

}
