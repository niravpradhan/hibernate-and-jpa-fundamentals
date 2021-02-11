import me.niravpradhan.data.entities.AccountType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        /* Configuration */
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(AccountType.class);
        configuration.setProperties(new Properties() {
            {
                put("hibernate.connection.username", "ifdbuser");
                put("hibernate.connection.password", "MkP1978786");
                put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                put("hibernate.connection.url", "jdbc:mysql://mysqlcluster26.registeredsite.com:3306/ifinances");
            }
        });

        /* Building SessionFactory */
        SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build());

        /* Obtain Session and Call Persistence Methods */
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        AccountType type = new AccountType();

        type.setName("Checking");
        type.setCreatedDate(LocalDateTime.now());
        type.setLastUpdatedDate(LocalDateTime.now());
        type.setCreatedBy("Nirav");
        type.setLastUpdatedBy("Nirav");

        session.save(type);
        session.getTransaction().commit();
        session.close();

    }
}
