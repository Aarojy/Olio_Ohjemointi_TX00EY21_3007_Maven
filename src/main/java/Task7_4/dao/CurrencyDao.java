package Task7_4.dao;

import Task7_4.entity.Currency;
import Task7_4.datasource.MariaDbJpaConnection;
import jakarta.persistence.EntityManager;
import Task7_4.datasource.*;
import java.util.List;

public class CurrencyDao {

    public Double getConversionRate(String abbreviation) throws Exception {
        EntityManager em = Task7_4.datasource.MariaDbJpaConnection.getInstance();
        Task7_4.entity.Currency currency = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbreviation", Task7_4.entity.Currency.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
        return currency.getConversionRate();
    }

    public Currency getCurrencyFromAbb(String abbreviation) throws Exception {
        EntityManager em = Task7_4.datasource.MariaDbJpaConnection.getInstance();
        Task7_4.entity.Currency currency = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbreviation", Task7_4.entity.Currency.class)
                .setParameter("abbreviation", abbreviation).getSingleResult();
        return currency;
    }

    public List<Task7_4.entity.Currency> getAllCurrencies() throws Exception {
        EntityManager em = Task7_4.datasource.MariaDbJpaConnection.getInstance();
        List<Task7_4.entity.Currency> currencies = em.createQuery("SELECT c FROM Currency c", Task7_4.entity.Currency.class).getResultList();
        return currencies;
    }

    public void addCurrency(String name, String abbreviation, Double conversionRate) throws Exception {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        Task7_4.entity.Currency currency = new Task7_4.entity.Currency(name, abbreviation, conversionRate);
        em.persist(currency);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        CurrencyDao currencyDao = new CurrencyDao();
        //System.out.println(conversionRate);
        //List<Currency> currencies = currencyDao.getAllCurrencies();
        //for (Currency currency : currencies) {
        //    System.out.println(currency.getName() + " " + currency.getAbbreviation() + " " + currency.getConversionRate());
        //}
    }
}
