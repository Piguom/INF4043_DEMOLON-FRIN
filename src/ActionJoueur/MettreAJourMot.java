package ActionJoueur;

import Dictionnaire.Dictionnaire;
import Jeu.Start;
import Joueur.Joueur;
import Plateforme.Popup;
import Plateforme.PotCommun;
import Tapis.Tapis;

public class MettreAJourMot {
	
	static Dictionnaire dico = new Dictionnaire();
	static PotCommun potCommun = Start.potCommun;
	
	 public static String mettreAJourMot(){
		  String motACompleter = Popup.PopupInput("Mot a completer : ");
		  Joueur joueurAdverse = Start.getJoueurWhereMotExist(motACompleter);
		  if(joueurAdverse != null){
			  String nouveauMot = Popup.PopupInput("Le mot est bien dans la liste de votre adversaire, veuillez inserer le nouveau mot :");
			  if(nouveauMot.contains(motACompleter)){
				  Tapis.addMotToTapis(motACompleter);
				  if(dico.motValide(Tapis.tapis,nouveauMot) == false  || dico.isWord(nouveauMot) == false){
					  potCommun.AjoutTextCommG("\nLe nouveau mot n'est pas dans le disctionnaire");
					  Tapis.removeMotToTapis(motACompleter);
					  return null;
				  }else{
					  joueurAdverse.getMontableauDeMot().remove(motACompleter);
					  Tapis.removeMotToTapis(nouveauMot);
				  }
				  return nouveauMot;
			  }else{
				  potCommun.AjoutTextCommG("\nVotre mot n'est pas dans la liste de votre adversaire");
				  return null;
			  }
		  }
		  potCommun.AjoutTextCommG("\nMont encore inconnu des deux listes");
		  return null;
	  } 
}
