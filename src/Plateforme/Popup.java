package Plateforme;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup {
	
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
	    return selection.toString();
	}
}
