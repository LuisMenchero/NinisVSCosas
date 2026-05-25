package modelos.Cosas;

import javafx.scene.layout.Pane;
import modelos.Ninis.Nini;

public class CascoCv extends Cosa {
    // --- ATRIBUTOS ---
    private boolean cascoRoto = false;

    // --- CONSTRUCTOR ---
    public CascoCv(Pane root) {
        super(600, 20, 60, 2, "Animaciones/Cosas/casco_andando.gif", root);
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
        if (cascoRoto) {
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
        } else {
            if (!atacandoNini) {
                this.setImagenCosa("Animaciones/Cosas/Casco_Ataquendo.gif");
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
                this.setImagenCosa("Animaciones/Cosas/casco_andando.gif");
                atacandoNini = false;
                movimientoDeHitbox.stop();
                hitbox.setTranslateX(0);
            }
        }
    }

    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (salud <= saludMaxima / 3 && !cascoRoto) {
            romperCasco();
        }
    }

    public void romperCasco() {
        if (atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
        } else {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
        }
        cascoRoto = true;
    }
}
