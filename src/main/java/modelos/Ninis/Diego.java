package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Nota;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

/**
 * Representa a un Adripan
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Diego extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<Nota> notasNuevas;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Diego
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Diego(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.DIEGO, 100, 100, 3, 5, "Animaciones/Ninis/DiegoEsperando.gif", root);
        notasNuevas = new ArrayList<>();
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
     * Metodo que hace que Diego ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/DiegoDisparando.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1.2));
        pausa.setOnFinished(evento -> {
            notasNuevas.add(new Nota(fila, columna, root));
            this.setImagenNiniImage("Animaciones/Ninis/DiegoEsperando.gif");
        });
        pausa.play();
    }

    public ArrayList<Proyectil> getNotasNuevas() {
        ArrayList<Proyectil> copiaNotasNuevas = new ArrayList<>();
        for (Nota nota : notasNuevas) {
            copiaNotasNuevas.add(nota);
        }
        notasNuevas.clear();
        return copiaNotasNuevas;
    }
}
