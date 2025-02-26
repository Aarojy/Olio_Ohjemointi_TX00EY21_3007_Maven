package Task6_2.controller;

import Task6_2.model.CurrencyConverter;
import Task6_2.view.ConverterView;

public class ConventerController {
    private ConverterView view;
    private CurrencyConverter converter = new CurrencyConverter();

    public ConventerController(ConverterView view) {
        this.view = view;
    }

    public void convert(String fromCurrency, String toCurrency, double amount) {
        try {
            double result = converter.convert(fromCurrency, toCurrency, amount);
            view.printResult(Double.toString(result));
        } catch (Exception e) {
            view.printResult("Currency not found");
        }
    }

    public String[] getCurrencies() {
        return converter.getCurrencies();
    }
}
