package Dictionnaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;

import Plateforme.PotCommun;

public class Dictionnaire implements IsWord
{
	private String path;
	
	public Dictionnaire(){
		this.path = System.getProperty("user.dir")+"/target/classes/dico.txt";
	}
	
	public Dictionnaire(String path){
		this.path = path;
	}
	
	@Override
	public boolean isWord(String word)	{
		try {
			File f = new File(path); 
			BufferedReader reader = new BufferedReader(new FileReader(f)); 	
			String line;
			while((line = reader.readLine()) != null) { 
				if (line.equals(word)) {
					try {
						PotCommun.commG.getDocument().insertString(0, "\nLe fichier contient le mot : "+word, null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//System.out.println("Le fichier contient le mot : "+word); 
						reader.close();
						return true;
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Une erreur est survenue avec le dictionnaire"); 
			e.printStackTrace();
		}
		try {
			PotCommun.commG.getDocument().insertString(0, "\nLe mot "+word +" n'existe pas dans le dictionnaire", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("Le mot "+word +" n'existe pas dans le dictionnaire");
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
			File f = new File(path); 
			BufferedReader reader = new BufferedReader(new FileReader(f)); 	
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
			File f = new File(path); 
			BufferedReader reader = new BufferedReader(new FileReader(f)); 	
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
