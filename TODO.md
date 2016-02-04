## TODO

(Liste non exhaustive de ce qu'il reste à faire)

Quand une tâche est faite, merci d'écrire DONE devant et de ne pas l'effacer.

# Background 

* Créer un scénario : Si le temps le permet, on pourra envisager plusieurs scénarios et fin possibles, mais pour le moment, il vaut mieux avoir toutes les fonctionnalités. On pourra peut-être aussi envisager une partie du scénario aléatoire. 

# Developpement Model

* [DONE] L'utilisateur créer son personnage au début de la partie. Il choisit la classe et le pseudo. Lors de sa création, la santé Max et les caractéristiques sont automatiquement calculés en fonction de la classe choisit. 

* [DONE] Implémenter les containtes et caractéristiques des différentes classes lors de la création du personnage par le joueur. 

* [EN COURS PAR LOICK] Réequilibrer les valeurs concernants les caractéristiques des différentes classes.

* [DONE] La santé diminue lorsque le personnage est blessé au combat. Elle peut augmenter si le personnage se soigne.

* [DONE] Le niveau d'expérience augmente lorsqu'un combat est gagné. 

* [DONE] Quand le personnage gagne un niveau, il dispose d'un point de compétence à attribuer quelque part dans ces compétences. (voir Dev. View pour afficher une fenêtre spécifique). <<< Fenêtre et Assignation (Views + Controllers) existent mais ils faut tout relier ensemble (Model) >>> 

* [OPTION] Pour rendre le jeu équitable, une contrainte commune à tous les personnages doit être vérifier. Exemple : la somme des caractéristiques de base ne dois pas exceder une certaine valeur. (VOIR SUJET DU PROF).  

* Gérer la sauvegarde EN BINAIRE (Sérialisation + déserialisation). 

* [DONE] Le personnage peut récupérer du stuff. Dans ce cas, l'objet est ajouté au sac du joueur et/ou équipé. S'il est mis dans le sac, la poids disponible du sac est mis à jours. Le poids maximum supporté ne peut pas être dépassé. De base, le joueur peut être équipé de une arme, une armure et des bottes. Il faut également gérer la suppression d'items du sac si il est plein et que l'on veut ajouter un objet.

* Si le joueur utilise un consommable, l'objet est détruit et les stats du joueur sont mis à jour en conséquence.
    - En combat
    - [DONE] En dehors d'un combat

* [DONE] La vie du joueur se met à jour quand il est attaqué pendant un combat.

* [DONE] Utilisation d'une capacité : 
    1. Vérifier qu'elle est réussite (proba de réussite). Cette probabilité dépend des caractéristiques du personnage (?) et de ses points de compétences. 
    2. Si la capacité est réussie : 
        - Calculer les dégats occasionés (force de l'attaquant + valeur de dégats de l'arme) : DEG
        - Calculer la défense du personnage attaqué (Défense + résistance des armures) : DEF
        - Calculer les dommages (DEG - DEF)
        - Soustraire les dommages subis à la santé du personnage attaqué

* [DONE] Après chaque combat, la santé du joueur est réinitialisée (mais pas au maximum). 

* Actions disponibles pendant un combat : 
    - [DONE] Capacité(s)
    - Utiliser un consomable
    
* [DONE] Si le personnage arrive à 0 de vie, la partie est terminée (cd. View).

* [DONE] A la fin du combat (en cas de victoire), le joueur gagne de l'xp. 

* [DONE] Un combat oppose plusieurs personnages à plusieurs personnages.

* [DONE] Evenements possibles ([OPTION] aléatoires ou prédéfinis) :
    - [DONE] Combat contre un enemis ([DONE] plusieurs)
    - [DONE] Découverte d'un endroit avec du stuff
    - Autres (?)
    
* [DONE] Implémenter l'IA pour les combats.

# Developpement View

* [DONE, class KeyboardInput] Refactoring de l'ensemble des vues (principalement isValid et le Scanner...)

* [OPTION] "help" : donne toutes les commandes possibles au joueur. 

* [DONE]Prévoir "une fenêtre" pour attribuer un point de compétence lors du gain de niveau.

* [DONE]Prévoir "une fenêtre" pour visualiser et gérer le contenu du sac à dos.  

* [DONE]Prévoir "une fenêtre" pour visualiser un combat au tour par tour.

* [OPTION] Si le joueur tape une commande qui n'est pas prise en charge, "commande non reconnue" apparait et le jeu se poursuit. 

* [DONE] Prévoir "une fenêtre" pour visualiser la mort du personnage, et la fin de la partie.

# Autres

* [DONE] Créer un fichier UML Complet et à jour du projet.

* [EN COURS] Créer une Javadoc complète pour le projet.

* [EN COURS] Prévoir une "présentation" du jeu pour le 14 JAN 2016.
