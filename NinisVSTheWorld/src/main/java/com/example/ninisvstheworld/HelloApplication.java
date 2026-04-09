package com.example.ninisvstheworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private final Image bgImage = new Image("file:src/main/resources/Animaciones/Items/FondoNvsW.png");

    @Override
    public void start(Stage stage) throws IOException {
        ImageView fondoPaner = new ImageView();
        fondoPaner.imageProperty().set(bgImage);
        StackPane root = new StackPane();
        root.getChildren().add(fondoPaner);
        fondoPaner.fitWidthProperty().bind(root.widthProperty());
        fondoPaner.fitWidthProperty().bind(root.widthProperty());
        fondoPaner.setPreserveRatio(true);
        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("Ninis vs TheWorld - Luis & Diego");
        stage.setScene(scene);
        stage.show();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

    }
}
