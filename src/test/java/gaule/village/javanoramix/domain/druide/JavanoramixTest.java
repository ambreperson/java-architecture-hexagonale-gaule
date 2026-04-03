package gaule.village.javanoramix.domain.druide;

import gaule.village.javanoramix.domain.adapter.BardeDouble;
import gaule.village.javanoramix.domain.adapter.CuiseurDouble;
import gaule.village.javanoramix.domain.adapter.StockDouble;
import gaule.village.javanoramix.domain.druide.cuiseur.CuiseurNonPréchaufféException;
import gaule.village.javanoramix.domain.shared.Niveau;
import gaule.village.javanoramix.domain.druide.cuiseur.AppareilDeCuisson;
import gaule.village.javanoramix.domain.druide.stock.IngrédientManquantException;
import gaule.village.javanoramix.domain.druide.stock.Stock;
import gaule.village.javanoramix.domain.recette.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavanoramixTest {

    public static final Recette RECETTE_DES_FRAIFLES = new Recette(
            "Recette des fraifles",
            List.of(
                    new Ingrédient("trèfle à 4 feuilles", 8),
                    new Ingrédient("fraise", 12)
            ),
            Optional.empty(),
            List.of(
                    new Étape(
                            "Mélanger les trèfles et les fraises",
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            Optional.of(new Ingrédient("fraise", 12)),
                            Action.MELANGER,
                            "fraifle"
                    )
            )
    );

    public static final Recette RECETTE_DES_FRAIFLES_AU_GUI = new Recette(
            "Recette des fraifles au gui",
            List.of(
                    new Ingrédient("trèfle à 4 feuilles", 8),
                    new Ingrédient("fraise", 12),
                    new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
            ),
            Optional.empty(),
            List.of(
                    new Étape(
                            "Mélanger les trèfles et les fraises",
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            Optional.of(new Ingrédient("fraise", 12)),
                            Action.MELANGER,
                            "fraifle"
                    ),
                    new Étape(
                            "Mélanger les fraifles et le gui",
                            new Ingrédient("fraifle", 20),
                            Optional.of(new Ingrédient("feuille de gui coupée à la serpe d'or", 1)),
                            Action.MELANGER,
                            "fraifle au gui"
                    )
            )
    );

    public static final Recette RECETTE_DES_FRAIFLES_AU_GUI_PAS_ASSEZ_DE_FRAIFLES = new Recette(
            "Recette approximative des fraifles au gui",
            List.of(
                    new Ingrédient("trèfle à 4 feuilles", 8),
                    new Ingrédient("fraise", 12),
                    new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
            ),
            Optional.empty(),
            List.of(
                    new Étape(
                            "Mélanger les trèfles et les fraises",
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            Optional.of(new Ingrédient("fraise", 12)),
                            Action.MELANGER,
                            "fraifle"
                    ),
                    new Étape(
                            "Mélanger les fraifles et le gui",
                            new Ingrédient("fraifle", 20 + 1),
                            Optional.of(new Ingrédient("feuille de gui coupée à la serpe d'or", 1)),
                            Action.MELANGER,
                            "fraifle au gui"
                    )
            )
    );

    public static final Recette RECETTE_DES_FRAIFLES_AU_GUI_ET_LAIT_DORÉ = new Recette(
            "Recette des fraifles au gui et lait doré",
            List.of(
                    new Ingrédient("trèfle à 4 feuilles", 8),
                    new Ingrédient("fraise", 12),
                    new Ingrédient("feuille de gui coupée à la serpe d'or", 1),
                    new Ingrédient("once de lait de sanglier", 4),
                    new Ingrédient("pincée de curcuma", 10)
            ),
            Optional.empty(),
            List.of(
                    new Étape(
                            "Mélanger les trèfles et les fraises",
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            Optional.of(new Ingrédient("fraise", 12)),
                            Action.MELANGER,
                            "fraifle"
                    ),
                    new Étape(
                            "Ajouter le gui",
                            new Ingrédient("fraifle", 20),
                            Optional.of(new Ingrédient("feuille de gui coupée à la serpe d'or", 1)),
                            Action.MELANGER,
                            "fraifle au gui"
                    ),
                    new Étape(
                            "Préparer le lait doré",
                            new Ingrédient("once de lait de sanglier", 4),
                            Optional.of(new Ingrédient("pincée de curcuma", 10)),
                            Action.MELANGER,
                            "lait doré"
                    ),
                    new Étape(
                            "Mélanger les fraifles et le lait doré",
                            new Ingrédient("fraifle au gui", 21),
                            Optional.of(new Ingrédient("lait doré", 14)),
                            Action.MELANGER,
                            "fraifle au gui et lait doré"
                    )
            )
    );

    public static final Recette RECETTE_DES_FRAISES_BOUILLIES = new Recette(
            "Recette des fraises bouillies",
            List.of(
                    new Ingrédient("fraise", 12)
            ),
            Optional.of(new Température(90)),
            List.of(
                    new Étape(
                            "Faire bouillir les fraises",
                            new Ingrédient("fraise", 12),
                            Optional.empty(),
                            Action.BOUILLIR,
                            "fraise bouillie"
                    )
            )
    );

    public static final Recette RECETTE_DES_FRAIFLES_BOUILLIES = new Recette(
            "Recette des fraifles bouillies",
            List.of(
                    new Ingrédient("trèfle à 4 feuilles", 8),
                    new Ingrédient("fraise", 12)
            ),
            Optional.of(new Température(90)),
            List.of(
                    new Étape(
                            "Mélanger les trèfles et les fraises",
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            Optional.of(new Ingrédient("fraise", 12)),
                            Action.MELANGER,
                            "fraifle"
                    ),
                    new Étape(
                            "Faire bouillir les fraifles",
                            new Ingrédient("fraifle", 20),
                            Optional.empty(),
                            Action.BOUILLIR,
                            "fraifle bouillie"
                    )
            )
    );

    @Test
    void préparerDesFraifles() {
        // Arrange
        StockDouble stock = new StockDouble(
            new ArrayList<>(List.of(
                new Ingrédient("fraise", 12),
                new Ingrédient("trèfle à 4 feuilles", 8)
            ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraifle", 20);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAIFLES);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(0, stock.getContenu().size());
    }

    @Test
    void préparerDesFraiflesIngrédientAbsent() {
        // Arrange
        Stock stock = new StockDouble(
                new ArrayList<>(List.of(new Ingrédient("fraise", 12)))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        // Act + Assert
        assertThrows(IngrédientManquantException.class, () -> javanoramix.préparer(RECETTE_DES_FRAIFLES));

    }

    @Test
    void préparerDesFraiflesIngrédientManquant() {
        // Arrange
        Stock stock = new StockDouble(
            new ArrayList<>(List.of(
                new Ingrédient("fraise", 12 - 1),
                new Ingrédient("trèfle à 4 feuilles", 8)
            ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        // Act + Assert
        assertThrows(IngrédientManquantException.class, () -> javanoramix.préparer(RECETTE_DES_FRAIFLES));

    }

    @Test
    void préparerDesFraiflesSurplusIngrédients() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12 + 1),
                        new Ingrédient("trèfle à 4 feuilles", 8)
                ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraifle", 20);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAIFLES);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(1, stock.getContenu().size());
    }

    @Test
    void préparerDesFraiflesAuGui() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12),
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraifle au gui", 21);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAIFLES_AU_GUI);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(0, stock.getContenu().size());
    }

    @Test
    void préparerDesFraiflesAuGuiAvecDuLaitDoré() {
        // Arrange
        Stock stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12),
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1),
                        new Ingrédient("once de lait de sanglier", 4),
                        new Ingrédient("pincée de curcuma", 10)
                ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraifle au gui et lait doré", 35);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAIFLES_AU_GUI_ET_LAIT_DORÉ);

        // Assert
        assertEquals(platAttendu, platObtenu);
    }

    @Test
    void préparerDesFraisesBouillies() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12)
                ))
        );
        CuiseurDouble cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraise bouillie", 12);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAISES_BOUILLIES);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(0, stock.getContenu().size());
        assertEquals(Ingrédient.INGRÉDIENT_VIDE, cuiseur.getIngrédientEnCuisson());
    }

    @Test
    void préparerDesFraiflesBouillies() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12),
                        new Ingrédient("trèfle à 4 feuilles", 8)
                ))
        );
        CuiseurDouble cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("fraifle bouillie", 20);

        // Act
        Plat platObtenu = javanoramix.préparer(RECETTE_DES_FRAIFLES_BOUILLIES);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(0, stock.getContenu().size());
        assertEquals(Ingrédient.INGRÉDIENT_VIDE, cuiseur.getIngrédientEnCuisson());
    }

    @Test
    void préparerDesFraiflesAuGuiPasAssezDeFraifles() {
        // Arrange
        Stock stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("fraise", 12),
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                ))
        );
        AppareilDeCuisson cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        // Act + Assert
        assertThrows(IngrédientManquantException.class, () -> javanoramix.préparer(RECETTE_DES_FRAIFLES_AU_GUI_PAS_ASSEZ_DE_FRAIFLES));
    }

    @Test
    void préparerDeLaPotionMagique() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("fraise", 12),
                        new Ingrédient("once de lait de sanglier", 4),
                        new Ingrédient("pincée de curcuma", 10),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                ))
        );
        CuiseurDouble cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);

        Plat platAttendu = new Plat("potion magique", 35);

        // Act
        Plat platObtenu = javanoramix.préparer(Recette.RECETTE_DE_LA_POTION_MAGIQUE);

        // Assert
        assertEquals(platAttendu, platObtenu);
        assertEquals(0, stock.getContenu().size());
        assertEquals(Ingrédient.INGRÉDIENT_VIDE, cuiseur.getIngrédientEnCuisson());
    }

    @Test
    void prévenirQueLaPotionMagiqueEstPrête() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("trèfle à 4 feuilles", 16),
                        new Ingrédient("fraise", 24),
                        new Ingrédient("once de lait de sanglier", 8),
                        new Ingrédient("pincée de curcuma", 20),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 2)
                ))
        );
        CuiseurDouble cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);


        // Act
        javanoramix.préparer(Recette.RECETTE_DE_LA_POTION_MAGIQUE);

        // Assert
        assertEquals("Le plat potion magique est prêt !", barde.messages.get(0));
        assertEquals(Niveau.NORMAL, barde.niveaux.get(0));
    }

    @Test
    void prévenirQuIlManqueDesIngrédientsPourLaProchaineFois() {
        // Arrange
        StockDouble stock = new StockDouble(
                new ArrayList<>(List.of(
                        new Ingrédient("trèfle à 4 feuilles", 8),
                        new Ingrédient("fraise", 12),
                        new Ingrédient("once de lait de sanglier", 4),
                        new Ingrédient("pincée de curcuma", 10),
                        new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                ))
        );
        CuiseurDouble cuiseur = new CuiseurDouble();
        BardeDouble barde = new BardeDouble();
        Druide javanoramix = new Javanoramix(stock, cuiseur, barde);


        // Act
        javanoramix.préparer(Recette.RECETTE_DE_LA_POTION_MAGIQUE);

        // Assert
        assertEquals( "Il manque des ingrédients pour la prochaine fois !", barde.messages.get(0));
        assertEquals(Niveau.IMPORTANT, barde.niveaux.get(0));

        assertEquals("Le plat potion magique est prêt !", barde.messages.get(1));
        assertEquals(Niveau.NORMAL, barde.niveaux.get(1));
    }

    @Nested
    class AlerterSiLeDruideNePeuxPasPréparerLePlat {

        @Test
        void alerterSiIlManqueDesIngrédients() {
            StockDouble stock = new StockDouble(
                    new ArrayList<>(List.of(
                            new Ingrédient("trèfle à 4 feuilles", 0),
                            new Ingrédient("fraise", 12),
                            new Ingrédient("once de lait de sanglier", 4),
                            new Ingrédient("pincée de curcuma", 10),
                            new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                    ))
            );
            CuiseurDouble cuiseur = new CuiseurDouble();
            BardeDouble barde = new BardeDouble();
            Druide javanoramix = new Javanoramix(stock, cuiseur, barde);


            // Act +Assert
            assertThrows(IngrédientManquantException.class, () -> javanoramix.préparer(Recette.RECETTE_DE_LA_POTION_MAGIQUE));
            assertEquals( "Je ne peux pas préparer la recette de la potion magique !", barde.messages.get(0));
            assertEquals(Niveau.URGENT, barde.niveaux.get(0));
        }

        @Test
        void alerterSiLeCuiseurNePréchauffePas() {
            // Arrange
            StockDouble stock = new StockDouble(
                    new ArrayList<>(List.of(
                            new Ingrédient("trèfle à 4 feuilles", 8),
                            new Ingrédient("fraise", 12),
                            new Ingrédient("once de lait de sanglier", 4),
                            new Ingrédient("pincée de curcuma", 10),
                            new Ingrédient("feuille de gui coupée à la serpe d'or", 1)
                    ))
            );
            CuiseurDouble cuiseur = new CuiseurDouble(CuiseurDouble.Etat.NON_PRÉCHAUFFÉ);
            BardeDouble barde = new BardeDouble();
            Druide javanoramix = new Javanoramix(stock, cuiseur, barde);


            // Act + Assert
            assertThrows(CuiseurNonPréchaufféException.class, () -> javanoramix.préparer(Recette.RECETTE_DE_LA_POTION_MAGIQUE));
            assertEquals( "Je ne peux pas préparer la recette de la potion magique !", barde.messages.get(0));
            assertEquals(Niveau.URGENT, barde.niveaux.get(0));
        }
    }
}
