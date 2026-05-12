package escenas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenaMenu {


    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("/Imagenes/fondomenu.jpg");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Button btnJugar = new Button("Jugar");
        btnJugar.setLayoutX(575);
        btnJugar.setLayoutY(250);
        btnJugar.setOnAction(evento -> {
            EscenaJuego escenaJuego = new EscenaJuego();
            stage.setScene(escenaJuego.construir(stage));
        });
        btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: black; -fx-font-size: 35px;");
        btnJugar.setOnMouseEntered(evento -> {btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnJugar.setOnMouseExited(evento -> {btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: black; -fx-font-size: 35px;");});

        Button btnSeleccionar = new Button("Seleccionar ninis");
        btnSeleccionar.setLayoutX(500);
        btnSeleccionar.setLayoutY(370);
        btnSeleccionar.setOnAction(evento -> {
            EscenaSeleccionar escenaSeleccionar = new EscenaSeleccionar();
            stage.setScene(escenaSeleccionar.construir(stage));
        });
        btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: black; -fx-font-size: 35px;");
        btnSeleccionar.setOnMouseEntered(evento -> {btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");});
        btnSeleccionar.setOnMouseExited(evento -> {btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: black; -fx-font-size: 35px;");});



        Pane root = new Pane(fondo, btnJugar, btnSeleccionar);
        return new Scene (root, 1280, 720);
    }

}
