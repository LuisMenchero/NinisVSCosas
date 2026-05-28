package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;
/**
 * Representa a un Keke
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Keke extends Nini {
    // --- ATRIBUTOS ---
    private double cooldownAtaque;
    private double tiempoUltimoGolpe;
    private boolean atacandoCosa = false;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Keke
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Keke(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.KEKE, 175, 175, 0, 50, "Animaciones/Ninis/Keke_Idle.gif", root);
        this.cooldownAtaque = 1;
        this.tiempoUltimoGolpe = 0;
    }

    // --- MÉTODOS ---
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

    }

    /**
     * Metodo que hace que Keke ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        if (!atacandoCosa) {
            this.setImagenNiniImage("Animaciones/Ninis/Keke_BimBamBum.gif");
            atacandoCosa = true;
        }
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            this.setImagenNiniImage("Animaciones/Ninis/Keke_Idle.gif");
            atacandoCosa = false;
        });
        pausa.play();
    }

    // GETTERS Y SETTERS
    public double getCooldownAtaque() {
        return cooldownAtaque;
    }


    public double getTiempoUltimoGolpe() {
        return tiempoUltimoGolpe;
    }

    public void setCooldownAtaque(double cooldownAtaque) {
        this.cooldownAtaque = cooldownAtaque;
    }

    public void setTiempoUltimoGolpe(double tiempoUltimoGolpe) {
        this.tiempoUltimoGolpe = tiempoUltimoGolpe;
    }
}
