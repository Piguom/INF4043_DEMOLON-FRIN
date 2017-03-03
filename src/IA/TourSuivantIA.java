package IA;

import Jeu.Start;
import Joueur.Joueur;
import Plateforme.PotCommun;

public class TourSuivantIA {
	
	static PotCommun potCommun = Start.potCommun;
	
	public static boolean tourSuivantIA(Joueur joueurCourant){
		  
		potCommun.AjoutTextCommG("\nC'est au tour de l'IA ==> "+joueurCourant.getNomJoueur()+"\n");
		
		  String mot = CreerNouveauMotIA.creerNouveauMotIA();
		  if (mot != null) {
			  potCommun.AjoutTextCommG("\nMot cree par l'IA : "+mot);
				  joueurCourant.getMontableauDeMot().add(mot);
		}else{
			Joueur joueurAdverse = null;
			for(Joueur joueur : Start.getListeDesJoueurs()){
				if(joueur.getNomJoueur() != joueurCourant.getNomJoueur()){
					joueurAdverse = joueur; 
				}
			}
			mot = MettreAJourMotIA.mettreAJourMotIA(joueurAdverse);
			if(mot != null && joueurCourant.getMontableauDeMot().contains(mot) == false){
				potCommun.AjoutTextCommG("\nLe mot : "+mot+" a ete cree a partir d'un mot de l'adversaire par l'IA");
				  joueurCourant.getMontableauDeMot().add(mot);
			}else{
				potCommun.AjoutTextCommG("\nL'IA passe son tour.");	
				return false;
			}

		}
		
		  potCommun.AjoutTextCommG("\nL'IA : "+joueurCourant.getNomJoueur()+" marque 1 point.");
		if(joueurCourant.getMontableauDeMot().size() == Start.getScorePourGagner()){
			return true;
		}
		return false;
	  }

}
