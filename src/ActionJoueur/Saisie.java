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
			saisie = Popup.PopupChoice("Faites votre choix : ");
			
			switch (saisie) {
	    case "Saisir un mot":
	  	  return CreerNouveauMot.creerNouveauMot();
	    case "Completer un mot":
	    	return MettreAJourMot.mettreAJourMot();
	    case "Passer son tour":
	    	if(joueurCourant.getNomJoueur().equals(Lancement.getNameJ1()))
	    		potCommun.AjoutTextComm1("Vous passez votre tour");
	    	else
	    		potCommun.AjoutTextComm2("Vous passez votre tour");
	    	return null;
	    default :
	    	if(joueurCourant.getNomJoueur().equals(Lancement.getNameJ1()))
	    		potCommun.AjoutTextComm1("La valeur saisie n'existe pas !");
	    	else
	    		potCommun.AjoutTextComm2("La valeur saisie n'existe pas !");
	    	return saisie(joueurCourant);
			}
		}
}
