package gaule.village.javanoramix.domain.adapter;

import gaule.village.javanoramix.domain.barde.Barde;
import gaule.village.javanoramix.domain.shared.Niveau;

import java.util.ArrayList;
import java.util.List;

public class BardeDouble implements Barde {
    public List<String> messages = new ArrayList<>();
    public List<Niveau> niveaux = new ArrayList<>();

    @Override
    public void chanter(String message, Niveau niveau) {
        this.messages.add(message);
        this.niveaux.add(niveau);
    }
}
