import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.Address;
import me.niravpradhan.data.entities.Bank;
import me.niravpradhan.data.entities.BankContact;
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

            Bank bank = session.find(Bank.class, 16L);

            bank.getBankContacts().forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }
}