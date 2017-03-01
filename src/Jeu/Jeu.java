package Jeu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Joueur.TourSuivant;
import Plateforme.PotCommun;
import Sac.Sac;

public class Jeu {

	  private static Dictionnaire dico;
	  public static Sac sacDeLettres;
	  public static ArrayList<Joueur> listeDesJoueurs;
	  public static ArrayList<Character> tapis;
	  public static int joueurCourant;
	  public static int nbDeMotsPourGagner;
	  JOptionPane ia = new JOptionPane();
	  String j1, j2;
	  
	  public Jeu (int nbDeMots){
	    Jeu.dico = new Dictionnaire();
	    Jeu.sacDeLettres = new Sac();
	    Jeu.listeDesJoueurs = new ArrayList<Joueur>();
	    Jeu.tapis = new ArrayList<Character>();
	    Jeu.joueurCourant = 0;
	    Jeu.nbDeMotsPourGagner = nbDeMots;
	  }
	  
	  public void init(String j1, String j2){
		  
		  this.j1 = j1;
		  this.j2 = j2;
		  
		  Joueur joueur1 = new Joueur();
		  joueur1.setNomJoueur(j1);
		  
		  Joueur joueur2 = new Joueur();
		  joueur2.setNomJoueur(j2);
		  
		  char lettreDuJoueur1 = Jeu.sacDeLettres.generateRandomChar();
		  char lettreDuJoueur2 = Jeu.sacDeLettres.generateRandomChar();
		  
		 
		  if(Jeu.sacDeLettres.testCharIsBetter(lettreDuJoueur1,lettreDuJoueur2)){
			  Jeu.listeDesJoueurs.add(joueur1);
			  Jeu.listeDesJoueurs.add(joueur2);
		  }else{
			  Jeu.listeDesJoueurs.add(joueur2);
			  Jeu.listeDesJoueurs.add(joueur1);
		  }
		  
		  Jeu.tapis.add(lettreDuJoueur1);
		  Jeu.tapis.add(lettreDuJoueur2);
		  
		  for(Joueur joueur : listeDesJoueurs){
			  int choiceIA = JOptionPane.showConfirmDialog(null,"Vous voulez que "+joueur.getNomJoueur()+" soit une IA ?", "Choix de l'IA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			  if(choiceIA == JOptionPane.OK_OPTION)
				  joueur.setIA(true);
		  }		  
		  debutDeJeu();
	  }
	  
	  public void debutDeJeu(){
	  
		  new PotCommun(j1, j2);
		  PotCommun.DefaultFrame();
		  
		  boolean endGame = false;
		  while(endGame == false){
			  endGame = TourSuivant.tourSuivant();
		  }
		  
		  FinDuJeu.finDuJeu();
	  }
	  
	  public static Joueur getJoueurWhereMotExist(String mot){
		  for(Joueur joueur : Jeu.getListeDesJoueurs()){
			  for (String motDeLaListe : joueur.getMontableauDeMot()){
				   if(motDeLaListe.equals(mot)){
					   return joueur;
				   }
			   }
		  }
		  return null;
	  }  
	  
	  public Dictionnaire getDico() {
		  return dico;
	  }
		
		public Sac getSacDeLettres() {
			return sacDeLettres;
		}
		
		public static ArrayList<Joueur> getListeDesJoueurs() {
			return listeDesJoueurs;
		}
		
		public ArrayList<Character> getTapis() {
			return tapis;
		}
		
		public void setDico(Dictionnaire dico) {
			Jeu.dico = dico;
		}
		
		public void setSacDeLettres(Sac sacDeLettres) {
			Jeu.sacDeLettres = sacDeLettres;
		}
		
		public void setListeDesJoueurs(ArrayList<Joueur> listeDesJoueurs) {
			Jeu.listeDesJoueurs = listeDesJoueurs;
		}
		
		public static int getNbDeMotsPourGagner(){
			return nbDeMotsPourGagner;
		}
}
