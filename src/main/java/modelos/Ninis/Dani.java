package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.PelotaBaloncesto;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

/**
 * Representa a un Dani
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Dani extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<PelotaBaloncesto> pelotasNuevas;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Dani
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Dani(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.DANI, 100, 300, 10, 5, "Animaciones/Ninis/Dani_idle.gif", root);
        pelotasNuevas = new ArrayList<>();
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
        if (hayCosaEnMiFila(cosas)) {
            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
            if (tiempoDelUltimoDisparo > cooldownDisparo) {
                tiempoDelUltimoDisparo = 0;
                atacar(cosas);
            }
        }
    }

    /**
     * Metodo que hace que Dani ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/Dani_Ataque.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(evento -> {
            pelotasNuevas.add(new PelotaBaloncesto(fila, columna, root));
            this.setImagenNiniImage("Animaciones/Ninis/Dani_idle.gif");
        });
        pausa.play();
    }

    public ArrayList<Proyectil> getPelotasNuevas() {
        ArrayList<Proyectil> copiaPelotasNuevas = new ArrayList<>();
        for (PelotaBaloncesto pelota : pelotasNuevas) {
            copiaPelotasNuevas.add(pelota);
        }
        pelotasNuevas.clear();
        return copiaPelotasNuevas;
    }
}
