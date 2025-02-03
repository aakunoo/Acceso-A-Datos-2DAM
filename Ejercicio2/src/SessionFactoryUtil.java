import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	
	private static final SessionFactory sessionFactory;
	 
    static {
        try {
            sessionFactory = new Configuration().configure().addAnnotatedClass(Localidad.class).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
