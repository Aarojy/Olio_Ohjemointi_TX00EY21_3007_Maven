package Task7_4.controller;

import Task7_4.dao.CurrencyDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newCurrencyController {

    @FXML
    private TextField currencyName;

    @FXML
    private TextField currencyAbbreviation;

    @FXML
    private TextField currencyRate;

    @FXML
    public void addCurrency() {
        Stage stage = (Stage) currencyName.getScene().getWindow();

        try {
        String name = currencyName.getText();
        String abb = currencyAbbreviation.getText();
        Double rate = Double.parseDouble(currencyRate.getText());

        try {
            CurrencyDao currencyDao = new CurrencyDao();
            currencyDao.addCurrency(name, abb, rate);
        } catch (Exception e) {
            currencyName.setText("DATABASE ERROR");
            currencyAbbreviation.setText("DATABASE ERROR");
            currencyRate.setText("DATABASE ERROR");
            return;
        }

        stage.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            currencyRate.setText("INVALID INPUT");
        }
    }

    @FXML
    public void cancelAdding() {
        Stage stage = (Stage) currencyName.getScene().getWindow();
        stage.close();
    }


}
