/**
 * Aceasta clasa reprezinta o comanda.
 */
public abstract class Comanda {
    /**
     * Metoda abstracta care trebuie sa execute comanda.
     *
     * @param words Un array de String-uri necesar pentru executarea comenzii.
     */
    public abstract void executa(String[] words);
}
