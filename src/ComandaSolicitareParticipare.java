/**
 * Aceasta clasa reprezinta o comanda prin care este solicitata participarea
 * unui client la o licitatie.
 */
public class ComandaSolicitareParticipare extends Comanda {
    /**
     * Solicita participarea unui client cu un anumit id
     * la o licitatie pentru un anumit produs.
     *
     * @param words Un array de String-uri ce contine atat id-ul clientului,
     *              cat si id-ul produsului.
     */
    @Override
    public void executa(String[] words) {
        int idClient = Integer.parseInt(words[1]);
        Client c = CasaDeLicitatii.getInstance().cautaClientDupaId(idClient);
        if (c == null) {
            System.err.println("Nu exista niciun client cu id-ul " + idClient + ".");
            return;
        }
        int idProdus = Integer.parseInt(words[2]);
        c.solicitaParticipare(idProdus);
    }
}
