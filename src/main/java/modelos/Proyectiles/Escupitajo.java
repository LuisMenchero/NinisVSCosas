package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Escupitajo extends Proyectil {
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---
    public Escupitajo(double fila, double columna, Pane root) {
        super(210,fila + 25, columna  + 60, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Ninis/Guevara_Idle.gif");
        this.imagenProyectil.setFitWidth(ancho);
        this.imagenProyectil.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenProyectil.setLayoutX(this.columna);
        this.imagenProyectil.setLayoutY(this.fila);

        root.getChildren().add(imagenProyectil);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames) {
        moverProyectil(tiempoFrames);
    }

    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
    }
}
