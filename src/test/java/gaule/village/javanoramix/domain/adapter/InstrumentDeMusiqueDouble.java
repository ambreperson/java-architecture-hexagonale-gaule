package gaule.village.javanoramix.domain.adapter;

import gaule.village.javanoramix.domain.barde.instrument.InstrumentDeMusique;
import gaule.village.javanoramix.domain.chant.Chanson;
import gaule.village.javanoramix.domain.shared.Niveau;

import java.util.ArrayList;
import java.util.List;

public class InstrumentDeMusiqueDouble implements InstrumentDeMusique {
    public List<String> messages = new ArrayList<>();
    public List<Niveau> niveaux = new ArrayList<>();

    @Override
    public void jouer(Chanson chanson) {
        this.messages.add(chanson.getParole());
        this.niveaux.add(chanson.getNiveau());
    }
}
