package modelos;
import modelos.Ninis.Nini;

/**
 * Representa una celda
 * @author Diego
 * @author Luis
 * @version 1.0
 */
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

    /**
     * Setter de nini en la celda
     * @param nini nini a settear
     */
    public void setNini(Nini nini) {
        this.nini = nini;
        if (nini != null) {
            this.hayPlanta = true;
        }
    }

    /**
     * Getter de hayPlanta
     * @return boolean hayPlanta
     */
    public boolean getHayPlanta() {
        return hayPlanta;
    }

    /**
     * Getter de nini
     * @return nini
     */
    public Nini getNini() {
        return nini;
    }
}
