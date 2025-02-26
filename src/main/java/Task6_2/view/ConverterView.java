package Task6_2.view;

import Task6_1.controller.DictionaryController;
import Task6_2.controller.ConventerController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    @Override
    public void start(Stage stage) {

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

        for (String currency : controller.getCurrencies()) {
            fromCurrency.getItems().add(currency);
            toCurrency.getItems().add(currency);
        }

        fromCurrency.setValue(controller.getCurrencies()[0]);
        toCurrency.setValue(controller.getCurrencies()[1]);
        inputAmount.setText("0.00");
        resultAmount.setText("0.00");


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

        convertButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.convert(fromCurrency.getValue(), toCurrency.getValue(), Double.parseDouble(inputAmount.getText()));
                } catch (Exception e) {
                    resultAmount.setText("Conversion Error");
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
}
