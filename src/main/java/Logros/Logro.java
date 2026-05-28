package Logros;

import modelos.GestorPuntos;

/**
 * Representa un logro que el jugador puede conseguir
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Logro {
    // ATRIBUTOS
    private int idLogro;
    private TipoDificultad tipoDificultad;
    private boolean completado;
    private String titulo;
    private int minuto;
    private TipoMedalla tipoMedalla;
    private int puntuacionLogro;

    // CONSTRUCTOR

    /**
     * Constructor de Logro
     *
     * @param idLogro         representa el número que identifica al logro
     * @param tipoDificultad  representa como de dificil es conseguir dicho logro
     * @param titulo          representa el nombre del logro
     * @param tipoMedalla     representa la medalla que obtienes al conseguirlo
     * @param puntuacionLogro representa los puntos que se suman a tu intento una vez completada
     */
    public Logro(int idLogro, TipoDificultad tipoDificultad, String titulo, TipoMedalla tipoMedalla, int puntuacionLogro) {
        this.idLogro = idLogro;
        this.tipoDificultad = tipoDificultad;
        this.completado = false;
        this.titulo = titulo;
        this.minuto = 0;
        this.tipoMedalla = tipoMedalla;
        this.puntuacionLogro = puntuacionLogro;
    }


    // METODOS

    /**
     * Método que activa el logro cuando se cumple la condición
     */
    public void completarLogro() {
        this.completado = true;
        darPuntos();
    }

    /**
     * Método que suma puntos al jugador
     */
    private void darPuntos() {
        GestorPuntos gepun = GestorPuntos.getInstancia();
        gepun.añadirPuntos(puntuacionLogro);
    }

    // GETTERS Y SETTERS
    public int getIdLogro() {
        return idLogro;
    }

    public TipoDificultad getTipoDificultad() {
        return tipoDificultad;
    }

    public boolean estaCompletado() {
        return completado;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getMinuto() {
        return minuto;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }

    public int getPuntuacionLogro() {
        return puntuacionLogro;
    }
}
