package Task7_4.dao;

import Task7_4.datasource.MariaDbJpaConnection;
import Task7_4.entity.Currency;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void addTransaction(Currency fromCurrency, Currency toCurrency, double amount) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        Task7_4.entity.Transaction transaction = new Task7_4.entity.Transaction(fromCurrency, toCurrency, amount);
        em.persist(transaction);
        em.getTransaction().commit();
    }
}
