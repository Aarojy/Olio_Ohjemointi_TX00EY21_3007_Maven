package Task7_2.dao;

import Task7_2.datasource.MariaDbConnection;
import Task7_2.entity.Currency;

import java.sql.*;
import java.util.ArrayList;

public class CurrencyDao {
    public Double getConversionRate(String abbreviation) {

        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT conversionRate FROM currencies WHERE abbreviation=?";

        Double cr = null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            rs.next();
            cr = rs.getDouble(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cr;
    }

    public ArrayList<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT currencyName, abbreviation, conversionRate FROM currencies";
        ArrayList<Currency> currencies = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String currencyName = rs.getString(1);
                String abbreviation = rs.getString(2);
                double conversionRate = rs.getDouble(3);
                Currency currency = new Currency(currencyName, abbreviation, conversionRate);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    public static void main(String[] args) {
        CurrencyDao currencyDao = new CurrencyDao();
        Double conversionRate = currencyDao.getConversionRate("JPY");
        System.out.println(conversionRate);
    }
}
