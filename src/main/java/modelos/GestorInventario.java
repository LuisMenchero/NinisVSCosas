package modelos;

import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;

public class GestorInventario {

    public static GestorInventario instancia;  ;
    private String[] inventario = new String[8];


    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }


    public int añadirNiniInventario(String nombreNini) {
        int posicion = 100;

        for (int i = 0; i < 8; i++) {
            if (inventario[i] == nombreNini) {
                return posicion;
            }
        }


        for (int i = 0; i < 8; i++) {
            if (inventario[i] == null) {
                inventario[i] = nombreNini;
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

    public void eliminarNiniInventario(String nombreNini) {
    for (int i = 0; i < 8; i++) {
        if (inventario[i] == nombreNini) {
            inventario[i] = null;
        }
    }
    }


    public int getPosicionActual(String nombreNini) {
        for (int i = 0; i < 8; i++) {
            if (nombreNini.equals(inventario[i])) {
                return i;
            }
        }
        return 100;
    }


    public String[] getInventario() {
        return inventario;
    }
}
