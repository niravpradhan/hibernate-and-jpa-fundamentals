import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.Address;
import me.niravpradhan.data.entities.Bank;
import me.niravpradhan.data.entities.BankContact;
import me.niravpradhan.data.entities.Credential;
import me.niravpradhan.data.entities.TimeTest;
import me.niravpradhan.data.entities.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            User user = new User();
            Address address = new Address();
            //user.setAge(22);
            user.setBirthDate(LocalDateTime.of(1978, 11, 30, 5, 30, 0));
            user.setCreatedBy("dilip");
            user.setCreatedDate(LocalDateTime.now());
            user.setEmailAddress("dilip.pradhan@gmail.com");
            user.setFirstName("dilip");
            user.setLastName("pradhan");
            user.setLastUpdatedBy("nirav");
            user.setLastUpdatedDate(LocalDateTime.now());

            address.setAddressLine1("line 1");
            address.setAddressLine2("line2");
            address.setCity("Philadelphia");
            address.setState("PA");
            address.setZipCode("12345");
            user.setAddress(address);

            Credential credential = new Credential();
            credential.setUserName("dilip");
            credential.setPassword("Password");
            
            credential.setUser(user);
            user.setCredential(credential);

            session.save(credential);

            session.getTransaction().commit();

            User dbUser = session.find(User.class, credential.getUser().getUserId());
            System.out.println(dbUser.getCredential().getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }
}