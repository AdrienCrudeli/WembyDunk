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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelDessin extends JPanel {
	BufferedImage[] playerImage;
	double scalePlayer = 5.0;
	double scaleBall = 10.0;
	double scaleHoop = 16.0;
	BufferedImage[] ATKDRG = new BufferedImage[8];
	BufferedImage[] ATKDRD = new BufferedImage[8];
	BufferedImage[] ATKDRST = new BufferedImage[4];
	BufferedImage[] ATKSH = new BufferedImage[4];
	BufferedImage[] ATKSHED = new BufferedImage[2];
	BufferedImage[] ATKHB = new BufferedImage[6];
	BufferedImage[] ATKRUND = new BufferedImage[8];
	BufferedImage[] ATKRUNG = new BufferedImage[8];
	BufferedImage[] ATKST = new BufferedImage[8];
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
	KeyHandler keyH = new KeyHandler();
	double dx=1;
	double dy=1;


public void setKeyHandler(KeyHandler keyH){
	this.keyH = keyH;
}

	
	public void setGp(GamePanel gp) {
		this.gp = gp;
		
	}
	public JPanelDessin () {
		 this.setBackground(Color.black);
		    this.setFocusable(true);
		    try {
		    	//images dribble à gauche
		    	ATKDRG[0] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG1.png"));
		    	ATKDRG[1] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG2.png"));
		    	ATKDRG[2] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG3.png"));
		    	ATKDRG[3] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG4.png"));
		    	ATKDRG[4] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG5.png"));
		    	ATKDRG[5] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG6.png"));
		    	ATKDRG[6] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG7.png"));
		    	ATKDRG[7] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunG8.png"));
		    	//images dribble à droite
		    	ATKDRD[0] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD1.png"));
		    	ATKDRD[1] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD2.png"));
		    	ATKDRD[2] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD3.png"));
		    	ATKDRD[3] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD4.png"));
		    	ATKDRD[4] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD5.png"));
		    	ATKDRD[5] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD6.png"));
		    	ATKDRD[6] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD7.png"));
		    	ATKDRD[7] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleRunD8.png"));
		    	//images dribble sans bouger
		    	ATKDRST[0] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleStand1.png"));
		    	ATKDRST[1] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleStand2.png"));
		    	ATKDRST[2] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleStand3.png"));
		    	ATKDRST[3] = ImageIO.read(getClass().getResource("/sprite/AtkDribbleStand4.png"));
		    	//images du tir
		    	ATKSH[0] = ImageIO.read(getClass().getResource("/sprite/AtkShotST1.png"));
		    	ATKSH[1] = ImageIO.read(getClass().getResource("/sprite/AtkShotST2.png"));
		    	ATKSH[2] = ImageIO.read(getClass().getResource("/sprite/AtkShotST3.png"));
		    	ATKSH[3] = ImageIO.read(getClass().getResource("/sprite/AtkShotST4.png"));
		    	
		    	ATKSHED[0] = ImageIO.read(getClass().getResource("/sprite/AtkShotST5.png"));
		    	ATKSHED[1] = ImageIO.read(getClass().getResource("/sprite/AtkShotST6.png"));
		    	//images pour garder la balle dans les mains
		    	ATKHB[0] = ImageIO.read(getClass().getResource("/sprite/AtkHBall1.png"));
		    	ATKHB[1] = ImageIO.read(getClass().getResource("/sprite/AtkHBall1.png"));
		    	ATKHB[2] = ImageIO.read(getClass().getResource("/sprite/AtkHBall1.png"));
		    	ATKHB[3] = ImageIO.read(getClass().getResource("/sprite/AtkHBall2.png"));
		    	ATKHB[4] = ImageIO.read(getClass().getResource("/sprite/AtkHBall2.png"));
		    	ATKHB[5] = ImageIO.read(getClass().getResource("/sprite/AtkHBall2.png"));
		    	//imges pour courir à droite sans la balle
		    	ATKRUND[0] = ImageIO.read(getClass().getResource("/sprite/AtkRunD1.png"));
		    	ATKRUND[1] = ImageIO.read(getClass().getResource("/sprite/AtkRunD2.png"));
		    	ATKRUND[2] = ImageIO.read(getClass().getResource("/sprite/AtkRunD3.png"));
		    	ATKRUND[3] = ImageIO.read(getClass().getResource("/sprite/AtkRunD4.png"));
		    	ATKRUND[4] = ImageIO.read(getClass().getResource("/sprite/AtkRunD5.png"));
		    	ATKRUND[5] = ImageIO.read(getClass().getResource("/sprite/AtkRunD6.png"));
		    	ATKRUND[6] = ImageIO.read(getClass().getResource("/sprite/AtkRunD7.png"));
		    	ATKRUND[7] = ImageIO.read(getClass().getResource("/sprite/AtkRunD8.png"));
		    	
		    	ATKRUNG[0] = ImageIO.read(getClass().getResource("/sprite/AtkRunG1.png"));
		    	ATKRUNG[1] = ImageIO.read(getClass().getResource("/sprite/AtkRunG2.png"));
		    	ATKRUNG[2] = ImageIO.read(getClass().getResource("/sprite/AtkRunG3.png"));
		    	ATKRUNG[3] = ImageIO.read(getClass().getResource("/sprite/AtkRunG4.png"));
		    	ATKRUNG[4] = ImageIO.read(getClass().getResource("/sprite/AtkRunG5.png"));
		    	ATKRUNG[5] = ImageIO.read(getClass().getResource("/sprite/AtkRunG6.png"));
		    	ATKRUNG[6] = ImageIO.read(getClass().getResource("/sprite/AtkRunG7.png"));
		    	ATKRUNG[7] = ImageIO.read(getClass().getResource("/sprite/AtkRunG8.png"));
		    	//images sans bouger sans la balle
		    	ATKST[0] = ImageIO.read(getClass().getResource("/sprite/AtkStand1.png"));
		    	ATKST[1] = ImageIO.read(getClass().getResource("/sprite/AtkStand2.png"));
		    	ATKST[2] = ImageIO.read(getClass().getResource("/sprite/AtkStand3.png"));
		    	ATKST[3] = ImageIO.read(getClass().getResource("/sprite/AtkStand4.png"));
		    	ATKST[4] = ImageIO.read(getClass().getResource("/sprite/AtkStand5.png"));
		    	ATKST[5] = ImageIO.read(getClass().getResource("/sprite/AtkStand6.png"));
		    	ATKST[6] = ImageIO.read(getClass().getResource("/sprite/AtkStand7.png"));
		    	ATKST[7] = ImageIO.read(getClass().getResource("/sprite/AtkStand8.png"));
		    	
		    	backgroundImage = ImageIO.read(getClass().getResource("/sprite/court1.png"));
		    	hoopImage = ImageIO.read(getClass().getResource("/sprite/panier.png"));
		    	ballImage = ImageIO.read(getClass().getResource("/sprite/Ball.png"));  // ton image de ballon
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		/*this.setBackground(Color.black);
		this.setFocusable(true);*/
	}

	protected void paintComponent(Graphics g) { //classe qui repaint //attention null
		super.paintComponent(g); //classe parental
		
		this.setBackground(Color.black);
		
		if(gp!=null) {
			setDx((double)this.getWidth()/gp.getCalcul().getScreenWidth());
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
			
			//on va vérifier des conditions pour savoir quel mouvement le joueur fait
			if (playerImage == null) {
				playerImage = ATKHB;
				}
			if(gp.getBallonMoovset().isBallonFollowsPlayer()==true) {
				if(gp.getJoueur1Moovset().isMoovLeft() == true) {//aller à gauche
					playerImage = ATKDRG;
					}
				if (gp.getJoueur1Moovset().isMoovRight() == true){//aller à droite
					playerImage = ATKDRD;
					}
				if(gp.getJoueur1Moovset().isInjump() == true) {
					playerImage = ATKSH;
				}
				if(gp.getBallonMoovset().isBallauch() ==true) {
					playerImage = ATKSHED;
				}
				/*if (gp.getJoueur1Moovset().isMoovLeft() == false && gp.getJoueur1Moovset().isMoovRight() == false){//si joueur pas bouger avec la balle
					playerImage = ATKDRST;
					}*/
				}
			else if(gp.getBallonMoovset().isBallonFollowsPlayer()==false) {
				gp.getBallonMoovset().setBallauch(false);
				if(gp.getJoueur1Moovset().moovLeft == true) {//aller à gauche
					playerImage = ATKRUNG;
					}
				if (gp.getJoueur1Moovset().moovRight == true) {//aller à droite
					playerImage = ATKRUND;
					}
				/*if(gp.getJoueur1Moovset().moovLeft == false && gp.getJoueur1Moovset().moovRight == false && gp.getJoueur1Moovset().injump == false) {//si joueur pas bouger avec la balle
					playerImage = ATKST;
					}*/
				}
			 if (gp.getJoueur1().getVecteurVitesse().getX() != 0 || gp.getJoueur1().getVecteurVitesse().getY() != 0) {
		            // Il bouge : on fait défiler les frames
		            frameCounter++;
		            if (frameCounter >= frameDelay) {
		                currentFrame = (currentFrame + 1) % playerImage.length;
		                frameCounter = 0;
		            }
		        } else {
		            // Il est à l'arrêt : on affiche toujours la première image
		            currentFrame = 0;
		        }
			 
			 if (backgroundImage != null) {
				    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
				} else {
				    // En cas de problème, tu peux mettre un fond noir
				    g.setColor(Color.BLACK);
				    g.fillRect(0, 0, this.getWidth(), this.getHeight());
				}
			 
				/*g.setColor(toColor[1]);
				g.fillRect((int)(toPaint[1].getX()*dx),(int) (toPaint[1].getY()*dy),(int) (toFill[2]*dx),(int) (toFill[3]*dy));*/

				
				
				
				
				
				
				 
			/*g.setColor(toColor[0]);
			g.fillRect((int)(toPaint[0].getX()*dx),(int) (toPaint[0].getY()*dy),(int) (toFill[0]*dx),(int) (toFill[1]*dy));*/
			
			/*g.drawImage(playerImage,
				    (int)(toPaint[0].getX()*dx),
				    (int)(toPaint[0].getY()*dy),
				    (int)(toFill[0]*dx),
				    (int)(toFill[1]*dy),
				    null);*/
			
			if (playerImage[currentFrame] != null) {
			    g.drawImage(playerImage[currentFrame],
			        (int)(toPaint[0].getX()*dx),
			        (int)((toPaint[0].getY() - gp.getCalcul().getYOffsetForPlayerDrawing()) * dy),
			        (int)(toFill[0]*dx),
			        (int)(toFill[1]*dy),
			        null);
			}
			

			/*g.setColor(toColor[2]);
			g.fillRect((int)(toPaint[2].getX()*dx),(int) (toPaint[2].getY()*dy),(int) (toFill[4]*dx),(int) (toFill[5]*dy));*/
			
			if (hoopImage != null) {
			    g.drawImage(hoopImage,
			        (int)(toPaint[2].getX()*dx),
			        (int)(toPaint[2].getY()*dy),
			        (int)(toFill[4]*dx),  // Tu peux aussi agrandir comme pour les autres si besoin
			        (int)(toFill[5]*dy),
			        null);
			} else {
			    // Sécurité : si l'image ne se charge pas, on garde le carré bleu
			    g.setColor(toColor[2]);
			    g.fillRect((int)(toPaint[2].getX()*dx),(int) (toPaint[2].getY()*dy),(int) (toFill[4]*dx),(int) (toFill[5]*dy));
			}
			
			
			if (gp.getBallonMoovset().isBallonFollowsPlayer()==false){
			    g.drawImage(ballImage,
			        (int)(toPaint[1].getX()*dx),
			        (int)((toPaint[1].getY() - gp.getCalcul().getYOffsetForBallDrawing()) * dy),
			        (int)(toFill[2]*dx),
			        (int)(toFill[3]*dy),
			        null);
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
