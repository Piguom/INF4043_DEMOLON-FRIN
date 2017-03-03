package Sac;

import java.util.Random;

import javax.swing.JTextArea;

import Plateforme.Lancement;
import Plateforme.PotCommun;

public class Sac {
	private String alphabet;
	private int alphabetSize;
	
	public Sac(){
		this.alphabet = "abcdefghijklmnopqrstuvwxyz";
		this.alphabetSize = this.alphabet.length();
	}
	
	public char genererNombreAleatoire(){
		Random nbAlea = new Random();
		return alphabet.charAt(nbAlea.nextInt(alphabetSize));
	}
	
	public boolean testerValeurCaractere(char lettre1,char lettre2){
		PotCommun.comm1 = new JTextArea("\nVous avez tire la lettre "+lettre1 + " : " + (int)lettre1);
		PotCommun.comm2 = new JTextArea("\nVous avez tire la lettre "+lettre2 + " : "  + (int)lettre2);
		if((int)lettre1<(int)lettre2){
			PotCommun.commG = new JTextArea("\nLe joueur ==> "+Lancement.getNameJ1()+" commence !\n");
			return true;
		}else{
			PotCommun.commG = new JTextArea("\nLe joueur ==> "+Lancement.getNameJ2()+" commence !");
			return false;
		}
			
	}
}
