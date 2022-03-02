/**
 * Aceasta clasa reprezinta o comanda prin care vor fi afisate comisioanele brokerilor.
 */
public class ComandaAfisareComisioane extends Comanda {
    /**
     * Afiseaza comisioanele incasate de brokeri.
     *
     * @param words Un array de String-uri necesar pentru executarea comenzii.
     */
    @Override
    public void executa(String[] words) {
        Thread t = new Thread(() -> CasaDeLicitatii.getInstance().afiseazaComisioane());
        t.start();
    }
}
