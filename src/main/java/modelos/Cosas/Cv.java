package modelos.Cosas;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Proyectiles.Nota;

public class Cv extends Cosa{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Cv(Pane root) {
        super(2000,20 , 60, 2, "Animaciones/Cosas/caminarCV.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna+20)-pixelesPorSegundosActual * tiempoFrames);
        //Si queremos que se mueva de fila en algun momento poner un set y
    }

    @Override
    public void atacar() {
        this.setImagenCosa(new ImageView("Animaciones/Cosas/Ataquendo.gif"));
        if (pixelesPorSegundosActual != 0) {
            this.setImagenCosa(new ImageView("Animaciones/Cosas/caminarCV.gif"));
        }
    }

    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
        if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
            tiempoUltimoGolpe = 0;
            atacar();
            System.out.printf("ATACAAAAR ATACAAAR");
        }
    }

}
