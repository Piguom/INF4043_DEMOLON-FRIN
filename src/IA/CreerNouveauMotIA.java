package IA;

import java.util.ArrayList;

import Dictionnaire.Dictionnaire;
import Tapis.Tapis;

public class CreerNouveauMotIA {
	
	static Dictionnaire dico = new Dictionnaire();
	
	public static String creerNouveauMotIA(){
		  ArrayList<String> listeDesMots = dico.getAllMotFromSize(Tapis.tapis.size());
		  
		  String charSequence = "";
		  for(Character c : Tapis.tapis){
			  charSequence = charSequence+c;
		  }
		  for(String mot : listeDesMots){
			  if(dico.motValide(Tapis.tapis,mot) && dico.isWord(mot)){
						  Tapis.removeMotToTapis(mot);
						  return mot;
			  }
		  }
		  return null;
	  }
}
