package gaule.village.javanoramix.domain.barde;

public class Assurancetourix implements Barde {
    private static final String PRÉPARATION = "*accorde sa lyre* PLING PLONG… *s'éclaircit la voix* Hum hum… MI-MI-MIIIIII... ";
    private static final String FIN_LYRIQUE = " ... LAAAAAAA !!";

    @Override
    public String chanter(String texte) {
        var chanson = PRÉPARATION + texte + FIN_LYRIQUE;
        System.out.println(chanson);
        return chanson;
    }
}
