package Task6_1.view;

import Task6_1.controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    DictionaryController controller;
    Label result = new Label();
    Label searchedWord = new Label();
    TextField searchField = new TextField();

    @Override
    public void start(Stage stage) {

        stage.setTitle("Dictionary");
        stage.setResizable(false);
        Insets insets = new Insets(10, 10, 10, 10);

        VBox vbox = new VBox();
        FlowPane pane = new FlowPane();
        VBox resultPane = new VBox();
        Button searchButton = new Button("Search");
        searchedWord.setText("Waiting for your search...");
        searchedWord.setStyle("-fx-font-weight: bold");
        result.setText("Waiting for your search...");

        pane.setMargin(searchButton, insets);
        pane.setMargin(searchField, insets);
        pane.setMargin(pane, insets);
        pane.setAlignment(Pos.CENTER);
        resultPane.setAlignment(Pos.CENTER);
        resultPane.setMargin(result, insets);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.search(searchField.getText());
            }
        });

        pane.getChildren().add(searchButton);
        pane.getChildren().add(searchField);
        resultPane.getChildren().add(searchedWord);
        resultPane.getChildren().add(result);

        vbox.getChildren().add(pane);
        vbox.getChildren().add(resultPane);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public void printResult(String result) {
            this.result.setText(result);
            this.searchedWord.setText(searchField.getText());
            this.searchField.clear();
            VBox.setMargin(this.result, new Insets(10, 10, 10, 10));
    }
}

