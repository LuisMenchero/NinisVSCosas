package modelos.Cosas;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;

public class Furgo extends Cosa {
    // --- ATRIBUTOS ---
    private boolean niniRecogido = false;

    // --- CONSTRUCTOR ---
    public Furgo(Pane root) {
        super(7000, 75, 9999, 2, "Animaciones/Cosas/Furgo_Abierto.gif", root);
        imagenCosa.setFitWidth(175);
        imagenCosa.setFitHeight(175);
        imagenCosa.setX(-20);
        imagenCosa.setY(-30);
        hitbox.setWidth(120);
    }

    @Override
    public void caminar(double tiempoFrames) {
        if (!niniRecogido) {
            columna = (columna - pixelesPorSegundosActual * tiempoFrames);
            this.imagenCosa.setLayoutX(columna);
            this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        } else {
            columna = (columna + pixelesPorSegundosActual * tiempoFrames);
            this.imagenCosa.setLayoutX(columna);
            this.hitbox.setX((columna + 20) + pixelesPorSegundosActual * tiempoFrames);
        }

    }

    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!niniRecogido) {
            if (!atacandoNini) {
                this.setImagenCosa("Animaciones/Cosas/Furgo_Cerrado.gif");
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
                atacandoNini = false;
                movimientoDeHitbox.stop();
                hitbox.setTranslateX(0);
                niniRecogido = true;
                root.getChildren().remove(hitbox);
            }
        }
    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

    public boolean isNiniRecogido() {
        return niniRecogido;
    }
}
