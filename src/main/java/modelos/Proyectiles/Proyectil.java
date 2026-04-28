package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Proyectil {
    // --- ATRIBUTOS ---
    protected int pixelesPorSegundo;
    // imagen de la nota
    protected ImageView imagenProyectil;
    protected double ancho = 20;
    protected double alto = 20;

    // para colocar la nota
    protected double fila;
    protected double columna;
    protected Pane root;

    // --- CONSTRUCTOR ---
    public Proyectil(int pixelesPorSegundo,double fila, double columna, Pane root) {
        this.pixelesPorSegundo = pixelesPorSegundo;
        this.fila = fila;
        this.columna = columna;
        this.root = root;
    }
    // --- MÉTODOS ---
    protected abstract void actualizar(double tiempoFrames);
    protected abstract void moverProyectil(double tiempoFrames);

    // --- GETTERS Y SETTERS ---


    public ImageView getImagenProyectil() {
        return imagenProyectil;
    }
}
