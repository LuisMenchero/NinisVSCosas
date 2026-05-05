package modelos.Cosas;

import controladores.ControladorReloj;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelos.Cuadricula;

public abstract class Cosa {
    // --- ATRIBUTOS ---
    // Posicion
    protected double columna;
    protected double fila;
    // Tamaño
    protected double ancho = 80;
    protected double alto = 95;

    // datos de la cosa
    protected int saludMaxima;
    protected int salud;
    protected int pixelesPorSegundo;
    protected int daño;
    protected double cooldownAtaque;
    protected double tiempoUltimoGolpe;

    // el gif de la cosa
    protected String rutaImagenCosa;
    protected ImageView imagenCosa;
    protected Pane root;

    // funcionamiento
    protected int pixelesPorSegundosActual;
    protected Rectangle hitbox;

    // --- CONSTRUCTOR ---


    public Cosa(int salud, int velocidad, int daño, double cooldownAtaque, String rutaImagenCosa, Pane root) {
        this.columna = 1280;
        int filaRandom = (int)(Math.random() * (4 - 0 + 1) + 0);
        this.fila = Cuadricula.buscarMitadCeldaEjeY(filaRandom);
        this.salud = salud;
        this.saludMaxima = salud;
        this.pixelesPorSegundo = velocidad;
        this.pixelesPorSegundosActual = velocidad;
        this.daño = daño;
        this.cooldownAtaque = cooldownAtaque;
        this.tiempoUltimoGolpe = cooldownAtaque;
        this.rutaImagenCosa = rutaImagenCosa;
        this.root = root;

        // Para el gif
        this.imagenCosa = new ImageView(rutaImagenCosa);
        this.imagenCosa.setFitWidth(ancho);
        this.imagenCosa.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenCosa.setLayoutX(columna);
        this.imagenCosa.setLayoutY(fila);

        //para la hitbox (nueva) ((vaya movida))
        // nocilla que merendilla AY MI LOPI
        hitbox = new Rectangle(
                columna,
                fila+20,
                40,60 );
     hitbox.setFill(Color.RED);
     hitbox.setOpacity(0.5);
     hitbox.setVisible(true);

        root.getChildren().addAll(imagenCosa, hitbox);
    }


    // --- METODOS ---
    public abstract void caminar(double tiempoFrames);
    public abstract void atacar();
    public abstract void actualizar(double tiempoFrames);

    public void recibirDaño(int daño) {
        this.salud = salud - daño;
        if (this.salud <= 0) {
            morir();
        }
    }

    public void morir() {
        root.getChildren().remove(imagenCosa);
        root.getChildren().remove(hitbox);
        ControladorReloj.getCosas().remove(this);
    }



    // --- GETTERS Y SETTERS ---
    public double getColumna() {
        return columna;
    }

    public double getFila() {
        return fila;
    }

    public String getRutaImagenCosa() {
        return rutaImagenCosa;
    }

    public ImageView getImagenCosa() {
        return imagenCosa;
    }

    public int getDaño() {
        return daño;
    }

    public void setPixelesPorSegundosActual(int pixelesPorSegundosActual) {
        this.pixelesPorSegundosActual = pixelesPorSegundosActual;
    }

    public void setImagenCosa(ImageView imagenCosa) {
        this.imagenCosa = imagenCosa;
    }

    public int getPixelesPorSegundo() {
        return pixelesPorSegundo;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
