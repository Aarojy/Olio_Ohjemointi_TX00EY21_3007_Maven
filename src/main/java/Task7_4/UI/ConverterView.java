package Task7_4.UI;

import Task7_4.application.ConventerController;
import Task7_4.dao.CurrencyDao;
import Task7_4.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;

public class ConverterView extends Application {

    ConventerController controller;
    TextField resultAmount = new TextField();
    TextField inputAmount = new TextField();
    EntityManager manager = Task7_4.datasource.MariaDbJpaConnection.getInstance();


    @Override
    public void start(Stage stage) {
        addDefaultCurrencies();

        stage.setTitle("Currency Converter");
        stage.setResizable(false);
        Insets insets = new Insets(10, 10, 10, 10);

        Label fromCurrencyLabel = new Label("From currency:");
        Label toCurrencyLabel = new Label("To currency:");
        ChoiceBox<String> fromCurrency = new ChoiceBox<>();
        ChoiceBox<String> toCurrency = new ChoiceBox<>();
        Label inputAmountLabel = new Label("Input amount:");
        Label resultAmountLabel = new Label("Output amount:");
        Label instruction = new Label("Enter the amount and select the currencies to convert\nThen press the \"convert\" button.");
        resultAmount.setEditable(false);
        Button convertButton = new Button("Convert");
        Button addCurrencyButton = new Button("Add currency");

        try {
            for (Currency currency : controller.getCurrencies()) {
                fromCurrency.getItems().add(currency.getAbbreviation());
                toCurrency.getItems().add(currency.getAbbreviation());
            }

            fromCurrency.setValue(controller.getCurrencies().get(0).getAbbreviation());
            toCurrency.setValue(controller.getCurrencies().get(1).getAbbreviation());
            inputAmount.setText("0.00");
            resultAmount.setText("0.00");

        } catch (Exception e) {
            System.out.println("Error loading currencies");
            inputAmount.setText("Data loading error");
            resultAmount.setText("Data loading error");
        }


        GridPane gridPane = new GridPane();

        VBox inputCurrencyPane = new VBox();
        VBox inputAmountPane = new VBox();
        VBox resultCurrencyPane = new VBox();
        VBox resultAmountPane = new VBox();
        VBox buttonPane = new VBox();

        inputCurrencyPane.getChildren().add(fromCurrencyLabel);
        inputCurrencyPane.getChildren().add(fromCurrency);
        inputAmountPane.getChildren().add(inputAmountLabel);
        inputAmountPane.getChildren().add(inputAmount);

        resultCurrencyPane.getChildren().add(toCurrencyLabel);
        resultCurrencyPane.getChildren().add(toCurrency);
        resultAmountPane.getChildren().add(resultAmountLabel);
        resultAmountPane.getChildren().add(resultAmount);

        buttonPane.getChildren().add(convertButton);
        buttonPane.getChildren().add(addCurrencyButton);

        convertButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.convert(fromCurrency.getValue(), toCurrency.getValue(), Double.parseDouble(inputAmount.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                    resultAmount.setText("Conversion Error");
                }
            }
        });

addCurrencyButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/newCurrency.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("New currency?");
            stage.setScene(new Scene(root));

            stage.showAndWait();

            fromCurrency.getItems().clear();
            toCurrency.getItems().clear();

            for (Currency currency : controller.getCurrencies()) {
                fromCurrency.getItems().add(currency.getAbbreviation());
                toCurrency.getItems().add(currency.getAbbreviation());
            }

            fromCurrency.setValue(controller.getCurrencies().get(0).getAbbreviation());
            toCurrency.setValue(controller.getCurrencies().get(1).getAbbreviation());

        } catch (Exception e) {
            System.out.println("Error opening new currency window");
            e.printStackTrace();
        }
    }
});

        gridPane.add(buttonPane, 1, 0, 1, 2);
        gridPane.add(inputCurrencyPane, 0, 0);
        gridPane.add(inputAmountPane, 2, 0);
        gridPane.add(resultCurrencyPane, 0, 1);
        gridPane.add(resultAmountPane, 2, 1);
        gridPane.add(instruction, 0, 2, 3, 1);

        VBox.setMargin(convertButton, insets);
        GridPane.setMargin(inputCurrencyPane, insets);
        GridPane.setMargin(inputAmountPane, insets);
        GridPane.setMargin(resultCurrencyPane, insets);
        GridPane.setMargin(resultAmountPane, insets);
        GridPane.setMargin(instruction, insets);

        buttonPane.setAlignment(Pos.CENTER);
        instruction.setAlignment(Pos.CENTER);
        inputCurrencyPane.setAlignment(Pos.CENTER);
        resultCurrencyPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void init() {
        controller = new ConventerController(this);
    }

    public void printResult(String result) {
        this.resultAmount.setText(String.format(Locale.US, "%.2f", Double.parseDouble(result)));
        this.inputAmount.setText(String.format(Locale.US,"%.2f", Double.parseDouble(inputAmount.getText())));
    }

    public void addDefaultCurrencies() {
        try {
            CurrencyDao currencyDao = new CurrencyDao();
            currencyDao.addCurrency("US Dollar", "USD", 1.00);
            currencyDao.addCurrency("Euro", "EUR", 0.941434);
            currencyDao.addCurrency("British Pound", "GBP", 0.781589);
            currencyDao.addCurrency("Russian Ruble", "RUB", 89.632194);
            currencyDao.addCurrency("Japanese Yen", "JPY", 149.852447);
            currencyDao.addCurrency("Chinese Yuan Renminbi", "CNY", 7.265366);
            currencyDao.addCurrency("Swedish Krona", "SEK", 10.418393);
            currencyDao.addCurrency("Iranian Rial", "IRR", 42173.524706);
            currencyDao.addCurrency("Canadian Dollar", "CAD", 1.441013);

        } catch (Exception e) {
            System.out.println("Error adding default currencies");
        }
    }
}
