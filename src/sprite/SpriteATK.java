package sprite;
   

import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Calculator.Vector;
import Test_codeur.GamePanel;
import sprite.SpriteATK;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.awt.event.ActionEvent;


import Calculator.Controller;
import Test_codeur.KeyHandler;
import player.PlayerMoovset;
import InterfaceGraphique.JPanelDessin;

public class SpriteATK extends PlayerMoovset implements ImageObserver, ActionListener {
	
	
	public BufferedImage spriteStandBall,
	spriteDribbleStand,
	spriteDribbleRunD,
	spriteDribbleRunG,
	spriteShoot,
	spriteShootAv,
	spriteShootAr,
	spriteStand,
	spriteRun;// Image des sprites
	public String action = "droite";
	public boolean fmove = false;
	public int frameIndex = 0;    // Index de l'animation
	private Timer timerstand;
	public final int SPRITE_SIZE = 32;
	 
	GamePanel gp;
	KeyHandler keyH;

	public SpriteATK(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		}

	public void GetATKImage() {
		try {
			spriteStandBall = ImageIO.read(getClass().getResource("/sprite/ATKHBall.png"));
			spriteDribbleStand = ImageIO.read(getClass().getResource("/sprite/ATKDribbleStand.png"));
			spriteDribbleRunD = ImageIO.read(getClass().getResource("/sprite/ATKDribbleRunD.png"));
			spriteDribbleRunG =ImageIO.read(getClass().getResource("/sprite/ATKDribbleRunG.png"));
			spriteShoot = ImageIO.read(getClass().getResource("sprite/ATKShoot.png"));
			spriteShootAv = ImageIO.read(getClass().getResource("sprite/ATKShootForward.png"));
			spriteShootAr = ImageIO.read(getClass().getResource("sprite/ATKShootFade.png"));
			spriteStand = ImageIO.read(getClass().getResource("sprite/ATKStand.png"));
			spriteRun = ImageIO.read(getClass().getResource("sprite/ATKRun.png"));
		}catch(IOException e) {
			e.printStackTrace();
			}
		 timerstand = new Timer(250, this);
	     timerstand.start();
	}
	
	public String action() {
		if (keyH.qPressed == false && keyH.aPressed == false && keyH.spacePressed == false && keyH.dPressed == false ) {
			action = null;
		}

		else if (keyH.qPressed == true && !keyH.aPressed) {//aller à gauche
			action = "gaucheD";
			fmove = true;
		}
		else if(keyH.qReleased == true && !keyH.aPressed) {//arreter d'aller à gauche 
			action = "Gauche";
		}
		
		else if (keyH.dPressed == true && !keyH.aPressed) {//aller à droite
			action = "droiteD";
			fmove = true;
		}
		else if (keyH.dReleased == true && !keyH.aPressed) {//arreter d'aller à droite
			action = "droiteD";
			fmove = true;
		}
		
		
		return action;
		}
	
	
	public void draw(Graphics g) {
		 // Timer pour le mouvement et l'animation
	     
		timerstand = new Timer(250,(ActionListener) this);// problème action listener
	    timerstand.start();
		BufferedImage image = null;
		if(fmove == false && action == null) {
			image = spriteStandBall.getSubimage(frameIndex * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		}
		else if(action =="droite") {
			image = spriteDribbleStand.getSubimage(frameIndex * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		}
		else if(action == "gauche") {
			image = spriteDribbleStand.getSubimage(frameIndex * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		}
		else if (action == "gaucheD") {
			image = spriteDribbleRunG.getSubimage(frameIndex * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		}
		else if (action == "droiteD") {
			image = spriteDribbleRunD.getSubimage(frameIndex * SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE, SPRITE_SIZE);
		}
		
		g.drawImage(image, 64, 64, 64, 64, this);//ajouter x et y et la taille du sprite ( ici 64x64)
	}
	

	

