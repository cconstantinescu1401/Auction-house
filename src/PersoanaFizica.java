/**
 * Aceasta clasa reprezinta un client de tip persoana fizica.
 */
public class PersoanaFizica extends Client {
    private String dataNastere;

    /**
     * Creeaza o persoana fizica.
     */
    public PersoanaFizica() {
    }

    /**
     * Seteaza data de nastere a persoanei fizice.
     *
     * @param dataNastere Un String ce reprezinta data de nastere.
     */
    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    /**
     * Returneaza un String ce contine informatiile despre persoana fizica.
     *
     * @return Un String ce contine informatiile despre persoana fizica.
     */
    public String toString() {
        return "id " + this.getId() + ", " + this.getNume() + ", data nastere: " + dataNastere;
    }
}
