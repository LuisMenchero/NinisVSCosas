package controladores;

import javafx.animation.AnimationTimer;

public class ControladorReloj {

//esta clase sirve para que el juego funcione en si
// de lo que se encarga es de dar "tiempoFrames" que es el tiempo que ha pasado desde el ultimo frame"
// esto lo hemos investigado y sirve en general para que el funcionamiento de la logica no se vea ligada a los frames a los que te vaya el juego

    public void iniciarReloj() {

        AnimationTimer temporizador = new AnimationTimer() {
            private long ultimoTiempo = 0;
            //hemos usado long para que funcione porque si no se queda el juego capum

            @Override
            public void handle(long now) {
                if (ultimoTiempo < 0) {
                    ultimoTiempo = now;
                    return;
                }

                double tiempoFrames = (now - ultimoTiempo) / 1000000000.0;
                ultimoTiempo = now;


                // lo hemos hecho de forma que sea una pila de llamadas pero nos hemos debatido que fuera un getter
                actualizar(tiempoFrames);

            }
        };

        temporizador.start();

    }


    public void actualizar(double tiempoFrames) {
        //aqui van las cosas que requieren ser actualizadas que reciban tiempoFrames


    }



}