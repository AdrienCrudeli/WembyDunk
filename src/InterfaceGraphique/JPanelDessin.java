package InterfaceGraphique;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculator.Vector;
import Test_codeur.GamePanel;

import Test_codeur.KeyHandler;
import sprite.SpriteATK;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelDessin extends JPanel {
	
	
	public Vector[] toPaint = new Vector[3];
	public Color[]  toColor = new Color[3];
	public GamePanel gp ;
	public int[] toFill = new int[6];
	public String[] name = new String[3];
	public KeyHandler keyH;
	double dx=1;
	double dy=1;

	
	
	public void setGp(GamePanel gp) {
		this.gp = gp;
		
	}
	public JPanelDessin () {
		this.setBackground(Color.black);
		this.setFocusable(true);
	}

	protected void paintComponent(Graphics g) { //classe qui repaint //attention null
		super.paintComponent(g); //classe parental
		
		this.setBackground(Color.black);

		if(gp!=null) {
			setDx((double)this.getWidth()/gp.getCalcul().getScreenWidth());
			setDy((double)this.getHeight()/gp.getCalcul().getScreenHeight());
			name[0]="joueur";
			name[1]="ballon";
			name[2]="panier";
			toPaint[0]=gp.getJoueur1().getVecteurPosition(); 
			toPaint[1]=gp.getBallon().getVecteurPosition();
			toPaint[2]=gp.getPanier().getVecteurPosition();
			toColor[0]=Color.white;
			toColor[1]=Color.orange;
			toColor[2]=Color.blue;
			toFill[0]= (int) ((gp.getCalcul().taillePerso.getX()));
			toFill[1]=(int) ((gp.getCalcul().taillePerso.getY())); 
			toFill[2]=(int) ((gp.getCalcul().tailleBallon.getX()));
			toFill[3]=(int) ((gp.getCalcul().tailleBallon.getY()));
			toFill[4]=(int) ((gp.getCalcul().taillePanier.getX()));
			toFill[5]=(int) ((gp.getCalcul().taillePanier.getY()));
			
			g.setColor(toColor[0]);
			g.fillRect((int)(toPaint[0].getX()*dx),(int) (toPaint[0].getY()*dy),(int) (toFill[0]*dx),(int) (toFill[1]*dy));
			g.setColor(toColor[1]);
			g.fillRect((int)(toPaint[1].getX()*dx),(int) (toPaint[1].getY()*dy),(int) (toFill[2]*dx),(int) (toFill[3]*dy));
			g.setColor(toColor[2]);
			g.fillRect((int)(toPaint[2].getX()*dx),(int) (toPaint[2].getY()*dy),(int) (toFill[4]*dx),(int) (toFill[5]*dy));
		
				
			
				
	
			
			
			 Graphics2D g2 = (Graphics2D)g;

			
			g2.dispose();
			
		}
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	
		
		
	
	
}
