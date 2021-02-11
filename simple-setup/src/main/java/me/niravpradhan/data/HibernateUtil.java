package me.niravpradhan.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error building Session Factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
