package Task6_4.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NotebookView extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Notebook");

        stage.setScene(new Scene(root));
        stage.show();
    }
}
