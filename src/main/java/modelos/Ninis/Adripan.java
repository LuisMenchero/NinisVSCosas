package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Adripan extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private boolean estaCargado = false;
    private boolean enProcesoCarga = false;
    private double tiempoParaRecarga;

    // --- CONSTRUCTOR ---
    public Adripan(double columna, double fila, Pane root) {
        super(columna, fila, 80, 25, 10, "Animaciones/Ninis/AdripanEsperando.gif", root);
    }

    //--- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();

        tiempoParaRecarga = tiempoParaRecarga+ 10 + tiempoFrames;
        if (!estaCargado && !enProcesoCarga) {
            recargar();
        }
        if (estaCargado) {
            atacar(cosas);
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }

    public void recargar () {
        enProcesoCarga = true;
        this.setImagenNiniImage("Animaciones/Ninis/AdripanRecarga.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));

        pausa.setOnFinished(evento -> {
            this.setImagenNiniImage("Animaciones/Ninis/AdripanCargado.gif");
            estaCargado = true;
        });
        pausa.play();
    }
}
