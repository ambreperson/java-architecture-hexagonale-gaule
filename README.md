# Javanoramix - Le Gestionnaire de Recettes Gauloises

*Par Ordralfabétix, poissonnier passionné du village et développeur Java*

---

## Mon poisson est frais, et mon code aussi !

Oyez oyez, braves gens ! Moi, Ordralfabétix, le meilleur poissonnier de toute la Gaule (et le seul à proposer du poisson frais arrivant directement de Lutèce !), je vais vous conter comment j'ai sauvé notre village avec mon **Java** !

Alors voilà : Panoramix, notre druide, a perdu la mémoire. Plus de recette de potion magique ! Une catastrophe ! Notre cher Astérix a donc décidé qu'il fallait créer une application pour **conserver à jamais nos précieuses recettes gauloises**.

Et qui s'est porté volontaire ? Votre humble serviteur, évidemment !

Bon, Cétautomatix aussi s'est proposé avec son Go... Pfff ! Du Go ! Un langage aussi brut que ses coups de marteau ! Moi, je cuisine du **Java** tous les jours dans ma poissonnerie, un langage raffiné comme mes meilleures sardines, structuré comme mes étalages parfaitement ordonnés !

---

## L'Architecture Hexagonale, ou comment préparer du code comme du bon poisson

Alors, j'aurais pu faire comme Cétautomatix et empiler du code comme il empile ses enclumes. Mais non ! Moi, Ordralfabétix, j'ai du raffinement ! J'ai utilisé l'**architecture hexagonale**, aussi appelée "Ports et Adaptateurs".

C'est comme quand je prépare mon poisson :
- Le **cœur** (le domaine), c'est le poisson : frais, pur, sans ajout superflu
- Les **ports**, ce sont les recettes : l'interface entre le poisson et le client
- Les **adaptateurs**, ce sont les différentes préparations : grillé, fumé, mariné...

```
                    ┌─────────────────────┐
                    │  REST API (APIx)    │  ← Vous commandez ici
                    │   (Spring MVC)      │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │     JAVANORAMIX     │  ← Le cerveau de l'opération
                    │  (Service Druide)   │     (Java + Panoramix, vous l'avez ?)
                    └────┬───────────┬────┘
                         │           │
                ┌────────▼───┐ ┌─────▼────────┐
                │   Stock    │ │  Appareil    │  ← Les ports
                │   (Port)   │ │  De Cuisson  │
                └────────┬───┘ └─────┬────────┘
                         │           │
                ┌────────▼───┐ ┌─────▼────────┐
                │GardeManger │ │  Thermomix   │  ← Les adaptateurs
                │  Adapter   │ │   Adapter    │
                └────────┬───┘ └─────┬────────┘
                         │           │
                ┌────────▼───┐ ┌─────▼────────┐
                │GardeManger │ │  Thermomix   │  ← L'infrastructure
                └────────────┘ └──────────────┘
```

---

## Structure du Projet

```
java-architecture-hexagonale-gaule/
├── build.gradle                    # Configuration Gradle - aussi frais que mon poisson
├── src/
│   ├── main/java/gaule/village/javanoramix/
│   │   ├── JavanoramixApplication.java     # Point d'entrée Spring Boot
│   │   ├── config/
│   │   │   └── JavanoramixConfiguration.java   # Configuration des beans
│   │   │
│   │   ├── domain/                 # LE DOMAINE - le coeur, frais et pur !
│   │   │   ├── druide/
│   │   │   │   ├── Druide.java                 # L'interface (port primaire)
│   │   │   │   ├── Javanoramix.java            # L'implémentation métier
│   │   │   │   ├── cuiseur/
│   │   │   │   │   └── AppareilDeCuisson.java  # Port secondaire
│   │   │   │   └── stock/
│   │   │   │       └── Stock.java              # Port secondaire
│   │   │   └── recette/
│   │   │       ├── Recette.java          # Qu'est-ce qu'une recette ?
│   │   │       ├── Étape.java            # Une étape de préparation
│   │   │       ├── Ingrédient.java       # Un ingrédient (record)
│   │   │       ├── Action.java           # MELANGER, BOUILLIR
│   │   │       ├── Température.java      # Gestion de la chaleur
│   │   │       └── Plat.java             # Le résultat final
│   │   │
│   │   ├── adapters/druide/        # LES ADAPTATEURS
│   │   │   ├── ThermomixAdapter.java     # Adapter pour la cuisson
│   │   │   └── GardeMangerAdapter.java   # Adapter pour le stock
│   │   │
│   │   ├── infrastructure/         # L'INFRASTRUCTURE
│   │   │   ├── Thermomix.java            # Le vrai appareil de cuisson
│   │   │   └── GardeManger.java          # Le vrai garde-manger
│   │   │
│   │   └── apix/                   # L'API REST (entrée)
│   │       └── PotionMagiqueRestController.java
│   │
│   └── test/java/gaule/village/javanoramix/
│       ├── ArchitectureHexagonaleTest.java   # Tests ArchUnit !
│       └── domain/druide/
│           └── JavanoramixTest.java          # Tests métier
│
├── gradlew / gradlew.bat           # Gradle Wrapper
└── settings.gradle
```

---

## Utilisation

