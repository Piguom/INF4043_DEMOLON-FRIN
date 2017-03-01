package Jeu;

import java.util.ArrayList;

public class Tapis {
	public static void addMotToTapis(String mot){
		  for(Character c : mot.toCharArray()){
			  Jeu.tapis.add(c);
		  }
	  }
	  
	  public static void removeMotToTapis(String mot){
		  for(Character c : mot.toCharArray()){
			  Jeu.tapis.remove(c);
		  }
	  }
	  
	  public void setTapis(ArrayList<Character> tapis) {
			Jeu.tapis = tapis;
		}
}
