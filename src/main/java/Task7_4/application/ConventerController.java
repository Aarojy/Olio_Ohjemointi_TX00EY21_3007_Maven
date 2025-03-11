package Task7_4.application;

import Task7_4.UI.ConverterView;
import Task7_4.dao.CurrencyDao;
import Task7_4.dao.TransactionDao;
import Task7_4.entity.Currency;

import java.util.List;

public class ConventerController {
    private ConverterView view;
    private CurrencyDao dao;
    private TransactionDao tDao;

    public ConventerController(ConverterView view) {
        this.view = view;
        dao = new CurrencyDao();
        tDao = new TransactionDao();

    }

    public void convert(String fromCurrency, String toCurrency, double amount) {
        try {
            Currency conversionFrom = dao.getCurrencyFromAbb(fromCurrency);
            Currency conversionTo = dao.getCurrencyFromAbb(toCurrency);

            double result = amount * conversionTo.getConversionRate() / conversionFrom.getConversionRate();

            view.printResult(Double.toString(result));
            tDao.addTransaction(conversionFrom, conversionTo, amount);

        } catch (Exception e) {
            view.printResult("Currency not found");
        }
    }

    public List<Currency> getCurrencies() throws Exception {return dao.getAllCurrencies();
    }
}
