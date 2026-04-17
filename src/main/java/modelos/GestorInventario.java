package modelos;

import modelos.Ninis.Nini;

public class GestorInventario {

    public static GestorInventario instancia;  ;
    private Nini[] inventario = new Nini[8];


    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }


    public void añadirNiniInventario(Nini nini) {
        for (int i = 0; i < 8; i++) {
            if (inventario[i] == null) {
                inventario[i] = nini;
            }
        }
    }

    public void eliminarNiniInventario(Nini nini) {
    for (int i = 0; i < 8; i++) {
        if (inventario[i] == nini) {
            inventario[i] = null;
        }
    }
    }


}
