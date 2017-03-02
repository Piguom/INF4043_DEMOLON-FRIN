package Plateforme;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackGroundImage {
	
	public BackGroundImage(){}
	
	public static JPanel setBackgroundImage(JFrame frame, String img) throws IOException
	{
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1;
			
			//private BufferedImage buf = ImageIO.read(new ImageIcon(img));
			ImageIcon icon = new ImageIcon(Lancement.class.getResource(img));
			Image image = icon.getImage();
			
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(image, 0,0, null);
			}
		};
		
		frame.setContentPane(panel);
		
		return panel;
	}
}
