import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class LocalidadPrincipal {
 
    public static void main(String[] args) {
        
        // onbtengo el SessionFactory
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        
        // Abro una sesión
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
 
            // Hacer una consulta para obtener todos los países
            Query<Localidad> query = session.createQuery("FROM Localidad", Localidad.class);  // Recupera todos los países
            List<Localidad> localidadList = query.getResultList();
 
            // Imprimir la lista de países
            System.out.println("Lista de localidades:");
            if (localidadList.isEmpty()) {
                System.out.println("No se encontraron Localidades.");
            } else {
                for (Localidad localidad : localidadList) {
                    System.out.println("ID: " + localidad.getCodlocalidad() + ", Name: " + localidad.getNombre());
                }
            }
 
            // Confirmar la transacción
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Asegurarse de que la sesión se cierre
            sessionFactory.close();
        }
    }
}