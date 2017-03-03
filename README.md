# INF4043_DEMOLON-FRIN - Jeu de Lettres

Ce jeu a été développé par 2 étudiants en 4ème année d'école d'ingénieur (ESIEA) pour un cours d'Architecture Logiciel (INF4043).

<b>Pour lancer le .jar "LetterGame" en ligne de commande ==> <i>java -jar LetterGame.jar</i></b>

#Règles du jeux

- Objectif du jeux :
Le premier joueur ayant 10 mots gagne la partie

- Déroulement du jeux :
Chacun des joueurs tire une lettre aléatoire d'un sac, et les mettent au milieu dans le pot commun
Le joueur qui a tiré la lettre la plus petite lettre dans l'alphabet commence.
Chaque fois que c'est le début du tour d'un joueur il tire deux lettres aléatoires qu'il rajoute au pot commun
Chaque fois qu'un joueur fait un mot il tire une lettre aléatoire qu'il rajoute au pot commun
Quand le joueur ne trouve plus de mot il passe et le joueur suivant commence son tour (par tirer 2 lettres qu'il rajoute au pot commun)

- Comment faire un mot ?

En utilisant uniquement les lettres du pot commun
En prenant un mot de ces adversaires (toutes les lettres du mot) et en lui rajoutant des lettres du pot commun
En rallongeant un de ces mots avec des lettres du pot commun ou en utilisant un autre mot (toutes les lettres)
Attention, seul les noms communs sont autorisés

#Description de chacun des package
- <b>ActionJoueur :</b>
Il instancie les 3 fonctions principales d'un joueur : creer, mettre à jour et saisir un mot.

- <b>Dictionnaire :</b>
Comme son nom l'indique, c'est le package où se trouve le dictionnaire afin de chercher un mot et de vérifier si le mot entré par le joueur est valide ou non.

- <b>IA :</b>
C'est le package qui regroupe toutes les actions possible de l'ordinateur (intelligence artificielle) qui lui permet de jouer son tour normalement (creer et modifier un mot)

- <b>Jeu :</b>
Dans celui-ci se trouvent les 3 classes principales du jeu, le début du jeu, le jeu tour à tour et la fin du jeu.

- <b>Joueur :</b>
Ce package permet d'instancier un joueur, de l'enregistrer dans la liste des participants (maximum 2) et de récupérer le joueur qui est en train de jouer pour le différencier de son adversaire lors de certaines actions.

- <b>Plateforme :</b>
La classe dites "main" se trouve dans celui-ci (Lancement). Ce sont les 4 classes qui permettent l'affichage graphique avec java swing. Il contient les 2 plateformes de jeu (lancement et le tapie ou pot commun) ainsi que les images à charger et les popup qui s'affichent tout le long du jeu.

- <b>RelanceApplication :</b>
Ce package a été rajouter afin de permettre au(x) joueur(s) de relancer une parti "proprement" en killant l'application et en la relançant aussitôt derrière.
Cette classe est quasiement à part des fonctions du jeu.

- <b>Sac :</b>
Il ne contient qu'une seule classe qui permet aux joueurs de tirer la première lettre du jeu afin de déterminer qui sera le premier à jouer entre les 2.

- <b>Tapis :</b>
Cette classe permet d'ajouter, retirer une ou des lettres du pot commun afin de les distribuer dans le camp qui va bien afin de (re)former des mots. Ceux-ci sont alors afficher dans la liste des mots du joueur venant de jouer.
