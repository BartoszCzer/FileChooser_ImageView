package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("Image");
        stage.setScene(scene);
        stage.show();

        imageLayout();
    }

    public void imageLayout() {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Button button = new Button("Browse");
        root.add(button, 0, 0);
        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image("file:" + file.getAbsolutePath());
                ImageView imageView = new ImageView();
                imageView.setImage(image);
            }
        });

        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
