package IA;

import java.util.ArrayList;

import Dictionnaire.Dictionnaire;
import Joueur.Joueur;
import Tapis.Tapis;

public class MettreAJourMotIA {
	
	static Dictionnaire dico = new Dictionnaire();
	
	public static String mettreAJourMotIA(Joueur joueurAdverse) {
		  ArrayList<String> listeDesMots = new ArrayList<String>();
		  for(String mot : joueurAdverse.getMontableauDeMot()){
			  listeDesMots = dico.getAllMotFromBase(mot);
			  Tapis.addMotToTapis(mot);
			  for(String nouveauMot : listeDesMots){
				  if(dico.motValide(Tapis.tapis,nouveauMot) && dico.isWord(nouveauMot)){
					  Tapis.removeMotToTapis(mot);
					  joueurAdverse.getMontableauDeMot().remove(mot);
					  return nouveauMot;
				  }
			  }
			  Tapis.removeMotToTapis(mot);
		  }
		  return null;
		  
	  }
}
