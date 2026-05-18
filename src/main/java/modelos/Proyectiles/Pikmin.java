package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Pikmin extends Proyectil{
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---
    public Pikmin(double fila, double columna, Pane root) {
        super(200, 20, 20,20 , fila + 35, columna  + 65, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Proyectiles/nota.gif");
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
    public void impactar() {
        root.getChildren().remove(imagenProyectil);
        root.getChildren().remove(hitbox);
        System.out.println("impacto");
    }

    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
        this.hitbox.setX(columna+pixelesPorSegundo * tiempoFrames);
    }
}
