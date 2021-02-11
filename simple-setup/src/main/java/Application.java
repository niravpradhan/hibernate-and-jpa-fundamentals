import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.User;
import org.hibernate.Session;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setCreatedBy("Amita");
        user.setCreatedDate(LocalDateTime.now());
        user.setLastUpdatedBy("Amita");
        user.setLastUpdatedDate(LocalDateTime.now());
        user.setBirthDate(LocalDateTime.now());
        user.setEmailAddress("amita.pradhan@gmail.com");
        user.setFirstName("Amita");
        user.setLastName("Pradhan");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}