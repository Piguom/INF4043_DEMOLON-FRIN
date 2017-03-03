package Plateforme;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ActionJoueur.Saisie;
import Jeu.Start;
import Joueur.Joueur;

public class Popup {
	
	static JFrame pot = PotCommun.pot;
	static Joueur joueur = Start.getJoueurCourant();
	
	public static String PopupInput(String sentences){
		JFrame frame = new JFrame();
	    Object result = JOptionPane.showInputDialog(frame, sentences);   
	    if(result == null){
	    	result = Saisie.saisie(joueur);
	    	return null;
		}
		else
		    return result.toString();
	}
	
	public static String PopupChoice(String sentences){
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Saisir un mot", "Completer un mot", "Passer son tour" };
		String initialSelection = "Saisir un mot";
		Object selection = JOptionPane.showInputDialog(null, sentences,"Choix", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		if(selection == null){
	    	JOptionPane.showMessageDialog(null, "Vous avez annulé le choix.\n La jeu va quitter !");
	    	pot.dispose();
	    	System.exit(0);
	    	return null;
		}
		else
			return selection.toString();
	}
	
	public static String PopupRejouer(String sentences){
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Oui", "Non"};
		String initialSelection = "Oui";
		Object selection = JOptionPane.showInputDialog(null, sentences,"Choix", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		if(selection == null){
	    	JOptionPane.showMessageDialog(null, "Vous avez annulé le choix.\n La jeu va quitter !");
	    	pot.dispose();
	    	System.exit(0);
	    	return null;
		}
		else
			return selection.toString();
	}
}
