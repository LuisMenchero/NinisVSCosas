package modelos.Items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelos.GestorButanitos;

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
        hitbox.setVisible(true);
        hitbox.setOnMouseClicked(evento -> {recoger(); gestorButanitos.aniquilarButanito(this);});


        double ejeXAleatorio = Math.random() * (60 - (-10) + 1) + (-10);
        double ejeYAleatorio = Math.random() * (60 - (-10) + 1) + (-10);

        this.imagenButanito.setLayoutX(columna + ejeXAleatorio);
        this.imagenButanito.setLayoutY(fila + ejeYAleatorio);
        hitbox.setX(columna + ejeXAleatorio);
        hitbox.setY(fila + ejeYAleatorio);


        root.getChildren().addAll(imagenButanito,hitbox);
    }

    public void recoger() {
        gestorButanitos.sumarButanitos(50);
        root.getChildren().remove(imagenButanito);
        root.getChildren().remove(hitbox);
    }

    public void setImagenButanito(ImageView imagenButanito) {
        this.imagenButanito = imagenButanito;
    }
}
