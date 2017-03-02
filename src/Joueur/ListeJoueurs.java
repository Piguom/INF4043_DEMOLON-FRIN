package Joueur;

import java.util.ArrayList;

public class ListeJoueurs {
	
	 public static ArrayList<Joueur> listeDesJoueurs;
	 
	 public ListeJoueurs(){
		 listeDesJoueurs = new ArrayList<Joueur>();
	 }	
	
	public void setListeDesJoueurs(ArrayList<Joueur> listeDesJoueurs) {
		ListeJoueurs.listeDesJoueurs = listeDesJoueurs;
	}

}
