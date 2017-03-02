package IA;

import Jeu.Start;
import Joueur.Joueur;
import Plateforme.PotCommun;

public class TourSuivantIA {
	
	static PotCommun potCommun = Start.potCommun;
	
	public static boolean tourSuivantIA(Joueur joueurCourant){
		  
		potCommun.AjoutTextCommG("\n Tour de l'IA "+joueurCourant.getNomJoueur());
		
		  String mot = CreerNouveauMotIA.creerNouveauMotIA();
		  if (mot != null) {
			  potCommun.AjoutTextCommG("\nLe mot cree par l'IA : "+mot);
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
				potCommun.AjoutTextCommG("\nLe mot cree par l'IA : "+mot+" a partir d'un mot de l'adversaire.");
				  joueurCourant.getMontableauDeMot().add(mot);
			}else{
				potCommun.AjoutTextCommG("\nL'IA n'a pas reussi a creer un mot ou a allonger un de vos mots, elle passe son tour.");	
				return false;
			}

		}
		
		  potCommun.AjoutTextCommG("\nl'IA "+joueurCourant.getNomJoueur()+" marque 1 point.");
		if(joueurCourant.getMontableauDeMot().size() == Start.getScorePourGagner()){
			return true;
		}
		return false;
	  }

}
