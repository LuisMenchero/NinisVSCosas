package modelos.Cosas;
import controladores.ControladorReloj;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import modelos.Cuadricula;
import modelos.Ninis.Nini;

/**
 * Representa de forma abstracta una cosa (enemigo)
 * @author Diego
 * @author Luis
 * @version 1.0
 */
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
    protected boolean atacandoNini = false;
    protected int pixelesPorSegundosActual;
    protected Rectangle hitbox;
    protected TranslateTransition movimientoDeHitbox;
    protected boolean estaRalentizado = false;
    // Congelamiento
    protected boolean estaCongelado = false;
    protected ImageView imagenCongelado;

    // --- CONSTRUCTOR ---
    /**
     * Contructor de una cosa, inicia y coloca su imagen, hitbox...
     * @param salud salud que tiene esa cosa
     * @param velocidad velocidad a la que se mueve esa cosa
     * @param daño daño que hace esa cosa
     * @param cooldownAtaque tiempo que tarda la cosa entre ataques
     * @param rutaImagenCosa ubicacion de su gif
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Cosa(int salud, int velocidad, int daño, double cooldownAtaque, String rutaImagenCosa, Pane root) {
        this.columna = 1280;
        int filaRandom = (int) (Math.random() * (4 - 0 + 1) + 0);
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
        hitbox = new Rectangle(
                columna,
                fila + 20,
                40, 60);
        hitbox.setFill(Color.RED);
        hitbox.setOpacity(0.5);
        hitbox.setVisible(true);

        movimientoDeHitbox = new TranslateTransition(Duration.millis(100), hitbox);
        movimientoDeHitbox.setByX(-1);
        movimientoDeHitbox.setCycleCount(Animation.INDEFINITE);
        movimientoDeHitbox.setAutoReverse(true);

        // para la congelación
        imagenCongelado = new ImageView("Animaciones/Cosas/bloque_hielo.png");
        imagenCongelado.setFitWidth(ancho);
        imagenCongelado.setFitHeight(alto);
        imagenCongelado.setLayoutX(columna);
        imagenCongelado.setLayoutY(fila);
        imagenCongelado.setOpacity(0.67);
        imagenCongelado.setVisible(false);

        root.getChildren().addAll(imagenCosa, hitbox, imagenCongelado);
    }


    // --- METODOS ---

    /**
     * Mueve la cosa segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    public abstract void caminar(double tiempoFrames);

    /**
     * Hace que la cosa ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    public abstract void atacar(double tiempoFrames, Nini niniAtacando);


    /**
     * Hace que la cosa sume puntos para las estadísticas
     */
//    public abstract void darPuntos();





    /**
     * Actualiza la cosa
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    public abstract void actualizar(double tiempoFrames);

    public void recibirDaño(int daño) {
        this.salud = salud - daño;
        System.out.println("Salud: " + salud);
        if (this.salud <= 0) {
            morir();
        }
    }

    /**
     * Mata a la cosa
     */
    public void morir() {
        root.getChildren().remove(imagenCosa);
        root.getChildren().remove(hitbox);
        ControladorReloj.getCosas().remove(this);
    }

    /**
     * Congela a la cosa
     */
    public void congelar() {
        imagenCongelado.setVisible(true);
        this.pixelesPorSegundosActual = 0;
    }

    /**
     * Descongela a la cosa
     */
    public void descongelar() {
        imagenCongelado.setVisible(false);
        this.pixelesPorSegundosActual = this.pixelesPorSegundo;
    }


    // --- GETTERS Y SETTERS ---

    /**
     * Getter de columna
     * @return columna
     */
    public double getColumna() {
        return columna;
    }

    /**
     * Getter de fila
     * @return fila
     */
    public double getFila() {
        return fila;
    }

    /**
     * Getter de ruta imagen cosa
     * @return rutaImagenCosa
     */
    public String getRutaImagenCosa() {
        return rutaImagenCosa;
    }

    /**
     * Getter de imagen cosa
     * @return imagenCosa
     */
    public ImageView getImagenCosa() {
        return imagenCosa;
    }

    /**
     * Getter de daño
     * @return daño
     */
    public int getDaño() {
        return daño;
    }

    public void setColumna(double columna) {
        this.columna = columna;
    }

    public void setMovimientoDeHitbox(TranslateTransition movimientoDeHitbox) {
        this.movimientoDeHitbox = movimientoDeHitbox;
    }

    public int getPixelesPorSegundo() {
        return pixelesPorSegundo;
    }

    /**
     * Getter de pixeles por segundos a los que se mueve la cosa actualmente
     * @return pixelesPorSegundosActual
     */
    public int getPixelesPorSegundosActual() {
        return pixelesPorSegundosActual;
    }

    /**
     * Getter de esta ralentizado
     * @return estaRalentizado
     */
    public boolean estaRalentizado() {
        return estaRalentizado;
    }

    /**
     * Getter de la hitbox
     * @return hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

    /**
     * Setter de pixeles por segundo actual
     * @param pixelesPorSegundosActual
     */
    public void setPixelesPorSegundosActual(int pixelesPorSegundosActual) {
        this.pixelesPorSegundosActual = pixelesPorSegundosActual;
    }

    /**
     * Setter de nueva imagen de animacion
     * @param rutaNuevaAnimacion
     */
    public void setImagenCosa(String rutaNuevaAnimacion) {
        this.imagenCosa.setImage(new Image(rutaNuevaAnimacion));
    }

    /**
     * Setter del boolean atacando nini
     * @param atacandoNini
     */
    public void setAtacandoNini(boolean atacandoNini) {
        this.atacandoNini = atacandoNini;
    }

    /**
     * Setter del boolean esta ralentizado
     * @param estaRalentizado
     */
    public void setEstaRalentizado(boolean estaRalentizado) {
        this.estaRalentizado = estaRalentizado;
    }

}
