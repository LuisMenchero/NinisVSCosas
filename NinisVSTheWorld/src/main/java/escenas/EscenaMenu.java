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
        btnJugar.setLayoutX(350);
        btnJugar.setLayoutY(300);
        btnJugar.setOnAction(e -> {
            EscenaJuego escenaJuego = new EscenaJuego();
            stage.setScene(escenaJuego.construir(stage));
        });

        Button btnSeleccionar = new Button("Seleccionar ninis");
        btnSeleccionar.setLayoutX(320);
        btnSeleccionar.setLayoutY(370);
        btnSeleccionar.setOnAction(e -> {
            EscenaSeleccionar escenaSeleccionar = new EscenaSeleccionar();
            stage.setScene(escenaSeleccionar.construir(stage));
        });


        Pane root = new Pane(fondo, btnJugar, btnSeleccionar);
        return new Scene (root, 1280, 720);
    }

}
