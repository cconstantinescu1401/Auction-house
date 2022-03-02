/**
 * Aceasta clasa reprezinta un produs tip Mobila.
 */
public class Mobila extends Produs {
    private final String tip;
    private final String material;

    /**
     * Creeaza un obiect de tip Mobila, avand caracteristicile primite ca parametri.
     *
     * @param id        Un int reprezentand id-ul produsului.
     * @param nume      Un String reprezentand numele produsului.
     * @param pretMinim Un double reprezentand pretul minim al produsului.
     * @param an        Un int reprezentand nul in care a aparut produsul.
     * @param tip       Un String reprezentand tipul mobilei.
     * @param material  Un String reprezentand materialul din care este facuta mobila.
     */
    public Mobila(int id, String nume, double pretMinim, int an, String tip, String material) {
        this.setId(id);
        this.setNume(nume);
        this.setPretMinim(pretMinim);
        this.setAn(an);
        this.tip = tip;
        this.material = material;
        this.setPretVanzare(0);
    }

    /**
     * @return Un String ce contine detaliile despre mobila.
     */
    public String toString() {
        return "Id produs: " + getId() + ", " + getNume() + ", tip mobila: " + tip + ", material: " + material +
                ", an fabricare: " + getAn();
    }

}

