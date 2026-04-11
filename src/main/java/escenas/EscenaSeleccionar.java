package escenas;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EscenaSeleccionar {

    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondoNvsW.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Pane root = new Pane(fondo);
        return new Scene(root, 1280, 720);
    }

}
