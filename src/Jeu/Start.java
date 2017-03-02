package Jeu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Plateforme.PotCommun;
import Sac.Sac;
import Tapis.Tapis;

public class Start {
	
	/*Initialisation des variables*/
	static Dictionnaire dictionnaire;
	static Sac sac;
	static Tapis tapis;
	static String joueur1, joueur2;
	static int score,joueurQuiJoue;
	static Joueur player1,player2;
	static ArrayList<Joueur> joueurs;
	public static PotCommun potCommun;
	static Tour1vs1 tourUnvUn;
	
	/*Données pour le choix du premier joueur qui jouera*/
	char lettre1,lettre2;
	
	/*Booléen de décision de fin du jeu*/
	boolean finDuGame;
	
	public Start(int score){
		dictionnaire = new Dictionnaire();
		sac = new Sac();
		tapis = new Tapis();
		Start.score = score;
		joueurQuiJoue = 0;
		joueurs = new ArrayList<Joueur>();
		tourUnvUn = new Tour1vs1(getJoueurQuiJoue());
	}
	
	public void initialisation(String joueur1, String joueur2){
		Start.joueur1 = joueur1;
		Start.joueur2 = joueur2;
		
		//Enregistrement des joueurs
		player1 = new Joueur();
		player1.setNomJoueur(joueur1);
		  
		player2 = new Joueur();
		player2.setNomJoueur(joueur2);
		
		choixPremierJoueur();
		choixJoueurIA();
		jeuCommence();
		finDuGame();
	}
	
	public void choixPremierJoueur(){
		lettre1 = sac.generateRandomChar();
		lettre2 = sac.generateRandomChar();
		
		if(sac.testCharIsBetter(lettre1, lettre2)){
			joueurs.add(player1);
			joueurs.add(player2);
		}else{
			joueurs.add(player2);
			joueurs.add(player1);
		}
		
		tapis.add(lettre1);
		tapis.add(lettre2);
	}
	
	public void choixJoueurIA(){
		int choixIA;
		for(Joueur joueur : joueurs){
			choixIA = JOptionPane.showConfirmDialog(null,"Vous voulez que "+joueur.getNomJoueur()+" soit une IA ?", "Choix de l'IA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(choixIA == JOptionPane.OK_OPTION)
				joueur.setIA(true);
		}		  
	}
	
	public void jeuCommence(){
		potCommun = new PotCommun(joueur1, joueur2);
		potCommun.DefaultFrame();
		
		finDuGame = false;
		
		while(finDuGame == false){
			finDuGame = tourUnvUn.tourAvecAuMoinsUnPasIA();
		}
	}
	
	public void finDuGame(){
		potCommun.AjoutTextCommG("Fin du jeu");
		
		for(int i = 0;i < Start.getListeDesJoueurs().size();i++){
			if(Start.getListeDesJoueurs().get(i).getMontableauDeMot().size() == Start.getScorePourGagner()){
				potCommun.AjoutTextCommG(Start.getListeDesJoueurs().get(i).toString());
				potCommun.AjoutTextCommG("\nLe joueur : "+Start.getListeDesJoueurs().get(i).getNomJoueur()+" gagne !\n");
			}
		}
		potCommun.AjoutTextCommG("\n\nGame Over.\n\n");
	}
	
	/*Fonctions supplémentaire pour le bon déroulement des précédentes*/

	public Joueur getJoueurQuiJoue(){
		if(Start.joueurQuiJoue >= Start.joueurs.size()){
			Start.joueurQuiJoue = 0;
		}
		  
		Joueur joueurCourant = Start.joueurs.get(Start.joueurQuiJoue);
		Start.joueurQuiJoue ++;
		return joueurCourant;
	}
	
	public static ArrayList<Joueur> getListeDesJoueurs() {
		return joueurs;
	}	
	 
	public static int getScorePourGagner(){
		return score;
	}
	  
	public static Joueur getJoueurWhereMotExist(String mot){
		for(Joueur joueur : Start.getListeDesJoueurs()){
			for (String motDeLaListe : joueur.getMontableauDeMot()){
				if(motDeLaListe.equals(mot)){
					return joueur;
				}
			}
		}
		return null;
	} 
}
