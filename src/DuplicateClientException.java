/**
 * Aceasta clasa reprezinta o exceptie care apare atunci cand se incearca
 * crearea unui client cu un id ce apartine deja altui client.
 */
public class DuplicateClientException extends Exception {
    /**
     * Creeaza exceptia de tip DuplicateClientException.
     *
     * @param message Un String ce reprezinta mesajul exceptiei.
     */
    public DuplicateClientException(String message) {
        super(message);
    }
}
