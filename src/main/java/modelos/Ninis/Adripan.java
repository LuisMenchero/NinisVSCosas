package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;
/**
 * Representa a un Adripan
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Adripan extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private boolean estaCargado = false;
    private boolean enProcesoCarga = false;
    private double tiempoParaRecarga;
    private boolean explotar = false;
    private ImageView explosion;
    private Rectangle hitboxExplosion;
    private boolean hayContacto;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Adripan
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Adripan(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ADRIPAN, 80, 25, 0, 15, "Animaciones/Ninis/AdripanEsperando.gif", root);
    }

    //--- MÉTODOS ---
    /**
     * Metodo que se encarga de actualizar las acciones
     *
     * @param tiempoFrames es el tiempo que recibe del reloj
     * @param terreno lugar de las filas y columnas en la que se encuentra
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        PauseTransition pause = new PauseTransition(Duration.seconds(10));
        pause.setOnFinished(e1 -> {
            if (!estaCargado && !enProcesoCarga) {
                recargar();
            }
            if (estaCargado) {
                if (!explotar && hayContacto) {
                    atacar(cosas);
                    PauseTransition pause2 = new PauseTransition(Duration.seconds(0.5));
                    pause2.setOnFinished(e2 -> {
                        morir();
                        root.getChildren().remove(explosion);
                        root.getChildren().remove(hitboxExplosion);
                    });
                    pause2.play();
                }
            }
        });
        pause.play();
    }

    /**
     * Metodo que hace que Adripan ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        explotar = true;
        explosion = new ImageView("Animaciones/Ninis/boom-explosion.gif");
        hitboxExplosion = new Rectangle(columna - 50, fila - 50, 180, 180);
        hitboxExplosion.setFill(Color.RED);
        hitboxExplosion.setOpacity(0);
        hitboxExplosion.setVisible(true);
        explosion.setFitWidth(200);
        explosion.setFitHeight(200);
        explosion.setX(columna - 50);
        explosion.setY(fila - 50);
        root.getChildren().addAll(explosion, hitboxExplosion);
    }

    /**
     * Metodo que se encarga de que Adripan recargue
     *
     */
    public void recargar() {
        enProcesoCarga = true;
        this.setImagenNiniImage("Animaciones/Ninis/AdripanRecarga.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(2.6));

        pausa.setOnFinished(evento -> {
            this.setImagenNiniImage("Animaciones/Ninis/AdripanCargado.gif");
            estaCargado = true;
        });
        pausa.play();
    }

    public void setHayContacto(boolean hayContacto) {
        this.hayContacto = hayContacto;
    }

    public boolean estaCargado() {
        return estaCargado;
    }

    public Rectangle getHitboxExplosion() {
        return hitboxExplosion;
    }
}
