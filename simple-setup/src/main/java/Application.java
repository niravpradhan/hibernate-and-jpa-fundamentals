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

            Bank bank = new Bank();
            bank.setName("KOTAK BANK");
            bank.setInternational(true);

            bank.setCreatedBy("Nirav");
            bank.setCreatedDate(LocalDateTime.now());
            bank.setLastUpdatedBy("Nirav");
            bank.setLastUpdatedDate(LocalDateTime.now());

            BankContact bankContact1 = new BankContact();
            bankContact1.setName("Contact1");
            bankContact1.setPositionType("Position Type1");

            BankContact bankContact2 = new BankContact();
            bankContact2.setName("Contact2");
            bankContact2.setPositionType("Position Type2");

            bank.getBankContacts().add(bankContact1);
            bank.getBankContacts().add(bankContact2);

            Address address = new Address();
            address.setAddressLine1("Address Line 1");
            address.setAddressLine2("Address Line 2");
            address.setCity("IN");
            address.setState("KR");
            address.setZipCode("10001");
            bank.setAddress(address);

            session.save(bank);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }
}