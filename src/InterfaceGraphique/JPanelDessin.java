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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sprite.SpriteATK;


public class JPanelDessin extends JPanel {
	SpriteATK spriteATK = new SpriteATK(this, null );// dois mettre le key handler mais non reconnus
	
	public void setGp(GamePanel gp) {
		this.gp = gp;
	}
	public JPanelDessin () {
		this.setBackground(Color.black);
		this.setFocusable(true);
	}
	protected void paintComponent(Graphics g) { //classe qui repaint //attention null
		super.paintComponents(g); //classe parental
		System.out.println("dessin");
		Graphics2D g2 = (Graphics2D)g;

		SpriteATK.draw(g2);
		g2.dispose();
		
	}
}
