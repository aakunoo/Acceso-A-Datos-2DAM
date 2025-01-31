package practica5.DAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import practica5.DAO.Empleado;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class EmpleadoDAOImpl implements EmpleadoDAO {

	private MongoCollection<Document> coleccion;
	
	
	public EmpleadoDAOImpl() {

        MongoDBConnection conexion = MongoDBConnection.getInstancia();
        MongoDatabase db = conexion.getDatabase();
        
        boolean coleccionExiste = db.listCollectionNames().into(new ArrayList<>()).contains("empleados");

        	if(!coleccionExiste) {
        		db.createCollection("empleados");
        		System.out.println("Coección 'empleados' creada.");
        	}

        coleccion = db.getCollection("empleados");
        //system.out.println("DEBUG: Colección asignada: " + (this.coleccion == null ? "null" : this.coleccion));
    }

    @Override
    public boolean insertarEmpleado(Empleado empleado) {

        Empleado existente = buscarEmpleadoPorNIF(empleado.getNif());
        if (existente != null) {
            System.out.println("ERROR: Ya existe un empleado con el NIF " + empleado.getNif());
            return false;
        }

        if (empleado.getSalario() != null && empleado.getSalario() < 0) {
            System.out.println("ERROR: El salario no puede ser negativo.");
            return false;
        }

        Document doc = new Document("NumEmp", empleado.getNumEmp())
                .append("nombre", empleado.getNombre())
                .append("dep", empleado.getDep())
                .append("salario", empleado.getSalario())
                .append("fechaalta", empleado.getFechaAlta())
                .append("oficio", empleado.getOficio())
                .append("comision", empleado.getComision())
                .append("nif", empleado.getNif());

        coleccion.insertOne(doc);
        System.out.println("Empleado insertado correctamente en la colección.");
        return true;
    }

    @Override
    public Empleado buscarEmpleadoPorNIF(String nif) {
        Document doc = coleccion.find(eq("nif", nif)).first();
        if (doc != null) {
            return documentToEmpleado(doc);
        }
        return null;
    }

    @Override
    public List<Empleado> buscarTodosLosEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            Empleado emp = documentToEmpleado(doc);
            lista.add(emp);
        }
        return lista;
    }

    @Override
    public boolean actualizarSalarioEmpleado(String nif, double nuevoSalario) {

        if (nuevoSalario < 0) {
            System.out.println("ERROR: El salario no puede ser negativo.");
            return false;
        }

        Empleado empleado = buscarEmpleadoPorNIF(nif);
        if (empleado == null) {
            System.out.println("No existe un empleado con el NIF " + nif);
            return false;
        }

        Double salarioActual = empleado.getSalario();
        if (salarioActual != null && salarioActual == nuevoSalario) {
            System.out.println("El salario es igual al actual. No se ha modificado.");
            return false;
        }

        Bson filtro = eq("nif", nif);
        Bson operacion = set("salario", nuevoSalario);
        UpdateResult resultado = coleccion.updateOne(filtro, operacion);

        if (resultado.getMatchedCount() == 0) {
            System.out.println("No se encontró ningún documento para actualizar.");
            return false;
        } else {
            if (resultado.getModifiedCount() == 0) {
                System.out.println("El salario no cambió (posiblemente era el mismo).");
                return false;
            } else {
                System.out.println("El salario ha sido modificado correctamente.");
                return true;
            }
        }
    }

    @Override
    public boolean eliminarEmpleadoPorNIF(String nif) {
        Bson filtro = eq("nif", nif);
        DeleteResult resultado = coleccion.deleteOne(filtro);

        if (resultado.getDeletedCount() > 0) {
            System.out.println("Empleado con NIF " + nif + " eliminado correctamente.");
            return true;
        } else {
            System.out.println("No se encontró empleado con NIF " + nif + " para eliminar.");
            return false;
        }
    }

    private Empleado documentToEmpleado(Document doc) {
        Empleado emp = new Empleado();
        emp.setNumEmp(doc.getInteger("NumEmp", 0));
        emp.setNombre(doc.getString("nombre"));
        emp.setDep(doc.getInteger("dep", 0));
        emp.setSalario(doc.getDouble("salario"));
        emp.setFechaAlta(doc.getString("fechaalta"));
        emp.setOficio(doc.getString("oficio"));
        emp.setComision(doc.getInteger("comision", 0));
        emp.setNif(doc.getString("nif"));
        return emp;
    }
}