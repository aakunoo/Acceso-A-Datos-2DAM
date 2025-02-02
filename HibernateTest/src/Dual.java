



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class Dual {
 
    public static void main(String[] args) {
        
        // Obtener el SessionFactory
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        
        // Abrir una sesión
        try (Session session = sessionFactory.openSession()) {
            // Iniciar la transacción (aunque no la necesitamos para solo hacer un SELECT)
            Transaction tx = session.beginTransaction();
 
            // Hacer una consulta para obtener todos los países
            Query<Countries> query = session.createQuery("FROM Countries", Countries.class);  // Recupera todos los países
            List<Countries> countriesList = query.getResultList();
 
            // Imprimir la lista de países
            System.out.println("Lista de países:");
            if (countriesList.isEmpty()) {
                System.out.println("No se encontraron países.");
            } else {
                for (Countries country : countriesList) {
                    System.out.println("ID: " + country.getCountryId() + ", Name: " + country.getCountryName());
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