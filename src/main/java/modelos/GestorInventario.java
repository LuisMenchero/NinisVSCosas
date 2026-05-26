package modelos;
import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;
import modelos.Ninis.TipoNini;

/**
 * Gestor del inventario en el que estan las plantas elegidas
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class GestorInventario {

    public static GestorInventario instancia;

    private TipoNini[] inventario = new TipoNini[8];

    /**
     * Da la instancia del Singletone de GestorInventaio si existe y si no, la crea
     * @return instancia
     */
    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }

    /**
     * Añade un nini al inventario
     * @param tipoNini el nini a añadir
     * @return posicion en el array del inventrio
     */
    public int añadirNiniInventario(TipoNini tipoNini) {
        int posicion = 100; //100 = inexistente

        for (int i = 0; i < 8; i++) {
            if (inventario[i] == tipoNini) {
                return posicion;
            }
        }


        for (int i = 0; i < 8; i++) {
            if (inventario[i] == null) {
                inventario[i] = tipoNini;
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

    /**
     * Elimina del inventario un nini
     * @param tipoNini nini a eliminar
     */
    public void eliminarNiniInventario(TipoNini tipoNini) {
        for (int i = 0; i < 8; i++) {
            if (inventario[i] == tipoNini) {
                inventario[i] = null;
            }
        }
    }

    /**
     * Getter de la posición en el array de un nini
     * @param nombreNini el nombre del nini que requiere su posición
     * @return posición del nini (100 si no está o da error)
     */
    public int getPosicionActual(TipoNini nombreNini) {
        for (int i = 0; i < 8; i++) {
            if (nombreNini.equals(inventario[i])) {
                return i;
            }
        }
        return 100; //100 = inexistente
    }

    /**
     * Getter del inventario
     * @return inventario
     */
    public TipoNini[] getInventario() {
        return inventario;
    }
}
