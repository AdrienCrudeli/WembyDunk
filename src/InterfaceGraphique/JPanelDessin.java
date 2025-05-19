package InterfaceGraphique;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

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
	BufferedImage playerImage;
	BufferedImage[] playerImagesRight = new BufferedImage[4];
	BufferedImage[] playerImagesLeft = new BufferedImage[4];

	int currentFrame = 0;
	int frameCounter = 0;
	int frameDelay = 10; 
	
	BufferedImage ballImage;
	BufferedImage backgroundImage;
	BufferedImage hoopImage;
	
	public Vector[] toPaint = new Vector[3];
	public Color[]  toColor = new Color[3];
	public GamePanel gp ;
	public int[] toFill = new int[6];
	public KeyHandler keyH;
	double dx=1;
	double dy=1;

	
	
	public void setGp(GamePanel gp) {
		this.gp = gp;
		
	}
	public JPanelDessin () {
		 this.setBackground(Color.black);
		    this.setFocusable(true);
		    try {//assignations des images aux variables
		    	playerImagesRight[0] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG1.png"));
		    	playerImagesRight[1] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG2.png"));
		    	playerImagesRight[2] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG3.png"));
		    	playerImagesRight[3] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG4.png"));
		    	backgroundImage = ImageIO.read(getClass().getResource("/sprite/court1.png"));
		    	hoopImage = ImageIO.read(getClass().getResource("/sprite/panier.png"));
		    	ballImage = ImageIO.read(getClass().getResource("/sprite/Ball.png"));  // ton image de ballon
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}

	protected void paintComponent(Graphics g) { //classe qui repaint //attention null
		super.paintComponent(g); //classe parental
				
		if(gp!=null) {//variables pour dessiner
			setDx((double)this.getWidth()/gp.getCalcul().getScreenWidth()); //sert à resize les éléments en fonction de la taille de la fenêtre
			setDy((double)this.getHeight()/gp.getCalcul().getScreenHeight());
			toPaint[0]=gp.getJoueur1().getVecteurPosition(); 
			toPaint[1]=gp.getBallon().getVecteurPosition();
			toPaint[2]=gp.getPanier().getVecteurPosition();
			toColor[0]=Color.white;
			toColor[1]=Color.orange;
			toColor[2]=Color.blue;
			toFill[0]= (int) (gp.getCalcul().taillePerso.getX());
			toFill[1]=(int) ((gp.getCalcul().taillePerso.getY())); 
			toFill[2]=(int) (gp.getDiamètreBallon());
			toFill[3]=(int)  (gp.getDiamètreBallon());
			toFill[4]=(int) (gp.getLongueurPanier());
			toFill[5]=(int) (gp.getLargeurPanier());
			
			
			 if (gp.getJoueur1Moovset().isMoovRight()) {
		            // Il bouge à droite : on fait défiler les frames pour courir à droite
		            frameCounter++;
		            if (frameCounter >= frameDelay) {
		                currentFrame = (currentFrame + 1) % playerImagesRight.length;
		                frameCounter = 0;
		            }
		            
		            else if (gp.getJoueur1Moovset().isMoovLeft())        {
			            // Il bouge à gauche : on fait défiler les frames pour courir à gauche
		            	if (frameCounter >= frameDelay) {
			                currentFrame = (currentFrame + 1) % playerImagesLeft.length;
			                frameCounter = 0;
			            }	
		            }
			 }
			 if (backgroundImage != null) {
				    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
				} else {
				    // En cas de problème, tu peux mettre un fond noir
				    g.setColor(Color.BLACK);
				    g.fillRect(0, 0, this.getWidth(), this.getHeight());
				}
			 
				
				if (gp.getBallonMoovset().isBallonFollowsPlayer()==false){
				    g.drawImage(ballImage,
				        (int)(toPaint[1].getX()*dx),
				        (int)(toPaint[1].getY()*dy),
				        (int)(toFill[2]*dx),
				        (int)(toFill[3]*dy),
				        null);
				}

			
			if (playerImagesRight[currentFrame] != null) {
			    g.drawImage(playerImagesRight[currentFrame],
			        (int)(toPaint[0].getX()*dx),
			        (int)(toPaint[0].getY()*dy),
			        (int)(toFill[0]*dx),
			        (int)(toFill[1]*dy),
			        null);
			}
			

			
			if (hoopImage != null) {
			    g.drawImage(hoopImage,
			        (int)(toPaint[2].getX()*dx),
			        (int)(toPaint[2].getY()*dy),
			        (int)(toFill[4]*dx), 
			        (int)(toFill[5]*dy),
			        null);
			} else {
			    // Sécurité : si l'image ne se charge pas, on affiche un carré bleu
			    g.setColor(toColor[2]);
			    g.fillRect((int)(toPaint[2].getX()*dx),(int) (toPaint[2].getY()*dy),(int) (toFill[4]*dx),(int) (toFill[5]*dy));
			}
		
				
			
				
	
			
			
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
