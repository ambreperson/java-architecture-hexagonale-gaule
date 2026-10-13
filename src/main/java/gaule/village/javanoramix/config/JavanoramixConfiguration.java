package gaule.village.javanoramix.config;

import gaule.village.javanoramix.domain.barde.AssuranceTourix;
import gaule.village.javanoramix.domain.barde.Barde;
import gaule.village.javanoramix.domain.druide.Druide;
import gaule.village.javanoramix.domain.druide.Javanoramix;
import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.notif.Notificateur;
import gaule.village.javanoramix.domain.druide.stock.Stock;
import gaule.village.javanoramix.domain.recette.Ingrédient;
import gaule.village.javanoramix.infrastructure.GardeManger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavanoramixConfiguration {
    @Bean
    Druide druide(Stock stock, AppareilDeCuisson appareilDeCuisson, Notificateur notificateur) {
        return new Javanoramix(stock, appareilDeCuisson,  notificateur);
    }

    @Bean
    Barde barde() {
        return new AssuranceTourix();
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
}
