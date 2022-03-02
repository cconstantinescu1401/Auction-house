/**
 * Aceasta clasa reprezinta o exceptie care apare atunci cand se incearca
 * crearea unui produs cu un id ce apartine deja altui produs.
 */
public class DuplicateProductException extends Exception {
    /**
     * Creeaza exceptia de tip DuplicateProductException.
     *
     * @param message Un String ce reprezinta mesajul exceptiei.
     */
    public DuplicateProductException(String message) {
        super(message);
    }
}
