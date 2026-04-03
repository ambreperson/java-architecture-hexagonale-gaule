package gaule.village.javanoramix.adapters.barde;

import gaule.village.javanoramix.domain.barde.instrument.InstrumentDeMusique;
import gaule.village.javanoramix.domain.chant.Chanson;
import gaule.village.javanoramix.infrastructure.Harpe;
import org.springframework.stereotype.Service;

@Service
public class InstrumentDeMusiqueAdapter implements InstrumentDeMusique {
    private final Harpe harpe;

    public InstrumentDeMusiqueAdapter(Harpe harpe) {
        this.harpe = harpe;
    }

    @Override
    public void jouer(Chanson chanson) {
        harpe.jouer(chanson);
    }
}