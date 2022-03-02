/**
 * Aceasta clasa reprezinta o comanda prin care vor fi sterse produsele
 * vandute din lista de produse scoase la vanzare.
 */
public class ComandaStergereProduseVandute extends Comanda {
    /**
     * Sterge produsele vandute cu ajutorul unui broker ales aleator.
     *
     * @param words Un array de String-uri necesar pentru executarea comenzii.
     */
    @Override
    public void executa(String[] words) {
        Broker broker = CasaDeLicitatii.getInstance().cautaBrokerAleator();
        Thread t = new Thread(broker);
        t.start();
    }
}
