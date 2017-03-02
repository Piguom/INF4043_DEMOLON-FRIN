package Plateforme;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup {
	
	static JFrame pot = PotCommun.pot;
	
	public static String PopupInput(String sentences){
		JFrame frame = new JFrame();
	    Object result = JOptionPane.showInputDialog(frame, sentences);    
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
