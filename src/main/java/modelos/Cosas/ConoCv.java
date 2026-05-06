package modelos.Cosas;

import javafx.scene.layout.Pane;
import modelos.Ninis.Nini;

public class ConoCv extends Cosa {
    // --- ATRIBUTOS ---
    private boolean conoRoto = false;

    // --- CONSTRUCTOR ---
    public ConoCv(Pane root) {
        super(4000, 20, 60, 2, "Animaciones/Cosas/cono_andando.gif", root);
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
        if (conoRoto) {
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
                this.setImagenCosa("Animaciones/Cosas/Cono_Ataquendo.gif");
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
                this.setImagenCosa("Animaciones/Cosas/cono_andando.gif");
                atacandoNini = false;
                movimientoDeHitbox.stop();
                hitbox.setTranslateX(0);
            }
        }


    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (salud <= saludMaxima / 2 && !conoRoto) {
            romperCono();
        }
    }

    public void romperCono() {
        if (atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
        } else {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
        }
        conoRoto = true;
    }


}
