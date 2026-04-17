package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Nota extends Proyectil {
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---
    public Nota(double fila, double columna, Pane root) {
        super(200,fila + 35, columna  + 65, root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames) {
        moverProyectil(tiempoFrames);
        System.out.println("hola funciono");
    }

    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenNota.setLayoutX(columna);
        System.out.println("me muevo");
    }
}
