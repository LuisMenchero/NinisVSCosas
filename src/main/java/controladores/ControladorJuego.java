package controladores;

import escenas.EscenaJuego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelos.Cosas.CascoCv;
import modelos.Cosas.ConoCv;
import modelos.Cosas.Cosa;
import modelos.Cosas.Cv;
import modelos.Ninis.Nini;

public class ControladorJuego {

    //voy a hacer la parte del spawn de cosas (los he llamado enemigos porque si no me hago un lio)
    public static double tiempoUltimoEnemigo = 0;
    public static double tiempoEnSpawnear = 10;
    private static int ronda = 0;
    private static int tipo;


    public static void spawnEnemigos (){
        if (tiempoUltimoEnemigo >= tiempoEnSpawnear){
            tiempoUltimoEnemigo = 0;

            if (ronda == 0){
                tipo = (int) (Math.random()*3);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                     enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                     enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                     enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);


            }


        }
    }

//        Cv cv = new Cv(root);
//        ConoCv cncv = new ConoCv(root);
//        CascoCv cscv = new CascoCv(root);
//        reloj.registrarCosa(cv);
//        reloj.registrarCosa(cncv);
//        reloj.registrarCosa(cscv);



    public static void terminarPartida(){
//        EscenaJuego.getReloj().pausa();
        EscenaJuego.getReloj().terminar();
        EscenaJuego.getPanelPartidaTerminada().setVisible(true);
    }

}
