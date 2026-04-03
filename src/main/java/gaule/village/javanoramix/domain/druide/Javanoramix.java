package gaule.village.javanoramix.domain.druide;

import gaule.village.javanoramix.domain.barde.Barde;
import gaule.village.javanoramix.domain.druide.cuiseur.CuiseurNonPréchaufféException;
import gaule.village.javanoramix.domain.shared.Niveau;
import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.stock.IngrédientManquantException;
import gaule.village.javanoramix.domain.druide.stock.Stock;
import gaule.village.javanoramix.domain.recette.*;

public class Javanoramix implements Druide {

    private final Stock stock;
    private final AppareilDeCuisson cuiseur;
    private final Barde barde;

    public Javanoramix(Stock stock, AppareilDeCuisson cuiseur, Barde barde) {
        this.stock = stock;
        this.cuiseur = cuiseur;
        this.barde = barde;
    }

    @Override
    public Plat préparer(Recette recetteÀPréparer) {
        try {
            System.out.printf("Préparation de la recette : %s\n", recetteÀPréparer.nom());

            vérifierDisponibilitéIngrédients(recetteÀPréparer);

            préchauffer(recetteÀPréparer);

            Ingrédient dernierIngrédientObtenu = Ingrédient.INGRÉDIENT_VIDE;
            for (Étape étape : recetteÀPréparer.déroulé()) {
                System.out.printf("Étape : %s\n", étape.nom());
                if (étape.action() == Action.MELANGER) {
                    dernierIngrédientObtenu = mélanger(étape);
                }
                if (étape.action() == Action.BOUILLIR) {
                    dernierIngrédientObtenu = bouillir(étape);
                }
                stock.stockerIngrédient(dernierIngrédientObtenu);
                System.out.printf("Réservation de %s\n", dernierIngrédientObtenu.toString());
            }

            alerterSiIlManqueDesIngrédientsPourLaProchaineFois(recetteÀPréparer);
            return servir(dernierIngrédientObtenu);
        } catch (IngrédientManquantException | CuiseurNonPréchaufféException e) {
            barde.chanter("Je ne peux pas préparer la %s !".formatted(recetteÀPréparer.nom().toLowerCase()), Niveau.URGENT);
            throw e;
        }
    }

    private void vérifierDisponibilitéIngrédients(Recette recetteÀPréparer) {
        System.out.println("Vérification de la disponibilité des ingrédients");
        boolean ingrédientsDisponibles = recetteÀPréparer.ingrédients()
                .stream()
                .allMatch(stock::vérifierDisponibilité);

        if (!ingrédientsDisponibles) throw new IngrédientManquantException();
    }

    private void préchauffer(Recette recetteÀPréparer) {
        if (recetteÀPréparer.préchauffage().isPresent()) {
            var températureSouhaitée = recetteÀPréparer.préchauffage().get();
            cuiseur.préchauffer(températureSouhaitée);
            while (cuiseur.vérifierTempérature().degré() < températureSouhaitée.degré()) {
                try {
                    System.out.printf("Préchauffage du cuiseur en cours : %d °C -> %d °C\n", cuiseur.vérifierTempérature().degré(), températureSouhaitée.degré());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private Ingrédient mélanger(Étape étape) {
        Ingrédient avec = étape.avec().orElseThrow();
        System.out.printf("Mélanger %s avec %s\n", étape.base(), avec);
        if (!stock.vérifierDisponibilité(étape.base()) || !stock.vérifierDisponibilité(avec)) {
            throw new IngrédientManquantException();
        }
        var ingrédientDeBase = this.stock.récupérerIngrédient(étape.base()).orElseThrow();
        var ingrédientAvec = this.stock.récupérerIngrédient(avec).orElseThrow();
        return new Ingrédient(étape.nomIngrédientObtenu(), ingrédientDeBase.quantité() + ingrédientAvec.quantité());
    }

    private Ingrédient bouillir(Étape étape) {
        System.out.printf("Mise à bouillir de %s\n", étape.base());
        if (!stock.vérifierDisponibilité(étape.base())) {
            throw new IngrédientManquantException();
        }
        var ingrédientDeBase = this.stock.récupérerIngrédient(étape.base()).orElseThrow();
        cuiseur.cuire(ingrédientDeBase, étape.nomIngrédientObtenu());
        return cuiseur.prélever();
    }

    private void alerterSiIlManqueDesIngrédientsPourLaProchaineFois(Recette recetteÀPréparer) {
        try {
            vérifierDisponibilitéIngrédients(recetteÀPréparer);
        } catch (IngrédientManquantException e) {
            barde.chanter("Il manque des ingrédients pour la prochaine fois !", Niveau.IMPORTANT);
        }
    }

    private Plat servir(Ingrédient ingrédient) {
        var ingrédientÀServir = this.stock.récupérerIngrédient(ingrédient).orElseThrow();
        var plat = new Plat(ingrédientÀServir.nom(), ingrédientÀServir.quantité());
        System.out.printf("Le plat %s est prêt !\n", plat);
        barde.chanter("Le plat %s est prêt !".formatted(plat.nom()), Niveau.NORMAL);
        return plat;
    }
}
