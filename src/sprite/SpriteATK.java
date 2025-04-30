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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import Calculator.Controller;
import Test_codeur.KeyHandler;
import player.PlayerMoovset;
import InterfaceGraphique.JPanelDessin;

public class SpriteATK extends PlayerMoovset {
	GamePanel gp;
	KeyHandler keyH;
	public SpriteATK(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		}

public void draw(Graphics g) {
	JPanelDessin.setBackground(Color.black);

	if(gp!=null) {
		double dx = (double)JPanelDessin.getWidth()/gp.getCalcul().getScreenWidth();
		JPanelDessin.toPaint[0]=gp.getJoueur1().getVecteurPosition(); 
		JPanelDessin.toPaint[1]=gp.getBallon().getVecteurPosition();
		JPanelDessin.toColor[0]=Color.white;
		JPanelDessin.toColor[1]=Color.orange;
		JPanelDessin.toFill[0]=gp.getCalcul().getTileSize();
		JPanelDessin.toFill[1]=(int) (gp.getCalcul().getTileSize()/2);
		JPanelDessin.toFill[2]=gp.JPanelDessin.getCalcul().getTileSize();
		JPanelDessin.toFill[3]=(int) (gp.getCalcul().getTileSize()/2);

		for (int i=0;i<2;i++) {
			g.setColor(JPanelDessin.toColor[i]);
			g.fillRect((int)(JPanelDessin.toPaint[i].getX()*dx),JPanelDessin.toPaint[i].getY(),JPanelDessin.toFill[i],JPanelDessin.toFill[i+2]);

		}
	}
}}
	

