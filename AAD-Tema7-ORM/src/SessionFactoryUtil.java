

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
 
/*
public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
 
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
 
    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();
 
    }
}
*/

 
public class SessionFactoryUtil {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
            sessionFactory = new Configuration().configure().addAnnotatedClass(Countries.class).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}