import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.User;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setFirstName("Nirav");
        user.setLastName("Pradhan");
        user.setEmail("nirav.pradhan@gmail.com");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}