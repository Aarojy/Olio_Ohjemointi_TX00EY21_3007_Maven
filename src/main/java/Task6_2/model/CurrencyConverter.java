package Task6_2.model;

import java.util.ArrayList;

public class CurrencyConverter {
    private ArrayList<Currency> currencies = new ArrayList<>();

    public CurrencyConverter() {
        currencies.add(new Currency("US Dollar", "USD", 1.0));
        currencies.add(new Currency("Euro", "EUR", 0.950329));
        currencies.add(new Currency("British Pound", "GBP", 0.789001));
        currencies.add(new Currency("Japanese Yen", "JPY", 148.88));
        currencies.add(new Currency("Australian Dollar", "AUD", 1.57));
        currencies.add(new Currency("Canadian Dollar", "CAD", 1.430231));
        currencies.add(new Currency("Swiss Franc", "CHF", 0.891816));
        currencies.add(new Currency("Chinese Yuan", "CNY", 7.251193));
        currencies.add(new Currency("Swedish Krona", "SEK", 10.592141));
        currencies.add(new Currency("New Zealand Dollar", "NZD", 1.747504));
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        for (Currency currency : currencies) {
            if (currency.getAbbreviation().equals(fromCurrency)) {
                double fromConversionRate = currency.getConversionRate();
                for (Currency currency2 : currencies) {
                    if (currency2.getAbbreviation().equals(toCurrency)) {
                        double toConversionRate = currency2.getConversionRate();
                        return amount * toConversionRate / fromConversionRate;
                    }
                }
            }
        }
        throw new Exception("Currency not found");
    }

    public String[] getCurrencies() {
        String[] currencyAbbreviations = new String[currencies.size()];
        for (int i = 0; i < currencies.size(); i++) {
            currencyAbbreviations[i] = currencies.get(i).getAbbreviation();
        }
        return currencyAbbreviations;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        try {
            System.out.println(converter.convert("JPY", "CNY", 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
