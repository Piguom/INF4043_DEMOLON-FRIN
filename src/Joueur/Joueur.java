package Joueur;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private ArrayList<String> monTableauDeMot;
	private boolean isIA;
	
	public Joueur(){
		this.nomJoueur = "";
		this.monTableauDeMot = new ArrayList<String>();
		this.isIA = false;
	}
	
	public String getNomJoueur(){
		return this.nomJoueur;
	}
	
	public void setNomJoueur(String nmJoueur){
	    this.nomJoueur = nmJoueur;
	}
	
	public void setMotToMonTableau(String mot){
		this.monTableauDeMot.add(mot);
	}
	
	public ArrayList<String> getMontableauDeMot(){
		return this.monTableauDeMot;
	}
	
	public void setIA(boolean ia){
		this.isIA = ia;
	}
	
	public boolean isIA(){
		return this.isIA;
	}
	
	public String toString(){
		return this.nomJoueur + " tableau de mots : " + this.monTableauDeMot.toString();
	}
	
}
