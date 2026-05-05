package modelos.Cosas;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;
import modelos.Proyectiles.Nota;

public class Cv extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    public Cv(Pane root) {
        super(2000, 20, 60, 2, "Animaciones/Cosas/caminarCV.gif", root);
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        //Si queremos que se mueva de fila en algun momento poner un set y
    }

//    @Override
//    public void atacar(double tiempoFrames, Nini niniAtacando) {
//        while (!niniAtacando.isEstaMuerto()) {
//            tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
//            if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
//                tiempoUltimoGolpe = 0;
//                this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
//                System.out.printf("ATACAAAAR ATACAAAR");
//                niniAtacando.recibirDaño(daño);
//            }
//        }
//    }

    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
            atacandoNini = true;
        }

        tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
        if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 1) {
            tiempoUltimoGolpe = 0;
            niniAtacando.recibirDaño(daño);
            System.out.println("vida nini : " + niniAtacando.getSalud());
        }

        if (niniAtacando.isEstaMuerto()) {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
            atacandoNini = false;
        }
    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

}
