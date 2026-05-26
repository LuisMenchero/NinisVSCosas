package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Maria extends Nini {
    // --- ATRIBUTOS ---
    private boolean hayContacto = false;
    private boolean estaPeleando = false;
    // --- CONSTRUCTOR ---

    public Maria(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.MARIA, 125, 150, 0, 5, "Animaciones/Ninis/Maria_Idle.gif", root);
    }

    // --- MÉTODOS ---
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
