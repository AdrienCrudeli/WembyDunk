package InterfaceGraphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelImageMenu extends JPanel {
	
	private static final long serialVersionUID = 3641337531772753865L;
	private String sNomImage;
	private Image image=null;

	
	public JPanelImageMenu() {
		super();
		sNomImage=null;
	}
	public JPanelImageMenu(String sNom) {
		super();
		sNomImage=sNom;
		chargerImage();	
	}
	
	public void setImage(String sNom) {
		sNomImage=sNom;
		chargerImage();	
	}
	
	private void chargerImage(){
		if(sNomImage!=null) {
			String sNomFile=".\\images\\"+sNomImage;
		               
		          try {
					image = ImageIO.read(new File(sNomFile));
				} catch (IOException e) {
image=null;
e.printStackTrace();
				}
		       
		}	
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		if(image!=null) {
			 g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(), null);
		}
	}	
}