package IA;

import Jeu.Jeu;
import Joueur.Joueur;
import Plateforme.PotCommun;

public class TourSuivantIA {
	
	public static boolean tourSuivantIA(Joueur joueurCourant){
		  
		PotCommun.AjoutTextCommG("\n Tour de l'IA "+joueurCourant.getNomJoueur());
		//  System.out.println("\n Tour de l'IA "+joueurCourant.getNomJoueur());
		 
		  String mot = CreerNouveauMotIA.createNewMotIA();
		  if (mot != null) {
			  PotCommun.AjoutTextCommG("Le mot créé par l'IA : "+mot);
			//  System.out.println("Le mot créé par l'IA : "+mot);
				  joueurCourant.getMontableauDeMot().add(mot);
		}else{
			Joueur joueurAdverse = null;
			for(Joueur joueur : Jeu.getListeDesJoueurs()){
				if(joueur.getNomJoueur() != joueurCourant.getNomJoueur()){
					joueurAdverse = joueur; 
				}
			}
			mot = MettreAJourMotIA.updateMotIA(joueurAdverse);
			if(mot != null && joueurCourant.getMontableauDeMot().contains(mot) == false){
				PotCommun.AjoutTextCommG("Le mot créé par l'IA : "+mot+" a partir d'un mot de l'adversaire.");
				//System.out.println("Le mot créé par l'IA : "+mot+" a partir d'un mot de l'adversaire.");
				  joueurCourant.getMontableauDeMot().add(mot);
			}else{
				PotCommun.AjoutTextCommG("L'IA n'a pas réussi a créer un mot ou à allonger un de vos mots, elle passe son tour.");				
				//System.out.println("L'IA n'a pas réussi a créer un mot ou à allonger un de vos mots, elle passe son tour.");
				return false;
			}

		}
		
		System.out.println("l'IA "+joueurCourant.getNomJoueur()+" marque 1 point.");
		if(joueurCourant.getMontableauDeMot().size() == Jeu.getNbDeMotsPourGagner()){
			return true;
		}
		return false;
	  }

}
