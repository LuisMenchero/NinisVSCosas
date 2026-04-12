package modelos;

public class Celda {
    // --- ATRIBUTOS ---
    private Nini nini = null;
    private boolean hayPlanta = false;

    // --- MÉTODOS ---


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

}
