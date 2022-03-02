import java.util.*;

/**
 * Aceasta clasa reprezinta un administrator.
 */
public class Administrator extends Angajat {
    private final ListaProduse listaProduse;
    private Scanner scanner;

    /**
     * Creeaza un administrator care are acces la lista de produse primita ca parametru.
     *
     * @param listaProduse Lista de produse scoase la vanzare.
     */
    public Administrator(ListaProduse listaProduse) {
        this.listaProduse = listaProduse;
    }

    /**
     * Seteaza scannerul folosit de administrator.
     *
     * @param scanner Scanner-ul care va fi folosit de administrator pentru
     *                citirea din fisier si adaugarea unor noi produse.
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Metoda care suprascrie metoda run(), in urma careia vor fi adaugate noi produse.
     */
    @Override
    public void run() {
        try {
            listaProduse.adaugaProduse(scanner);
        } catch (DuplicateProductException e) {
            e.printStackTrace();
        }
    }
}
