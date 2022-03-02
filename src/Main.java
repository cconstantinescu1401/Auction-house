import java.io.*;
import java.util.Scanner;

/**
 * Aceasta clasa contine metoda main din cadrul proiectului.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduceti numele fisierului care contine comenzile:");
        File in = new File(input.next());
        Scanner scnr = new Scanner(in);

        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            String[] words = line.split(",");
            Comanda comandaCurenta;
            switch (words[0]) {
                case "adaugaClient":
                    comandaCurenta = new ComandaAdaugareClient();
                    break;
                case "adaugaAngajat":
                    comandaCurenta = new ComandaAdaugareAngajat();
                    break;
                case "solicitaParticipare":
                    comandaCurenta = new ComandaSolicitareParticipare();
                    break;
                case "adaugaProduse":
                    comandaCurenta = new ComandaAdaugareProduse();
                    break;
                case "afiseazaProduse":
                    comandaCurenta = new ComandaAfisareProduse();
                    break;
                case "stergeProduseVandute":
                    comandaCurenta = new ComandaStergereProduseVandute();
                    break;
                case "afiseazaComisioane":
                    comandaCurenta = new ComandaAfisareComisioane();
                    break;
                case "exit":
                    return;
                default:
                    comandaCurenta = null;
            }
            if (comandaCurenta == null)
                System.out.println("Comanda " + words[0] + " nu a fost gasita.\n");
            else
                comandaCurenta.executa(words);
        }

    }
}
