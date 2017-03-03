package ActionJoueur;

import Dictionnaire.Dictionnaire;
import Jeu.Start;
import Plateforme.Popup;
import Plateforme.PotCommun;
import Tapis.Tapis;

public class CreerNouveauMot {
	
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
}
