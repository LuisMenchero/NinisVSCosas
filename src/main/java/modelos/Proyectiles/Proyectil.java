package modelos.Proyectiles;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Representa de forma abstracta un proyectil
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public abstract class Proyectil {
    // --- ATRIBUTOS ---
    protected int pixelesPorSegundo;
    protected int daño;
    // imagen de la nota
    protected ImageView imagenProyectil;
    protected double ancho;
    protected double alto;

    // para colocar la nota
    protected double fila;
    protected double columna;
    protected Pane root;

    //Funcionamiento
    protected Rectangle hitbox;
    protected boolean haImpactado = false;

    // Para saber si esta quemado
    protected ImageView imagenProyectilQuemado;
    protected boolean estaQuemado = false;

    // --- CONSTRUCTOR ---

    /**
     * Constructor de proyectil
     * @param pixelesPorSegundo velocidad de movimiento
     * @param daño cuanto daño hace
     * @param ancho tamaño horizontal
     * @param alto tamaño vertical
     * @param fila donde se encuentra (fila)
     * @param columna donde se encuentra (columna)
     * @param root Pane root de la escena en la que aparece
     */
    public Proyectil(int pixelesPorSegundo, int daño, int ancho, int alto,double fila, double columna, Pane root) {
        this.pixelesPorSegundo = pixelesPorSegundo;
        this.daño = daño;
        this.ancho = ancho;
        this.alto = alto;
        this.fila = fila;
        this.columna = columna;
        this.root = root;
        this.hitbox = new Rectangle(
                columna,
                fila ,
                15,20);
        hitbox.setFill(Color.RED);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(false);
        imagenProyectilQuemado = new ImageView("Animaciones/Proyectiles/proyectil_quemado.gif");
        imagenProyectilQuemado.setX(-20);
        imagenProyectilQuemado.setY(fila);
        imagenProyectilQuemado.setVisible(false);
        this.root.getChildren().addAll(hitbox,imagenProyectilQuemado);
    }
    // --- MÉTODOS ---

    /**
     *  Actualiza el proyectil
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    protected abstract void actualizar(double tiempoFrames);

    /**
     * Mueve el proyectil
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    protected abstract void moverProyectil(double tiempoFrames);

    /**
     * Impacta al chocar
     */
    public abstract void impactar();

    // --- GETTERS Y SETTERS ---


    public ImageView getImagenProyectil() {
        return imagenProyectil;
    }

    public int getDaño() {
        return daño;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public ImageView getImagenProyectilQuemado() {
        return imagenProyectilQuemado;
    }

    public boolean estaQuemado() {
        return estaQuemado;
    }

    public boolean isHaImpactado() {
        return haImpactado;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public void setEstaQuemado(boolean estaQuemado) {
        this.estaQuemado = estaQuemado;
    }
}
