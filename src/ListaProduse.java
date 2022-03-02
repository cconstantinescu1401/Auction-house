import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Aceasta clasa reprezinta o lista de produse.
 */
public class ListaProduse {
    private final List<Produs> produse;
    Lock lock = new ReentrantLock();

    /**
     * Creeaza o lista de produse.
     */
    public ListaProduse() {
        produse = new ArrayList<>();
    }

    /**
     * Afiseaza produsele din cadrul listei.
     */
    public void afiseazaProduse() {
        lock.lock();
        try {
            System.out.println("Produse pentru vanzare:");
            for (Produs p : produse)
                System.out.println(p);
            System.out.println();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Adauga in lista noi produse, folosind scanner-ul primit ca parametru
     * pentru citirea informatiilor despre produse.
     *
     * @param scanner Un obiect de tip Scanner folosit pentru citirea
     *                informatiilor despre produsele ce urmeaza a fi adaugate.
     * @throws DuplicateProductException daca se incearca adaugarea unui produs
     *                                   cu un id ce apartine deja altui produs.
     */
    public void adaugaProduse(Scanner scanner) throws DuplicateProductException {
        lock.lock();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");
            ProdusFactory f = new ProdusFactory();
            Produs p = f.creeazaProdus(words);
            boolean duplicat = produse.stream()
                    .filter(produs -> produs.getId() == p.getId())
                    .findAny()
                    .orElse(null)
                    != null;
            if (duplicat) {
                lock.unlock();
                throw new DuplicateProductException("Exista deja un produs cu id-ul " + p.getId() + ".");
            }
            produse.add(p);
            System.out.println("Administratorul a adaugat produsul: " + p + ".\n");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    /**
     * Sterge produsele vandute din cadrul listei.
     */
    public void stergeProduseVandute() {
        lock.lock();
        produse.removeIf(p -> p.getPretVanzare() > 0);
        System.out.println("Un broker a sters produsele vandute.\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    /**
     * Cauta in cadrul listei produsul care are id-ul specificat.
     *
     * @param id Un int ce reprezinta id-ul produsului cautat.
     * @return Un obiect de tip Produs care are id-ul specificat,
     * sau null, daca nu a fost gasit un astfel de produs.
     */
    public Produs gasesteDupaId(int id) {
        for (Produs p : produse)
            if (p.getId() == id)
                return p;
        return null;

    }

}
