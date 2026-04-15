package escenas;

import controladores.ControladorJuego;
import controladores.ControladorReloj;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelos.*;

public class EscenaJuego {

    ControladorReloj reloj = new ControladorReloj();

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
        GestorButanitos geB = new  GestorButanitos();

        //Botón de pausa
        Button btnPausa = new Button("=");
        btnPausa.setLayoutX(1200);
        btnPausa.setLayoutY(10);
        btnPausa.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
        } );

        //Iniciar el reloj interno del juego (game loop)
        reloj.iniciarReloj();

        Pane root = new Pane(fondo, btnPausa);


        Luis l1 = new Luis(Cuadricula.buscarMitadCeldaEjeX(2),Cuadricula.buscarMitadCeldaEjeY(1),root, geB);

        terreno[2][1].setNini(l1);
        Luis l2 = new Luis(Cuadricula.buscarMitadCeldaEjeX(1),Cuadricula.buscarMitadCeldaEjeY(2),root, geB);

        terreno[1][2].setNini(l2);

        Diego d1 = new Diego(Cuadricula.buscarMitadCeldaEjeX(1),Cuadricula.buscarMitadCeldaEjeY(1),root);
        terreno[1][1].setNini(d1);

        Callejo c1 = new Callejo(Cuadricula.buscarMitadCeldaEjeX(3),Cuadricula.buscarMitadCeldaEjeY(3),root);
        terreno[3][3].setNini(c1);

        Lopez lopi1 = new Lopez(Cuadricula.buscarMitadCeldaEjeX(2),Cuadricula.buscarMitadCeldaEjeY(3),root);
        terreno[2][3].setNini(lopi1);

        Adripan ad1 = new Adripan(Cuadricula.buscarMitadCeldaEjeX(5),Cuadricula.buscarMitadCeldaEjeY(3),root);
        terreno[5][3].setNini(ad1);

        Guevara g1 = new Guevara(Cuadricula.buscarMitadCeldaEjeX(7),Cuadricula.buscarMitadCeldaEjeY(3),root,terreno);
        terreno[7][3].setNini(g1);

        Luis l33 = new Luis(Cuadricula.buscarMitadCeldaEjeX(6),Cuadricula.buscarMitadCeldaEjeY(1),root, geB);

        terreno[6][1].setNini(l33);


        ConstruirPanelPausa(stage);
        root.getChildren().add(panelPausa);

        return new Scene(root, 1280, 720);
    }

    Pane panelPausa = new Pane();

    private void ConstruirPanelPausa (Stage stage){

        panelPausa.setPrefSize(1280, 720);

        //Esta es la primera vez que uso el -fx y sirve como una especie de css
        panelPausa.setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        Text textoPausa = new Text("Pausa");
        textoPausa.setFill(Color.WHITE);
        textoPausa.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        textoPausa.setLayoutX(640);
        textoPausa.setLayoutY(300);

        Button btnReanudar = new Button("Reanudar");
        btnReanudar.setLayoutX(640);
        btnReanudar.setLayoutY(350);
        btnReanudar.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
        });

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(640);
        btnSalir.setLayoutY(400);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
        });


        panelPausa.setVisible(false);
        panelPausa.getChildren().addAll(textoPausa, btnReanudar, btnSalir);
    }


    public void mostrarPanelPausa (){
        if (reloj.isPausado()){
        panelPausa.setVisible(true);
        }else {
        panelPausa.setVisible(false);
        }
    }



}
