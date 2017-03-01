package Plateforme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Jeu.Jeu;

public class Lancement extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel(new BorderLayout());
	static JTextField joueur1 = new JTextField("Nom joueur 1");
	static JTextField joueur2 = new JTextField("Nom joueur 2");
	static JPanel j1 = new JPanel();
	static JPanel j2 = new JPanel();
	static JPanel b1 = new JPanel();
	static JButton valider = new JButton("Valider");
	static String nom1, nom2;

	public static void DefaultFrame(){
		frame.setTitle("Jeu de Lettre");
		frame.setSize(600, 600);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
	
		ChoixJoueur();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void ChoixJoueur(){

		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(600,600));
		
		j1.add(joueur1);
		j1.setOpaque(false);
		j2.add(joueur2);
		j2.setOpaque(false);
		b1.add(valider);
		b1.setOpaque(false);		
		
		panel.add(j1);
		panel.add(j2);
		panel.add(b1);
		
		panel.getComponent(0).setBounds(100,5,100,30); 
		panel.getComponent(1).setBounds(300,5,100,30); 
		panel.getComponent(2).setBounds(150,100,100,30); 
		
		frame.setContentPane(panel);
	}
	
	public static String getNameJ1(){return nom1;}
	
	public static String getNameJ2(){return nom2;}
	
	public static void main(String[] args) throws IOException{
		DefaultFrame();
		
		valider.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				nom1 = joueur1.getText();
				nom2 = joueur2.getText();
				
				Jeu jeu = new Jeu(10);
				jeu.init(nom1, nom2);
				
				PotCommun.DefaultFrame();
				
				panel.setVisible(false);
				frame.setVisible(false);
			}			
		}); 	
	}
}
