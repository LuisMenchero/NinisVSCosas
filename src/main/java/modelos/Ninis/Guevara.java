package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Guevara extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private double multiplicadorDaño = 1.5;
    private int tiempoEnDesaparecer = 5;
    private double tiempoParaDesaparecer = 0;

    // --- CONSTRUCTOR ---
    public Guevara(double columna, double fila, Pane root) {
        super(columna, fila, 500, 25, 0, "Animaciones/Ninis/Guevara_Idle.gif", root);

    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if(tiempoParaDesaparecer > tiempoEnDesaparecer) {
            recibirDaño(500);
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
    }

}
