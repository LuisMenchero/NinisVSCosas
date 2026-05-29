package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Items.Butanito;

import java.util.ArrayList;
/**
 * Representa a un Irene
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Irene extends Nini {
    // --- ATRIBUTOS ---
    private double tiempoProduccionButanito = 0;
    private double tiempoGeneracionButanito = 0.75;
    private int tiempoEnDesaparecer = 4;
    private double tiempoParaDesaparecer = 0;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Irene
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Irene(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.IRENE, 125, 0, 0, 350, "Animaciones/Ninis/Irene_Idle.gif", root);
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
        tiempoProduccionButanito = tiempoProduccionButanito + tiempoFrames;
        if (tiempoProduccionButanito >= tiempoGeneracionButanito) {
            tiempoProduccionButanito = 0;
            System.out.println("butanito generado");
            Butanito nuevoButanito = new Butanito(columna, fila, root, "Animaciones/Items/Butanito.gif");
        }
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if (tiempoParaDesaparecer > tiempoEnDesaparecer) {
            morir();
        }
    }

    /**
     * Metodo que hace que Irene ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
