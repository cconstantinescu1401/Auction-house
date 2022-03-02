/**
 * Aceasta clasa reprezinta un obiect folosit pentru implementarea
 * design pattern-ului Factory asupra unui Produs.
 */
public class ProdusFactory {
    /**
     * Creeaza produsul corespunzator informatiilor din array-ul de String-uri
     * primit ca parametru.
     *
     * @param words Un array de String-uri ce contine informatiile despre produs.
     * @return Un obiect de tip Produs ce reprezinta produsul creat.
     */
    public Produs creeazaProdus(String[] words) {
        String tip = words[0];
        switch (tip) {
            case "Mobila":
                return new Mobila(Integer.parseInt(words[1]), words[2], Double.parseDouble(words[3]),
                        Integer.parseInt(words[4]), words[5], words[6]);
            case "Tablou":
                return new Tablou(Integer.parseInt(words[1]), words[2], Double.parseDouble(words[3]),
                        Integer.parseInt(words[4]), words[5], convertCulori(words[6]));
            case "Bijuterie":
                return new Bijuterie(Integer.parseInt(words[1]), words[2], Double.parseDouble(words[3]),
                        Integer.parseInt(words[4]), words[5], Boolean.parseBoolean(words[6]));
            default:
                return null;
        }
    }

    /**
     * Converteste String-ul primit ca parametru intr-un obiect de tip Culori
     * ce corespunde String-ului.
     *
     * @param s Un String ce contine tipul de culori.
     * @return Un obiect de tip Culori care corespunde String-ului primit ca parametru.
     */
    public Culori convertCulori(String s) {
        switch (s) {
            case "ulei":
                return Culori.ulei;
            case "tempera":
                return Culori.tempera;
            case "acrilic":
                return Culori.acrilic;
            default:
                return null;
        }

    }
}
