package modelos;

import modelos.Ninis.Nini;

public class Celda {
    // --- ATRIBUTOS ---
    private Nini nini = null;
    private boolean hayPlanta = false;

    // --- MÉTODOS ---

    public void limpiar (){
        this.nini = null;
        this.hayPlanta = false;
    }

    // GETTERS Y SETTERS
    public void setNini(Nini nini) {
        this.nini = nini;
        if (nini != null) {
            this.hayPlanta = true;
        }
    }

    public boolean getHayPlanta() {
        return hayPlanta;
    }

    public Nini getNini() {
        return nini;
    }
    public void setHayPlanta(boolean hayPlanta) {}
}
