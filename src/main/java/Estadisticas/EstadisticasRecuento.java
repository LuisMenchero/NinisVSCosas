package Estadisticas;

/**
 * Sirve para gestionar contadores para las estadisticas finales
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class EstadisticasRecuento {
    private static int cosasMatadas = 0;
    private static int ninisMuertos = 0;
    private static int ninisEliminados = 0;
    private static int butanitosTotales = 100;


    // METODOS
    /**
     * Suma 1 a la cantidad de cosas matadas
     *
     */
    public static void sumarCosasMatadas() {
        cosasMatadas++;
    }

    /**
     * Suma 1 a la cantidad de ninis muertos
     *
     */
    public static void sumarNinisMuertos() {
        ninisMuertos++;
    }

    /**
     * Suma 1 a la cantidad de ninis eliminados
     *
     */
    public static void sumarNinisEliminados() {
        ninisEliminados++;
    }

    /**
     * Suma 1 a la cantidad de butanitos totales
     *
     */
    public static void sumarButanitosTotales() {
        butanitosTotales = butanitosTotales + 50;
    }



    // GETTERS Y SETTERS
    public static int getCosasMatadas() {
        return cosasMatadas;
    }

    public static int getNinisMuertos() {
        return ninisMuertos;
    }

    public static int getNinisEliminados() {
        return ninisEliminados;
    }

    public static int getButanitosTotales() {
        return butanitosTotales;
    }
}
