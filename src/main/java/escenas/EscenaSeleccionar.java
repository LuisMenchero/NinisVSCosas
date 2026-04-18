package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EscenaSeleccionar {

    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/SeleccionPlanta.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Text titulo = new Text("-- Selecciona tus Ninis --");
        titulo.setStyle("-fx-font-size: 40px; -fx-color-label-visible: red;");
        titulo.setLayoutX(55);
        titulo.setLayoutY(100);

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(255);
        btnSalir.setLayoutY(620);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
        });

        // fila 1
        ImageView guevara = new ImageView("Imagenes/CosoPrueba.png");
        guevara.setFitWidth(100);
        guevara.setFitHeight(100);
        guevara.setLayoutX(18);
        guevara.setLayoutY(150);

        ImageView luis = new ImageView("Imagenes/CosoPrueba.png");
        luis.setFitWidth(100);
        luis.setFitHeight(100);
        luis.setLayoutX(123);
        luis.setLayoutY(150);

        ImageView diego = new ImageView("Imagenes/CosoPrueba.png");
        diego.setFitWidth(100);
        diego.setFitHeight(100);
        diego.setLayoutX(228);
        diego.setLayoutY(150);

        ImageView adripan = new ImageView("Imagenes/CosoPrueba.png");
        adripan.setFitWidth(100);
        adripan.setFitHeight(100);
        adripan.setLayoutX(333);
        adripan.setLayoutY(150);

        ImageView callejo = new ImageView("Imagenes/CosoPrueba.png");
        callejo.setFitWidth(100);
        callejo.setFitHeight(100);
        callejo.setLayoutX(438);
        callejo.setLayoutY(150);


        // fila 2
        ImageView guevara1 = new ImageView("Imagenes/CosoPrueba.png");
        guevara1.setFitWidth(100);
        guevara1.setFitHeight(100);
        guevara1.setLayoutX(18);
        guevara1.setLayoutY(255);

        ImageView luis1 = new ImageView("Imagenes/CosoPrueba.png");
        luis1.setFitWidth(100);
        luis1.setFitHeight(100);
        luis1.setLayoutX(123);
        luis1.setLayoutY(255);

        ImageView diego1 = new ImageView("Imagenes/CosoPrueba.png");
        diego1.setFitWidth(100);
        diego1.setFitHeight(100);
        diego1.setLayoutX(228);
        diego1.setLayoutY(255);

        ImageView adripan1 = new ImageView("Imagenes/CosoPrueba.png");
        adripan1.setFitWidth(100);
        adripan1.setFitHeight(100);
        adripan1.setLayoutX(333);
        adripan1.setLayoutY(255);

        ImageView callejo1 = new ImageView("Imagenes/CosoPrueba.png");
        callejo1.setFitWidth(100);
        callejo1.setFitHeight(100);
        callejo1.setLayoutX(438);
        callejo1.setLayoutY(255);


        // fila 3
        ImageView guevara2 = new ImageView("Imagenes/CosoPrueba.png");
        guevara2.setFitWidth(100);
        guevara2.setFitHeight(100);
        guevara2.setLayoutX(18);
        guevara2.setLayoutY(360);

        ImageView luis2 = new ImageView("Imagenes/CosoPrueba.png");
        luis2.setFitWidth(100);
        luis2.setFitHeight(100);
        luis2.setLayoutX(123);
        luis2.setLayoutY(360);

        ImageView diego2 = new ImageView("Imagenes/CosoPrueba.png");
        diego2.setFitWidth(100);
        diego2.setFitHeight(100);
        diego2.setLayoutX(228);
        diego2.setLayoutY(360);

        ImageView adripan2 = new ImageView("Imagenes/CosoPrueba.png");
        adripan2.setFitWidth(100);
        adripan2.setFitHeight(100);
        adripan2.setLayoutX(333);
        adripan2.setLayoutY(360);

        ImageView callejo2 = new ImageView("Imagenes/CosoPrueba.png");
        callejo2.setFitWidth(100);
        callejo2.setFitHeight(100);
        callejo2.setLayoutX(438);
        callejo2.setLayoutY(360);

        // fila 4
        ImageView guevara3 = new ImageView("Imagenes/CosoPrueba.png");
        guevara3.setFitWidth(100);
        guevara3.setFitHeight(100);
        guevara3.setLayoutX(18);
        guevara3.setLayoutY(465);

        ImageView luis3 = new ImageView("Imagenes/CosoPrueba.png");
        luis3.setFitWidth(100);
        luis3.setFitHeight(100);
        luis3.setLayoutX(123);
        luis3.setLayoutY(465);

        ImageView diego3 = new ImageView("Imagenes/CosoPrueba.png");
        diego3.setFitWidth(100);
        diego3.setFitHeight(100);
        diego3.setLayoutX(228);
        diego3.setLayoutY(465);

        ImageView adripan3 = new ImageView("Imagenes/CosoPrueba.png");
        adripan3.setFitWidth(100);
        adripan3.setFitHeight(100);
        adripan3.setLayoutX(333);
        adripan3.setLayoutY(465);

        ImageView callejo3 = new ImageView("Imagenes/CosoPrueba.png");
        callejo3.setFitWidth(100);
        callejo3.setFitHeight(100);
        callejo3.setLayoutX(438);
        callejo3.setLayoutY(465);


        Pane root = new Pane(fondo,titulo, btnSalir,guevara, luis, diego, adripan,callejo,guevara1, luis1, diego1, adripan1,callejo1, guevara2, luis2, diego2, adripan2,callejo2,guevara3,luis3,diego3,adripan3,callejo3);
        return new Scene(root, 1280, 720);
    }

}
