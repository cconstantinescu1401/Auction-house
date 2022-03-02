/**
 * Aceasta clasa reprezinta o licitatie.
 */
public class Licitatie {
    private final int id;
    private final int nrParticipanti;
    private final int idProdus;
    private final int nrPasiMaxim;
    private int nrParticipantiInscrisi = 0;

    /**
     * Creeaza o licitatie descrisa de parametri specificati.
     *
     * @param id             Un int ce reprezinta id-ul licitatiei.
     * @param nrParticipanti Un int ce reprezinta numarul de participanti
     *                       necesari pentru inceperea licitatiei.
     * @param idProdus       Un int ce reprezinta id-ul produsului pentru care
     *                       are loc licitatie.
     * @param nrPasiMaxim    Un int ce reprezinta numarul maxim de pasi din
     *                       cadrul licitatiei.
     */
    public Licitatie(int id, int nrParticipanti, int idProdus, int nrPasiMaxim) {
        this.id = id;
        this.nrParticipanti = nrParticipanti;
        this.idProdus = idProdus;
        this.nrPasiMaxim = nrPasiMaxim;
    }

    /**
     * Afla id-ul licitatiei.
     *
     * @return Un int ce reprezinta id-ul licitatiei.
     */
    public int getId() {
        return id;
    }

    /**
     * Afla id-ul produsului pentru care are loc licitatia.
     *
     * @return Un int ce reprezinta id-ul produsului pentru care are loc
     * licitatia.
     */
    public int getIdProdus() {
        return idProdus;
    }

    /**
     * Afla numarul maxim de pasi din cadrul licitatiei.
     *
     * @return Un int ce reprezinta numarul maxim de pasi din cadrul
     * licitatiei.
     */
    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }

    /**
     * Adauga 1 la numarul de participanti inscrisi la licitatie.
     */
    public void inscrieParticipant() {
        if (nrParticipanti > nrParticipantiInscrisi)
            nrParticipantiInscrisi += 1;
    }

    /**
     * Afla daca licitatia a inceput.
     *
     * @return True, daca licitatia a inceput, sau False, daca
     * licitatia nu a inceput inca.
     */
    public boolean esteInCurs() {
        return nrParticipantiInscrisi == nrParticipanti;
    }
}
