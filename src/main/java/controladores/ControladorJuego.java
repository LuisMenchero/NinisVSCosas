package controladores;

import escenas.EscenaJuego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;

public class ControladorJuego {

    public static void terminarPartida(){
            if (EscenaJuego.getReloj().isPausado()) {
                EscenaJuego.getPanelPartidaTerminada().setVisible(true);
            } else {
                EscenaJuego.getPanelPartidaTerminada().setVisible(true);
            }

    }

}
