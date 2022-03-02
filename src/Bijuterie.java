/**
 * Aceasta clasa reprezinta un produs tip Bijuterie.
 */
public class Bijuterie extends Produs {
    private final String material;
    private final boolean piatraPretioasa;

    /**
     * Creeaza un obiect de tip Bijuterie, avand caracteristicile primite ca parametri.
     *
     * @param id              Un int reprezentand id-ul produsului.
     * @param nume            Un String reprezentand numele produsului.
     * @param pretMinim       Un double reprezentand pretul minim al produsului.
     * @param an              Un int reprezentand nul in care a aparut produsul.
     * @param material        Un String reprezentand materialul din care este facuta bijuteria.
     * @param piatraPretioasa O valoare booleana ce sugereaza daca bijuteria are sau nu o piatra pretioasa.
     */
    public Bijuterie(int id, String nume, double pretMinim, int an, String material, boolean piatraPretioasa) {
        this.setId(id);
        this.setNume(nume);
        this.setPretMinim(pretMinim);
        this.setAn(an);
        this.piatraPretioasa = piatraPretioasa;
        this.material = material;
        this.setPretVanzare(0);
    }

    /**
     * @return Un String ce contine detaliile despre bijuterie.
     */
    public String toString() {
        String s = "Id produs: " + getId() + ", " + getNume() + ", material bijuterie: " + material;
        if (piatraPretioasa)
            s += ", cu piatra pretioasa, an fabricare: " + getAn();
        else
            s += ", fara piatra pretioasa, an fabricare: " + getAn();
        return s;
    }
}
