/**
 * Aceasta clasa reprezinta o comanda prin care vor fi afisate produsele scoase
 * la vanzare.
 */
public class ComandaAfisareProduse extends Comanda {
    /**
     * Afiseaza produsele din lista de produse scoase la vanzare, cu ajutorul
     * unui client ales aleator.
     *
     * @param words Un array de String-uri necesar pentru executarea comenzii.
     */
    @Override
    public void executa(String[] words) {
        Client client = CasaDeLicitatii.getInstance().cautaClientAleator();
        Thread t = new Thread(client);
        t.start();
    }
}
