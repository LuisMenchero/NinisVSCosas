package modelos.Cosas;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Ninis.Nini;

/**
 * Representa a un enemigo Jamiroquai
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Jamiroquai extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    /**
     * Constructor de Jamiroquai
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Jamiroquai(Pane root) {
        super(250, 14, 80, 1, "Animaciones/Cosas/Jamiroquai_Andando.gif", root);
    }

    /**
     * Mueve a Jamiroquai segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCongelado.setLayoutX(columna);
    }

    /**
     * Hace que Jamiroquai ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
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

    /**
     * Actualiza a Jamiroquai
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

}

