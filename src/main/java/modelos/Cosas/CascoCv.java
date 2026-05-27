package modelos.Cosas;
import javafx.scene.layout.Pane;
import modelos.Ninis.Nini;

/**
 * Representa a un enemigo CascoCv
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class CascoCv extends Cosa {
    // --- ATRIBUTOS ---
    private boolean cascoRoto = false;

    // --- CONSTRUCTOR ---

    /**
     * Constructor de CascoCV
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public CascoCv(Pane root) {
        super(600, 20, 60, 2, "Animaciones/Cosas/casco_andando.gif", root);
    }

    /**
     * Mueve a CascoCV segun pasa el tiempo
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
     * Hace que CascoCV ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
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

    /**
     * Actualiza a CascoCV
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (salud <= saludMaxima / 3 && !cascoRoto) {
            romperCasco();
        }
    }

    /**
     * Cambia el estado de CascoCV a cascoRoto y cambia sus animaciones
     */
    public void romperCasco() {
        if (atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Ataquendo.gif");
        } else {
            this.setImagenCosa("Animaciones/Cosas/caminarCV.gif");
        }
        cascoRoto = true;
    }
}
