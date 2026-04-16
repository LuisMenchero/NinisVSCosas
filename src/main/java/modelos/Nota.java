package modelos;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Nota {
    // --- ATRIBUTOS ---

    // imagen de la nota
    protected ImageView imagenNota;
    protected double ancho = 20;
    protected double alto = 20;

    // para colocar la nota
    private double fila;
    private double columna;
    private Pane root;


    // --- CONSTRUCTOR ---
    public Nota(double fila, double columna, Pane root) {
        this.fila = fila;
        this.columna = columna;
        this.root = root;

        // Para el gif
        this.imagenNota = new ImageView("Animaciones/Proyectiles/nota.gif");
        this.imagenNota.setFitWidth(ancho);
        this.imagenNota.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenNota.setLayoutX(columna + 65);
        this.imagenNota.setLayoutY(fila + 35);

        root.getChildren().add(imagenNota);
    }
}
