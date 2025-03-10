package Task7_3.application;

import Task7_3.UI.ConverterView;
import Task7_3.dao.CurrencyDao;
import Task7_3.entity.Currency;

import java.util.List;

public class ConventerController {
    private ConverterView view;
    private CurrencyDao dao;

    public ConventerController(ConverterView view) {
        this.view = view;
        dao = new CurrencyDao();
    }

    public void convert(String fromCurrency, String toCurrency, double amount) {
        try {
            double conversionRateFrom = dao.getConversionRate(fromCurrency);
            double conversionRateTo = dao.getConversionRate(toCurrency);

            double result = amount * conversionRateTo / conversionRateFrom;

            view.printResult(Double.toString(result));
        } catch (Exception e) {
            view.printResult("Currency not found");
        }
    }

    public List<Currency> getCurrencies() throws Exception {return dao.getAllCurrencies();
    }
}
