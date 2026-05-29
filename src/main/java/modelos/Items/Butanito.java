package modelos.Items;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelos.GestorButanitos;

/**
 * Representa un butanito (moneda)
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Butanito {
    // Posicion
    private double columna;
    private double fila;
    // Tamaño
    private double ancho = 40;
    private double alto = 40;
    // Valores
    private int valor = 50;
    private GestorButanitos gestorButanitos = GestorButanitos.getInstancia();
    // el gif del Butanito
    private ImageView imagenButanito;
    private Pane root;
    // Hitbox
    private Rectangle hitbox;

    /**
     * Constructor del butanito, hace que aparezca
     * @param columna columna en la que se situa el butanito
     * @param fila fila en la que se situa el butanito
     * @param root Pane root de la escena en la que aparece el butanito
     * @param rutaButanito ruta en la que esta el gif del butanito
     */
    public Butanito(double columna, double fila, Pane root, String rutaButanito) {
        this.columna = columna;
        this.fila = fila;
        this.root = root;
        gestorButanitos.añadirButanito(this);
        imagenButanito = new ImageView(rutaButanito);
        imagenButanito.setFitWidth(ancho);
        imagenButanito.setFitHeight(alto);
        hitbox = new Rectangle();
        hitbox.setWidth(ancho);
        hitbox.setHeight(alto);

        hitbox.setFill(Color.BLUE);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(false);
        hitbox.setOnMouseClicked(evento -> {recoger(); gestorButanitos.aniquilarButanito(this);});


        double ejeXAleatorio = Math.random() * (60 - (-10) + 1) + (-10);
        double ejeYAleatorio = Math.random() * (60 - (-10) + 1) + (-10);

        this.imagenButanito.setLayoutX(columna + ejeXAleatorio);
        this.imagenButanito.setLayoutY(fila + ejeYAleatorio);
        hitbox.setX(columna + ejeXAleatorio);
        hitbox.setY(fila + ejeYAleatorio);


        root.getChildren().addAll(imagenButanito,hitbox);
    }

    /**
     * Permite recoger butanito y llama al gestor para sumarlo
     */
    public void recoger() {
        gestorButanitos.sumarButanitos(50);
        root.getChildren().remove(imagenButanito);
        root.getChildren().remove(hitbox);
    }

    /**
     * Setter de la imagen del butanito
     * @param imagenButanito ImageView del butanito
     */
    public void setImagenButanito(ImageView imagenButanito) {
        this.imagenButanito = imagenButanito;
    }
}
