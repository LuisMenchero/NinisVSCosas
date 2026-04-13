package escenas;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelos.*;

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
        GestorButanitos geB = new  GestorButanitos();


        Pane root = new Pane(fondo);
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

        Guevara g1 = new Guevara(Cuadricula.buscarMitadCeldaEjeX(7),Cuadricula.buscarMitadCeldaEjeY(3),root);
        terreno[7][3].setNini(g1);

        Luis l33 = new Luis(Cuadricula.buscarMitadCeldaEjeX(6),Cuadricula.buscarMitadCeldaEjeY(1),root, geB);

        terreno[6][1].setNini(l33);
        return new Scene(root, 1280, 720);
    }

}
