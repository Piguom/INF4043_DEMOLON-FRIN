package Tapis;

import java.util.ArrayList;

public class Tapis {	

	public static ArrayList<Character> tapis;
	
	public Tapis(){
	    tapis = new ArrayList<Character>();
	}
	
	public void add(char lettre){
		tapis.add(lettre);
	}
	
	public static void addMotToTapis(String mot){
		for(Character c : mot.toCharArray()){
			tapis.add(c);
		}
	}
	  
	public static void removeMotToTapis(String mot){
		for(Character c : mot.toCharArray()){
			tapis.remove(c);
		}
	}
	  
	public void setTapis(ArrayList<Character> tapis) {
		Tapis.tapis = tapis;
	}
	  
	public ArrayList<Character> getTapis() {
		return tapis;
	}
	
}
