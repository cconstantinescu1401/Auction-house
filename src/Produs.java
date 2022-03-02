/**
 * Aceasta clasa abstracta reprezinta un produs.
 */
public abstract class Produs {
    private int id;
    private String nume;
    private double pretVanzare;
    private double pretMinim;
    private int an;

    /**
     * Seteaza id-ul produsului.
     *
     * @param id Un int ce reprezinta id-ul produsului.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Seteaza numele produsului.
     *
     * @param nume Un String ce reprezinta numele produsului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Seteaza pretul de vanzare al produsului.
     *
     * @param pretVanzare Un double ce reprezinta pretul de vanzare al produsului.
     */
    public void setPretVanzare(double pretVanzare) {
        this.pretVanzare = pretVanzare;
    }

    /**
     * Seteaza pretul minim al produsului.
     *
     * @param pretMinim Un double ce reprezinta pretul minim al produsului.
     */
    public void setPretMinim(double pretMinim) {
        this.pretMinim = pretMinim;
    }

    /**
     * Seteaza anul in care a aparut produsul.
     *
     * @param an Un int ce reprezinta anul in care a aparut produsul.
     */
    public void setAn(int an) {
        this.an = an;
    }

    /**
     * Afla id-ul produsului.
     *
     * @return Un int ce reprezinta id-ul produsului.
     */
    public int getId() {
        return id;
    }

    /**
     * Afla numele produsului.
     *
     * @return Un String ce reprezinta numele produsului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Afla pretul de vanzare al produsului.
     *
     * @return Un double ce reprezinta pretul de vanzare al produsului.
     */
    public double getPretVanzare() {
        return pretVanzare;
    }

    /**
     * Afla pretul minim al produsului.
     *
     * @return Un double ce reprezinta pretul minim al produsului.
     */
    public double getPretMinim() {
        return pretMinim;
    }

    /**
     * Afla anul in care a aparut produsul.
     *
     * @return Un int ce reprezinta anul in care a aparut produsul.
     */
    public int getAn() {
        return an;
    }

    /**
     * Metoda abstracta ce ar trebui sa returneze un String ce contine
     * informatiile despre un produs.
     *
     * @return Un String ce contine informatiile despre un produs.
     */
    public abstract String toString();
}
