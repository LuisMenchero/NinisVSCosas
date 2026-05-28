package Logros;

import modelos.GestorPuntos;

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
    public void completarLogro(){
        this.completado = true;
    }

    public void darPuntos(){
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
