package gaule.village.javanoramix.domain.barde;

import gaule.village.javanoramix.domain.barde.instrument.InstrumentDeMusique;
import gaule.village.javanoramix.domain.chant.Chanson;
import gaule.village.javanoramix.domain.shared.Niveau;

public class Assurancetourix implements Barde {

    private final InstrumentDeMusique instrument;

    public Assurancetourix(InstrumentDeMusique instrument) {
        this.instrument = instrument;
    }

    @Override
    public void chanter(String message, Niveau niveau) {
        Chanson chanson = Chanson.create(message, niveau);
        for(int i = 0; i < chanson.getNombreRepetitions(); i++) {
            instrument.jouer(chanson);
        }
    }
}
