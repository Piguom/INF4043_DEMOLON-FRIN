package Jeu;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Plateforme.Popup;
import Plateforme.PotCommun;
import Tapis.Tapis;

public class Mot {
	
	static Dictionnaire dico = new Dictionnaire();
	static PotCommun potCommun = Start.potCommun;
	
	 public static String createNewMot(){
		  String mot = Popup.PopupInput("Entrer votre mot : ");
		  if(dico.motValide(Tapis.tapis,mot) && dico.isWord(mot)){
			  Tapis.removeMotToTapis(mot);
			  return mot;
		  }else{
			  potCommun.AjoutTextCommG("Le mot "+mot+" n'est pas valide ou n'existe pas.");
			// System.out.println("Le mot "+mot+" n'est pas valide ou n'existe pas.");
			  return null;
		}
	  }
	  
	  public static String updateMot(){
		 // Scanner sc = new Scanner(System.in);
		 // System.out.println("Entrez le mot a completer :");
		  String motACompleter = Popup.PopupInput("Entrer le mot � compl�ter : ");
		  Joueur joueurAdverse = Start.getJoueurWhereMotExist(motACompleter);
		  if(joueurAdverse != null){
			  //System.out.println("Le mot existe dans une des liste des joueurs, entrez le nouveau mot : ");
			  String nouveauMot = Popup.PopupInput("Le mot existe dans une des liste des joueurs, entrez le nouveau mot : ");
			  if(nouveauMot.contains(motACompleter)){
				  Tapis.addMotToTapis(motACompleter);
				  if(dico.motValide(Tapis.tapis,nouveauMot) == false  || dico.isWord(nouveauMot) == false){
					  potCommun.AjoutTextCommG("Le nouveau mot n'existe pas.");
					 // System.out.println("Le nouveau mot n'existe pas.");
					  Tapis.removeMotToTapis(motACompleter);
					  return null;
				  }else{
					  joueurAdverse.getMontableauDeMot().remove(motACompleter);
					  Tapis.removeMotToTapis(nouveauMot);
				  }
				  return nouveauMot;
			  }else{
				  potCommun.AjoutTextCommG("Le mot � completer ne contient pas le mot de base");
				  //System.out.println("Le mot � completer ne contient pas le mot de base");
				  return null;
			  }
		  }
		  potCommun.AjoutTextCommG("Aucun joueurs n'a d�ja fait ce mot.");
		 // System.out.println("Aucun joueurs n'a d�ja fait ce mot.");
		  return null;
	  } 
}
