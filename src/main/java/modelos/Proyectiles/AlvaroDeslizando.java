package modelos.Proyectiles;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AlvaroDeslizando extends Proyectil{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public AlvaroDeslizando(double fila, double columna, Pane root) {
        super(95, 1, 20,20 , fila + 25, columna-60, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Ninis/Alvaro_Ataque.gif");


        // para posicionarlo en la pantalla
        this.imagenProyectil.setLayoutX(this.columna);
        this.imagenProyectil.setLayoutY(this.fila -20);
        this.imagenProyectil.setFitWidth(100);
        this.imagenProyectil.setFitHeight(100);
        this.hitbox.setLayoutX(this.columna-150);
        this.hitbox.setWidth(60);
        this.hitbox.setHeight(60);

        root.getChildren().add(imagenProyectil);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames) {
        moverProyectil(tiempoFrames);
    }

    @Override
    public void impactar() {
    }

    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
        this.hitbox.setX(columna+pixelesPorSegundo * tiempoFrames);
    }
}
