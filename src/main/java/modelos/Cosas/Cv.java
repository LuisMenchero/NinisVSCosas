package modelos.Cosas;

import javafx.scene.layout.Pane;

public class Cv extends Cosa{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Cv(Pane root) {
        super(2000,20 ,"Animaciones/Ninis/Guevara_Idle.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundo * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
    }

    @Override
    public void atacar() {

    }

    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
    }

}
