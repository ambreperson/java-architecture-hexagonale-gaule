package gaule.village.javanoramix.infrastructure;

import gaule.village.javanoramix.domain.barde.instrument.InstrumentDeMusique;
import gaule.village.javanoramix.domain.chant.Chanson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Harpe implements InstrumentDeMusique {

    private static final Logger logger = LoggerFactory.getLogger(Harpe.class.getName());

    @Override
    public void jouer(Chanson chanson) {
        switch (chanson.getNiveau()) {
            case NORMAL -> logger.info(chanson.getParole());
            case IMPORTANT -> logger.warn(chanson.getParole());
            case URGENT -> logger.error(chanson.getParole());
        }
    }
}
