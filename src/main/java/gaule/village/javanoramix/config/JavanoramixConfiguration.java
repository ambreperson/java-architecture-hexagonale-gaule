package gaule.village.javanoramix.config;

import gaule.village.javanoramix.adapters.barde.InstrumentDeMusiqueAdapter;
import gaule.village.javanoramix.domain.barde.Assurancetourix;
import gaule.village.javanoramix.domain.barde.Barde;
import gaule.village.javanoramix.domain.barde.instrument.InstrumentDeMusique;
import gaule.village.javanoramix.domain.druide.Druide;
import gaule.village.javanoramix.domain.druide.Javanoramix;
import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.stock.Stock;
import gaule.village.javanoramix.domain.recette.Ingrédient;
import gaule.village.javanoramix.infrastructure.GardeManger;
import gaule.village.javanoramix.infrastructure.Harpe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavanoramixConfiguration {
    @Bean
    Druide druide(Stock stock, AppareilDeCuisson appareilDeCuisson, Barde barde) {
        return new Javanoramix(stock, appareilDeCuisson, barde);
    }

    @Bean
    GardeManger gardeManger() {
        var contenu = new ArrayList<>(List.of(
                        new Ingrédient("poisson frais arrivant de Lutèce par char à bœufs", 100),
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("fraise", 12),
                        new Ingrédient("once de lait de sanglier", 4),
                        new Ingrédient("pincée de curcuma", 10),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                ));
        return new GardeManger(contenu);
    }

    @Bean
    InstrumentDeMusique instrumentDeMusique(Harpe harpe) {
        return new InstrumentDeMusiqueAdapter(harpe);
    }

    @Bean
    Assurancetourix assurancetourix(InstrumentDeMusique instrumentDeMusique) {
        return new Assurancetourix(instrumentDeMusique);
    }

    @Bean
    Barde barde(Assurancetourix assurancetourix) {
        return assurancetourix;
    }
}
