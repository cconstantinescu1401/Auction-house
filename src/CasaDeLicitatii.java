import java.util.*;

/**
 * Aceasta clasa reprezinta o casa de licitatii.
 */
public class CasaDeLicitatii {
    private final List<Licitatie> licitatiiActive;
    private final List<Client> clienti;
    private final ListaProduse produse;
    private final List<Broker> brokeri;
    private final List<Administrator> administratori;

    private static CasaDeLicitatii instance;

    private CasaDeLicitatii() {
        licitatiiActive = new ArrayList<>();
        produse = new ListaProduse();
        clienti = new ArrayList<>();
        brokeri = new ArrayList<>();
        administratori = new ArrayList<>();
    }

    /**
     * Returneaza instanta casei de licitatii, fiind implementat design pattern-ul Singleton.
     *
     * @return Instanta unicului obiect de tip CasaDeLicitatii.
     */
    public static CasaDeLicitatii getInstance() {
        if (instance == null) {
            instance = new CasaDeLicitatii();
        }
        return instance;
    }

    /**
     * Returneaza un administrator aleator din lista de administratori.
     *
     * @return Un obiect de tip Administrator ce reprezinta un administrator aleator.
     */
    public Administrator cautaAdministratorAleator() {
        if (administratori.size() == 0)
            return null;
        if (administratori.size() == 1)
            return administratori.get(0);
        return administratori.get(new Random().nextInt(administratori.size() - 1));
    }

    /**
     * Returneaza un broker aleator din lista de brokeri.
     *
     * @return Un obiect de tip Broker ce reprezinta un broker aleator.
     */
    public Broker cautaBrokerAleator() {
        if (brokeri.size() == 0)
            return null;
        if (brokeri.size() == 1)
            return brokeri.get(0);
        return brokeri.get(new Random().nextInt(brokeri.size() - 1));
    }

    /**
     * Returneaza un client aleator din lista de clienti.
     *
     * @return Un obiect de tip Client ce reprezinta un client aleator.
     */
    public Client cautaClientAleator() {
        if (clienti.size() == 0)
            return null;
        if (clienti.size() == 1)
            return clienti.get(0);
        return clienti.get(new Random().nextInt(clienti.size() - 1));
    }

    /**
     * Adauga clientul care corespunde arrayului de String-uri primit ca paramteru in lista de clienti.
     *
     * @param words arrayul de String-uri ce contine informatiile despre client.
     * @throws DuplicateClientException daca in lista de clienti exista deja un client cu id-ul precizat.
     */
    public void adaugaClient(String[] words) throws DuplicateClientException {
        int id = Integer.parseInt(words[1]);
        if (cautaClientDupaId(id) != null)
            throw new DuplicateClientException("Exista deja un client cu id-ul " + id + ".");
        String nume = words[2];
        String adresa = words[3];
        String tip = words[4];
        switch (tip) {
            case "persoana fizica":
                PersoanaFizica pf = (PersoanaFizica) new ClientBuilder(new PersoanaFizica())
                        .withId(id)
                        .withNume(nume)
                        .withAdresa(adresa)
                        .withListaProduse(produse)
                        .withNrLicitatiiCastigate(0)
                        .withNrParticipari(0)
                        .build();
                pf.setDataNastere(words[5]);
                clienti.add(pf);
                break;
            case "persoana juridica":
                PersoanaJuridica pj = (PersoanaJuridica) new ClientBuilder(new PersoanaJuridica())
                        .withId(id)
                        .withNume(nume)
                        .withAdresa(adresa)
                        .withListaProduse(produse)
                        .withNrLicitatiiCastigate(0)
                        .withNrParticipari(0)
                        .build();
                pj.setCapitalSocial(Double.parseDouble(words[6]));
                pj.setCompanie(words[5]);
                clienti.add(pj);
                break;
            default:
        }
    }

    /**
     * Cauta in lista de clienti clientul cu id-ul specificat.
     *
     * @param id Un int ce reprezinta id-ul clientului cautat.
     * @return Un obiect de tip Client care are id-ul specificat, sau null, daca
     * niciun client nu are id-ul specificat.
     */
    public Client cautaClientDupaId(int id) {
        return clienti.stream()
                .filter(client -> client.getId() == id)
                .findAny()
                .orElse(null);
    }

    /**
     * Cauta in lista de produse produsul cu id-ul specificat.
     *
     * @param id Un int ce reprezinta id-ul produsului cautat.
     * @return Un obiect de tip Produs care are id-ul specificat, sau null, daca
     * niciun produs nu are id-ul specificat.
     */
    public Produs cautaProdusDupaId(int id) {
        return produse.gasesteDupaId(id);
    }

    /**
     * Adauga angajatul care corespunde arrayului de String-uri primit ca paramteru in lista
     * corespunzatoare(administratori/brokeri).
     *
     * @param words arrayul de String-uri ce contine informatiile despre angajat.
     */
    public void adaugaAngajat(String[] words) {
        String tip = words[1];
        if (tip.equals("administrator")) {
            administratori.add(new Administrator(produse));
        } else if (tip.equals("broker"))
            brokeri.add(new Broker(produse));
    }

    /**
     * Adauga o licitatie cu caracteristicile primite drept parametri in lista de
     * licitatii active.
     *
     * @param nrParticipanti Un int care reprezinta numarul de participanti necesari
     *                       pentru a incepe licitatia.
     * @param idProdus       Un int ce reprezinta id-ul produsului pentru care are loc licitatia.
     * @param nrPasiMaxim    Un int ce reprezinta numarul de pasi maxim dupa care se incheie
     *                       licitatia.
     * @return Un obiect de tip Licitatie ce reprezinta licitatia care a fost adaugata.
     */
    public Licitatie adaugaLicitatie(int nrParticipanti, int idProdus, int nrPasiMaxim) {
        int idLicitatie = licitatiiActive.size() + 1;
        Licitatie l = new Licitatie(idLicitatie, nrParticipanti, idProdus, nrPasiMaxim);
        licitatiiActive.add(l);
        return l;
    }

