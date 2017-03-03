package Jeu;

import java.util.ArrayList;

import ActionJoueur.Saisie;
import IA.TourSuivantIA;
import Joueur.Joueur;
import Plateforme.Lancement;
import Plateforme.PotCommun;
import Sac.Sac;
import Tapis.Tapis;

public class Tour1vs1 {
	
	Joueur joueurActuel= Start.getJoueurCourant();
	Tapis tapis= Start.tapis;
	Sac sac= Start.sac;
	ArrayList<Joueur> joueurs= Start.joueurs;
	PotCommun potCommun= Start.potCommun;
	int joueurCourant = Start.joueurQuiJoue;
	
	public Tour1vs1(){}
	
	public boolean tourAvecAuMoinsUnPasIA(){
		//On le fait 2 fois pour avoir 2 lettres
		tapis.add(sac.genererNombreAleatoire());
		
		for(Joueur joueur : joueurs){
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
