package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Nota;
import modelos.Proyectiles.PelotaBaloncesto;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Dani extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<PelotaBaloncesto> pelotasNuevas;

    // --- CONSTRUCTOR ---

    public Dani(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.DANI, 100, 300, 10, 5, "Animaciones/Ninis/Dani_idle.gif", root);
        pelotasNuevas = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        if (hayZombieEnMiFila(cosas)) {
            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
            if (tiempoDelUltimoDisparo > cooldownDisparo) {
                tiempoDelUltimoDisparo = 0;
                atacar(cosas);
            }
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/Dani_Ataque.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(evento -> {
            pelotasNuevas.add(new PelotaBaloncesto(fila, columna, root));
            this.setImagenNiniImage("Animaciones/Ninis/Dani_idle.gif");
        });
        pausa.play();
    }

    public ArrayList<Proyectil> getPelotasNuevas() {
        ArrayList<Proyectil> copiaPelotasNuevas = new ArrayList<>();
        for (PelotaBaloncesto pelota : pelotasNuevas) {
            copiaPelotasNuevas.add(pelota);
        }
        pelotasNuevas.clear();
        return copiaPelotasNuevas;
    }
}
