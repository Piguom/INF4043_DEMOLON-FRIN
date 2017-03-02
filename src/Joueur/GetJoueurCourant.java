package Joueur;

import java.util.ArrayList;

import Jeu.Start;

public class GetJoueurCourant extends Joueur{	
	
	  public static Joueur getJoueurCourant(){
		  int joueurCourant = Start.joueurQuiJoue;
		  ArrayList<Joueur> listeDesJoueurs = Start.getListeDesJoueurs();
		  
		  if(joueurCourant >= listeDesJoueurs.size()){
			  joueurCourant = 0;
		  }
		  Joueur joueurQuiJoue = listeDesJoueurs.get(joueurCourant);
		  joueurCourant++;
		  return joueurQuiJoue;
	  }
}

