package Jeu;

import java.util.Scanner;

import Joueur.Joueur;
import Joueur.TourSuivant;
import Plateforme.Lancement;
import Plateforme.Popup;
import Plateforme.PotCommun;

public class Saisie {

	static Scanner scanner = new Scanner(System.in);
	
	  public static String saisie(){
	    	Joueur joueurCourant = TourSuivant.getJoueurCourant();
		//	System.out.println("1 : saisir un mot , 2 : completer un mot , 3: passer son tours.");
		//	System.out.println("Faite votre choix : ");
			String saisie;
			saisie = Popup.PopupChoice("Faites votre choix : ");
			
			switch (saisie) {
	    case "Saisir un mot":
	  	  return Mot.createNewMot();
	    case "Compléter un mot":
	    	return Mot.updateMot();
	    case "Passer son tour":
	    	if(joueurCourant.toString() == Lancement.getNameJ1())
	    		PotCommun.AjoutTextComm1("Vous passez votre tour");
	    	else
	    		PotCommun.AjoutTextComm2("Vous passez votre tour");
	    	//System.out.println("Vous passez votre tours");
	    	return null;
	    default :  
	    	if(joueurCourant.toString() == Lancement.getNameJ1())
	    		PotCommun.AjoutTextComm1("La valeur saisie n'existe pas !");
	    	else
	    		PotCommun.AjoutTextComm2("La valeur saisie n'existe pas !");
	    	//System.out.println("La valeur saisie n'existe pas !");
	    	return saisie();
			}
		}
}
