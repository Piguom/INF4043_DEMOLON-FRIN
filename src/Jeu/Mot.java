package Jeu;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Plateforme.Popup;
import Plateforme.PotCommun;
import Tapis.Tapis;

public class Mot {
	
	static Dictionnaire dico = new Dictionnaire();
	static PotCommun potCommun = Start.potCommun;
	
	 public static String creerNouveauMot(){
		  String mot = Popup.PopupInput("Entrer votre mot : ");
		  if(dico.motValide(Tapis.tapis,mot) && dico.isWord(mot)){
			  Tapis.removeMotToTapis(mot);
			  return mot;
		  }else{
			  potCommun.AjoutTextCommG("\nLe mot "+mot+" n'est pas valide ou n'existe pas.");
			  return null;
		}
	  }
	  
	  public static String mettreAJourMot(){
		  String motACompleter = Popup.PopupInput("Entrer le mot a completer : ");
		  Joueur joueurAdverse = Start.getJoueurWhereMotExist(motACompleter);
		  if(joueurAdverse != null){
			  String nouveauMot = Popup.PopupInput("Le mot existe dans une des liste des joueurs, entrez le nouveau mot : ");
			  if(nouveauMot.contains(motACompleter)){
				  Tapis.addMotToTapis(motACompleter);
				  if(dico.motValide(Tapis.tapis,nouveauMot) == false  || dico.isWord(nouveauMot) == false){
					  potCommun.AjoutTextCommG("Le nouveau mot n'existe pas.");
					  Tapis.removeMotToTapis(motACompleter);
					  return null;
				  }else{
					  joueurAdverse.getMontableauDeMot().remove(motACompleter);
					  Tapis.removeMotToTapis(nouveauMot);
				  }
				  return nouveauMot;
			  }else{
				  potCommun.AjoutTextCommG("Le mot � completer ne contient pas le mot de base");
				  return null;
			  }
		  }
		  potCommun.AjoutTextCommG("Aucun joueurs n'a d�ja fait ce mot.");
		  return null;
	  } 
}
