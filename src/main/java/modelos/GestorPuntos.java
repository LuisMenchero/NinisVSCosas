package modelos;

public class GestorPuntos {
    // ATRIBUTOS
    private int contadorPuntosTotales;
    public static GestorPuntos instancia;

    // CONSTRUCTOR
    /**
     *Constructor del gestor de butanitos (inicia arraylist)
     */
    private GestorPuntos() {
        this.contadorPuntosTotales = 0;
    }

    /**
     * Da la instancia del Singletone de modelos.GestorPuntos si existe y si no, la crea
     * @return instancia
     */
    public static GestorPuntos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPuntos();
        }
        return instancia;
    }

    // METODOS
    /**
     * Añade puntos al contador total de puntos
     * @param puntos la cantidad de puntos a añadir
     */
    public void añadirPuntos(int puntos) {
        contadorPuntosTotales = contadorPuntosTotales + puntos;
    }

    /**
     * Elimina puntos al contador total de puntos
     * @param puntos la cantidad de puntos a eliminar
     */
    public void eliminarPuntos(int puntos) {
        contadorPuntosTotales = contadorPuntosTotales - puntos;
    }

    // GETTERS Y SETTERS

    public int getContadorPuntosTotales() {
        return contadorPuntosTotales;
    }
}
