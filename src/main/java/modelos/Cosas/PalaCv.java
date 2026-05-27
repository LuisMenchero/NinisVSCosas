package modelos.Cosas;
import javafx.scene.layout.Pane;
import modelos.Ninis.Nini;

/**
 * Representa a un enemigo PalaCV
 */
public class PalaCv extends Cosa {
    // --- ATRIBUTOS ---
    private boolean palaRota = false;

    // --- CONSTRUCTOR ---

    /**
     * Constructor de PalaCV
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public PalaCv(Pane root) {
        super(900, 20, 65, 2, "Animaciones/Cosas/caminar_pala.gif", root);
    }

    /**
     * Mueve a PalaCV segun pasa el tiempo
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
     * Hace que PalaCV ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (palaRota) {
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
                this.setImagenCosa("Animaciones/Cosas/Ataquendo_pala.gif");
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
                this.setImagenCosa("Animaciones/Cosas/caminar_pala.gif");
                atacandoNini = false;
                movimientoDeHitbox.stop();
                hitbox.setTranslateX(0);
            }
        }
    }

    /**
     * Actualiza a PalaCV
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (salud <= saludMaxima / 3 && !palaRota) {
            romperPala();
        }
    }

    /**
     * Cambia el estado de PalaCV a palaRota y cambia sus animaciones
     */
    public void romperPala() {
        if (atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
        } else {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
        }
        palaRota = true;
    }
}
