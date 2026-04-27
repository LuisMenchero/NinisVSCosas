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
    private double tiempoParaRecarga;

    // --- CONSTRUCTOR ---
    public Adripan(double columna, double fila, Pane root) {
        super(columna, fila, 80, 25, 10, "Animaciones/Ninis/AdripanEsperando.gif", root);
    }

    //--- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
//        if (tiempoFrames > ) {
//
//        }

        tiempoParaRecarga = tiempoParaRecarga+ 10 + tiempoFrames;
        if (!estaCargado) {
            recargar();
        }
        if (estaCargado) {

        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }

    public void recargar () {
        this.setImagenNiniImage("Animaciones/Ninis/AdripanEsperando.gif");
        PauseTransition pausa1 = new PauseTransition(Duration.seconds(1));
        pausa1.setOnFinished(evento -> {
            this.setImagenNiniImage("Animaciones/Ninis/AdripanRecarga.gif");
        });
        pausa1.play();

        PauseTransition pausa2 = new PauseTransition(Duration.seconds(1));
        pausa2.setOnFinished(evento -> {
            estaCargado = true;
            this.setImagenNiniImage("Animaciones/Ninis/AdripanCargado.gif");
        });
        pausa2.play();
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
