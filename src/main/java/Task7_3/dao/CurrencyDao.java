package Task7_3.dao;

import Task7_3.entity.Currency;
import jakarta.persistence.EntityManager;
import Task7_3.datasource.*;
import java.util.List;

public class CurrencyDao {

    public Double getConversionRate(String abbreviation) throws Exception {
        EntityManager em = MariaDbJpaConnection.getInstance();
        Currency currency = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbreviation", Currency.class)
                .setParameter("abbreviation", abbreviation)
                .getSingleResult();
        return currency.getConversionRate();
    }

    public List<Currency> getAllCurrencies() throws Exception {
        EntityManager em = MariaDbJpaConnection.getInstance();
        List<Currency> currencies = em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        return currencies;
    }

    public void addCurrency(String name, String abbreviation, Double conversionRate) throws Exception {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        Currency currency = new Currency(name, abbreviation, conversionRate);
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
