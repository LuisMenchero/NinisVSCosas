package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.CabezaGuille;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

/**
 * Representa a un Guille
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Guille extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<CabezaGuille> cabezasNuevas;
    private boolean haAtacado = false;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Guille
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Guille(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.GUILLE, 125, 175, 2, 5, "Animaciones/Ninis/Guille_Idle.gif", root);
        cabezasNuevas = new ArrayList<>();
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
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(e -> {
            if (!haAtacado) {
                atacar(cosas);
            }
        });
        pausa.play();
    }

    /**
     * Metodo que hace que Guille ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/Guille_Atacando.gif");

        haAtacado = true;
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(evento -> {
            cabezasNuevas.add(new CabezaGuille(fila, columna, root));
            PauseTransition pausaPequeña = new PauseTransition(Duration.millis(10));
            pausaPequeña.setOnFinished(e -> {
                morir();
            });
            pausaPequeña.play();
        });
        pausa.play();

    }

    public ArrayList<Proyectil> getCabezasNuevas() {
        ArrayList<Proyectil> copiaCabezasNuevas = new ArrayList<>();
        for (CabezaGuille cabeza : cabezasNuevas) {
            copiaCabezasNuevas.add(cabeza);
        }
        cabezasNuevas.clear();
        return copiaCabezasNuevas;
    }
}
