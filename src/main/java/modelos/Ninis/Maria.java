package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;
/**
 * Representa a un Maria
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Maria extends Nini {
    // --- ATRIBUTOS ---
    private boolean hayContacto = false;
    private boolean estaPeleando = false;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Maria
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Maria(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.MARIA, 125, 150, 0, 20, "Animaciones/Ninis/Maria_Idle.gif", root);
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
        if (!hayContacto && !estaPeleando) {
            for (Cosa cosa : cosas) {
                if (cosa.getHitbox().getBoundsInParent().intersects(this.getHitbox().getBoundsInParent())) {
                    atacar(cosas);
                    PauseTransition pausa = new PauseTransition(Duration.seconds(10));
                    pausa.setOnFinished(event -> {
                        this.setImagenNiniImage("Animaciones/Ninis/Maria_Idle.gif");
                        estaPeleando = false;
                        hayContacto = false;
                    });
                    pausa.play();
                }
            }
        }
    }

    /**
     * Metodo que hace que Maria ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        hayContacto = true;
        this.setImagenNiniImage("Animaciones/Ninis/Maria_Atacando.gif");
    }

    public boolean hayContacto() {
        return hayContacto;
    }

    public boolean estaPeleando() {
        return estaPeleando;
    }

    public void setEstaPeleando(boolean estaPeleando) {
        this.estaPeleando = estaPeleando;
    }
}
