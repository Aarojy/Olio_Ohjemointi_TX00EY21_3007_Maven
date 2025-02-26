package Task6_3.view;

import Task6_3.controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetInterface extends Application {
    int[] SIZE = {400, 400};
    PetController controller;

    @Override
    public void start(Stage stage) {

        stage.setResizable(false);
        stage.setTitle("Pet Game");
        Canvas canvas = new Canvas(SIZE[0], SIZE[1]);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image catImage = new Image("cat.png", 100, 100,true,false);
        gc.drawImage(catImage, 200, 200);

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            controller.setPetTarget(x, y);
            gc.clearRect(0, 0, SIZE[0], SIZE[1]);
            gc.drawImage(catImage, controller.getPetX()-50, controller.getPetY()-25);
        });

        canvas.setOnMouseExited(event -> {
            controller.stopPet();
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, SIZE[0], SIZE[1]);
                controller.updatePetPosition();
                gc.drawImage(catImage, controller.getPetX() - 50, controller.getPetY() - 25);
                stage.show();
            }
        }.start();

        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        StackPane root = new StackPane(canvas);
        root.setStyle("-fx-background-color: #6ce50d;");
        Scene scene = new Scene(root, SIZE[0], SIZE[1]);
        stage.setScene(scene);
        stage.show();

    }

    public void init() {
        controller = new PetController(this, SIZE[0], SIZE[1]);
    }
}
