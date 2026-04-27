package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.*;
import modelos.Cosas.Cosa;
import modelos.Items.Butanito;

import java.util.ArrayList;

public class Luis extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private double tiempoProduccionButanito = 0;
    private double tiempoGeneracionButanito = 25;

    // --- CONSTRUCTOR ---

    public Luis(double columna, double fila, Pane root) {
        super(columna, fila, 75, 50, 0, "Animaciones/Ninis/Lis.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
        tiempoProduccionButanito = tiempoProduccionButanito + tiempoFrames;
        if (tiempoProduccionButanito >= tiempoGeneracionButanito) {
            tiempoProduccionButanito = 0;
            System.out.println("butanito generado");
            Butanito nuevoButanito = new Butanito(columna,fila,root,"Animaciones/Items/Butanito.gif");

        }
    }

    @Override
    public void disparar(ArrayList<Cosa> cosas){
    }
}
