package modelos.Cosas;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;

/**
 * Representa un enemigo Furgo
 */
public class Furgo extends Cosa {
    // --- ATRIBUTOS ---
    private boolean niniRecogido = false;

    // --- CONSTRUCTOR ---

    /**
     * Constructor de Furgo
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Furgo(Pane root) {
        super(700, 75, 9999, 2, "Animaciones/Cosas/Furgo_Abierto.gif", root);
        imagenCosa.setFitWidth(175);
        imagenCosa.setFitHeight(175);
        imagenCosa.setX(-20);
        imagenCosa.setY(-30);
        hitbox.setWidth(120);
    }

    /**
     * Mueve a Furgo segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
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
        this.imagenCongelado.setLayoutX(columna);
    }

    /**
     * Hace que Furgo ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
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

    /**
     * Actualiza a furgo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

    public boolean isNiniRecogido() {
        return niniRecogido;
    }
}
