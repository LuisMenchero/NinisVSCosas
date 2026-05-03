package modelos.Cosas;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Cv extends Cosa{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Cv(Pane root) {
        super(2000,20 , 2, "Animaciones/Cosas/caminarCV.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
    }

    @Override
    public void atacar() {
        this.setImagenCosa(new ImageView("Animaciones/Cosas/Ataquendo.gif"));
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(event -> {
            this.setImagenCosa(new ImageView("Animaciones/Cosas/caminarCV.gif"));
        });
        pausa.play();
    }

    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
    }

}
