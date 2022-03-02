/**
 * Aceasta clasa reprezinta un obiect folosit pentru implementarea design
 * pattern-ului Builder asupra Client.
 */
public class ClientBuilder {
    private final Client client;

    /**
     * Creeaza un obiect de tip ClientBuilder, ce va ajuta
     * in construirea clientului specificat.
     *
     * @param c Un obiect de tip Client ce urmeaza a fi folosit.
     */
    public ClientBuilder(Client c) {
        client = c;
    }

    /**
     * Seteaza id-ul clientului.
     *
     * @param id Un int ce reprezinta noua valoare a id-ului clientului.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withId(int id) {
        client.setId(id);
        return this;
    }

    /**
     * Seteaza numele clientului.
     *
     * @param nume Un String ce reprezinta noul nume al clientului.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withNume(String nume) {
        client.setNume(nume);
        return this;
    }

    /**
     * Seteaza adresa clientului.
     *
     * @param adresa Un String ce reprezinta noua adresa a clientului.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withAdresa(String adresa) {
        client.setAdresa(adresa);
        return this;
    }

    /**
     * Seteaza numarul de participari la licitatii ale clientului.
     *
     * @param nrParticipari Un int ce reprezinta valoarea cu care va fi setat
     *                      numarul de participari la licitatii ale clientului.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withNrParticipari(int nrParticipari) {
        client.setNrParticipari(nrParticipari);
        return this;
    }

    /**
     * Seteaza numarul de licitatii castigate ale clientului.
     *
     * @param nrLicitatiiCastigate Un int ce reprezinta valoarea cu care va fi setat
     *                             numarul de licitatii castigate ale clientului.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        client.setNrLicitatiiCastigate(nrLicitatiiCastigate);
        return this;
    }

    /**
     * Seteaza lista de produse scoase la vanzare vizibila pentru client.
     *
     * @param listaProduse Un obiect de tip ListaProduse ce reprezinta lista
     *                     de produse scoase la vanzare.
     * @return Obiectul ClientBuilder dupa modificarea facuta.
     */
    public ClientBuilder withListaProduse(ListaProduse listaProduse) {
        client.setListaProduse(listaProduse);
        return this;
    }

    /**
     * Construieste clientul corespunzator.
     *
     * @return Un obiect de tip Client construit in urma instructiunilor.
     */
    public Client build() {
        return client;
    }
}
