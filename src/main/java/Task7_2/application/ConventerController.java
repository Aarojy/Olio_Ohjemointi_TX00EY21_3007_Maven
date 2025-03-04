package Task7_2.application;

import Task7_2.dao.CurrencyDao;
import Task7_2.entity.Currency;
import Task7_2.UI.ConverterView;

import java.util.ArrayList;

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

    public ArrayList<Currency> getCurrencies() {return dao.getAllCurrencies();
    }
}
