/**
 * Aceasta clasa reprezinta thread-ul corespunzator unei licitatii.
 */
public class ThreadLicitatie extends Thread {
    private final Licitatie licitatie;

    /**
     * Creeaza un thread corespunzator licitatiei primite ca parametru.
     *
     * @param licitatie Un obiect de tip Licitatie ce reprezinta licitatia respectiva.
     */
    public ThreadLicitatie(Licitatie licitatie) {
        this.licitatie = licitatie;
    }

    /**
     * Executa procesul corespunzator desfasurarii licitatiei, respectand mecanismul de licitare.
     */
    @Override
    public void run() {
        System.out.println("A inceput licitatia pentru produsul cu id-ul " + licitatie.getIdProdus() + ".\n");
        CasaDeLicitatii casa = CasaDeLicitatii.getInstance();
        double pretMaxim = 0;
        int idClient = 0;

        for (int i = 1; i <= licitatie.getNrPasiMaxim(); i++) {
            Pair<Double, Integer> pair = casa.aflaPretMaximLicitat(licitatie.getId());
            pretMaxim = pair.arg1;
            idClient = pair.arg2;

            if (pretMaxim < 0) {
                pretMaxim = pretMaxim * (-1);
                if (pretMaxim > casa.cautaProdusDupaId(licitatie.getIdProdus()).getPretMinim())
                    break;
            }
            System.out.println("Licitatie " + licitatie.getId() + ": pretul maxim oferit la pasul " + i +
                    " este de " + pretMaxim + ".\n");
            casa.anuntaBrokeri(pretMaxim, licitatie.getId());
        }

        Produs produsLicitatie = casa.cautaProdusDupaId(licitatie.getIdProdus());
        if (pretMaxim > produsLicitatie.getPretMinim()) {
            Client castigator = casa.cautaClientDupaId(idClient);
            System.out.println("Licitatia cu id-ul " + licitatie.getId() + " s-a incheiat. " +
                    "Astfel, produsul " + produsLicitatie + " a fost vandut clientului " +
                    castigator + " pentru pretul de " + pretMaxim + ".\n");

            castigator.adaugaLicitatieCastigata();
            double comision = castigator.calculeazaComision(pretMaxim);
            casa.cautaBrokerAsociat(castigator, licitatie.getId()).adaugaComision(comision);
            produsLicitatie.setPretVanzare(pretMaxim);

        } else {
            System.out.println("Licitatia cu id-ul " + licitatie.getId() + " s-a incheiat. " +
                    "Produsul " + produsLicitatie + "nu a fost vandut, intrucat pretul minim de " +
                    produsLicitatie.getPretMinim() + " nu a fost atins.");
        }
        casa.incheieComunicarea(licitatie.getId());
    }
}
