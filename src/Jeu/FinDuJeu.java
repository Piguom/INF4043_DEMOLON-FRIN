package Jeu;

import Plateforme.PotCommun;

public class FinDuJeu {
	 public static void finDuJeu(){
		 PotCommun.AjoutTextCommG("Fin du jeu");
		 //System.out.println("Fin du jeu.");
		  for(int i = 0;i < Jeu.getListeDesJoueurs().size();i++){
			  if(Jeu.getListeDesJoueurs().get(i).getMontableauDeMot().size() == Jeu.getNbDeMotsPourGagner()){
					 PotCommun.AjoutTextCommG(Jeu.getListeDesJoueurs().get(i).toString());
					 PotCommun.AjoutTextCommG("Le joueur : "+Jeu.getListeDesJoueurs().get(i).getNomJoueur()+" gagne !");
				 // System.out.println(Jeu.getListeDesJoueurs().get(i).toString());
				 // System.out.println("Le joueur : "+Jeu.getListeDesJoueurs().get(i).getNomJoueur()+" gagne !");
			  }
		  }
		  PotCommun.AjoutTextCommG("Game Over.");
		  //System.out.println("Game Over.");
	  }
}
