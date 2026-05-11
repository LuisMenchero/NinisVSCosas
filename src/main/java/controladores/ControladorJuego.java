package controladores;

import escenas.EscenaJuego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;

public class ControladorJuego {

    public static void terminarPartida(){
//        EscenaJuego.getReloj().pausa();
        EscenaJuego.getReloj().terminar();
        EscenaJuego.getPanelPartidaTerminada().setVisible(true);
    }

}
