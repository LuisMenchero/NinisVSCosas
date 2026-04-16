package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaSeleccionar {

    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondoNvsW.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(1200);
        btnSalir.setLayoutY(10);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
        });

        Pane root = new Pane(fondo, btnSalir);
        return new Scene(root, 1280, 720);
    }

}
