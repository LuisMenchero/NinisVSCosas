package modelos.Proyectiles;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Representa un proyectil Pikmin
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Pikmin extends Proyectil{
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---

    /**
     * Constructor de pikmin
     * @param fila donde se encuentra (fila)
     * @param columna donde se encuentra (columna)
     * @param root Pane root de la escena en la que aparece
     */
    public Pikmin(double fila, double columna, Pane root) {
        super(200, 20, 20,20 , fila + 35, columna  + 65, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Proyectiles/nota.gif");
        this.imagenProyectil.setFitWidth(ancho);
        this.imagenProyectil.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenProyectil.setLayoutX(this.columna);
        this.imagenProyectil.setLayoutY(this.fila);
        this.imagenProyectilQuemado.setFitWidth(ancho+20);
        this.imagenProyectilQuemado.setFitHeight(alto+20);

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
        if (this.haImpactado == true) {
            return;
        }
        this.haImpactado = true;
        root.getChildren().remove(imagenProyectil);
        root.getChildren().remove(hitbox);
        root.getChildren().remove(imagenProyectilQuemado);
    }

    /**
     * Mueve el proyectil
     */
    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
        this.hitbox.setX(columna+pixelesPorSegundo * tiempoFrames);
        this.imagenProyectilQuemado.setLayoutX(columna);
    }
}