    /**
     * Asociaza clientului specificat un broker(ales in mod aleator), marcand si
     * faptul ca acel client s-a inscris in licitatia pentru produsul cu id-ul specificat.
     *
     * @param c         Un obiect de tip Client ce reprezinta clientul caruia casa de licitatii
     *                  ii va asocia un broker.
     * @param idProdus  Un int ce reprezinta id-ul produsului pentru care clientul doreste
     *                  sa liciteze.
     * @param pretMaxim Un double ce reprezinta pretul maxim care ar putea fi oferit de client.
     */
    public void asociazaBroker(Client c, int idProdus, double pretMaxim) {
        if (produse.gasesteDupaId(idProdus).getPretMinim() > pretMaxim)
            return;
        Licitatie l = licitatiiActive.stream()
                .filter(licitatie -> licitatie.getIdProdus() == idProdus)
                .findAny()
                .orElse(null);
        if (l != null && (l.esteInCurs() || cautaBrokerAsociat(c, l.getId()) != null))
            return;
        Random r = new Random();
        if (l == null) {
            l = adaugaLicitatie(2 + r.nextInt(5), idProdus, 1 + r.nextInt(10));
        }
        Broker broker = brokeri.get(r.nextInt(brokeri.size()));
        broker.adaugaClientAsociat(c, pretMaxim, l.getId());
        l.inscrieParticipant();
        System.out.println("Clientul cu " + c + " s-a inscris in licitatia pentru produsul cu id-ul " + idProdus + ".\n");
        if (l.esteInCurs()) {
            for (Broker b : brokeri)
                for (ClientAsociat ca : b.getClientiAsociati())
                    if (ca.getIdLicitatie() == l.getId())
                        ca.adaugaParticipare();
            ThreadLicitatie tl = new ThreadLicitatie(l);
            tl.start();
        }
    }

    /**
     * Informeaza brokerii asupra pretului maxim oferit la un anumit pas, primit
     * ca parametru, in cadrul licitatiei cu id-ul specificat.
     *
     * @param pretOferit  Un double ce reprezinta pretul maxim oferit la un anumit pas.
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei despre care este vorba.
     */
    public void anuntaBrokeri(double pretOferit, int idLicitatie) {
        for (Broker b : brokeri)
            b.comunicaPret(pretOferit, idLicitatie);
    }

    /**
     * Afla pretul maxim licitat la un anumit pas de participantii la licitatia cu id-ul
     * primit ca parametru, returnand o pereche de valori ce contine atat pretul maxim
     * licitat la acel pas, cat si id-ul clientului care a oferit acel pret.
     *
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei despre care este vorba.
     * @return O pereche de valori ce contine atat pretul maxim licitat la acel pas, cat
     * si id-ul clientului care a oferit acel pret.
     */
    public synchronized Pair<Double, Integer> aflaPretMaximLicitat(int idLicitatie) {
        ArrayList<Pair<Double, Integer>> preturiLicitate = new ArrayList<>();
        double pretMaxim = 0;
        int idClient = 0;
        for (Broker b : brokeri)
            preturiLicitate.addAll(b.solicitaPreturiLicitate(idLicitatie));
        if (preturiLicitate.size() == 1)
            return new Pair<>(preturiLicitate.get(0).arg1 * (-1), preturiLicitate.get(0).arg2);
        for (Pair<Double, Integer> p : preturiLicitate) {
            if (p.arg1 > pretMaxim) {
                pretMaxim = p.arg1;
                idClient = p.arg2;
            } else if (p.arg1 == pretMaxim) {
                Client c1 = cautaClientDupaId(p.arg2);
                Client c2 = cautaClientDupaId(idClient);
                if (c1.getNrLicitatiiCastigate() > c2.getNrLicitatiiCastigate())
                    idClient = p.arg2;
            }
        }
        return new Pair<>(pretMaxim, idClient);
    }

    /**
     * Cauta in lista de brokeri brokerul asociat clientului specificat,
     * in cadrul licitatiei cu id-ul specificat.
     *
     * @param c           Un obiect de tip Client ce reprezinta clientul.
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei.
     * @return Un obiect de tip Broker ce reprezinta brokerul asociat
     * clientului in cadrul acelei licitatii, sau null, daca nu a fost
     * gasit niciun astfel de broker.
     */
    public Broker cautaBrokerAsociat(Client c, int idLicitatie) {
        for (Broker b : brokeri)
            for (ClientAsociat ca : b.getClientiAsociati())
                if (ca.getIdClient() == c.getId() && ca.getIdLicitatie() == idLicitatie)
                    return b;
        return null;

    }

    /**
     * Incheie comunicarea dintre brokeri si clientii asociati in cadrul licitatiei
     * cu id-ul specificat, stergand din lista de clienti asociati ai fiecarui broker
     * pe aceia care au participat la licitatia respectiva.
     *
     * @param idLicitatie Un int ce reprezinta id-ul licitatiei respective.
     */
    public void incheieComunicarea(int idLicitatie) {
        for (Broker b : brokeri)
            b.stergeClientiAsociati(idLicitatie);
    }

    /**
     * Afiseaza comisioanele incasate de fiecare broker in parte.
     */
    public void afiseazaComisioane() {
        System.out.println("Comisioane brokeri:");
        for (int i = 1; i <= brokeri.size(); i++)
            System.out.println("Broker " + i + ": " + brokeri.get(i - 1).getComision() + ".");
        System.out.println();
    }

}
