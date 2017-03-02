package Joueur;

public class GetJoueurCourant {
	
	  private static int joueurCourant;
	  
	  public GetJoueurCourant(){
		    joueurCourant = 0;
	  }
	
	  public static Joueur getJoueurCourant(){
		  
		  if(joueurCourant >= ListeJoueurs.listeDesJoueurs.size()){
			  joueurCourant = 0;
		  }
		  Joueur joueurCourant = ListeJoueurs.listeDesJoueurs.get(GetJoueurCourant.joueurCourant);
		  GetJoueurCourant.joueurCourant ++;
		  return joueurCourant;
	  }
}