### Prérequis
- Java 24 ou supérieur (on utilise du frais ici, pas du surgelé comme le code de Cétautomatix !)
- Gradle (fourni via le wrapper)

### Lancer l'application

```bash
# Démarrer le serveur Spring Boot
./gradlew bootRun

# L'application démarre sur http://localhost:8080
```

### Préparer une potion magique

```bash
# Via l'API REST
curl -X POST http://localhost:8080/potion-magique
```

### Lancer les tests

```bash
# Tous les tests
./gradlew test

# Uniquement les tests métier
./gradlew test --tests "JavanoramixTest"

# Uniquement les tests d'architecture
./gradlew test --tests "ArchitectureHexagonaleTest"
```

---

## Technologies Utilisées

| Technologie       | Utilisation          | Commentaire d'Ordralfabétix                        |
| ----------------- | -------------------- | -------------------------------------------------- |
| **Java 24**       | Langage              | Frais comme mon poisson du matin !                 |
| **Spring Boot 4** | Framework            | Un framework de qualité, pas de la ferraille       |
| **Gradle**        | Build                | Pour construire proprement, pas à coups de marteau |
| **JUnit 5**       | Tests unitaires      | Mes tests sont solides comme mes sardines          |
| **ArchUnit**      | Tests d'architecture | Pour garantir la fraîcheur de l'architecture !     |
| **Records Java**  | Modèles immuables    | Modernes et élégants, comme ma poissonnerie        |

---

## Les Principes de l'Architecture Hexagonale

### 1. Isolation du domaine
Le code métier (dans `domain/`) n'a **aucune dépendance externe**. Pas de Spring, pas de framework. C'est du code pur, comme du poisson frais sans additifs !

### 2. Inversion des dépendances
Les adapters dépendent des ports (interfaces), jamais l'inverse. Le domaine ne connaît que ses propres interfaces !

### 3. Testabilité
Grâce aux interfaces et aux doubles de test, on peut tout tester indépendamment. Mes tests sont verts comme les algues de la mer !

### 4. Validation par ArchUnit
Contrairement à Cétautomatix qui fait confiance à ses biceps, moi j'utilise **ArchUnit** pour GARANTIR que l'architecture est respectée. Mes tests vérifient automatiquement :
- Que le domain ne dépend de rien d'externe
- Que l'API n'utilise que le domain
- Que les adapters sont correctement isolés

---

## La Conférence

Cette application a été créée pour une conférence :

> **L'architecture hexagonale au pays des irréductibles développeurs**
>
> Une conférence épique, pragmatique et pleine d'humour, pour découvrir (ou redécouvrir) l'architecture hexagonale par la pratique !

Présentée par deux irréductibles développeurs :
- **Ordralfabétix** - Version Java, disponible ici même
- **Cétautomatix** - Version Go, disponible [ici](https://github.com/nathancastelein/go-architecture-hexagonale-gaule)

Les deux rivaux explorent les concepts fondamentaux de l'architecture hexagonale et mettent en lumière, à travers des implémentations concrètes en Java et en Go, les différences d'approche selon les écosystèmes !

---

## Contribution

Si vous voulez contribuer, n'hésitez pas ! Mais attention :
- Du code propre et bien structuré, pas du bricolage de forgeron
- Des tests, avec ArchUnit pour vérifier l'architecture
- Respectez la fraîcheur du domain !

---

*"Ils sont fous ces Romains !" - Obélix*

*"Ils sont fous ces développeurs qui n'utilisent pas l'architecture hexagonale !" - Ordralphabétix*

---

**Fait avec la fraîcheur de Lutèce par Ordralfabétix, poissonnier et développeur Java du village gaulois**

## L'Exercice du Barde — Assurancetourix s'en mêle !

*"Tais-toi, Assurancetourix !" - Tout le village*

Bien. Le gestionnaire de potions fonctionne. Panoramix retrouve ses recettes. Le village est sauvé.

Mais voilà qu'Assurancetourix, le barde du village, réclame sa place dans l'application.
Et pour une fois, il a raison.

### L'objectif

Intégrer un domaine `barde/` et le brancher sur le domaine `druide/` existant **sans toucher au cœur du domaine druide**.
Comme quand on prépare une nouvelle sauce sans changer la recette du poisson — c'est tout l'art de l'architecture hexagonale !

**Implémenter les règles métier du Druide**

- Lorsque la potion est préparée, le duide doit informer le village avec un niveau `NORMAL`
- Si le duide n'a pas réussi à préparer la potion, il doit informer le village avec un niveau `URGENT`
- Si à la fin de la préparation, il manque des ingrédients, il doit informer le village avec un niveau `IMPORTANT`

**Implémenter les règles métier du Barde**

Dans `Assurancetourix` (le service domaine), respecter ces règles :

- `NORMAL` → message diffusé tel quel
- `IMPORTANT` → message en majuscules, précédé de `"⚠️ ATTENTION, BRAVES GAULOIS : "`, répété deux fois
- `URGENT` → message en majuscules, répété trois fois, séparé par `" ! "`

Exemple pour `URGENT` :
```
"les romains arrivent"
→ "LES ROMAINS ARRIVENT ! LES ROMAINS ARRIVENT ! LES ROMAINS ARRIVENT !"