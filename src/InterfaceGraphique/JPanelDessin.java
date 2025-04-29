package InterfaceGraphique;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculator.Vector;
import Test_codeur.GamePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelDessin extends JPanel {
	
	
	public Vector[] toPaint = new Vector[2];
	public Color[]  toColor = new Color[2];
	private GamePanel gp = new GamePanel();
	public int[] toFill = new int[4];
	
	
	
	public JPanelDessin () {
		this.setPreferredSize(new Dimension(gp.getCalcul().getScreenWidth(),gp.getCalcul().getScreenHeight()));
		this.setBackground(Color.black);
		this.setFocusable(true);
	}
	protected void paintComponent(Graphics g) { //classe qui repaint //attention null
		
		super.paintComponents(g); //classe parental
		Graphics2D g2 = (Graphics2D)g;
		toPaint[0]=gp.getJoueur1().getVecteurPosition(); 
		toPaint[1]=gp.getBallon().getVecteurPosition();
		toColor[0]=Color.white;
		toColor[1]=Color.orange;
		toFill[0]=gp.getCalcul().getTileSize();
		toFill[1]=(int) (gp.getCalcul().getTileSize()/2);
		toFill[2]=gp.getCalcul().getTileSize();
		toFill[3]=(int) (gp.getCalcul().getTileSize()/2);

		for (int i=0;i<2;i++) {
			g2.setColor(toColor[i]);
			g2.fillRect(toPaint[i].getX(),toPaint[i].getY(),toFill[i],toFill[i+2]);

		}
		g2.dispose(); //aide pour le calcul en abandonnant les tache
	}
		
		
	
	public void update() {
		gp.update();
	}
}
