import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PaisUnico {
    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

        // abro sesión
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            String idCiudad = "US";

            Countries ciudad = session.get(Countries.class, idCiudad);

            if (ciudad != null) {
                System.out.println("País encontrado:");
                System.out.println("ID: " + ciudad.getCountryId());
                  System.out.println("Nombre: " + ciudad.getCountryName());
                System.out.println("Región ID: " + ciudad.getRegionId());
            } else {
                System.out.println("No se encontró ningún país con el ID: " + idCiudad);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
 
            sessionFactory.close();
        }
    }
}
