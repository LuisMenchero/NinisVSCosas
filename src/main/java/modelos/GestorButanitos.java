package modelos;

import java.util.ArrayList;

public class GestorButanitos {
    // --- ATRIBUTOS ---
    public static GestorButanitos instancia;
    private ArrayList<Butanito> butanitos;
    private int contadorButanitos = 50;
    // --- CONSTRUCTOR ---


    private GestorButanitos() {
        this.butanitos = new ArrayList<>();;
    }

    public static GestorButanitos getInstancia() {
        if (instancia == null) {
            instancia = new GestorButanitos();
        }
        return instancia;
    }


    // --- MÉTODOS ---
    public void añadirButanito(Butanito butanito) {
        butanitos.add(butanito);
    }

    public void aniquilarButanito(Butanito butanito) {
        for (Butanito butanitoAct : butanitos) {
            if (butanitoAct == butanito) {
                butanitos.remove(butanitoAct);
                butanitoAct.setImagenButanito(null);
                return;
            }
        }
    }



    public void sumarButanitos(int nuevosButanitos) {
        contadorButanitos = contadorButanitos + nuevosButanitos;
        System.out.println(contadorButanitos);
    }

    public void restarButanitos(int costeButanitos) {
        contadorButanitos = contadorButanitos - costeButanitos;
    }

}
