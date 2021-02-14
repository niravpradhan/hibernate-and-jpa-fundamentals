import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.Account;
import me.niravpradhan.data.entities.Transaction;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            Account account = createAccount();

            account.getTransactions().add(createShoesTranction(account));
            account.getTransactions().add(createClothsTranction(account));

            session.save(account);

            session.getTransaction().commit();

            Transaction dbTransaction = session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
            System.out.println(dbTransaction.getNotes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }

    private static Transaction createClothsTranction(Account account) {
        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setTransactionType("Withdrawal");
        transaction.setTitle("Title1");
        transaction.setAmount(new BigDecimal("1000.00"));
        transaction.setInitialBalance(new BigDecimal("10000.00"));
        transaction.setClosingBalance(new BigDecimal("9000.00"));
        transaction.setNotes("Buying Cloths");

        transaction.setCreatedBy("system");
        transaction.setCreatedDate(LocalDateTime.now());
        transaction.setLastUpdatedBy("system");
        transaction.setLastUpdatedDate(LocalDateTime.now());

        return transaction;
    }

    private static Transaction createShoesTranction(Account account) {
        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setTransactionType("Withdrawal");
        transaction.setTitle("Title1");
        transaction.setAmount(new BigDecimal("1000.00"));
        transaction.setInitialBalance(new BigDecimal("9000.00"));
        transaction.setClosingBalance(new BigDecimal("8000.00"));
        transaction.setNotes("Buying Shoes");

        transaction.setCreatedBy("system");
        transaction.setCreatedDate(LocalDateTime.now());
        transaction.setLastUpdatedBy("system");
        transaction.setLastUpdatedDate(LocalDateTime.now());

        return transaction;
    }

    private static Account createAccount() {
        Account account = new Account();

        account.setAccountType("SAVING");
        account.setName("NIRAV PRADHAN");
        account.setInitialBalance(new BigDecimal("10000.00"));
        account.setCurrentBalance(new BigDecimal("10000.00"));
        account.setOpenDate(LocalDate.of(2021, 2, 13));
        account.setCloseDate(LocalDate.of(2031, 2, 13));

        account.setCreatedBy("system");
        account.setCreatedDate(LocalDateTime.now());
        account.setLastUpdatedBy("system");
        account.setLastUpdatedDate(LocalDateTime.now());

        return account;
    }
}