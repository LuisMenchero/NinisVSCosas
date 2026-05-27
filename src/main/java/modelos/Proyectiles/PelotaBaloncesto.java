package modelos.Proyectiles;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Representa de forma abstracta un proyectil PelotaBaloncesto
 */
public class PelotaBaloncesto extends Proyectil {
    // --- ATRIBUTOS ---


    // --- CONSTRUCTOR ---

    /**
     * Constructor de PelotaBaloncesto
     * @param fila
     * @param columna
     * @param root
     */
    public PelotaBaloncesto(double fila, double columna, Pane root) {
        super(100, 200, 35,35 , fila + 55, columna + 65, root);
        // Para el gif
        this.imagenProyectil = new ImageView("Animaciones/Proyectiles/PelotaBaloncestoBotando.gif");
        this.imagenProyectil.setFitWidth(ancho);
        this.imagenProyectil.setFitHeight(alto);
        this.imagenProyectilQuemado.setFitWidth(ancho+20);
        this.imagenProyectilQuemado.setFitHeight(alto+20);


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
        if (this.haImpactado == true) {
            return;
        }
        haImpactado = true;
        root.getChildren().remove(imagenProyectil);
        root.getChildren().remove(hitbox);
        root.getChildren().remove(imagenProyectilQuemado);
    }

    /**
     * Mueve el proyectil
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void moverProyectil(double tiempoFrames) {
        columna = (columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectil.setLayoutX(columna);
        this.hitbox.setX(columna + pixelesPorSegundo * tiempoFrames);
        this.imagenProyectilQuemado.setLayoutX(columna);
    }
}
