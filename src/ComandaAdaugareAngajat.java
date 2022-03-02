/**
 * Aceasta clasa reprezinta o comanda prin care va fi adaugat un angajat.
 */
public class ComandaAdaugareAngajat extends Comanda {
    /**
     * Adauga un angajat descris de array-ul de String-uri primit ca parametru.
     *
     * @param words Un array de String-uri necesar pentru adaugarea angajatului.
     */
    @Override
    public void executa(String[] words) {
        CasaDeLicitatii.getInstance().adaugaAngajat(words);
    }
}
