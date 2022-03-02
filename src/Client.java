import java.util.Random;

/**
 * Aceasta clasa reprezinta un client.
 */
public class Client implements Runnable {
    private int id;
    private String nume;
    private String adresa;
    private int nrParticipari;
    private int nrLicitatiiCastigate;
    private ListaProduse listaProduse;

    /**
     * Creeaza un client.
     */
    public Client() {
    }

    /**
     * Afla id-ul clientului.
     *
     * @return Un int ce reprezinta id-ul clientului.
     */
    public int getId() {
        return id;
    }

    /**
     * Seteaza id-ul clientului.
     *
     * @param id Un int ce reprezinta valoarea cu care va fi setat id-ul.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Seteaza numele clientului.
     *
     * @param nume Un String ce reprezinta noul nume clientului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Afla numele clientului.
     *
     * @return Un String ce reprezinta numele clientului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Afla adresa clientului.
     *
     * @return Un String ce reprezinta adresa clientului.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Seteaza adresa clientului.
     *
     * @param adresa Un String ce reprezinta noua adresa a clientului.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Afla numarul de participari la licitatii ale clientului.
     *
     * @return Un int ce reprezinta numarul de participari la licitatii ale clientului.
     */
    public int getNrParticipari() {
        return nrParticipari;
    }

    /**
     * Seteaza numarul de participari la licitatii ale clientului.
     *
     * @param nrParticipari Un int ce reprezinta numarul de participari la licitatii ale clientului.
     */
    public void setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
    }

    /**
     * Afla numarul de licitatii castigate de client.
     *
     * @return Un int ce reprezinta numarul de licitatii castigate de client.
     */
    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }

    /**
     * Seteaza numarul de licitatii castigate de client.
     *
     * @param nrLicitatiiCastigate Un int ce reprezinta numarul de licitatii castigate de client.
     */
    public void setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }

    /**
     * Seteaza lista de produse scoase la vanzare.
     *
     * @param listaProduse Un obiect de tip ListaProduse ce reprezinta lista de produse
     *                     scoase la vanzare.
     */
    public void setListaProduse(ListaProduse listaProduse) {
        this.listaProduse = listaProduse;
    }

    /**
     * Adauga o noua licitatie castigata(1) la numarul de licitatii castigate.
     */
    public void adaugaLicitatieCastigata() {
        nrLicitatiiCastigate += 1;
    }

    /**
     * Solicita participarea clientului la licitatia pentru produsul
     * cu id-ul specificat.
     *
     * @param idProdus Un int ce reprezinta id-ul produsului la licitatia caruia
     *                 clientul doreste sa participe.
     */
    public void solicitaParticipare(int idProdus) {
        CasaDeLicitatii casa = CasaDeLicitatii.getInstance();
        Produs p = listaProduse.gasesteDupaId(idProdus);
        if (p == null) {
            System.err.println("Nu exista niciun produs cu id-ul " + idProdus + ".");
            return;
        }
        double pretMaxim = (new Random().nextDouble()) * (p.getPretMinim()) * 5;
        casa.asociazaBroker(this, idProdus, pretMaxim);
    }

    /**
     * Calculeaza comisionul datorat brokerului asociat, in functie de
     * valoarea tranzactionata de client.
     *
     * @param valTranz Un double ce reprezinta valoarea tranzactionata de client.
     * @return Un double ce reprezinta comisionul datorat broker-ului asociat.
     */
    public double calculeazaComision(double valTranz) {
        if (this instanceof PersoanaFizica) {
            if (this.nrParticipari < 5)
                return 0.20 * valTranz;
            else
                return 0.15 * valTranz;
        }
        if (this instanceof PersoanaJuridica) {
            if (this.nrParticipari < 25)
                return 0.25 * valTranz;
            else
                return 0.10 * valTranz;
        }
        return 0;
    }

    /**
     * Metoda care suprascrie metoda run(), in urma careia vor fi afisate produsele
     * scoase la vanzare.
     */
    @Override
    public void run() {
        listaProduse.afiseazaProduse();
    }

}
