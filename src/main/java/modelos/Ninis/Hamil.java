package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Hamil extends Nini {
    // --- ATRIBUTOS ---
    private double cooldownAtaque;
    private double tiempoUltimoGolpe;
    private boolean atacandoCosa = false;
    // --- CONSTRUCTOR ---

    public Hamil(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.HAMIL, 450, 450, 0, 5, "Animaciones/Ninis/Hamil_Idle.gif", root);
        this.cooldownAtaque = 2;
        this.tiempoUltimoGolpe = 0;
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        if (!atacandoCosa) {
            this.setImagenNiniImage("Animaciones/Ninis/Hamil_Ataque.gif");
            atacandoCosa = true;
        }
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            this.setImagenNiniImage("Animaciones/Ninis/Hamil_Idle.gif");
            atacandoCosa = false;
        });
        pausa.play();
    }

    public double getCooldownAtaque() {
        return cooldownAtaque;
    }

    public void setCooldownAtaque(double cooldownAtaque) {
        this.cooldownAtaque = cooldownAtaque;
    }

    public double getTiempoUltimoGolpe() {
        return tiempoUltimoGolpe;
    }

    public void setTiempoUltimoGolpe(double tiempoUltimoGolpe) {
        this.tiempoUltimoGolpe = tiempoUltimoGolpe;
    }
}
