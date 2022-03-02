import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Aceasta clasa reprezinta o comanda prin care vor fi adaugate produse.
 */
public class ComandaAdaugareProduse extends Comanda {
    /**
     * Adauga produse noi cu ajutorul unui administrator ales aleator.
     *
     * @param words Un array de String-uri necesar pentru adaugarea produselor.
     */
    @Override
    public void executa(String[] words) {
        Administrator admin = CasaDeLicitatii.getInstance().cautaAdministratorAleator();
        try {
            admin.setScanner(new Scanner(new File(words[1])));
            Thread t = new Thread(admin);
            t.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
