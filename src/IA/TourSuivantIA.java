package IA;

import Jeu.Start;
import Joueur.Joueur;
import Plateforme.PotCommun;

public class TourSuivantIA {
	
	static PotCommun potCommun = Start.potCommun;
	
	public static boolean tourSuivantIA(Joueur joueurCourant){
		  
		potCommun.AjoutTextCommG("\n Tour de l'IA "+joueurCourant.getNomJoueur());
		//  System.out.println("\n Tour de l'IA "+joueurCourant.getNomJoueur());
		 
		  String mot = CreerNouveauMotIA.createNewMotIA();
		  if (mot != null) {
			  potCommun.AjoutTextCommG("Le mot cree par l'IA : "+mot);
			//  System.out.println("Le mot cree par l'IA : "+mot);
				  joueurCourant.getMontableauDeMot().add(mot);
		}else{
			Joueur joueurAdverse = null;
			for(Joueur joueur : Start.getListeDesJoueurs()){
				if(joueur.getNomJoueur() != joueurCourant.getNomJoueur()){
					joueurAdverse = joueur; 
				}
			}
			mot = MettreAJourMotIA.updateMotIA(joueurAdverse);
			if(mot != null && joueurCourant.getMontableauDeMot().contains(mot) == false){
				potCommun.AjoutTextCommG("Le mot cree par l'IA : "+mot+" a partir d'un mot de l'adversaire.");
				//System.out.println("Le mot cr�� par l'IA : "+mot+" a partir d'un mot de l'adversaire.");
				  joueurCourant.getMontableauDeMot().add(mot);
			}else{
				potCommun.AjoutTextCommG("L'IA n'a pas r�ussi a cr�er un mot ou � allonger un de vos mots, elle passe son tour.");				
				//System.out.println("L'IA n'a pas r�ussi a cr�er un mot ou � allonger un de vos mots, elle passe son tour.");
				return false;
			}

		}
		
		  potCommun.AjoutTextCommG("\nl'IA "+joueurCourant.getNomJoueur()+" marque 1 point.");
		//System.out.println("l'IA "+joueurCourant.getNomJoueur()+" marque 1 point.");
		if(joueurCourant.getMontableauDeMot().size() == Start.getScorePourGagner()){
			return true;
		}
		return false;
	  }

}
