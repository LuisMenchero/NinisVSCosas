package modelos.Cosas;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.GestorButanitos;
import modelos.Ninis.Nini;

public class Hacienda extends Cosa {
    // --- ATRIBUTOS ---
    //El gestor de butanitos lo pillo en este para que pueda descontarlos
    GestorButanitos GB = GestorButanitos.getInstancia();


    // --- CONSTRUCTOR ---
    public Hacienda(Pane root) {
        super(2000, 20, 60, 2, "Animaciones/Cosas/caminarCV.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
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

    public void descontar () {
        this.setImagenCosa("Animaciones/Cosas/Hacienda_Descontar.gif");
        movimientoDeHitbox.play();
        GB.restarButanitos(100);
    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

}

