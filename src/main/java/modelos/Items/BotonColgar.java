package modelos.Items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BotonColgar {
    // --- ATRIBUTOS ---
    // Posicion
    private double posicionX;
    private double posicionY;
    // Tamaño
    private double ancho = 40;
    private double alto = 40;
    // Imagen
    private ImageView imagenColgar;
    private Pane root;

    // --- CONSTRUCTOR ---
    private BotonColgar() {
        this.imagenColgar = (new ImageView("Animaciones/Ninis/Guevara_Idle.gif"));
        this.imagenColgar.setFitWidth(ancho);
        this.imagenColgar.setFitHeight(alto);
        this.imagenColgar.setX(posicionX);
        this.imagenColgar.setY(posicionY);
    }

    // --- METODOS ---

}
