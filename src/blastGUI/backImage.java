package blastGUI;

import java.awt.Graphics;

import javax.swing.*;

public class backImage extends JPanel{
	private ImageIcon img;
		
	public backImage(ImageIcon img){
		this.img=img;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(img.getImage(),0,0,null);
	}

}