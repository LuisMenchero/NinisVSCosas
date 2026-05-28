package escenas;
import Estadisticas.GestorXML;
import Estadisticas.TransformadorXSLT;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelos.Ninis.TipoNini;

import java.awt.*;
import java.io.File;

/**
 * Representa la Escena menu del juego
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class EscenaMenu {

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

}
