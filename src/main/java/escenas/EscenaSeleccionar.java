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
import modelos.Ninis.TipoNini;

import java.util.HashMap;

/**
 * Representa la Escena seleccionar del juego
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class EscenaSeleccionar {

    /**
     * Construye la escena de seleccion y pone las cosas en sus sitios
     * @param stage ventana de la aplicacion
     * @return Scene
     */
    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/SeleccionPlanta.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Text titulo = new Text("-- Selecciona tus Ninis --");
        titulo.setStyle("-fx-font-size: 40px;");
        titulo.setLayoutX(55);
        titulo.setLayoutY(100);
        titulo.setFill(Color.web("#7289da"));

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(225);
        btnSalir.setLayoutY(580);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
        });

        btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnSalir.setOnMouseEntered(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnSalir.setOnMouseExited(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});



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

        Button btnQuitarNini = new Button("Quitar Nini");
        btnQuitarNini.setLayoutX(1000);
        btnQuitarNini.setLayoutY(620);
        btnQuitarNini.setVisible(false);
        btnQuitarNini.setStyle("-fx-background-color: none; -fx-text-fill: #dc3838; -fx-font-size: 35px;");
        btnQuitarNini.setOnMouseEntered(evento -> {btnQuitarNini.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnQuitarNini.setOnMouseExited(evento -> {btnQuitarNini.setStyle("-fx-background-color: none; -fx-text-fill: #dc3838; -fx-font-size: 35px;");});




        // fila 1
        ImageView luis = new ImageView("Imagenes/Luis_Cuadricula.png");
        luis.setFitWidth(100);
        luis.setFitHeight(100);
        luis.setLayoutX(columna1);
        luis.setLayoutY(fila1);

        luis.setOnMouseClicked(evento -> {
            colocar(TipoNini.LUIS, luis);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Lis.gif"));
            nombreNini.setText("-- LUIS --");
            descNini.setText(" Luis es un hacker que consigue saltarse\n cualquier sistema de seguridad. Con el \n tiempo, consigue robar Butanitos y te los\n da para que los uses.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 50 butanitos.");
            vidaNini.setText(" - SALUD - \n - 75 puntos de salud.");
            alcanceAtaque.setText(" - TIEMPO DE GENERACION DE BUTANITOS - \n - 25 segundos.");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.LUIS, luis, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView diego = new ImageView("Imagenes/Diegosaas_1.png");
        diego.setFitWidth(100);
        diego.setFitHeight(100);
        diego.setLayoutX(columna2);
        diego.setLayoutY(fila1);
        diego.setOnMouseClicked(evento -> {
            colocar(TipoNini.DIEGO, diego);
            fotoDesc.setImage(new Image("Animaciones/Ninis/DiegoEsperando.gif"));
            nombreNini.setText("-- DIEGO --");
            descNini.setText(" Diego es un bajista profesional. Con sus \n solos de bajo. \n Sus notas salen disparadas e impactan \n con el primer enemigo que se le cruce.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 100 butanitos.");
            vidaNini.setText(" - SALUD - \n - 100 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 enemigo.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Nota.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 20 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.DIEGO, diego, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView callejo = new ImageView("Imagenes/Callejones.png");
        callejo.setFitWidth(100);
        callejo.setFitHeight(100);
        callejo.setLayoutX(columna3);
        callejo.setLayoutY(fila1);
        callejo.setOnMouseClicked(evento -> {
            colocar(TipoNini.CALLEJO, callejo);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Callejo_idle.gif"));
            nombreNini.setText("-- CALLEJO --");
            descNini.setText(" Callejo es un escudo que aguanta \n bastantes golpes.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 50 butanitos.");
            vidaNini.setText(" - SALUD - \n - 500 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.CALLEJO, callejo, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView adripan = new ImageView("Imagenes/Adrinap.png");
        adripan.setFitWidth(100);
        adripan.setFitHeight(100);
        adripan.setLayoutX(columna4);
        adripan.setLayoutY(fila1);
        adripan.setOnMouseClicked(evento -> {
            colocar(TipoNini.ADRIPAN, adripan);
            fotoDesc.setImage(new Image("Animaciones/Ninis/AdripanEsperando.gif"));
            nombreNini.setText("-- ADRIPAN --");
            descNini.setText(" Adripan sale al campo a tomar el aire,\n cuando vapea, se carga y consigue \n la capacidad de explotar, haciendo\n mucho daño.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 25 butanitos.");
            vidaNini.setText(" - SALUD - \n - 80 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 3x3.");
            tipoProyectil.setText(" - TIPO DE ATAQUE - \n - Explosión.");
            dañoNini.setText(" - DAÑO - \n - Daño de explosión: 9999 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.ADRIPAN, adripan, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView isma = new ImageView("Imagenes/Ismahil.png");
        isma.setFitWidth(100);
        isma.setFitHeight(100);
        isma.setLayoutX(columna5);
        isma.setLayoutY(fila1);
        isma.setOnMouseClicked(evento -> {
            colocar(TipoNini.ISMA, isma);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Isma_Idle.gif"));
            nombreNini.setText("-- ISMA --");
            descNini.setText(" Isma se toma tranquilamente su café \n y su cigarro, pero si se cabrea  \n explota, haciendo mucho daño.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 150 butanitos.");
            vidaNini.setText(" - SALUD - \n - 50 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 3x3.");
            tipoProyectil.setText(" - TIPO DE ATAQUE - \n - Explosión.");
            dañoNini.setText(" - DAÑO - \n - Daño de explosión: 99999 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.ISMA, isma, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });


        // fila 2
        ImageView ximena = new ImageView("Imagenes/Guimena.png");
        ximena.setFitWidth(100);
        ximena.setFitHeight(100);
        ximena.setLayoutX(columna1);
        ximena.setLayoutY(fila2);
        ximena.setOnMouseClicked(evento -> {
            colocar(TipoNini.XIMENA, ximena);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Ximena_idle.gif"));
            nombreNini.setText("-- XIMENA --");
            descNini.setText(" Ximena le encantan las focas, \n tanto que ha aprendido magia \n para hacer aparecer una encima del \n que le ataque.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 50 butanitos.");
            vidaNini.setText(" - SALUD - \n - 500 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 casilla.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.XIMENA, ximena, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView lopez = new ImageView("Imagenes/Lucillos.png");
        lopez.setFitWidth(100);
        lopez.setFitHeight(100);
        lopez.setLayoutX(columna2);
        lopez.setLayoutY(fila2);
        lopez.setOnMouseClicked(evento -> {
            colocar(TipoNini.LOPEZ, lopez);
            fotoDesc.setImage(new Image("Animaciones/Ninis/LopezEsperando.gif"));
            nombreNini.setText("-- LÓPEZ --");
            descNini.setText(" '¿Qué hash dixo de mi pueblo? \n A que te egcupo.' ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 75 butanitos.");
            vidaNini.setText(" - SALUD - \n - 100 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - Toda la linea.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Escupitajo.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 20 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.LOPEZ, lopez, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });

        });

        ImageView guille = new ImageView("Imagenes/Guille_No_Seleccion.png");
        guille.setFitWidth(100);
        guille.setFitHeight(100);
        guille.setLayoutX(columna3);
        guille.setLayoutY(fila2);
        guille.setOnMouseClicked(evento -> {
            colocar(TipoNini.GUILLE, guille);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Guille_Idle.gif"));
            nombreNini.setText("-- GUILLE --");
            descNini.setText(" 'Aúpa Atleti' Guille hace crecer su \n cabeza y le mete una patada.");
            costeNini.setText(" - COSTE BUTANITOS - \n - 175 butanitos.");
            vidaNini.setText(" - SALUD - \n - 125 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - Toda la fila.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Cabeza de Guille.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 99999 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.GUILLE, guille, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView dani = new ImageView("Imagenes/Dani_no_seleccion.png");
        dani.setFitWidth(100);
        dani.setFitHeight(100);
        dani.setLayoutX(columna4);
        dani.setLayoutY(fila2);
        dani.setOnMouseClicked(evento -> {
            colocar(TipoNini.DANI, dani);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Dani_idle.gif"));
            nombreNini.setText("-- DANI --");
            descNini.setText(" Es un gran jugador de baloncesto,\n lanza triples a sus enemigos para \n matarlos. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 300 butanitos.");
            vidaNini.setText(" - SALUD - \n - 100 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 objetivo de la fila.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Pelota de Baloncesto.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 200 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.DANI, dani, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView keke = new ImageView("Imagenes/Keke_No_Seleccion.png");
        keke.setFitWidth(100);
        keke.setFitHeight(100);
        keke.setLayoutX(columna5);
        keke.setLayoutY(fila2);
        keke.setOnMouseClicked(evento -> {
            colocar(TipoNini.KEKE, keke);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Keke_Idle.gif"));
            nombreNini.setText("-- KEKE --");
            descNini.setText(" 'MMMMBIIIMM MBIM MBIM' \n (Sonidos de puñetazos) ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 175 butanitos.");
            vidaNini.setText(" - SALUD - \n - 175 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 casilla.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.KEKE, keke, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        // fila 3
        ImageView guevara = new ImageView("Imagenes/Guevarote.png");
        guevara.setFitWidth(100);
        guevara.setFitHeight(100);
        guevara.setLayoutX(columna1);
        guevara.setLayoutY(fila3);
        guevara.setOnMouseClicked(evento -> {
            colocar(TipoNini.GUEVARA, guevara);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Guevara_Idle.gif"));
            nombreNini.setText("-- GUEVARA --");
            descNini.setText(" Con su gran flan potencia a todos sus fans ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 25 butanitos.");
            vidaNini.setText(" - SALUD - \n - 500 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.GUEVARA, guevara, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView lorena = new ImageView("Imagenes/Lorena_no_seleccion.png");
        lorena.setFitWidth(100);
        lorena.setFitHeight(100);
        lorena.setLayoutX(columna2);
        lorena.setLayoutY(fila3);
        lorena.setOnMouseClicked(evento -> {
            colocar(TipoNini.LORENA, lorena);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Lorena_Idle.gif"));
            nombreNini.setText("-- LORENA --");
            descNini.setText(" 'Me consta que ahora estais curados' ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 25 butanitos.");
            vidaNini.setText(" - SALUD - \n - 500 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.LORENA, lorena, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView maria = new ImageView("Imagenes/Maria_No_Seleccion.png");
        maria.setFitWidth(100);
        maria.setFitHeight(100);
        maria.setLayoutX(columna3);
        maria.setLayoutY(fila3);
        maria.setOnMouseClicked(evento -> {
            colocar(TipoNini.MARIA, maria);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Maria_Idle.gif"));
            nombreNini.setText("-- MARIA --");
            descNini.setText(" 'No te metas con Yuyu', \n cuidado si te metes con Yuyu,\n te metes con todos. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 150 butanitos.");
            vidaNini.setText(" - SALUD - \n - 125 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 casilla.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.MARIA, maria, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView jud = new ImageView("Imagenes/Jut_No_Seleccion.png");
        jud.setFitWidth(100);
        jud.setFitHeight(100);
        jud.setLayoutX(columna4);
        jud.setLayoutY(fila3);
        jud.setOnMouseClicked(evento -> {
            colocar(TipoNini.JUD, jud);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Jud_Idle.gif"));
            nombreNini.setText("-- JUD --");
            descNini.setText(" Jud sola, crea un correfoc en \n el terreno, quemando algunos proyectiles \n que pasen. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 175 butanitos.");
            vidaNini.setText(" - SALUD - \n - 125 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.JUD, jud, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView elsa = new ImageView("Imagenes/Elsa_No_Seleccion.png");
        elsa.setFitWidth(100);
        elsa.setFitHeight(100);
        elsa.setLayoutX(columna5);
        elsa.setLayoutY(fila3);
        elsa.setOnMouseClicked(evento -> {
            colocar(TipoNini.ELSA, elsa);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Elsa_Idle.gif"));
            nombreNini.setText("-- ELSA --");
            descNini.setText(" Elsa crea una tormenta de nieve que \n congela todo el terreno \n 'Let it go, let it go' ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 0 butanitos.");
            vidaNini.setText(" - SALUD - \n - 150 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - Todo el campo.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.ELSA, elsa, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        // fila 4
        ImageView eliseo = new ImageView("Imagenes/Eliseo_no_seleccion.png");
        eliseo.setFitWidth(100);
        eliseo.setFitHeight(100);
        eliseo.setLayoutX(columna1);
        eliseo.setLayoutY(fila4);
        eliseo.setOnMouseClicked(evento -> {
            colocar(TipoNini.ELISEO, eliseo);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Eliseo3bolas_Idle.gif"));
            nombreNini.setText("-- ELISEO --");
            descNini.setText(" Eliseo es un tio muy chill, simplemente \n empuja a los enemigos si se meten \n con él. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 75 butanitos.");
            vidaNini.setText(" - SALUD - \n - 75 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 casilla.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.ELISEO, eliseo, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView raul = new ImageView("Imagenes/Rayul.png");
        raul.setFitWidth(100);
        raul.setFitHeight(100);
        raul.setLayoutX(columna2);
        raul.setLayoutY(fila4);
        raul.setOnMouseClicked(evento -> {
            colocar(TipoNini.RAUL, raul);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Raul_Idle.gif"));
            nombreNini.setText("-- RAUL --");
            descNini.setText(" La obsesión por los Pikmin de Rayul le \n ha hecho poder convertirse en ellos, lanza \n Pikmins roca a sus enemigos. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 300 butanitos.");
            vidaNini.setText(" - SALUD - \n - 75 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 3 filas.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Pikmin.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 20 .");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.RAUL, raul, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView irene = new ImageView("Imagenes/Irene_No_Seleccion.png");
        irene.setFitWidth(100);
        irene.setFitHeight(100);
        irene.setLayoutX(columna3);
        irene.setLayoutY(fila4);
        irene.setOnMouseClicked(evento -> {
            colocar(TipoNini.IRENE, irene);
             fotoDesc.setImage(new Image("Animaciones/Ninis/Irene_Idle.gif"));
            nombreNini.setText("-- IRENE --");
            descNini.setText(" Irene hace un directo en TikTok, \n le donan rosas y con ellas te regala \n Butanitos. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 0 butanitos.");
            vidaNini.setText(" - SALUD - \n - 125 puntos de salud.");
            alcanceAtaque.setText("");
            radioAtaque.setText("");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.IRENE, irene, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView alvaro = new ImageView("Imagenes/Alvaro_No_Seleccion.png");
        alvaro.setFitWidth(100);
        alvaro.setFitHeight(100);
        alvaro.setLayoutX(columna4);
        alvaro.setLayoutY(fila4);
        alvaro.setOnMouseClicked(evento -> {
            colocar(TipoNini.ALVARO, alvaro);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Alvaro_Idle.gif"));
            nombreNini.setText("-- ALVARO --");
            descNini.setText(" 'Instalateh Linush yah andah', \n se desliza y relentiza a los enemigos que \n se le cruzan. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 75 butanitos.");
            vidaNini.setText(" - SALUD - \n - 125 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Lejano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 fila.");
            tipoProyectil.setText(" - TIPO DE PROYECTIL - \n - Alvaro Deslizando.");
            dañoNini.setText(" - DAÑO - \n - Daño por proyectil: 35.");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.ALVARO, alvaro, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        ImageView hamil = new ImageView("Imagenes/Hamil_No_Seleccion.png");
        hamil.setFitWidth(100);
        hamil.setFitHeight(100);
        hamil.setLayoutX(columna5);
        hamil.setLayoutY(fila4);
        hamil.setOnMouseClicked(evento -> {
            colocar(TipoNini.HAMIL, hamil);
            fotoDesc.setImage(new Image("Animaciones/Ninis/Hamil_Idle.gif"));
            nombreNini.setText("-- HAMIL --");
            descNini.setText(" El gran guerrero del desgarro ha llegado. ");
            costeNini.setText(" - COSTE BUTANITOS - \n - 450 butanitos.");
            vidaNini.setText(" - SALUD - \n - 450 puntos de salud.");
            alcanceAtaque.setText(" - RANGO DE ATAQUE - \n - Cercano.");
            radioAtaque.setText(" - RADIO ATAQUE - \n - 1 casilla.");
            tipoProyectil.setText("");
            dañoNini.setText("");
            btnQuitarNini.setVisible(true);
            btnQuitarNini.setOnMouseClicked(quitarNini -> {
                quitarSeleccionado(TipoNini.HAMIL, hamil, fotoDesc, nombreNini, descNini, costeNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, dañoNini, btnQuitarNini);
            });
        });

        GestorInventario geInv = GestorInventario.getInstancia();

        HashMap<TipoNini, ImageView> nombresImagenes = new HashMap<>();
        nombresImagenes.put(TipoNini.LUIS, luis);
        nombresImagenes.put(TipoNini.DIEGO, diego);
        nombresImagenes.put(TipoNini.CALLEJO, callejo);
        nombresImagenes.put(TipoNini.ADRIPAN, adripan);
        nombresImagenes.put(TipoNini.GUEVARA, guevara);
        nombresImagenes.put(TipoNini.LOPEZ, lopez);
        nombresImagenes.put(TipoNini.ISMA, isma);
        nombresImagenes.put(TipoNini.XIMENA, ximena);
        nombresImagenes.put(TipoNini.GUILLE, guille);
        nombresImagenes.put(TipoNini.DANI, dani);
        nombresImagenes.put(TipoNini.KEKE, keke);
        nombresImagenes.put(TipoNini.LORENA, lorena);
        nombresImagenes.put(TipoNini.MARIA, maria);
        nombresImagenes.put(TipoNini.JUD, jud);
        nombresImagenes.put(TipoNini.ELSA, elsa);
        nombresImagenes.put(TipoNini.ELISEO, eliseo);
        nombresImagenes.put(TipoNini.RAUL, raul);
        nombresImagenes.put(TipoNini.IRENE, irene);
        nombresImagenes.put(TipoNini.ALVARO, alvaro);
        nombresImagenes.put(TipoNini.HAMIL, hamil);

        TipoNini[] inventarioCopia = geInv.getInventario();
        for (int i = 0; i < 8; i++) {
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
                } else if (posicion == 5) {
                    niniSeleccionado.setLayoutX(posicionXNini6);
                    niniSeleccionado.setLayoutY(posicionYNini6);
                } else if (posicion == 6) {
                    niniSeleccionado.setLayoutX(posicionXNini7);
                    niniSeleccionado.setLayoutY(posicionYNini7);
                } else if (posicion == 7) {
                    niniSeleccionado.setLayoutX(posicionXNini8);
                    niniSeleccionado.setLayoutY(posicionYNini8);
                }
            }
        }

        Pane root = new Pane(fondo, titulo, btnSalir, btnQuitarNini, nombreNini, descNini, costeNini, dañoNini, vidaNini, alcanceAtaque, radioAtaque, tipoProyectil, luis, fotoDesc, diego, callejo, adripan, isma, ximena, lopez, guille, dani, keke, guevara, lorena, maria, jud, elsa, eliseo, raul, irene, alvaro, hamil);
        return new Scene(root, 1280, 720);
    }

    /**
     * Coloca ninis en las posiciones seleccionadas
     * @param tipoNini enum del nini
     * @param niniSeleccionado el nini seleccionado
     */
    public void colocar(TipoNini tipoNini, ImageView niniSeleccionado) {
        GestorInventario geInv = GestorInventario.getInstancia();
        int posicion = geInv.añadirNiniInventario(tipoNini);

        if (posicion == 100) {
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
        } else if (posicion == 5) {
            niniSeleccionado.setLayoutX(posicionXNini6);
            niniSeleccionado.setLayoutY(posicionYNini6);
        } else if (posicion == 6) {
            niniSeleccionado.setLayoutX(posicionXNini7);
            niniSeleccionado.setLayoutY(posicionYNini7);
        } else if (posicion == 7) {
            niniSeleccionado.setLayoutX(posicionXNini8);
            niniSeleccionado.setLayoutY(posicionYNini8);
        } else {
            System.out.println("Error: posicion incorrecto");
        }
    }

    /**
     * Quita de la posición antes seleccionada al nini
     * @param tipoNini enum del nini
     * @param niniSeleccionado el nini seleccionado
     * @param fotoDesc gif del nini
     * @param nombreNini texto de nombre del nini
     * @param descNini texto de descripcion del nini
     * @param costeNini texto de coste del nini
     * @param vidaNini texto de vida del nini
     * @param alcanceAtaque texto de cantidad del alcance del nini
     * @param radioAtaque texto del radio de ataque del nini
     * @param tipoProyectil texto del tipo de proyectil del nini
     * @param dañoNini texto del daño que produce el nini
     * @param btnQuitarNini boton con el que se quita al nini
     */
    public void quitarSeleccionado(TipoNini tipoNini, ImageView niniSeleccionado,
                                   ImageView fotoDesc, Text nombreNini, Text descNini, Text costeNini, Text vidaNini,
                                   Text alcanceAtaque, Text radioAtaque, Text tipoProyectil, Text dañoNini, Button btnQuitarNini) {
        GestorInventario geInv = GestorInventario.getInstancia();

        // posiciones por defecto de los ninis a la izquierda
        int columna1 = 18;
        int columna2 = 123;
        int columna3 = 228;
        int columna4 = 333;
        int columna5 = 438;
        int fila1 = 150;
        int fila2 = 255;
        int fila3 = 360;
        int fila4 = 465;


        // tamaño por defecto
        niniSeleccionado.setFitWidth(100);
        niniSeleccionado.setFitHeight(100);

        // fila 1
        if (tipoNini == TipoNini.LUIS) {
            niniSeleccionado.setLayoutX(columna1);
            niniSeleccionado.setLayoutY(fila1);
        } else if (tipoNini == TipoNini.DIEGO) {
            niniSeleccionado.setLayoutX(columna2);
            niniSeleccionado.setLayoutY(fila1);
        } else if (tipoNini == TipoNini.CALLEJO) {
            niniSeleccionado.setLayoutX(columna3);
            niniSeleccionado.setLayoutY(fila1);
        } else if (tipoNini == TipoNini.ADRIPAN) {
            niniSeleccionado.setLayoutX(columna4);
            niniSeleccionado.setLayoutY(fila1);
        } else if (tipoNini == TipoNini.ISMA) {
            niniSeleccionado.setLayoutX(columna5);
            niniSeleccionado.setLayoutY(fila1);
        } else if (tipoNini == TipoNini.XIMENA) {
            niniSeleccionado.setLayoutX(columna1);
            niniSeleccionado.setLayoutY(fila2);
        } else if (tipoNini == TipoNini.LOPEZ) {
            niniSeleccionado.setLayoutX(columna2);
            niniSeleccionado.setLayoutY(fila2);
        } else if (tipoNini == TipoNini.GUILLE) {
            niniSeleccionado.setLayoutX(columna3);
            niniSeleccionado.setLayoutY(fila2);
        } else if (tipoNini == TipoNini.DANI) {
            niniSeleccionado.setLayoutX(columna4);
            niniSeleccionado.setLayoutY(fila2);
        } else if (tipoNini == TipoNini.KEKE) {
            niniSeleccionado.setLayoutX(columna5);
            niniSeleccionado.setLayoutY(fila2);
        } else if (tipoNini == TipoNini.GUEVARA) {
            niniSeleccionado.setLayoutX(columna1);
            niniSeleccionado.setLayoutY(fila3);
        } else if (tipoNini == TipoNini.LORENA) {
            niniSeleccionado.setLayoutX(columna2);
            niniSeleccionado.setLayoutY(fila3);
        } else if (tipoNini == TipoNini.MARIA) {
            niniSeleccionado.setLayoutX(columna3);
            niniSeleccionado.setLayoutY(fila3);
        } else if (tipoNini == TipoNini.JUD) {
            niniSeleccionado.setLayoutX(columna4);
            niniSeleccionado.setLayoutY(fila3);
        } else if (tipoNini == TipoNini.ELSA) {
            niniSeleccionado.setLayoutX(columna5);
            niniSeleccionado.setLayoutY(fila3);
        } else if (tipoNini == TipoNini.ELISEO) {
            niniSeleccionado.setLayoutX(columna1);
            niniSeleccionado.setLayoutY(fila4);
        } else if (tipoNini == TipoNini.RAUL) {
            niniSeleccionado.setLayoutX(columna2);
            niniSeleccionado.setLayoutY(fila4);
        } else if (tipoNini == TipoNini.IRENE) {
            niniSeleccionado.setLayoutX(columna3);
            niniSeleccionado.setLayoutY(fila4);
        } else if (tipoNini == TipoNini.ALVARO) {
            niniSeleccionado.setLayoutX(columna4);
            niniSeleccionado.setLayoutY(fila4);
        } else if (tipoNini == TipoNini.HAMIL) {
            niniSeleccionado.setLayoutX(columna5);
            niniSeleccionado.setLayoutY(fila4);
        }

        fotoDesc.setImage(null);
        nombreNini.setText("");
        descNini.setText("");
        costeNini.setText("");
        vidaNini.setText("");
        alcanceAtaque.setText("");
        radioAtaque.setText("");
        tipoProyectil.setText("");
        dañoNini.setText("");
        btnQuitarNini.setVisible(false);
        geInv.eliminarNiniInventario(tipoNini);
    }

}
