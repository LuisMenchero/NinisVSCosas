package modelos.Cosas;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;

public class Cv extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Cv(Pane root) {
        super(200, 20, 60, 2, "Animaciones/Cosas/caminarCV.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCongelado.setLayoutX(columna);
    }

    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
            atacandoNini = true;
            movimientoDeHitbox.play();
        }

        tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
        if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
            tiempoUltimoGolpe = 0;
            niniAtacando.recibirDaño(daño);
            System.out.println("vida nini : " + niniAtacando.getSalud());
        }

        if (niniAtacando.isEstaMuerto()) {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
            atacandoNini = false;
            movimientoDeHitbox.stop();
            hitbox.setTranslateX(0);
        }
    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

}
