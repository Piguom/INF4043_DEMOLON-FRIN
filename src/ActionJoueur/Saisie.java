package ActionJoueur;

import Jeu.Start;
import Joueur.Joueur;
import Plateforme.Lancement;
import Plateforme.Popup;
import Plateforme.PotCommun;

public class Saisie{
	
	static PotCommun potCommun;
	
	  public static String saisie(Joueur joueurCourant){
		  potCommun = Start.potCommun;
			String saisie;
			saisie = Popup.PopupChoice("Choisissez : ");
			
			switch (saisie) {
	    case "Saisir un mot":
	  	  return CreerNouveauMot.creerNouveauMot();
	    case "Completer un mot":
	    	return MettreAJourMot.mettreAJourMot();
	    case "Passer son tour":
	    	if(joueurCourant.getNomJoueur().equals(Lancement.getNameJ1()))
	    		potCommun.AjoutTextComm1("\nVous avez passer le tour");
	    	else
	    		potCommun.AjoutTextComm2("\nVous avez passer le tour");
	    	return null;
	    default :
	    	if(joueurCourant.getNomJoueur().equals(Lancement.getNameJ1()))
	    		potCommun.AjoutTextComm1("\nSaisie inconne !");
	    	else
	    		potCommun.AjoutTextComm2("\nSaisie inconne !");
	    	return saisie(joueurCourant);
			}
		}
}
