# Kata Archi Hexagonale - Assurancetourix

La potion est bien créée mais nous avons maintenant besoin de prévenir le village de sa confection afin de limiter le TTM (Time To Mettre une branlée aux romains)

L'intégration du barde doit se faire selon les règles du village (cf : [replay de la conf à Touraine Tech](https://www.youtube.com/watch?v=6m_oWe85_3s) 
* Tu isoleras ton code métier au coeur de ton application
* Tu limiteras les portes de ton application
* Tu repousseras les choix techniques
* Tu faciliteras la testabilité de ton système

## Exercice : Intégrer Assurancetourix pour prévenir le village

Il est préférable de réaliser l'exercice en TDD.

### Partie 1 : Le Barde entre en scène

Créer un domaine Barde  
Un Barde expose le Port Primaire `chanter` : `public String chanter(String texte)`  
Implémenter Assurancetourix qui chante à sa façon :   
* Assurancetourix chante dans sur la sortie standard (print) et dans le retour de la fonction  
* Assurancetourix commence par accorder sa lyre et faire des vocalises : `*accorde sa lyre* PLING PLONG… *s'éclaircit la voix* Hum hum… MI-MI-MIIIIII...`  
* Assurancetourix déclame le texte demandé tel quel pour ne pas se faire ligoter  
* Assurancetourix fini par un son caractéristique lyrique : `... LAAAAAAA !!`  

### Partie 2 : Besoin d'un Notificateur

Faire émerger la notion de Notificateur (Port Secondaire de Panoramix) dans le Domaine Druide  
Le Notificateur doit notifier : `public void notifier(String message)`  
Le Notificateur doit être appelé lorsque la potion est servie avec un message explicitant que la potion est prête et remplacer l'actuel message écrit par le druide.  

### Partie 3 : Branchement

Créer un adapteur permettant de notifier le village au travers d'Assurancetourix lorsque la potion est prête !  

### Partie 4 : Créer un test d'intégration (Bonus)

Au travers d'un test d'intégration démarrant toute l'application, valider sur un appel que le barde chante bien lorsque la potion magique est servie !  

