package modelos.Cosas;


import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;

public class Jamiroquai extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Jamiroquai(Pane root) {
        super(250, 14, 80, 1, "Animaciones/Cosas/Jamiroquai_Andando.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        //Si queremos que se mueva de fila en algun momento poner un set y
    }

    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Jamiroquai_Ataquendo.gif");
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
            this.setImagenCosa("Animaciones/Cosas/Jamiroquai_Andando.gif");
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

