package Plateforme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class PotCommun extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JFrame pot = new JFrame();
	static JPanel pan = new JPanel(new BorderLayout());
	static JPanel j1 = new JPanel();
	static JPanel j2 = new JPanel();
	static JPanel jeu = new JPanel();
	static JLabel title,player1,player2;
	static JScrollPane sp1, sp2, spG;
	
	public static String nom1,nom2;
	public static JTextArea comm1, comm2, commG;

	public PotCommun(String nom1, String nom2){
		PotCommun.nom1 = nom1;
		PotCommun.nom2 = nom2;
	}

	public void DefaultFrame(){		
		pot.setTitle("Jeu de Lettre : "+nom1+" vs "+nom2);
		pot.setResizable(true);
		pot.setLocationRelativeTo(null);
		pot.setLayout(new BorderLayout());
	
		Plateau();
		
		pot.getContentPane().add(j1, BorderLayout.WEST);
		pot.getContentPane().add(j2, BorderLayout.EAST);
		pot.getContentPane().add(jeu, BorderLayout.CENTER);
		
		pot.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pot.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pot.setVisible(true);
	}
	
	public static void Plateau(){				
		player1 = new JLabel(nom1);
		player2 = new JLabel(nom2);
		title = new JLabel("Informations communes : ");
		
		player1.setFont(new Font("Serif", Font.BOLD, 32));
		player2.setFont(new Font("Serif", Font.BOLD, 32));
		title.setFont(new Font("Serif", Font.BOLD, 32));
		
		comm1.setEditable(false);
		comm2.setEditable(false);
		commG.setEditable(false);
		
		sp1 = new JScrollPane(comm1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp2 = new JScrollPane(comm2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		spG = new JScrollPane(commG, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);	
		
		JScrollBar toTop = spG.getHorizontalScrollBar();
		toTop.setValue(0);
		
		spG.setHorizontalScrollBar(toTop);
		
		j1.setPreferredSize(new Dimension(400,pot.getHeight()));
		jeu.setPreferredSize(new Dimension(400,pot.getHeight()));
		j2.setPreferredSize(new Dimension(400,pot.getHeight()));
		
		j1.setLayout(new BoxLayout(j1,BoxLayout.Y_AXIS));
		j2.setLayout(new BoxLayout(j2,BoxLayout.Y_AXIS));
		jeu.setLayout(new BoxLayout(jeu,BoxLayout.Y_AXIS));
		
		j1.add(player1, BorderLayout.NORTH);
		j1.add(sp1);
		j1.setOpaque(true);
		j2.add(player2, BorderLayout.NORTH);
		j2.add(sp2);
		j2.setOpaque(true);
		jeu.add(title);
		jeu.add(spG);
		jeu.setBackground(Color.LIGHT_GRAY);
		jeu.setOpaque(true);
	}
	
	public void AjoutTextComm1(String text){
		try {
			PotCommun.comm1.getDocument().insertString(0, text, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AjoutTextComm2(String text){
		try {
			PotCommun.comm2.getDocument().insertString(0, text, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AjoutTextCommG(String text){
		try {
			PotCommun.commG.getDocument().insertString(0, text, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
