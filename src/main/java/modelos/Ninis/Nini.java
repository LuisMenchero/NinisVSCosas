package modelos.Ninis;

import controladores.ControladorReloj;
import escenas.EscenaJuego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Cuadricula;

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
    protected TipoNini tipoNini;
    protected int saludMaxima;
    protected int salud;
    protected boolean potenciado = false;
    protected boolean curado = false;
    protected double cooldownDisparo;
    protected int cooldownVolverPlantar;
    protected int costeButanitos;
    protected double tiempoDelUltimoDisparo;
    protected boolean estaMuerto = false;

    // el gif del Nini
    protected String rutaImagenNini;
    protected ImageView imagenNini;
    protected Pane root;

    // el gif del potenciador y gif de curación
    protected ImageView potenciador;
    protected ImageView curacion;

    //funcionamiento
    protected Rectangle hitbox;

    // --- CONSTRUCTOR ---
    public Nini(double columna, double fila, TipoNini tipoNini,int salud, int costeButanitos, double cooldownDisparo, int cooldownVolverPlantar,String rutaImagenNini, Pane root) {
        this.columna = columna;
        this.fila = fila;
        this.tipoNini = tipoNini;
        this.salud = salud;
        this.saludMaxima = salud;
        this.costeButanitos = costeButanitos;
        this.cooldownDisparo = cooldownDisparo;
        this.cooldownVolverPlantar = cooldownVolverPlantar;
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

        // para la curacion
        this.curacion = new ImageView("Animaciones/Ninis/PotenciadorLorena.gif");
        this.curacion.setFitWidth(ancho+20);
        this.curacion.setFitHeight(alto+20);
        this.curacion.setLayoutX(columna-10);
        this.curacion.setLayoutY(fila);
        this.curacion.setOpacity(0.4);
        this.curacion.setVisible(false);


        hitbox = new Rectangle(
                columna + 10,
                fila + 20,
                70, 60);
        hitbox.setFill(Color.RED);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(true);

        root.getChildren().addAll(imagenNini, potenciador,curacion, hitbox);
    }

    // --- MÉTODOS ---
    // abstactos
    protected abstract void atacar(ArrayList<Cosa> cosas);

    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
        curar();
    }

    // normales
    public void recibirDaño(int daño) {
        salud = salud - daño;
        if (salud <= 0) {
            morir();
        }
    }

    public void morir() {
        root.getChildren().remove(imagenNini);
        root.getChildren().remove(hitbox);
        this.potenciador.setVisible(false);
        this.curacion.setVisible(false);
        ControladorReloj.getNinis().remove(this);
        estaMuerto = true;

        //Esto de aqui para que el nini no exista más (que bien me expreso)
        int filaTerreno = Cuadricula.convertirAFila(fila);
        int columnaTerreno  = Cuadricula.convertirAColumna(columna);
        Celda [][] terreno = EscenaJuego.getTerreno();
        if (filaTerreno >=0 && filaTerreno < terreno.length && columnaTerreno >=0 && columnaTerreno < terreno[0].length) {
            terreno [filaTerreno][columnaTerreno].limpiar();
        }

    }


    public void potenciar() {
        if (ControladorReloj.detectarGuevara() && !potenciado) {
            this.potenciador.setVisible(true);
            this.potenciado = true;
        } else if (!ControladorReloj.detectarGuevara() && potenciado) {
            this.potenciador.setVisible(false);
            this.potenciado = false;
        }
    }
    public void curar() {
        if (ControladorReloj.detectarLorena() && !curado) {
            this.salud = saludMaxima;
            this.curacion.setVisible(true);
            this.curado = true;
        } else if (!ControladorReloj.detectarLorena() && curado) {
            this.curacion.setVisible(false);
            this.curado = false;
        }
    }

    protected boolean hayZombieEnMiFila(ArrayList<Cosa> cosas) {
        for (Cosa cosaAct : cosas) {
            if (cosaAct.getFila() == this.fila) {
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

    public int getCooldownVolverPlantar() {
        return cooldownVolverPlantar;
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

    public void setImagenNiniImage(String rutaNuevaAnimacion) {
        this.imagenNini.setImage(new Image(rutaNuevaAnimacion));
    }

    public TipoNini getTipoNini() {
        return tipoNini;
    }
    public void setPotenciado(boolean potenciado) {
        this.potenciado = potenciado;
    }

    public boolean isEstaMuerto() {
        return estaMuerto;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
