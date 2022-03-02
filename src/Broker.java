import java.util.*;

/**
 * Aceasta clasa reprezinta un broker.
 */
public class Broker extends Angajat {
    private final List<ClientAsociat> clientiAsociati;
    private final ListaProduse listaProduse;
    private double comision = 0;

    /**
     * Creeaza un obiect de tip Broker care are acces la lista de produse primita ca parametru.
     *
     * @param listaProduse Lista de produse scoase la vanzare.
     */
    public Broker(ListaProduse listaProduse) {
        this.listaProduse = listaProduse;
        this.clientiAsociati = new ArrayList<>();
    }

    /**
     * Returneaza lista de clienti asociati ai broker-ului.
     *
     * @return Un obiect de tip List ce reprezinta lista de clienti asociati.
     */
    public List<ClientAsociat> getClientiAsociati() {
        return clientiAsociati;
    }

    /**
     * Adauga suma primita ca parametru la comisionul total incasat de broker.
     *
     * @param suma Un double ce reprezinta suma care va fi adaugata la comisionul incasat.
     */
    public void adaugaComision(double suma) {
        comision += suma;
    }

    /**
     * Adauga un nou client asociat in lista de clienti asociati broker-ului.
     *
     * @param c           Un obiect de tip Client ce reprezinta clientul.
     * @param pretMaxim   Un double ce reprezinta pretul maxim stabilit de client pentru licitatie.
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei la care participa clientul.
     */
    public void adaugaClientAsociat(Client c, double pretMaxim, int idLicitatie) {
        synchronized (clientiAsociati) {
            clientiAsociati.add(new ClientAsociat(c, pretMaxim, idLicitatie));
        }
    }

    /**
     * Comunica clientilor asociati pretul maxim de la un anumit pas al licitatiei.
     *
     * @param pretOferit  Un double ce reprezinta pretul maxim oferit la pasul curent.
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei despre care este vorba.
     */
    public void comunicaPret(double pretOferit, int idLicitatie) {
        synchronized (clientiAsociati) {
            for (ClientAsociat c : clientiAsociati)
                if (c.getIdLicitatie() == idLicitatie)
                    c.actualizeazaPretLicitatie(pretOferit);
        }
    }

    /**
     * Solicita clientilor asociati ce participa la o anumita licitatie pretul oferit la pasul curent.
     *
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei despre care este vorba.
     * @return Un ArrayList ce are ca elemente perechi de valori formate din pretul oferit de client si id-ul acestuia.
     */
    public ArrayList<Pair<Double, Integer>> solicitaPreturiLicitate(int idLicitatie) {
        ArrayList<Pair<Double, Integer>> preturiLicitate = new ArrayList<>();
        synchronized (clientiAsociati) {
            for (ClientAsociat c : clientiAsociati)
                if (c.getIdLicitatie() == idLicitatie)
                    if (c.poateLicita()) {
                        double pret = c.comunicaPretLicitat();
                        int id = c.getIdClient();
                        preturiLicitate.add(new Pair<>(pret, id));
                    } else if (!c.isRetras()) {
                        System.out.println("Licitatie " + idLicitatie + ": Clientul cu " + c + " se retrage.\n");
                        c.setRetras(true);
                    }
        }
        return preturiLicitate;
    }

    /**
     * Metoda care suprascrie metoda run(), in urma careia vor fi sterse produsele vandute din lista de produse.
     */
    @Override
    public void run() {
        listaProduse.stergeProduseVandute();
    }

    /**
     * Afla comisionul total incasat de broker.
     *
     * @return Un double ce reprezinta comisionul incasat de broker.
     */
    public double getComision() {
        return comision;
    }

    /**
     * Sterge din lista de clienti asociati pe cei care au participat la licitatia cu id-ul specificat.
     *
     * @param idLicitatie Id-ul licitatiei mentionate.
     */
    public void stergeClientiAsociati(int idLicitatie) {
        synchronized (clientiAsociati) {
            clientiAsociati.removeIf(c -> c.getIdLicitatie() == idLicitatie);
        }
    }
}
