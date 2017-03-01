package Jeu;

import java.util.Scanner;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Plateforme.Popup;
import Plateforme.PotCommun;

public class Mot {
	
	static Dictionnaire dico = new Dictionnaire();
	
	 public static String createNewMot(){
		  //Scanner sc = new Scanner(System.in);
		  //System.out.println("Entrez votre mot :");
		  String mot = Popup.PopupInput("Entrer votre mot : ");
		  if(dico.motValide(Jeu.tapis,mot) && dico.isWord(mot)){
			  Tapis.removeMotToTapis(mot);
			  return mot;
		  }else{
			  PotCommun.AjoutTextCommG("Le mot "+mot+" n'est pas valide ou n'existe pas.");
			// System.out.println("Le mot "+mot+" n'est pas valide ou n'existe pas.");
			  return null;
		}
	  }
	  
	  public static String updateMot(){
		 // Scanner sc = new Scanner(System.in);
		 // System.out.println("Entrez le mot a completer :");
		  String motACompleter = Popup.PopupInput("Entrer le mot à compléter : ");
		  Joueur joueurAdverse = Jeu.getJoueurWhereMotExist(motACompleter);
		  if(joueurAdverse != null){
			  //System.out.println("Le mot existe dans une des liste des joueurs, entrez le nouveau mot : ");
			  String nouveauMot = Popup.PopupInput("Le mot existe dans une des liste des joueurs, entrez le nouveau mot : ");
			  if(nouveauMot.contains(motACompleter)){
				  Tapis.addMotToTapis(motACompleter);
				  if(dico.motValide(Jeu.tapis,nouveauMot) == false  || dico.isWord(nouveauMot) == false){
					  PotCommun.AjoutTextCommG("Le nouveau mot n'existe pas.");
					 // System.out.println("Le nouveau mot n'existe pas.");
					  Tapis.removeMotToTapis(motACompleter);
					  return null;
				  }else{
					  joueurAdverse.getMontableauDeMot().remove(motACompleter);
					  Tapis.removeMotToTapis(nouveauMot);
				  }
				  return nouveauMot;
			  }else{
				  PotCommun.AjoutTextCommG("Le mot à completer ne contient pas le mot de base");
				  //System.out.println("Le mot à completer ne contient pas le mot de base");
				  return null;
			  }
		  }
		  PotCommun.AjoutTextCommG("Aucun joueurs n'a déja fait ce mot.");
		 // System.out.println("Aucun joueurs n'a déja fait ce mot.");
		  return null;
	  }
}
