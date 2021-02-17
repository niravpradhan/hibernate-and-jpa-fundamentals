import me.niravpradhan.data.HibernateUtil;
import me.niravpradhan.data.entities.Account;
import me.niravpradhan.data.entities.Address;
import me.niravpradhan.data.entities.Bank;
import me.niravpradhan.data.entities.Credential;
import me.niravpradhan.data.entities.Currency;
import me.niravpradhan.data.entities.Market;
import me.niravpradhan.data.entities.Transaction;
import me.niravpradhan.data.entities.User;
import me.niravpradhan.data.entities.ids.CurrencyId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Currency currency = session.load(Currency.class, new CurrencyId("RUPEE", "INDIA"));

            Market market = new Market();
            market.setMarketName("Bombay Stock Exchange");
            market.setCurrency(currency);

            currency.getMarkets().add(market);

            session.save(market);

            tx.commit();

            Currency currency2 = market.getCurrency();
            System.out.println("SYMBOL: " + currency2.getSymbol());

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }


    private static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("First United Federal");

        Address address = new Address();
        address.setAddressLine1("103 Washington Plaza");
        address.setAddressLine2("Suite 332");
        address.setAddressType("PRIMARY");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("10000");
        bank.setAddress(address);

        bank.setCreatedBy("Kevin Bowersox");
        bank.setCreatedDate(LocalDateTime.now());
        bank.setInternational(false);
        bank.setLastUpdatedBy("Kevin Bowersox");
        bank.setLastUpdatedDate(LocalDateTime.now());
        return bank;
    }

    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
        user.setBirthDate(LocalDateTime.now());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(LocalDateTime.now());
        user.setCredential(createCredential(user));
        user.setEmailAddress("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedDate(LocalDateTime.now());
        return user;
    }

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUserName("test_username");
        credential.setPassword("test_password");
        return credential;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("101 Address Line");
        address.setAddressLine2("102 Address Line");
        address.setCity("New York");
        address.setState("PA");
        address.setZipCode("10000");
        address.setAddressType("PRIMARY");
        return address;
    }

    private static Transaction createNewBeltPurchase(Account account) {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(LocalDateTime.now());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(LocalDateTime.now());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Transaction createShoePurchase(Account account) {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(LocalDateTime.now());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(LocalDateTime.now());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(LocalDate.now());
        account.setOpenDate(LocalDate.now());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(LocalDateTime.now());
        account.setCreatedDate(LocalDateTime.now());
        return account;
    }

}