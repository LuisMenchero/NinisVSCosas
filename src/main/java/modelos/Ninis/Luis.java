package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.*;
import modelos.Cosas.Cosa;
import modelos.Items.Butanito;

import java.util.ArrayList;
/**
 * Representa a un Luis
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Luis extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private double tiempoProduccionButanito = 0;
    private double tiempoGeneracionButanito = 20;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Luis
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Luis(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.LUIS, 75, 50, 0, 5, "Animaciones/Ninis/Lis.gif", root);
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
    }

    /**
     * Metodo que hace que Luis ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
    }
}
