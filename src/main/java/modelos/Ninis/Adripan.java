package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Adripan extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private boolean estaCargado = false;
    // --- CONSTRUCTOR ---
    public Adripan(double columna, double fila, Pane root) {
        super(columna, fila, 80, 25, 10, "Animaciones/Ninis/AdripanEsperando.gif", root);
    }

    //--- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
    }

    @Override
    public void disparar(ArrayList<Cosa> cosas) {
    }

//    public void explotar(double tiempoFrames) {
//        if (estaCargado && -----) {
//
//        }
//    }

    public boolean cargar(double tiempoFrames) {
        if (tiempoFrames <= cooldownDisparo && !estaCargado) {
            setImagenNiniImage("Animaciones/Ninis/AdripanRecarga.gif");
            estaCargado = true;
        }
        if (estaCargado) {
            setImagenNiniImage("Animaciones/Ninis/AdripanCargado.gif");
        }
        return false;
    }
}
