/**
 * Aceasta clasa reprezinta un produs tip Tablou.
 */
public class Tablou extends Produs {
    private final String numePictor;
    private final Culori culori;

    /**
     * Creeaza un obiect de tip Tablou, avand caracteristicile primite ca parametri.
     *
     * @param id         Un int reprezentand id-ul produsului.
     * @param nume       Un String reprezentand numele produsului.
     * @param pretMinim  Un double reprezentand pretul minim al produsului.
     * @param an         Un int reprezentand nul in care a aparut produsul.
     * @param numePictor Un String reprezentand numele pictorului care a pictat tabloul.
     * @param culori     Un obiect de tip Culori care reprezinta tipul de culori folosite.
     */
    public Tablou(int id, String nume, double pretMinim, int an, String numePictor, Culori culori) {
        this.setId(id);
        this.setNume(nume);
        this.setPretMinim(pretMinim);
        this.setAn(an);
        this.numePictor = numePictor;
        this.culori = culori;
        this.setPretVanzare(0);
    }

    /**
     * @return Un String ce contine detaliile despre tablou.
     */
    public String toString() {
        return "Id produs: " + getId() + ", " + getNume() + ", pictor: " + numePictor + ", culori: " + culori +
                ", an: " + getAn();
    }

}
