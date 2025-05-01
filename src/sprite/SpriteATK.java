package sprite;
   

import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;


import Calculator.Controller;
import Test_codeur.KeyHandler;
import player.PlayerMoovset;
import InterfaceGraphique.JPanelDessin;

public class SpriteATK extends PlayerMoovset {
	
	private BufferedImage spriteStandBall,
	spriteDribbleStand,spriteDribbleRun,spriteShoot
	,spriteShootAv,spriteShootAr,spriteStand,spriteRun;;// Image des sprites
	 
	GamePanel gp;
	KeyHandler keyH;
	public SpriteATK(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		}
	public void GetATKImage() {
		try {
			spriteStandBall = ImageIO.read(getClass().getResource(""));
		}
	}
	
	public void draw(Graphics g) {


	}
}

	

