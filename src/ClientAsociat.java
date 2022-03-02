import java.util.Random;

/**
 * Aceasta clasa reprezinta un client asociat unui broker.
 */
public class ClientAsociat {
    private final Client client;
    private final double pretMaxim;
    private final int idLicitatie;
    private double pretLicitatie = 0;
    private boolean retras;

    /**
     * Creeaza un client asociat descris de valorile primite drept parametri.
     *
     * @param client      Un obiect de tip Client ce reprezinta clientul propriu-zis.
     * @param pretMaxim   Un double ce reprezinta pretul maxim ce poate fi oferit de
     *                    client in cadrul licitatiei.
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei despre care este vorba.
     */
    public ClientAsociat(Client client, double pretMaxim, int idLicitatie) {
        this.client = client;
        this.pretMaxim = pretMaxim;
        this.idLicitatie = idLicitatie;
    }

    /**
     * Afla daca clientul s-a retras din cadrul licitatiei.
     *
     * @return O valoare booleana care va avea valoarea true, daca
     * clientul s-a retras, sau false, daca clientul nu s-a retras.
     */
    public boolean isRetras() {
        return retras;
    }

    /**
     * Seteaza valoarea booleana ce indica daca clientul s-a retras
     * sau nu.
     *
     * @param retras O valoare booleana cu care va fi setat variabila
     *               ce indica daca clientul s-a retras sau nu.
     */
    public void setRetras(boolean retras) {
        this.retras = retras;
    }

    /**
     * Afla id-ul licitatiei la care participa clientul.
     *
     * @return Un int ce reprezinta id-ul licitatiei la care participa
     * clientul.
     */
    public int getIdLicitatie() {
        return idLicitatie;
    }

    /**
     * Seteaza pretul de referinta din cadrul licitatiei.
     *
     * @param pretLicitatie Un double ce reprezinta noul pret de
     *                      referinta din cadrul licitatiei.
     */
    public void actualizeazaPretLicitatie(double pretLicitatie) {
        this.pretLicitatie = pretLicitatie;
    }

    /**
     * Afla id-ul clientului.
     *
     * @return Un int reprezentand id-ul clientului.
     */
    public int getIdClient() {
        return client.getId();
    }

    /**
     * Adauga 1 la numarul de participari la licitatii ale clientului.
     */
    public void adaugaParticipare() {
        client.setNrParticipari(client.getNrParticipari() + 1);
    }

    /**
     * Comunica pretul oferit de client la pasul curent.
     *
     * @return Un int ce reprezinta pretul oferit de client la pasul curent.
     */
    public double comunicaPretLicitat() {
        Random r = new Random();
        double pret = pretLicitatie + r.nextDouble() * (pretMaxim - pretLicitatie);
        System.out.println("Licitatie " + idLicitatie + ": Clientul cu " + client + " a oferit " + pret + ".\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pret;
    }

    /**
     * Afla daca clientul poate licita in continuare sau nu.
     *
     * @return True, daca clientul poate licita in continuare, sau False,
     * daca acesta nu mai poate licita in continuare.
     */
    public boolean poateLicita() {
        return pretMaxim > pretLicitatie;
    }

    /**
     * Returneaza un string ce contine informatiile despre client.
     *
     * @return Un String ce contine informatiile despre client.
     */
    public String toString() {
        return client.toString();
    }
}
