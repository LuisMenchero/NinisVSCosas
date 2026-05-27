package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Eliseo extends Nini {
    // --- ATRIBUTOS ---
    private int contadorEmpujones = 3;
    private boolean estaEmpujando = false;
    // --- CONSTRUCTOR ---

    public Eliseo(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ELISEO, 75, 75, 3, 5, "Animaciones/Ninis/Eliseo3bolas_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        estaEmpujando = true;
        if (this.contadorEmpujones == 3) {
            this.setImagenNiniImage("Animaciones/Ninis/Eliseo_Empuje3bolas.gif");
            PauseTransition pausa = new PauseTransition(Duration.seconds(1));
            pausa.setOnFinished(e -> {
                this.setImagenNiniImage("Animaciones/Ninis/Eliseo2bolas_Idle.gif");
            });
            pausa.play();
        } else if (this.contadorEmpujones == 2) {
            this.setImagenNiniImage("Animaciones/Ninis/Eliseo_Empuje2Bolas.gif");
            PauseTransition pausa = new PauseTransition(Duration.seconds(1));
            pausa.setOnFinished(e -> {
                this.setImagenNiniImage("Animaciones/Ninis/Eliseo1bolas_Idle.gif");
            });
            pausa.play();
        } else if (this.contadorEmpujones == 1) {
            this.setImagenNiniImage("Animaciones/Ninis/Eliseo_Empuje1Bola.gif");
            PauseTransition pausa = new PauseTransition(Duration.seconds(1));
            pausa.setOnFinished(e -> {
                this.setImagenNiniImage("Animaciones/Ninis/EliseoSinCargas_Idle.gif");
            });
            pausa.play();
        }
        contadorEmpujones--;
    }

    public int getContadorEmpujones() {
        return contadorEmpujones;
    }

    public boolean estaEmpujando() {
        return estaEmpujando;
    }

    public void setEstaEmpujando(boolean estaEmpujando) {
        this.estaEmpujando = estaEmpujando;
    }
}
