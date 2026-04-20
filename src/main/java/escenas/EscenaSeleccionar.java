package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelos.GestorInventario;

public class EscenaSeleccionar {

    public Scene construir(Stage stage) {
        GestorInventario geInv = GestorInventario.getInstancia();

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
        // posiciones de las imagenes en la seleccion de ninis izquierda
        int columna1 = 18;
        int columna2 = 123;
        int columna3 = 228;
        int columna4 = 333;
        int columna5 = 438;
        int fila1 = 150;
        int fila2 = 255;
        int fila3 = 360;
        int fila4 = 465;

        // posiciones de las imagenes en pantalla cuando las seleccionas
        // Nini 1
        int posicionXNini1 = 577;
        int posicionYNini1 = 20;
        // Nini 2
        int posicionXNini2 = 748;
        int posicionYNini2 = 20;
        // Nini 3
        int posicionXNini3 = 577;
        int posicionYNini3 = 191;
        // Nini 4
        int posicionXNini4 = 748;
        int posicionYNini4 = 191;
        // Nini 5
        int posicionXNini5 = 577;
        int posicionYNini5 = 362;
        // Nini 6
        int posicionXNini6 = 748;
        int posicionYNini6 = 362;
        // Nini 7
        int posicionXNini7 = 577;
        int posicionYNini7 = 533;
        // Nini 8
        int posicionXNini8 = 748;
        int posicionYNini8 = 533;


        // fila 1
        ImageView luis = new ImageView("Imagenes/CosoPrueba.png");
        luis.setFitWidth(100);
        luis.setFitHeight(100);
        luis.setLayoutX(columna1);
        luis.setLayoutY(fila1);
        luis.setOnMouseClicked(evento -> {
            luis.setLayoutX(posicionXNini1);
            luis.setLayoutY(posicionYNini1);
            luis.setFitWidth(167);
            luis.setFitHeight(167);
        });

        ImageView diego = new ImageView("Imagenes/CosoPrueba.png");
        diego.setFitWidth(100);
        diego.setFitHeight(100);
        diego.setLayoutX(columna2);
        diego.setLayoutY(fila1);
        diego.setOnMouseClicked(evento -> {
            diego.setLayoutX(posicionXNini2);
            diego.setLayoutY(posicionYNini2);
            diego.setFitWidth(167);
            diego.setFitHeight(167);
        });

        ImageView callejo = new ImageView("Imagenes/CosoPrueba.png");
        callejo.setFitWidth(100);
        callejo.setFitHeight(100);
        callejo.setLayoutX(columna3);
        callejo.setLayoutY(fila1);
        callejo.setOnMouseClicked(evento -> {
            callejo.setLayoutX(posicionXNini3);
            callejo.setLayoutY(posicionYNini3);
            callejo.setFitWidth(167);
            callejo.setFitHeight(167);
        });

        ImageView adripan = new ImageView("Imagenes/CosoPrueba.png");
        adripan.setFitWidth(100);
        adripan.setFitHeight(100);
        adripan.setLayoutX(columna4);
        adripan.setLayoutY(fila1);
        adripan.setOnMouseClicked(evento -> {
            adripan.setLayoutX(posicionXNini4);
            adripan.setLayoutY(posicionYNini4);
            adripan.setFitWidth(167);
            adripan.setFitHeight(167);
        });

        ImageView isma = new ImageView("Imagenes/CosoPrueba.png");
        isma.setFitWidth(100);
        isma.setFitHeight(100);
        isma.setLayoutX(columna5);
        isma.setLayoutY(fila1);
        isma.setOnMouseClicked(evento -> {
            isma.setLayoutX(posicionXNini5);
            isma.setLayoutY(posicionYNini5);
            isma.setFitWidth(167);
            isma.setFitHeight(167);
        });


        // fila 2
        ImageView ximena = new ImageView("Imagenes/CosoPrueba.png");
        ximena.setFitWidth(100);
        ximena.setFitHeight(100);
        ximena.setLayoutX(columna1);
        ximena.setLayoutY(fila2);
        ximena.setOnMouseClicked(evento -> {
            ximena.setLayoutX(posicionXNini6);
            ximena.setLayoutY(posicionYNini6);
            ximena.setFitWidth(167);
            ximena.setFitHeight(167);
        });

        ImageView timon = new ImageView("Imagenes/CosoPrueba.png");
        timon.setFitWidth(100);
        timon.setFitHeight(100);
        timon.setLayoutX(columna2);
        timon.setLayoutY(fila2);
        timon.setOnMouseClicked(evento -> {
            timon.setLayoutX(posicionXNini7);
            timon.setLayoutY(posicionYNini7);
            timon.setFitWidth(167);
            timon.setFitHeight(167);
        });

        ImageView guille = new ImageView("Imagenes/CosoPrueba.png");
        guille.setFitWidth(100);
        guille.setFitHeight(100);
        guille.setLayoutX(columna3);
        guille.setLayoutY(fila2);
        guille.setOnMouseClicked(evento -> {
            guille.setLayoutX(posicionXNini8);
            guille.setLayoutY(posicionYNini8);
            guille.setFitWidth(167);
            guille.setFitHeight(167);
        });

        ImageView dani = new ImageView("Imagenes/CosoPrueba.png");
        dani.setFitWidth(100);
        dani.setFitHeight(100);
        dani.setLayoutX(columna4);
        dani.setLayoutY(fila2);

        ImageView keke = new ImageView("Imagenes/CosoPrueba.png");
        keke.setFitWidth(100);
        keke.setFitHeight(100);
        keke.setLayoutX(columna5);
        keke.setLayoutY(fila2);


        // fila 3
        ImageView guevara = new ImageView("Imagenes/CosoPrueba.png");
        guevara.setFitWidth(100);
        guevara.setFitHeight(100);
        guevara.setLayoutX(columna1);
        guevara.setLayoutY(fila3);

        ImageView lorena = new ImageView("Imagenes/CosoPrueba.png");
        lorena.setFitWidth(100);
        lorena.setFitHeight(100);
        lorena.setLayoutX(columna2);
        lorena.setLayoutY(fila3);

        ImageView maria = new ImageView("Imagenes/CosoPrueba.png");
        maria.setFitWidth(100);
        maria.setFitHeight(100);
        maria.setLayoutX(columna3);
        maria.setLayoutY(fila3);

        ImageView jud = new ImageView("Imagenes/CosoPrueba.png");
        jud.setFitWidth(100);
        jud.setFitHeight(100);
        jud.setLayoutX(columna4);
        jud.setLayoutY(fila3);

        ImageView elsa = new ImageView("Imagenes/CosoPrueba.png");
        elsa.setFitWidth(100);
        elsa.setFitHeight(100);
        elsa.setLayoutX(columna5);
        elsa.setLayoutY(fila3);

        // fila 4
        ImageView eliseo = new ImageView("Imagenes/CosoPrueba.png");
        eliseo.setFitWidth(100);
        eliseo.setFitHeight(100);
        eliseo.setLayoutX(columna1);
        eliseo.setLayoutY(fila4);

        ImageView hueco1 = new ImageView("Imagenes/CosoPrueba.png");
        hueco1.setFitWidth(100);
        hueco1.setFitHeight(100);
        hueco1.setLayoutX(columna2);
        hueco1.setLayoutY(fila4);

        ImageView hueco2 = new ImageView("Imagenes/CosoPrueba.png");
        hueco2.setFitWidth(100);
        hueco2.setFitHeight(100);
        hueco2.setLayoutX(columna3);
        hueco2.setLayoutY(fila4);

        ImageView hueco3 = new ImageView("Imagenes/CosoPrueba.png");
        hueco3.setFitWidth(100);
        hueco3.setFitHeight(100);
        hueco3.setLayoutX(columna4);
        hueco3.setLayoutY(fila4);

        ImageView hueco4 = new ImageView("Imagenes/CosoPrueba.png");
        hueco4.setFitWidth(100);
        hueco4.setFitHeight(100);
        hueco4.setLayoutX(columna5);
        hueco4.setLayoutY(fila4);


        Pane root = new Pane(fondo,titulo,btnSalir,luis,diego,callejo,adripan,isma,ximena,timon,guille,dani,keke,guevara,lorena,maria,jud,elsa,eliseo,hueco1,hueco2,hueco3,hueco4);
        return new Scene(root, 1280, 720);
    }

}
