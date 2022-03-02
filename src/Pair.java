/**
 * Aceasta clasa reprezinta o pereche de doua obiecte generice.
 *
 * @param <T> Tipul primului obiect din cadrul perechii.
 * @param <U> Tipul celui de-al doilea obiect din cadrul perechii.
 */
public class Pair<T, U> {
    public final T arg1;
    public final U arg2;

    /**
     * Creeaza o pereche de doua obiecte specificate ca parametri.
     *
     * @param t Primul obiect din cadrul perechii.
     * @param u Al doilea obiect din cadrul perechii.
     */
    public Pair(T t, U u) {
        this.arg1 = t;
        this.arg2 = u;
    }
}
