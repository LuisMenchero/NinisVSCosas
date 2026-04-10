package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaMenu {

    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondomenu.jpg");
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
