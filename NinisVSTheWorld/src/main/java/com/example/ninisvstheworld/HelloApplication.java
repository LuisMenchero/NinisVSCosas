package com.example.ninisvstheworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        StackPane root = new StackPane();
        ImageView fondoPaner = new ImageView("Animaciones/Ninis/AdripanCargado.gif");
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 320, 240);
        scene.getStylesheets().add(this.getClass().getResource("./EstiloPrueba.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
