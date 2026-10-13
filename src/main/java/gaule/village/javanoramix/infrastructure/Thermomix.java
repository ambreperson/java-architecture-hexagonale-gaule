package gaule.village.javanoramix.infrastructure;

import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.cuiseur.CuiseurNonPréchaufféException;
import gaule.village.javanoramix.domain.recette.Ingrédient;
import gaule.village.javanoramix.domain.recette.Température;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Repository
public class Thermomix {
    protected Ingrédient ingrédientEnCuisson = Ingrédient.INGRÉDIENT_VIDE;
    private Température températureActuelle = Température.ZERO_CELCIUS;
    private Température températureSouhaitée = Température.ZERO_CELCIUS;
    private final ExecutorService executeur = Executors.newSingleThreadExecutor();

    public void préchauffer(Température températureSouhaitée) {
        this.températureSouhaitée = températureSouhaitée;
        executeur.submit(() -> {
            while (this.températureActuelle.degré() < températureSouhaitée.degré()) {
                try {
                    Thread.sleep(300);
                    setTempératureActuelle(new Température(this.températureActuelle.degré() + 10));
                } catch (InterruptedException _) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public synchronized Température vérifierTempérature() {
        return températureActuelle;
    }

    public synchronized void setTempératureActuelle(Température nouvelleTempérature) {
        this.températureActuelle = nouvelleTempérature;
    }

    public void cuire(Ingrédient ingrédientÀCuire, String nomIngrédientObtenu) {
        if (this.vérifierTempérature().degré() != this.températureSouhaitée.degré()) {
            throw new CuiseurNonPréchaufféException();
        }
        this.ingrédientEnCuisson = new Ingrédient(nomIngrédientObtenu, ingrédientÀCuire.quantité());
    }

    public Ingrédient prélever() {
        var ingrédientÀPrélever = this.ingrédientEnCuisson;
        this.ingrédientEnCuisson = Ingrédient.INGRÉDIENT_VIDE;
        return ingrédientÀPrélever;
    }
}
