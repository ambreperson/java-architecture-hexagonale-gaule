package gaule.village.javanoramix.domain.adapter;

import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.cuiseur.CuiseurNonPréchaufféException;
import gaule.village.javanoramix.domain.recette.Ingrédient;
import gaule.village.javanoramix.domain.recette.Température;
import gaule.village.javanoramix.infrastructure.Thermomix;

public class CuiseurDouble extends Thermomix implements AppareilDeCuisson {

    private Etat etat = Etat.PRÉCHAUFFÉ;

    public Ingrédient getIngrédientEnCuisson() {
        return this.ingrédientEnCuisson;
    }

    public void préchauffer(Température températureSouhaitée) {
        if (etat == Etat.NON_PRÉCHAUFFÉ) {
            throw new CuiseurNonPréchaufféException();
        }
        super.préchauffer(températureSouhaitée);
    }

    public CuiseurDouble() {
    }

    public CuiseurDouble(Etat etat) {
        this.etat = etat;
    }

    public enum Etat {
        PRÉCHAUFFÉ, NON_PRÉCHAUFFÉ
    }

}
