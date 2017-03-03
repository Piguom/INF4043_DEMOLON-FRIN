package Dictionnaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Jeu.Start;
import Plateforme.PotCommun;

public class Dictionnaire implements IsWord
{
	InputStream path;
	InputStreamReader isr;
	BufferedReader reader;
	public static PotCommun potCommun;
	
	public Dictionnaire(){
		potCommun = Start.potCommun;
		this.path = getClass().getClassLoader().getResourceAsStream("dico.txt");
	}
	
	public Dictionnaire(InputStream path){
		try {
			path.read();
			this.path = path;
			path.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isWord(String word)	{
		try {	
			isr = new InputStreamReader(path);
			reader = new BufferedReader(isr); 
			String line;
			while((line = reader.readLine()) != null) { 
				if (line.equals(word)) {
					potCommun.AjoutTextCommG("\nLe fichier contient le mot : "+word);
					return true;
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Une erreur est survenue avec le dictionnaire"); 
			e.printStackTrace();
		}
		potCommun.AjoutTextCommG("\nLe mot "+word +" n'existe pas dans le dictionnaire");
		return false;
	}
	
	public boolean motValide(ArrayList<Character>listeDeLettre,String mot){
		ArrayList<Character> temp = (ArrayList<Character>) listeDeLettre.clone();
		int taille = mot.length();
		
		for(int i = 0; i < taille;i++){
		     int index = temp.indexOf(mot.charAt(i));
		     if(index != -1){
		    	 temp.remove(index);
		     }else{
		    	 return false;
		     }
		}
		return true;
	}
	
	public ArrayList<String> getAllMotFromSize(int taille){
		ArrayList<String> listeDesMots = new ArrayList<String>();
		try {	
			isr = new InputStreamReader(path);
			reader = new BufferedReader(isr); 
			String line;
			while((line = reader.readLine()) != null) {
				if (line.length() > 1 && line.length() <= taille) {
					listeDesMots.add(line);
				}
			}
		} catch (IOException e) {
			System.out.println("Une erreur est survenue avec le dictionnaire"); 
			e.printStackTrace();
		}
		return listeDesMots;
	}
	
	public ArrayList<String> getAllMotFromBase(String base){
		ArrayList<String> listeDesMots = new ArrayList<String>();
		try {
			isr = new InputStreamReader(path);
			reader = new BufferedReader(isr); 
			String line;
			while((line = reader.readLine()) != null) {
				if (line.equals(base) == false && line.contains(base)) {
					listeDesMots.add(line);
				}
			}
		} catch (IOException e) {
			System.out.println("Une erreur est survenue avec le dictionnaire"); 
			e.printStackTrace();
		}
		return listeDesMots;
	}

}	
