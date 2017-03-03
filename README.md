# INF4043_DEMOLON-FRIN - Jeu de Lettres

Ce jeu a été développé par 2 étudiants en 4ème année d'école d'ingénieur (ESIEA) pour un cours d'Architecture Logiciel (INF4043).

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
Pour faciliter :

les lettres possibles sont uniquement les 26 de l'alphabet (ex : é <-> e)
les mots composés sont considérés comme deux mots
Pour les plus avancés :

Le cas des anagrammes :
On peut voler un mot en faisant un anagramme uniquement si il n'a pas déjà été fait. Bien entendu, faire un anagramme permet de tirer une nouvelle lettre.
