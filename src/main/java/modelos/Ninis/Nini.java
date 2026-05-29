package modelos.Ninis;

import Estadisticas.EstadisticasRecuento;
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
import modelos.GestorPuntos;

import java.util.ArrayList;

/**
 * Representa de forma abstracta un nini
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
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

    /**
     * Constructor de nini
     *
     * @param columna               lugar de las columnas en la que se encuentra
     * @param fila                  lugar de las filas en la que se encuentra
     * @param tipoNini              enum del nini
     * @param salud                 cantidad de salud del nini
     * @param costeButanitos        coste del nini
     * @param cooldownDisparo       tiempo que tarda en volver a disparar
     * @param cooldownVolverPlantar tiempo que tarda en poder a volver a plantarse
     * @param rutaImagenNini        ruta de la imagen del nini
     * @param root                  Pane root de la escena en la que aparece
     */
    public Nini(double columna, double fila, TipoNini tipoNini, int salud, int costeButanitos, double cooldownDisparo, int cooldownVolverPlantar, String rutaImagenNini, Pane root) {
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
        this.curacion.setFitWidth(ancho + 20);
        this.curacion.setFitHeight(alto + 20);
        this.curacion.setLayoutX(columna - 10);
        this.curacion.setLayoutY(fila);
        this.curacion.setOpacity(0.4);
        this.curacion.setVisible(false);
        hitbox = new Rectangle(
                columna + 10,
                fila + 20,
                70, 60);
        hitbox.setFill(Color.RED);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(false);

        root.getChildren().addAll(imagenNini, potenciador, curacion, hitbox);
    }

    // --- MÉTODOS ---
    // abstactos

    /**
     * Hace que la planta ataque a determinada cosa
     *
     * @param cosas a que cosa ataca
     */
    protected abstract void atacar(ArrayList<Cosa> cosas);

    /**
     * Actualiza el nini
     *
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param terreno      Parte del terreno (En array bidimensional) en la que se encuentra
     * @param cosas        Array de cosas
     */
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
        curar();
    }

    // normales

    /**
     * Recibe daño y se lo resta al nini
     *
     * @param daño Daño que recibe
     */
    public void recibirDaño(int daño) {
        salud = salud - daño;
        if (salud <= 0) {
            morir();
        }
    }

    /**
     * El nini muere y se elimina
     */
    public void morir() {
        root.getChildren().remove(imagenNini);
        root.getChildren().remove(hitbox);
        this.potenciador.setVisible(false);
        this.curacion.setVisible(false);
        ControladorReloj.getNinis().remove(this);
        estaMuerto = true;

        //Esto de aqui para que el nini no exista más (que bien me expreso)
        int filaTerreno = Cuadricula.convertirAFila(fila);
        int columnaTerreno = Cuadricula.convertirAColumna(columna);
        Celda[][] terreno = EscenaJuego.getTerreno();
        if (filaTerreno >= 0 && filaTerreno < terreno.length && columnaTerreno >= 0 && columnaTerreno < terreno[0].length) {
            terreno[filaTerreno][columnaTerreno].limpiar();
        }
        GestorPuntos gepun = GestorPuntos.getInstancia();
        gepun.eliminarPuntos(5);
        EstadisticasRecuento.sumarNinisMuertos();
    }


    /**
     * Potencia al nini
     */
    public void potenciar() {
        if (ControladorReloj.detectarGuevara() && !potenciado) {
            this.potenciador.setVisible(true);
            this.potenciado = true;
        } else if (!ControladorReloj.detectarGuevara() && potenciado) {
            this.potenciador.setVisible(false);
            this.potenciado = false;
        }
    }

    /**
     * Cura al nini
     */
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

    /**
     * Mira si hay algun enemigo en la fila
     *
     * @param cosas Array de cosas
     * @return boolean
     */
    protected boolean hayCosaEnMiFila(ArrayList<Cosa> cosas) {
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

    public TipoNini getTipoNini() {
        return tipoNini;
    }

    public void setImagenNiniImage(String rutaNuevaAnimacion) {
        this.imagenNini.setImage(new Image(rutaNuevaAnimacion));
    }

    public boolean isEstaMuerto() {
        return estaMuerto;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
