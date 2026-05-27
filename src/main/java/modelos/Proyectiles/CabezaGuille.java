package modelos.Proyectiles;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Representa un proyectil CabezaGuille
 */
public class CabezaGuille extends Proyectil{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    /**
     * Constructor de escupitajo
     * @param fila donde se encuentra (fila)
     * @param columna donde se encuentra (columna)
     * @param root Pane root de la escena en la que aparece
     */
    public CabezaGuille(double fila, double columna, Pane root) {
        super(100, 9999, 60,60 , fila + 25, columna-60, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Proyectiles/cabezaGuille.gif");


        // para posicionarlo en la pantalla
        this.imagenProyectil.setLayoutX(this.columna);
        this.imagenProyectil.setLayoutY(this.fila-50);
        this.hitbox.setLayoutX(this.columna-150);
        this.hitbox.setWidth(60);
        this.hitbox.setHeight(60);

        root.getChildren().add(imagenProyectil);
    }

    // --- MÉTODOS ---
    /**
     * Actualiza el proyectil
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        moverProyectil(tiempoFrames);
    }

    /**
     * Impacta al chocar
     */
    @Override
    public void impactar() {
    }

    /**
     * Mueve el proyectil
     */
    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
        this.hitbox.setX(columna+pixelesPorSegundo * tiempoFrames);
    }


}
