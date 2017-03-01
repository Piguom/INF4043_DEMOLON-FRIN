package Joueur;

import javax.swing.text.BadLocationException;

import Jeu.Jeu;
import Jeu.Saisie;
import Plateforme.PotCommun;

public class TourSuivant {
	
	public TourSuivant(){
		tourSuivant();
	}
	
	public static boolean tourSuivant(){
		Joueur joueurCourant = getJoueurCourant();
		  Jeu.tapis.add(Jeu.sacDeLettres.generateRandomChar());
		  Jeu.tapis.add(Jeu.sacDeLettres.generateRandomChar());
		  
		  for (Joueur joueur : Jeu.listeDesJoueurs) {
			  PotCommun.AjoutTextCommG("\n"+joueur.toString()+"\n");
				//System.out.println(joueur.toString());
			  }
		  try {
			PotCommun.commG.getDocument().insertString(0, "\nPot commun :"+ Jeu.tapis.toString()+"\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // System.out.println("Pot commun :"+ Jeu.tapis.toString());
		  
		  if(joueurCourant.isIA() == true){
			  return IA.TourSuivantIA.tourSuivantIA(joueurCourant);
		  }else{
			  try {
				PotCommun.commG.getDocument().insertString(0, "\n Tour de "+joueurCourant.getNomJoueur()+"\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 // System.out.println("\n Tour de "+joueurCourant.getNomJoueur());
			  String mot = Saisie.saisie();
			  if (mot != null && joueurCourant.getMontableauDeMot().contains(mot) == false) {
					  joueurCourant.getMontableauDeMot().add(mot);
					  PotCommun.AjoutTextCommG("\n"+joueurCourant.getNomJoueur()+" marque 1 point.");						
					 // System.out.println(joueurCourant.getNomJoueur()+" marque 1 point.");
					  if(joueurCourant.getMontableauDeMot().size() == Jeu.getNbDeMotsPourGagner()){
						  return true;
					  }
			}
			return false;
		  }
	}
	
	public static Joueur getJoueurCourant(){
		  
		  if(Jeu.joueurCourant >= Jeu.listeDesJoueurs.size()){
			  Jeu.joueurCourant = 0;
		  }
		  
		  Joueur joueurCourant = Jeu.listeDesJoueurs.get(Jeu.joueurCourant);
		  Jeu.joueurCourant ++;
		  return joueurCourant;
	  }
}
