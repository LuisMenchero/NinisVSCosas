package modelos;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class Nini {
    // --- ATRIBUTOS ---
    // Posicion
    protected double columna;
    protected double fila;
    // Tamaño
    protected double ancho = 80;
    protected double alto = 95;

    // datos del Nini
    protected int saludMaxima;
    protected int salud;
    protected double cooldownDisparo;
    protected int costeButanitos;
    protected int tiempoDelUltimoDisparo;

    // el gif del Nini
    protected ImageView imagenNini;
    protected Pane root;

    // --- CONSTRUCTOR ---
    public Nini(double columna, double fila, int salud, int costeButanitos, double cooldownDisparo, String rutaImagenNini, Pane root) {
        this.columna = columna;
        this.fila = fila;
        this.salud = salud;
        this.saludMaxima = salud;
        this.costeButanitos = costeButanitos;
        this.cooldownDisparo = cooldownDisparo;
        this.tiempoDelUltimoDisparo = costeButanitos;
        this.root = root;

        // Para el gif
        this.imagenNini = new ImageView(rutaImagenNini);
        this.imagenNini.setFitWidth(ancho);
        this.imagenNini.setFitHeight(alto);
        // para posicionarlo en la pantalla
        this.imagenNini.setLayoutX(columna);
        this.imagenNini.setLayoutY(fila);

        root.getChildren().add(imagenNini);
    }

    // --- MÉTODOS ---
    // abstactos
    //protected abstract void disparar(ArrayList<Cosa> cosas);

    //public abstract void actualizar(double tiempoFrames, ArrayList<Cosa> cosas);

    // normales
    public void recibirDaño(int daño) {
        salud = saludMaxima - daño;
        if (salud <= 0) {
            muerte();
        }
    }

    public void muerte() {
        root.getChildren().remove(imagenNini);
    }

    public boolean estaMuerto() {
        if (salud <= 0) {
            return true;
        }
        return false;
    }

//    protected boolean hayZombieEnMiFila(ArrayList<Cosa> cosas) {
//        for (Cosa cosaAct : cosas) {
//            if (cosaAct.getFila() == this.fila){
//              return true;
//            }
//        }
//        return false;
//    }

    // --- GETTERS ---
    public double getColumna() {
        return columna;
    }
    public double getFila() {
        return fila;
    }
    public int getCosteButanitos() {
        return costeButanitos;
    }
    public int getSalud() {
        return salud;
    }
    public ImageView getImagenNini() {
        return imagenNini;
    }
}
