/**
 * Aceasta clasa reprezinta o comanda prin care va fi adaugat un client.
 */
public class ComandaAdaugareClient extends Comanda {
    /**
     * Adauga un client descris de array-ul de String-uri primit ca parametru.
     *
     * @param words Un array de String-uri necesar pentru adaugarea clientului.
     */
    @Override
    public void executa(String[] words) {
        try {
            CasaDeLicitatii.getInstance().adaugaClient(words);
        } catch (DuplicateClientException e) {
            e.printStackTrace();
        }
    }
}
