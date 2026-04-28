package modelos.Cosas;

import controladores.ControladorReloj;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

    // el gif de la cosa
    protected String rutaImagenCosa;
    protected ImageView imagenCosa;
    protected Pane root;

    // --- CONSTRUCTOR ---


    public Cosa(int salud, int velocidad, String rutaImagenCosa, Pane root) {
        this.columna = 1280;
        int filaRandom = (int)(Math.random() * (4 - 0 + 1) + 0);
        this.fila = Cuadricula.buscarMitadCeldaEjeY(filaRandom);
        this.salud = salud;
        this.saludMaxima = salud;
        this.pixelesPorSegundo = velocidad;
        this.rutaImagenCosa = rutaImagenCosa;
        this.root = root;

        // Para el gif
        this.imagenCosa = new ImageView(rutaImagenCosa);
        this.imagenCosa.setFitWidth(ancho);
        this.imagenCosa.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenCosa.setLayoutX(columna);
        this.imagenCosa.setLayoutY(fila);

        root.getChildren().add(imagenCosa);
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
}
