package escenas;
import Estadisticas.GestorXML;
import Estadisticas.TransformadorXSLT;
import Logros.Logro;
import Logros.TipoDificultad;
import Logros.TipoMedalla;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelos.Ninis.TipoNini;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalTime;

/**
 * Representa la Escena menu del juego
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class EscenaMenu {
    private static Instant inicioPartida;
    private static Logro[] logros =  new Logro[6];
    /**
     * Construye la escena del menu y pone las cosas en sus sitios
     * @param stage ventana de la aplicacion
     * @return Scene
     */
    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("/Imagenes/fondomenu.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        Button btnJugar = new Button("Jugar");
        btnJugar.setLayoutX(575);
        btnJugar.setLayoutY(150);
        btnJugar.setOnAction(evento -> {
            EscenaJuego escenaJuego = new EscenaJuego();
            stage.setScene(escenaJuego.construir(stage));
            inicioPartida = Instant.now();
            Logro logro1 = new Logro(1, TipoDificultad.FACIL,"Coloca tu primer Nini", TipoMedalla.ESTIERCOL,5);
            Logro logro2 = new Logro(2, TipoDificultad.FACIL,"Planta dos filas de Luises", TipoMedalla.BRONCE,10);
            Logro logro3 = new Logro(3, TipoDificultad.INTERMEDIO,"Mata 200 cosas", TipoMedalla.PLATA,15);
            Logro logro4 = new Logro(4, TipoDificultad.DIFICIL,"Llega a la oleada 10", TipoMedalla.ORO,20);
            Logro logro5 = new Logro(5, TipoDificultad.CASI_IMPOSIBLE,"Llega a la oleada 10 sin que muera ningun nini", TipoMedalla.BUTANITO,50);
            Logro logro6 = new Logro(6, TipoDificultad.SECRETO,"Elimina treinta y tres angine de poitrine", TipoMedalla.DIAMANTE,33);
            logros[0] = logro1;
            logros[1] = logro2;
            logros[2] = logro3;
            logros[3] = logro4;
            logros[4] = logro5;
            logros[5] = logro6;
        });
        btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnJugar.setOnMouseEntered(evento -> {btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnJugar.setOnMouseExited(evento -> {btnJugar.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});

        Button btnSeleccionar = new Button("Seleccionar ninis");
        btnSeleccionar.setLayoutX(500);
        btnSeleccionar.setLayoutY(270);
        btnSeleccionar.setOnAction(evento -> {
            EscenaSeleccionar escenaSeleccionar = new EscenaSeleccionar();
            stage.setScene(escenaSeleccionar.construir(stage));
        });
        btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnSeleccionar.setOnMouseEntered(evento -> {btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");});
        btnSeleccionar.setOnMouseExited(evento -> {btnSeleccionar.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});


        Button btnEstadisticas = new Button("Estadisticas");
        btnEstadisticas.setLayoutX(535);
        btnEstadisticas.setLayoutY(390);
        btnEstadisticas.setOnAction(evento -> {
            GestorXML.inicializarXML();
            TransformadorXSLT.transformarXML();
            try {
                File archivo = new File("src/main/resources/Estadisticas/resultadoEstadisticas.html");
                Desktop.getDesktop().open(archivo);
            } catch (Exception e){
                System.out.println("Error al abrir archivo de estadisticas");
            }
        });
        btnEstadisticas.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnEstadisticas.setOnMouseEntered(evento -> {btnEstadisticas.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnEstadisticas.setOnMouseExited(evento -> {btnEstadisticas.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});



        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(580);
        btnSalir.setLayoutY(510);
        btnSalir.setOnAction(evento -> {
            Platform.exit();
            System.exit(0);
        });
        btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnSalir.setOnMouseEntered(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnSalir.setOnMouseExited(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});



        Pane root = new Pane(fondo, btnJugar, btnSeleccionar, btnEstadisticas,  btnSalir);
        return new Scene (root, 1280, 720);
    }


    public static Instant getInicioPartida() {
        return inicioPartida;
    }

    public static Logro[] getLogros() {
        return logros;
    }
}
