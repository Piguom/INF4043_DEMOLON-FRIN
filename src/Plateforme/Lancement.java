package Plateforme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Jeu.Start;

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
	static JLabel pseudo1,pseudo2;
	static String nom1, nom2;
	static PotCommun potCommun;

	public static void DefaultFrame() throws IOException{
		frame.setTitle("Jeu de Lettre");
		frame.setSize(600, 600);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
	
		ChoixJoueur();
				
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void ChoixJoueur() throws IOException{

		panel = setBackgroundImage(frame, new File("src/picture.jpg"));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(600,400));
		
		joueur1.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		    	joueur1.setText("");
		    }
		});
		joueur2.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		    	joueur2.setText("");
		    }
		});
		
		pseudo1 = new JLabel("Joueur 1 :");
		pseudo2 = new JLabel("Joueur 2 :");
		
		j1.add(pseudo1);
		j1.add(joueur1);
		j1.setOpaque(false);
		j2.add(pseudo2);
		j2.add(joueur2);
		j2.setOpaque(false);
		b1.add(valider);
		b1.setOpaque(false);		
		
		panel.add(j1);
		panel.add(j2);
		panel.add(b1);
		
		panel.getComponent(0).setBounds(100,150,150,30); 
		panel.getComponent(1).setBounds(290,150,150,30); 
		panel.getComponent(2).setBounds(250,200,100,30); 
		
		frame.setContentPane(panel);
	}
	
	public static String getNameJ1(){return nom1;}
	
	public static String getNameJ2(){return nom2;}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException{
		JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1;			
			private BufferedImage buf = ImageIO.read(img);
			
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(buf, 0,0, null);
			}
		};		
		frame.setContentPane(panel);		
		return panel;
	}
	
	public static void main(String[] args) throws IOException{
		DefaultFrame();
		
		valider.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				nom1 = joueur1.getText();
				nom2 = joueur2.getText();
				if(!nom1.equals("") && !nom2.equals("")){
					if(!nom1.equals(nom2)){
						Start start = new Start(10); //Nombre de point pour gagner
						start.initialisation(nom1, nom2);					
						potCommun.DefaultFrame();					
						panel.setVisible(false);
						frame.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "ALERTE : Vous ne pouvez pas avoir le même nom !!!");
				}
				else
					JOptionPane.showMessageDialog(null, "ALERTE : Vous devez entrer un nom dans chaque champ pour jouer !!!");
			}			
		}); 	
	}
}
