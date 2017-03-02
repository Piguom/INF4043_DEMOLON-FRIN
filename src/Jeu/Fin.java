package Jeu;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Plateforme.PotCommun;
import RelanceApplication.RelancerApplication;

public class Fin {
	
	static PotCommun potCommun = Start.potCommun;
	static JFrame pot = PotCommun.pot;
	
	public static void finDuGame() throws IOException, URISyntaxException{
		potCommun.AjoutTextCommG("\nFin du jeu");
		int joueur = 0;
		
		for(int i = 0;i < Start.getListeDesJoueurs().size();i++){
			if(Start.getListeDesJoueurs().get(i).getMontableauDeMot().size() == Start.getScorePourGagner()){
				potCommun.AjoutTextCommG("\n"+Start.getListeDesJoueurs().get(i).toString());
				potCommun.AjoutTextCommG("\nLe joueur : "+Start.getListeDesJoueurs().get(i).getNomJoueur()+" gagne !\n");
				joueur = i;
			}
		}
		potCommun.AjoutTextCommG("\n\nGame Over.\n\n");
		JOptionPane.showMessageDialog(null, "Jeu terminée ! \n"+Start.getListeDesJoueurs().get(joueur).getNomJoueur()+" a gagner !\n\t :D");
		int rejouer = JOptionPane.showConfirmDialog(null,"Le jeu va se fermer.\nVoulez-vous rejouer ?", "Fin du jeu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(rejouer == JOptionPane.OK_OPTION){
			RelancerApplication.restartApplication();
		}else{
			System.exit(0);
		}
	}
}
