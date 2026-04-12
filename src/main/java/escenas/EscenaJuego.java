package escenas;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelos.Celda;
import modelos.Cuadricula;

public class EscenaJuego {
    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondoNvsW.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        // Para crear e inicializar el tablero donde colocar las plantas/ninis
        Celda[][] terreno = new Celda[Cuadricula.columnas][Cuadricula.filas];
        for (int i = 0; i < Cuadricula.columnas; i++) {
            for (int j = 0; j < Cuadricula.filas; j++) {
                terreno[i][j] = new Celda();
            }
        }

        Pane root = new Pane(fondo);
        return new Scene(root, 1280, 720);
    }

}
