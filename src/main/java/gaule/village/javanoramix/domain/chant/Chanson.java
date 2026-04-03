package gaule.village.javanoramix.domain.chant;

import gaule.village.javanoramix.domain.shared.Niveau;

public class Chanson {

    private final String parole;
    private final Niveau niveau;
    private final int nombreRepetitions;

    private Chanson(String parole, Niveau niveau, int nombreRepetitions) {
        this.parole = parole;
        this.niveau = niveau;
        this.nombreRepetitions = nombreRepetitions;
    }

    public static Chanson create(String message, Niveau niveau) {
        String parole = switch (niveau) {
            case NORMAL -> message;
            case IMPORTANT -> "⚠ ATTENTION, BRAVES GAULOIS : " + message;
            case URGENT -> message.toUpperCase();
        };
        int nombreRepetitions = switch (niveau) {
            case NORMAL -> 1;
            case IMPORTANT -> 2;
            case URGENT -> 3;
        };
        return new Chanson(parole, niveau, nombreRepetitions);
    }

    public String getParole() {
        return parole;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public int getNombreRepetitions() {
        return nombreRepetitions;
    }
}
