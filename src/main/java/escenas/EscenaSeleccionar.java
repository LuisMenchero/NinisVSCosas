package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelos.GestorInventario;

import java.util.HashMap;

public class EscenaSeleccionar {

    public Scene construir(Stage stage) {


        ImageView fondo = new ImageView("imagenes/SeleccionPlanta.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Text titulo = new Text("-- Selecciona tus Ninis --");
        titulo.setStyle("-fx-font-size: 40px;");
        titulo.setLayoutX(55);
        titulo.setLayoutY(100);
        titulo.setFill(Color.WHITE);

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

        // posiciones de las descripciones
        // imagen
        int posicionXDescFoto = 1027;
        int posicionYDescFoto = 80;
        int tamañoDescFoto = 165;

        ImageView fotoDesc = new ImageView();
        fotoDesc.setFitWidth(tamañoDescFoto);
        fotoDesc.setFitHeight(tamañoDescFoto);
        fotoDesc.setLayoutX(posicionXDescFoto);
        fotoDesc.setLayoutY(posicionYDescFoto);

        Text nombreNini = new Text();
        nombreNini.setStyle("-fx-font-size: 20px;");
        nombreNini.setLayoutX(1027);
        nombreNini.setLayoutY(270);
        nombreNini.setFill(Color.WHITE);

        Text descNini = new Text();

        Text costeNini = new Text();

        Text vidaNini = new Text();

        Text dañoNini = new Text();




        // fila 1
        ImageView luis = new ImageView("Imagenes/Luis_Cuadricula.png");
        luis.setFitWidth(100);
        luis.setFitHeight(100);
        luis.setLayoutX(columna1);
        luis.setLayoutY(fila1);

        luis.setOnMouseClicked(evento -> {
            colocar(luis);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Lis.gif"));
            nombreNini.setText("-- LUIS --");
        });

        ImageView diego = new ImageView("Imagenes/Diegosaas_1.png");
        diego.setFitWidth(100);
        diego.setFitHeight(100);
        diego.setLayoutX(columna2);
        diego.setLayoutY(fila1);
        diego.setOnMouseClicked(evento -> {
            colocar(diego);
            fotoDesc.setImage(new Image("Animaciones/Ninis/DiegoEsperando.gif"));
            nombreNini.setText("-- DIEGO --");
        });

        ImageView callejo = new ImageView("Imagenes/Callejones.png");
        callejo.setFitWidth(100);
        callejo.setFitHeight(100);
        callejo.setLayoutX(columna3);
        callejo.setLayoutY(fila1);
        callejo.setOnMouseClicked(evento -> {
            colocar(callejo);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Callejo_idle.gif"));
            nombreNini.setText("-- CALLEJO --");
        });

        ImageView adripan = new ImageView("Imagenes/Adrinap.png");
        adripan.setFitWidth(100);
        adripan.setFitHeight(100);
        adripan.setLayoutX(columna4);
        adripan.setLayoutY(fila1);
        adripan.setOnMouseClicked(evento -> {
            colocar(adripan);
            fotoDesc.setImage(new Image("Animaciones/Ninis/AdripanEsperando.gif"));
            nombreNini.setText("-- ADRIPAN --");
        });

        ImageView isma = new ImageView("Imagenes/CosoPrueba.png");
        isma.setFitWidth(100);
        isma.setFitHeight(100);
        isma.setLayoutX(columna5);
        isma.setLayoutY(fila1);
        isma.setOnMouseClicked(evento -> {
            colocar(isma);

            nombreNini.setText("-- ISMA --");
        });


        // fila 2
        ImageView ximena = new ImageView("Imagenes/CosoPrueba.png");
        ximena.setFitWidth(100);
        ximena.setFitHeight(100);
        ximena.setLayoutX(columna1);
        ximena.setLayoutY(fila2);
        ximena.setOnMouseClicked(evento -> {
            colocar(ximena);

            nombreNini.setText("-- XIMENA --");
        });

        ImageView lopez = new ImageView("Imagenes/Lucillos.png");
        lopez.setFitWidth(100);
        lopez.setFitHeight(100);
        lopez.setLayoutX(columna2);
        lopez.setLayoutY(fila2);
        lopez.setOnMouseClicked(evento -> {
            colocar(lopez);

            fotoDesc.setImage(new Image("Animaciones/Ninis/LopezEsperando.gif"));
            nombreNini.setText("-- LÓPEZ --");
        });

        ImageView guille = new ImageView("Imagenes/CosoPrueba.png");
        guille.setFitWidth(100);
        guille.setFitHeight(100);
        guille.setLayoutX(columna3);
        guille.setLayoutY(fila2);
        guille.setOnMouseClicked(evento -> {
            colocar(guille);

            nombreNini.setText("-- GUILLE --");
        });

        ImageView dani = new ImageView("Imagenes/CosoPrueba.png");
        dani.setFitWidth(100);
        dani.setFitHeight(100);
        dani.setLayoutX(columna4);
        dani.setLayoutY(fila2);
        dani.setOnMouseClicked(evento -> {
            colocar(dani);

            nombreNini.setText("-- DANI --");
        });

        ImageView keke = new ImageView("Imagenes/CosoPrueba.png");
        keke.setFitWidth(100);
        keke.setFitHeight(100);
        keke.setLayoutX(columna5);
        keke.setLayoutY(fila2);
        keke.setOnMouseClicked(evento -> {
            colocar(keke);

            nombreNini.setText("-- KEKE --");
        });

        // fila 3
        ImageView guevara = new ImageView("Imagenes/Guevarote.png");
        guevara.setFitWidth(100);
        guevara.setFitHeight(100);
        guevara.setLayoutX(columna1);
        guevara.setLayoutY(fila3);
        guevara.setOnMouseClicked(evento -> {
            colocar(guevara);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Guevara_Idle.gif"));
            nombreNini.setText("-- GUEVARA --");
        });

        ImageView lorena = new ImageView("Imagenes/CosoPrueba.png");
        lorena.setFitWidth(100);
        lorena.setFitHeight(100);
        lorena.setLayoutX(columna2);
        lorena.setLayoutY(fila3);
        lorena.setOnMouseClicked(evento -> {
            colocar(lorena);

            nombreNini.setText("-- LORENA --");
        });

        ImageView maria = new ImageView("Imagenes/CosoPrueba.png");
        maria.setFitWidth(100);
        maria.setFitHeight(100);
        maria.setLayoutX(columna3);
        maria.setLayoutY(fila3);
        maria.setOnMouseClicked(evento -> {
            colocar(maria);

            nombreNini.setText("-- MARIA --");
        });

        ImageView jud = new ImageView("Imagenes/CosoPrueba.png");
        jud.setFitWidth(100);
        jud.setFitHeight(100);
        jud.setLayoutX(columna4);
        jud.setLayoutY(fila3);
        jud.setOnMouseClicked(evento -> {
            colocar(jud);

            nombreNini.setText("-- JUD --");
        });

        ImageView elsa = new ImageView("Imagenes/CosoPrueba.png");
        elsa.setFitWidth(100);
        elsa.setFitHeight(100);
        elsa.setLayoutX(columna5);
        elsa.setLayoutY(fila3);
        elsa.setOnMouseClicked(evento -> {
            colocar(elsa);

            nombreNini.setText("-- ELSA --");
        });

        // fila 4
        ImageView eliseo = new ImageView("Imagenes/CosoPrueba.png");
        eliseo.setFitWidth(100);
        eliseo.setFitHeight(100);
        eliseo.setLayoutX(columna1);
        eliseo.setLayoutY(fila4);
        eliseo.setOnMouseClicked(evento -> {
            colocar(eliseo);

            nombreNini.setText("-- ELISEO --");
        });

        ImageView hueco1 = new ImageView("Imagenes/CosoPrueba.png");
        hueco1.setFitWidth(100);
        hueco1.setFitHeight(100);
        hueco1.setLayoutX(columna2);
        hueco1.setLayoutY(fila4);
        hueco1.setOnMouseClicked(evento -> {
            colocar(hueco1);

            nombreNini.setText("-- --- --");
        });

        ImageView hueco2 = new ImageView("Imagenes/CosoPrueba.png");
        hueco2.setFitWidth(100);
        hueco2.setFitHeight(100);
        hueco2.setLayoutX(columna3);
        hueco2.setLayoutY(fila4);
        hueco2.setOnMouseClicked(evento -> {
            colocar(hueco2);

            nombreNini.setText("-- --- --");
        });

        ImageView hueco3 = new ImageView("Imagenes/CosoPrueba.png");
        hueco3.setFitWidth(100);
        hueco3.setFitHeight(100);
        hueco3.setLayoutX(columna4);
        hueco3.setLayoutY(fila4);
        hueco3.setOnMouseClicked(evento -> {
            colocar(hueco3);

            nombreNini.setText("-- --- --");
        });

        ImageView hueco4 = new ImageView("Imagenes/CosoPrueba.png");
        hueco4.setFitWidth(100);
        hueco4.setFitHeight(100);
        hueco4.setLayoutX(columna5);
        hueco4.setLayoutY(fila4);
        hueco4.setOnMouseClicked(evento -> {
            colocar(hueco4);

            nombreNini.setText("-- --- --");
        });

//        for (int i = 0; i < geInv.getInventario().length-1; i++) {
//            if (geInv.getInventario()[i] != null) {
//                precargarImagenes();
//            }
//        }

        GestorInventario geInv = new GestorInventario();

        Pane root = new Pane(fondo,titulo,btnSalir,nombreNini,luis, fotoDesc,diego,callejo,adripan,isma,ximena, lopez,guille,dani,keke,guevara,lorena,maria,jud,elsa,eliseo,hueco1,hueco2,hueco3,hueco4);
        return new Scene(root, 1280, 720);
    }

    public void colocar(ImageView niniSeleccionado){
        GestorInventario geInv = GestorInventario.getInstancia();
        int posicion = geInv.añadirNiniInventario(niniSeleccionado);

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

        niniSeleccionado.setFitWidth(167);
        niniSeleccionado.setFitHeight(167);

        if (posicion == 0) {
            niniSeleccionado.setLayoutX(posicionXNini1);
            niniSeleccionado.setLayoutY(posicionYNini1);
        } else if (posicion == 1) {
            niniSeleccionado.setLayoutX(posicionXNini2);
            niniSeleccionado.setLayoutY(posicionYNini2);
        } else if (posicion == 2) {
            niniSeleccionado.setLayoutX(posicionXNini3);
            niniSeleccionado.setLayoutY(posicionYNini3);
        } else if (posicion == 3) {
            niniSeleccionado.setLayoutX(posicionXNini4);
            niniSeleccionado.setLayoutY(posicionYNini4);
        } else if (posicion == 4) {
            niniSeleccionado.setLayoutX(posicionXNini5);
            niniSeleccionado.setLayoutY(posicionYNini5);
        }  else if (posicion == 5) {
            niniSeleccionado.setLayoutX(posicionXNini6);
            niniSeleccionado.setLayoutY(posicionYNini6);
        }  else if (posicion == 6) {
            niniSeleccionado.setLayoutX(posicionXNini7);
            niniSeleccionado.setLayoutY(posicionYNini7);
        }  else if (posicion == 7) {
            niniSeleccionado.setLayoutX(posicionXNini8);
            niniSeleccionado.setLayoutY(posicionYNini8);
        } else {
            System.out.println("Error: posicion incorrecto");
        }
    }

    public void precargarImagenes() {
        GestorInventario geInv = new GestorInventario();

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

        for (int i = 0; i < geInv.getInventario().length-1; i++) {
            if (geInv.getInventario()[i] != null) {
                geInv.getInventario()[i].setFitWidth(167);
                geInv.getInventario()[i].setFitHeight(167);

                if (i == 0) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini1);
                    geInv.getInventario()[i].setLayoutY(posicionYNini1);
                } else if (i == 1) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini2);
                    geInv.getInventario()[i].setLayoutY(posicionYNini2);
                } else if (i == 2) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini3);
                    geInv.getInventario()[i].setLayoutY(posicionYNini3);
                } else if (i == 3) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini4);
                    geInv.getInventario()[i].setLayoutY(posicionYNini4);
                } else if (i == 4) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini5);
                    geInv.getInventario()[i].setLayoutY(posicionYNini5);
                }  else if (i == 5) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini6);
                    geInv.getInventario()[i].setLayoutY(posicionYNini6);
                }  else if (i == 6) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini7);
                    geInv.getInventario()[i].setLayoutY(posicionYNini7);
                }  else if (i == 7) {
                    geInv.getInventario()[i].setLayoutX(posicionXNini8);
                    geInv.getInventario()[i].setLayoutY(posicionYNini8);
                }
            }
        }
    }

}
