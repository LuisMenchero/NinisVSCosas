package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.AlvaroDeslizando;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Alvaro extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<AlvaroDeslizando> alvaroDeslizados;
    private boolean haAtacado = false;
    // --- CONSTRUCTOR ---

    public Alvaro(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ALVARO, 125, 75, 2, 5, "Animaciones/Ninis/Alvaro_Idle.gif", root);
        alvaroDeslizados = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(e -> {
            if (!haAtacado) {
                atacar(cosas);
            }
        });
        pausa.play();
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/Alvaro_Ataque.gif");
        haAtacado = true;
        alvaroDeslizados.add(new AlvaroDeslizando(fila, columna, root));
        PauseTransition pausaPequeña = new PauseTransition(Duration.millis(5));
        pausaPequeña.setOnFinished(e -> {
            morir();
        });
        pausaPequeña.play();
    }

    public ArrayList<Proyectil> getAlvaroDeslizados() {
        ArrayList<Proyectil> copiaAlvaroDeslizados = new ArrayList<>();
        for (AlvaroDeslizando cabeza : alvaroDeslizados) {
            copiaAlvaroDeslizados.add(cabeza);
        }
        alvaroDeslizados.clear();
        return copiaAlvaroDeslizados;
    }
}
