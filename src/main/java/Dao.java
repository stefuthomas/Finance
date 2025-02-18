import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinancePU");
    private static final EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("FinancePU2");

    public void saveCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
        em.close();
    }

    public Category getCategory(int categoryId) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class, categoryId);
        em.close();
        return category;
    }

    public void saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(account);
        em.getTransaction().commit();
        em.close();
    }

    public Account getAccount(int accountId) {
        EntityManager em = emf.createEntityManager();
        Account account = em.find(Account.class, accountId);
        em.close();
        return account;
    }

    public void saveTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(transaction);
        em.getTransaction().commit();
        em.close();
    }

    public Transaction getTransaction(int transactionId) {
        EntityManager em = emf2.createEntityManager();
        Transaction transaction = em.find(Transaction.class, transactionId);
        em.close();
        return transaction;
    }
}