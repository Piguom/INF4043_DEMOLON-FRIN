package Plateforme;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackGroundImage {
	
	public BackGroundImage(){}
	
	public JPanel setBackgroundImage(JFrame frame, final File img) throws IOException{
		JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1;			
			private BufferedImage buf = ImageIO.read(img);
			
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(buf, 0,0, null);
			}
		};		
		frame.getContentPane().add(panel);		
		return panel;
	}
}
