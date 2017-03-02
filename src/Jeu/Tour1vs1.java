package Jeu;

import java.util.ArrayList;

import IA.TourSuivantIA;
import Joueur.Joueur;
import Plateforme.Lancement;
import Plateforme.PotCommun;
import Sac.Sac;
import Tapis.Tapis;

public class Tour1vs1 {
	
	Joueur joueurActuel;
	Tapis tapis;
	Sac sac;
	ArrayList<Joueur> joueurs;
	PotCommun potCommun;
	
	public Tour1vs1(Joueur joueurActuel){
		tapis = Start.tapis;
		sac = Start.sac;
		joueurs = Start.joueurs;
		potCommun = Start.potCommun;
		this.joueurActuel = joueurActuel;
	}
	
	public boolean tourAvecAuMoinsUnPasIA(){
		//On le fait 2 fois pour avoir 2 lettres
		tapis.add(sac.generateRandomChar());
		tapis.add(sac.generateRandomChar());
		
		for(Joueur joueur : Start.joueurs){
			if(joueur.getNomJoueur().equals(Lancement.getNameJ1()))
				potCommun.AjoutTextComm1("\n"+joueur.toString()+"\n");
	    	else
	    		potCommun.AjoutTextComm2("\n"+joueur.toString()+"\n");
		  }
	  
		potCommun.AjoutTextCommG("\nPot commun :"+ Tapis.tapis.toString());
	  
		if(joueurActuel.isIA() == true)
			return TourSuivantIA.tourSuivantIA(joueurActuel);
		else{
			potCommun.AjoutTextCommG("\n Tour de "+joueurActuel.getNomJoueur()+"\n");
			String mot = Saisie.saisie(joueurActuel);
		  if (mot != null && joueurActuel.getMontableauDeMot().contains(mot) == false) {
			  joueurActuel.getMontableauDeMot().add(mot);
			  potCommun.AjoutTextCommG("\n"+joueurActuel.getNomJoueur()+" marque 1 point.");						
			  if(joueurActuel.getMontableauDeMot().size() == Start.getScorePourGagner()){
				  return true;
			  }
		  }
		  return false;
	  }
	}
}
