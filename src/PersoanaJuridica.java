/**
 * Aceasta clasa reprezinta un client de tip persoana juridica.
 */
public class PersoanaJuridica extends Client {
    private Companie companie;
    private double capitalSocial;

    /**
     * Creeaza o persoana juridica.
     */
    public PersoanaJuridica() {
    }

    /**
     * Seteaza tipul companiei.
     *
     * @param companie Un String ce contine tipul companiei.
     */
    public void setCompanie(String companie) {
        this.companie = convertStringToCompanie(companie);
    }

    /**
     * Seteaza capitalul social al persoanei juridice.
     *
     * @param capitalSocial Un double ce reprezinta capitalul social.
     */
    public void setCapitalSocial(double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    /**
     * Converteste String-ul primit ca parametru intr-un
     * obiect de tip Companie ce urmeaza a fi returnat.
     *
     * @param s Un String ce contine tipul companiei.
     * @return Un obiect de tip Companie corespunzator String-ului
     * primit ca parametru.
     */
    public Companie convertStringToCompanie(String s) {
        if (s.equals("SRL"))
            return Companie.SRL;
        if (s.equals("SA"))
            return Companie.SA;
        return null;
    }

    /**
     * Converteste obiectul de tip Companie primit ca parametru intr-un
     * String ce urmeaza a fi returnat.
     *
     * @param companie Un obiect de tip Companie.
     * @return Un String corespunzator obiectului primit ca parametru.
     * primit ca parametru.
     */
    public String convertCompanieToString(Companie companie) {
        if (companie == Companie.SA)
            return "SA";
        if (companie == Companie.SRL)
            return "SRL";
        return null;
    }

    /**
     * Returneaza un String ce contine informatiile despre persoana juridica.
     *
     * @return Un String ce contine informatiile despre persoana juridica.
     */
    public String toString() {
        return "id " + this.getId() + ", " + this.getNume() + " " + convertCompanieToString(companie) +
                ", capital social: " + capitalSocial;
    }
}
