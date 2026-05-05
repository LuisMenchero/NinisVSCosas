package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Proyectil {
    // --- ATRIBUTOS ---
    protected int pixelesPorSegundo;
    protected int daño;
    // imagen de la nota
    protected ImageView imagenProyectil;
    protected double ancho = 20;
    protected double alto = 20;

    // para colocar la nota
    protected double fila;
    protected double columna;
    protected Pane root;

    //Funcionamiento
    protected Rectangle hitbox;

    // --- CONSTRUCTOR ---
    public Proyectil(int pixelesPorSegundo, int daño, double fila, double columna, Pane root) {
        this.pixelesPorSegundo = pixelesPorSegundo;
        this.daño = daño;
        this.fila = fila;
        this.columna = columna;
        this.root = root;
        this.hitbox = new Rectangle(
                columna,
                fila ,
                15,20);
        hitbox.setFill(Color.RED);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(true);
        this.root.getChildren().add(hitbox);
    }
    // --- MÉTODOS ---
    protected abstract void actualizar(double tiempoFrames);
    protected abstract void moverProyectil(double tiempoFrames);
    public abstract void impactar();

    // --- GETTERS Y SETTERS ---


    public ImageView getImagenProyectil() {
        return imagenProyectil;
    }

    public int getDaño() {
        return daño;
    }
}
