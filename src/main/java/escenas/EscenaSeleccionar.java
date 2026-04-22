package escenas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelos.GestorInventario;

import javax.swing.*;
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
        nombreNini.setStyle("-fx-font-size: 30px;");
        nombreNini.setLayoutX(1027);
        nombreNini.setLayoutY(280);
        nombreNini.setFill(Color.WHITE);
        nombreNini.setTextAlignment(TextAlignment.CENTER);

        Text descNini = new Text();
        descNini.setStyle("-fx-font-size: 15px;");
        descNini.setLayoutX(970);
        descNini.setLayoutY(310);
        descNini.setFill(Color.WHITE);
        nombreNini.setTextAlignment(TextAlignment.CENTER);

        Text costeNini = new Text();
        costeNini.setLayoutX(970);
        costeNini.setLayoutY(420);
        costeNini.setFill(Color.WHITE);

        Text vidaNini = new Text();
        vidaNini.setLayoutX(1110);
        vidaNini.setLayoutY(420);
        vidaNini.setFill(Color.WHITE);

        Text alcanceAtaque = new Text();
        alcanceAtaque.setLayoutX(970);
        alcanceAtaque.setLayoutY(490);
        alcanceAtaque.setFill(Color.WHITE);

        Text radioAtaque = new Text();
        radioAtaque.setLayoutX(1110);
        radioAtaque.setLayoutY(490);
        radioAtaque.setFill(Color.WHITE);

        Text tipoProyectil = new Text();
        tipoProyectil.setLayoutX(970);
        tipoProyectil.setLayoutY(540);
        tipoProyectil.setFill(Color.WHITE);

        Text dañoNini = new Text();
        dañoNini.setLayoutX(1110);
        dañoNini.setLayoutY(540);
        dañoNini.setFill(Color.WHITE);




        // fila 1
        ImageView luis = new ImageView("Imagenes/Luis_Cuadricula.png");
        luis.setFitWidth(100);
        luis.setFitHeight(100);
        luis.setLayoutX(columna1);
        luis.setLayoutY(fila1);

        luis.setOnMouseClicked(evento -> {
            colocar("luis", luis);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Lis.gif"));
            nombreNini.setText("-- LUIS --");
            descNini.setText(" Luis bla bla bla, ble ble ble,\n blo blo blo");
            costeNini.setText(" - COSTE BUTANITOS - \n - 50 butanitos.");
            vidaNini.setText(" - SALUD - \n - 75 puntos de salud.");
            alcanceAtaque.setText(" - TIEMPO DE GENERACION DE BUTANITOS - \n - 10 segundos.");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
        });

        ImageView diego = new ImageView("Imagenes/Diegosaas_1.png");
        diego.setFitWidth(100);
        diego.setFitHeight(100);
        diego.setLayoutX(columna2);
        diego.setLayoutY(fila1);
        diego.setOnMouseClicked(evento -> {
            colocar("diego", diego);
            fotoDesc.setImage(new Image("Animaciones/Ninis/DiegoEsperando.gif"));
            nombreNini.setText("-- DIEGO --");
            descNini.setText(" Diego es un bajista profesional. Con sus \n solos de bajo, conmueve a sus enemigos \n y eso les hace algo de daño.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 100 butanitos.");
            vidaNini.setText(" - SALUD - \n - 100 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 enemigo.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Nota.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView callejo = new ImageView("Imagenes/Callejones.png");
        callejo.setFitWidth(100);
        callejo.setFitHeight(100);
        callejo.setLayoutX(columna3);
        callejo.setLayoutY(fila1);
        callejo.setOnMouseClicked(evento -> {
            colocar("callejo", callejo);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Callejo_idle.gif"));
            nombreNini.setText("-- CALLEJO --");
            descNini.setText(" Callejo blabla.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 50 butanitos.");
            vidaNini.setText(" - SALUD - \n - 200 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
        });

        ImageView adripan = new ImageView("Imagenes/Adrinap.png");
        adripan.setFitWidth(100);
        adripan.setFitHeight(100);
        adripan.setLayoutX(columna4);
        adripan.setLayoutY(fila1);
        adripan.setOnMouseClicked(evento -> {
            colocar("adripan", adripan);
            fotoDesc.setImage(new Image("Animaciones/Ninis/AdripanEsperando.gif"));
            nombreNini.setText("-- ADRIPAN --");
            descNini.setText(" Adripan blablabla.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 25 butanitos.");
            vidaNini.setText(" - SALUD - \n - 80 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - Casillas de alrededor.");
            tipoProyectil.setText(" - TIPO DE ATAQUE - \n - Explosión.");
            dañoNini.setText(" - DAÑO - \n - Daño de explosión: --- .");
        });

        ImageView isma = new ImageView("Imagenes/CosoPrueba.png");
        isma.setFitWidth(100);
        isma.setFitHeight(100);
        isma.setLayoutX(columna5);
        isma.setLayoutY(fila1);
        isma.setOnMouseClicked(evento -> {
            colocar("isma", isma);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- ISMA --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });


        // fila 2
        ImageView ximena = new ImageView("Imagenes/CosoPrueba.png");
        ximena.setFitWidth(100);
        ximena.setFitHeight(100);
        ximena.setLayoutX(columna1);
        ximena.setLayoutY(fila2);
        ximena.setOnMouseClicked(evento -> {
            colocar("ximena", ximena);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Ximena_idle.gif"));
            nombreNini.setText("-- XIMENA --");

        });

        ImageView lopez = new ImageView("Imagenes/Lucillos.png");
        lopez.setFitWidth(100);
        lopez.setFitHeight(100);
        lopez.setLayoutX(columna2);
        lopez.setLayoutY(fila2);
        lopez.setOnMouseClicked(evento -> {
            colocar("lopez",lopez);
            fotoDesc.setImage(new Image("Animaciones/Ninis/LopezEsperando.gif"));
            nombreNini.setText("-- LÓPEZ --");

        });

        ImageView guille = new ImageView("Imagenes/CosoPrueba.png");
        guille.setFitWidth(100);
        guille.setFitHeight(100);
        guille.setLayoutX(columna3);
        guille.setLayoutY(fila2);
        guille.setOnMouseClicked(evento -> {
            colocar("guille",guille);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- GUILLE --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView dani = new ImageView("Imagenes/CosoPrueba.png");
        dani.setFitWidth(100);
        dani.setFitHeight(100);
        dani.setLayoutX(columna4);
        dani.setLayoutY(fila2);
        dani.setOnMouseClicked(evento -> {
            colocar("dani",dani);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- DANI --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView keke = new ImageView("Imagenes/CosoPrueba.png");
        keke.setFitWidth(100);
        keke.setFitHeight(100);
        keke.setLayoutX(columna5);
        keke.setLayoutY(fila2);
        keke.setOnMouseClicked(evento -> {
            colocar("keke",keke);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- KEKE --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        // fila 3
        ImageView guevara = new ImageView("Imagenes/Guevarote.png");
        guevara.setFitWidth(100);
        guevara.setFitHeight(100);
        guevara.setLayoutX(columna1);
        guevara.setLayoutY(fila3);
        guevara.setOnMouseClicked(evento -> {
            colocar("guevara",guevara);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Guevara_Idle.gif"));
            nombreNini.setText("-- GUEVARA --");
        });

        ImageView lorena = new ImageView("Imagenes/CosoPrueba.png");
        lorena.setFitWidth(100);
        lorena.setFitHeight(100);
        lorena.setLayoutX(columna2);
        lorena.setLayoutY(fila3);
        lorena.setOnMouseClicked(evento -> {
            colocar("lorena",lorena);
            // fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- LORENA --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView maria = new ImageView("Imagenes/CosoPrueba.png");
        maria.setFitWidth(100);
        maria.setFitHeight(100);
        maria.setLayoutX(columna3);
        maria.setLayoutY(fila3);
        maria.setOnMouseClicked(evento -> {
            colocar("maria",maria);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- MARIA --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView jud = new ImageView("Imagenes/CosoPrueba.png");
        jud.setFitWidth(100);
        jud.setFitHeight(100);
        jud.setLayoutX(columna4);
        jud.setLayoutY(fila3);
        jud.setOnMouseClicked(evento -> {
            colocar("jud",jud);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- JUD --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView elsa = new ImageView("Imagenes/CosoPrueba.png");
        elsa.setFitWidth(100);
        elsa.setFitHeight(100);
        elsa.setLayoutX(columna5);
        elsa.setLayoutY(fila3);
        elsa.setOnMouseClicked(evento -> {
            colocar("elsa",elsa);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- ELSA --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        // fila 4
        ImageView eliseo = new ImageView("Imagenes/CosoPrueba.png");
        eliseo.setFitWidth(100);
        eliseo.setFitHeight(100);
        eliseo.setLayoutX(columna1);
        eliseo.setLayoutY(fila4);
        eliseo.setOnMouseClicked(evento -> {
            colocar("eliseo",eliseo);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- ELISEO --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView hueco1 = new ImageView("Imagenes/CosoPrueba.png");
        hueco1.setFitWidth(100);
        hueco1.setFitHeight(100);
        hueco1.setLayoutX(columna2);
        hueco1.setLayoutY(fila4);
        hueco1.setOnMouseClicked(evento -> {
            colocar("hueco1",hueco1);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- --- --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView hueco2 = new ImageView("Imagenes/CosoPrueba.png");
        hueco2.setFitWidth(100);
        hueco2.setFitHeight(100);
        hueco2.setLayoutX(columna3);
        hueco2.setLayoutY(fila4);
        hueco2.setOnMouseClicked(evento -> {
            colocar("hueco2",hueco2);
            // fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- --- --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView hueco3 = new ImageView("Imagenes/CosoPrueba.png");
        hueco3.setFitWidth(100);
        hueco3.setFitHeight(100);
        hueco3.setLayoutX(columna4);
        hueco3.setLayoutY(fila4);
        hueco3.setOnMouseClicked(evento -> {
            colocar("hueco3",hueco3);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- --- --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

        ImageView hueco4 = new ImageView("Imagenes/CosoPrueba.png");
        hueco4.setFitWidth(100);
        hueco4.setFitHeight(100);
        hueco4.setLayoutX(columna5);
        hueco4.setLayoutY(fila4);
        hueco4.setOnMouseClicked(evento -> {
            colocar("hueco4",hueco4);
            //fotoDesc.setImage(new Image(""));
            nombreNini.setText("-- --- --");
            descNini.setText("");
            costeNini.setText(" - COSTE BUTANITOS - \n - --- butanitos.");
            vidaNini.setText(" - SALUD - \n - --- puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - ---.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - ---.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - ---.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: --- .");
        });

//        for (int i = 0; i < geInv.getInventario().length-1; i++) {
//            if (geInv.getInventario()[i] != null) {
//                precargarImagenes();
//            }
//        }

        GestorInventario geInv = GestorInventario.getInstancia();
        HashMap<String, ImageView> nombresImagenes = new HashMap<>();
        nombresImagenes.put("luis", luis);
        nombresImagenes.put("diego", diego);
        nombresImagenes.put("callejo", callejo);
        nombresImagenes.put("adripan", adripan);
        nombresImagenes.put("guevara", guevara);
        nombresImagenes.put("lopez", lopez);
        nombresImagenes.put("isma", isma);
        nombresImagenes.put("ximena", ximena);
        nombresImagenes.put("guille", guille);
        nombresImagenes.put("dani", dani);
        nombresImagenes.put("keke", keke);
        nombresImagenes.put("lorena", lorena);
        nombresImagenes.put("maria", maria);
        nombresImagenes.put("jud", jud);
        nombresImagenes.put("elsa", elsa);
        nombresImagenes.put("eliseo", eliseo);

        String [] inventarioCopia = geInv.getInventario();
        for (int i = 0; i < 8; i++){
            if (inventarioCopia[i] != null && nombresImagenes.containsKey(inventarioCopia[i])) {
                ImageView niniSeleccionado = nombresImagenes.get(inventarioCopia[i]);
                int posicion = geInv.getPosicionActual(inventarioCopia[i]);

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
                }
            }
        }

        Pane root = new Pane(fondo,titulo,btnSalir,nombreNini,descNini,costeNini,dañoNini,vidaNini,alcanceAtaque,radioAtaque,tipoProyectil,luis, fotoDesc,diego,callejo,adripan,isma,ximena, lopez,guille,dani,keke,guevara,lorena,maria,jud,elsa,eliseo,hueco1,hueco2,hueco3,hueco4);
        return new Scene(root, 1280, 720);
    }

    public void colocar(String nombreNini, ImageView niniSeleccionado){
        GestorInventario geInv = GestorInventario.getInstancia();
        int posicion = geInv.añadirNiniInventario(nombreNini);

        if (posicion == 100){
            return;
        }

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

}
