import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocalidadUnica {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

        // abro sesión
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            int idPersona = 4;

            Persona persona = session.get(Persona.class, idPersona);

            if (persona != null) {
                System.out.println("Persona encontrada:");
                System.out.println("ID: " + persona.getCodpersona());
                  System.out.println("Nombre: " + persona.getNombre());
                System.out.println("DNI: " + persona.getDni());
            } else {
                System.out.println("No se encontró ningún país con el ID: " + idPersona);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
 
            sessionFactory.close();
        }
    }
}

