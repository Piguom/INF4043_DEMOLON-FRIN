package IA;

import java.util.ArrayList;

import Dictionnaire.Dictionnaire;
import Jeu.Jeu;
import Jeu.Tapis;

public class CreerNouveauMotIA {
	
	static Dictionnaire dico = new Dictionnaire();
	
	public static String createNewMotIA(){
		  ArrayList<String> listeDesMots = dico.getAllMotFromSize(Jeu.tapis.size());
		  
		  String charSequence = "";
		  for(Character c : Jeu.tapis){
			  charSequence = charSequence+c;
		  }
		  for(String mot : listeDesMots){
			  if(dico.motValide(Jeu.tapis,mot) && dico.isWord(mot)){
						  Tapis.removeMotToTapis(mot);
						  return mot;
			  }
		  }
		  return null;
	  }
}
