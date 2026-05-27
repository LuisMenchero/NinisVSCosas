package modelos.Proyectiles;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Representa un proyectil Escupitajo
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Escupitajo extends Proyectil {
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---
    /**
     * Constructor de escupitajo
     * @param fila donde se encuentra (fila)
     * @param columna donde se encuentra (columna)
     * @param root Pane root de la escena en la que aparece
     */
    public Escupitajo(double fila, double columna, Pane root) {
        super(210, 1,25,25, fila + 25, columna  + 60, root);
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
//        root.getChildren().remove(imagenProyectil);
//        root.getChildren().remove(hitbox);
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
