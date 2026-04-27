package modelos.Ninis;

import controladores.ControladorReloj;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

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
    protected boolean potenciado = false;
    protected double cooldownDisparo;
    protected int costeButanitos;
    protected double tiempoDelUltimoDisparo;

    // el gif del Nini
    protected String rutaImagenNini;
    protected ImageView imagenNini;
    protected Pane root;

    // el gif del potenciador
    protected ImageView potenciador;

    // --- CONSTRUCTOR ---
    public Nini(double columna, double fila, int salud, int costeButanitos, double cooldownDisparo, String rutaImagenNini, Pane root) {
        this.columna = columna;
        this.fila = fila;
        this.salud = salud;
        this.saludMaxima = salud;
        this.costeButanitos = costeButanitos;
        this.cooldownDisparo = cooldownDisparo;
        this.rutaImagenNini = rutaImagenNini;
        this.tiempoDelUltimoDisparo = cooldownDisparo;
        this.root = root;

        // Para el gif
        this.imagenNini = new ImageView(rutaImagenNini);
        this.imagenNini.setFitWidth(ancho);
        this.imagenNini.setFitHeight(alto);


        // para posicionarlo en la pantalla
        this.imagenNini.setLayoutX(columna);
        this.imagenNini.setLayoutY(fila);


        // para el potenciador
        this.potenciador = new ImageView("Animaciones/Ninis/PotenciadorGuevara.gif");
        this.potenciador.setFitWidth(ancho);
        this.potenciador.setFitHeight(alto);
        this.potenciador.setLayoutX(columna);
        this.potenciador.setLayoutY(fila);
        this.potenciador.setOpacity(0.4);
        this.potenciador.setVisible(false);

        root.getChildren().addAll(imagenNini,potenciador);
    }

    // --- MÉTODOS ---
    // abstactos
    protected abstract void atacar(ArrayList<Cosa> cosas);

    public abstract void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas);
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

    public void potenciar() {
        if (ControladorReloj.detectarGuevara() && !potenciado) {
            this.potenciador.setVisible(true);
            this.potenciado =  true;
        }
    }

    protected boolean hayZombieEnMiFila(ArrayList<Cosa> cosas) {
        for (Cosa cosaAct : cosas) {
            if (cosaAct.getFila() == this.fila){
              return true;
            }
        }
        return false;
    }

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
    public String getRutaImagenNini() {
        return rutaImagenNini;
    }
    public ImageView getImagenNini() {
        return imagenNini;
    }
    public void setImagenNiniImage(String rutaNuevaAnimacion) {this.imagenNini.setImage(new Image(rutaNuevaAnimacion));}
    public void setPotenciado(boolean potenciado) {this.potenciado = potenciado;}
}
