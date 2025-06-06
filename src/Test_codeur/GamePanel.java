package Test_codeur;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Ballon.Ballon;
import Ballon.BallonMoovSet;
import Calculator.Controller;
import Calculator.Vector;
import Field.BasketBallCourt;
import InterfaceGraphique.JPanelDessin;
import player.PlayerData;
import player.PlayerMoovset;
import Field.Panier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GamePanel extends JPanel implements Runnable {

	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();

	///Initialisation//////////////////////////////////////////////////////////////////





	// variable dans controller

	public int charPosX = calcul.getInitCharPosX();
	public int charPosY = calcul.getInitCharPosY();
	public int charVit = calcul.getInitVitChar(); 
	public int jump = calcul.getInitSaut();
	Vector nulle = new Vector(0,0);

	public Vector gravity = calcul.getVecteurGravité();


	public Vector accGravity = calcul.getVecteurAccGravité();
	public int accJump=calcul.getAccJump();
	public int initGravity = calcul.getInitGravity();
	boolean asBeenPressed = false;

	public ImageIcon imageBallon = calcul.getImageBallon(); //Image importé pointée via nom de fichier
	public Vector vecteurPositionBallon = calcul.getInitVecteurPositionBallon();
	public double vitesseBallon = calcul.getInitVit(); //Vitesse Ballon instant t
	public double uBallon = calcul.getInitMhu(); //Coefficient viscosité dynamique
	public double diamètreBallon = calcul.getInitDiameter(); //Diamètre du Ballon
	public Vector gravityBallon = calcul.getGravityBallon();
	public Vector accGravityBallon = calcul.getAccGravityBallon();

	public Vector vecteurPositionPanier =calcul.getInitVecteurPositionPanier();
	public Vector vecteurPositionArceau =calcul.getCentreArceau();
	public int largeurPanier = calcul.getInitLargPanier();
	public int longueurPanier = calcul.getInitLongeurPanier();
	public int compteur1 = calcul.getInitCompteur() ;
	public boolean isCounted = false;


	double dx = 1;
	double dy = 1;
	/////////////////////////////////////////////////////////////////////////////////////



	// toutes les objets de classes/////////////////////////////////////////////////////

	PlayerData joueur1 = new PlayerData(charPosX,charPosY, charVit, jump,accJump);
	PlayerMoovset joueur1Moovset = new PlayerMoovset(joueur1);
	BasketBallCourt terrain = new BasketBallCourt(accGravity,gravity,gravityBallon,accGravityBallon);
	Ballon ballon = new Ballon(vecteurPositionBallon,vitesseBallon,uBallon,diamètreBallon,terrain);
	BallonMoovSet ballonMoovset = new BallonMoovSet(ballon);
	Vector offSet = new Vector(10,10);
	Panier panier = new Panier(vecteurPositionPanier, largeurPanier,longueurPanier);
	JPanelDessin dessin;

	//autre nécéssaires

	public boolean pivot = false;


	////Code////////////////////////////////////////////////////////////////

	public GamePanel(JPanelDessin dessin ) {
		this.dessin=dessin;
		this.setFocusable(true); // Make the panel focusable
		this.addKeyListener(keyH); // Add the KeyHandler as a key listener
		this.dx = dessin.getDx();
		this.dy = dessin.getDy();


	}

	public void start() {
		Thread t1 = new Thread(this);
		t1.start();
	}
	@Override
	public void run() { //créer par le thread, gameloop, selon gagneux mettre dans simulateur
		// TODO Auto-generated method stub


		double drawInterval= 1000000000/calcul.getFPS(); //méthode des deltas pour faire attendre
		double delta = 0; // on est en train de créer le séquencage
		long lastTime = System.nanoTime();
		long currentTime;
		while(true) {

			currentTime = System.nanoTime();
			delta+= (currentTime - lastTime)/drawInterval;
			lastTime=currentTime;
			if (delta>=1) {
				//update
				this.update();

				//dessine
				dessin.repaint();

				delta --;
			}

		}
	}

	public void update() { //classe qui met à jour

		//Pour corriger le code


		//Paramétrage des clés pour partie joueur
		if (keyH.qPressed == true && !keyH.aPressed) { //aller à gauche
			joueur1Moovset.moovLeft();
		}

		if(keyH.sPressed && !keyH.aPressed) { //aller en bas
			joueur1Moovset.moovDown();

		}

		if (keyH.dPressed && !keyH.aPressed) { //aller à droite
			joueur1Moovset.moovRight();
		}

		if(keyH.spacePressed && !joueur1Moovset.isInjump()) { //sauter
			joueur1Moovset.jumpCondition();
			joueur1Moovset.setDiviseur(calcul.getDividedVit());


		}

		if(keyH.spaceReleased) {
		}

		//managment de la gravité
		if (joueur1.getVecteurPosition().getY()<=(calcul.getScreenHeight()-106)*dy) {
			terrain.applieGravity(joueur1Moovset); //si le joueur en l'air, on active la gravité

			if (!joueur1Moovset.isInjump() || joueur1Moovset.getJoueur().getVecteurSaut().getY()<=0) {  
				terrain.addAccGrav(); //accélération liée à la gravité si en saut 

			}
		}

		if(joueur1.getVecteurPosition().getY()>=(calcul.getScreenHeight()-100)*dy) { //on reset la gravity les effets de l'accélération une ois au sol
			terrain.resetGravity();

		}

		if (joueur1Moovset.isInjump()) { // on a besoin de cette condition pour appliquer les différentes accélérations
			joueur1Moovset.jump();


			if (joueur1.getVecteurSaut().norme()>0) { //on ajoute une vecteur négatif jusqu'a atteindre 0 pour simuler l'accélération
				joueur1Moovset.getJoueur().getVecteurSaut().addition(joueur1Moovset.getJoueur().getVecteurAccJump().lambda(-1));
				terrain.applieGravity(joueur1Moovset);
			}
		}

		if (joueur1.getVecteurSaut().norme()==0 && joueur1.getVecteurPosition().getY()>=(calcul.getScreenHeight()-106)*dy) {
			joueur1.resetJump(); //on reset les effets liés au jump
			joueur1.resetVitesse();
			joueur1Moovset.setDiviseur(1);
			joueur1Moovset.setInJump(false);

		}

		if (joueur1.getVecteurPosition().getY()>(calcul.getScreenHeight()-110)*dy) { //impose ligne collision

			terrain.imposeCollision(joueur1);
		}

		if (joueur1.getVecteurPosition().getX()>(calcul.getScreenWidth()+420)*dx) {
			joueur1.getVecteurPosition().setX((int) ((calcul.getScreenWidth()+400)*dx));;
		}
		if (joueur1.getVecteurPosition().getX()<(-20)*dx) {
			joueur1.getVecteurPosition().setX((int)(0*dx));;
		}

		//Partie Ballon
		
		if (keyH.ePressed) {
			ballonMoovset.setBallonFollowsPlayer(true);
		}



		if (keyH.aPressed && ballonMoovset.isBallonFollowsPlayer()){//partie controller angle et puissance tire
			ballonMoovset.resetForce();
			if (keyH.zPressed ) {
				ballonMoovset.chargeZ();
			}
			if (keyH.dPressed) {
				ballonMoovset.chargeD();
			}

			if (keyH.sPressed) {
				ballonMoovset.chargeS();
			}
			if (keyH.qPressed) {
				ballonMoovset.chargeQ();
			}
			ballonMoovset.chargeTot();

			pivot = true;
		}
		if (keyH.aReleased && pivot && ballonMoovset.isBallonFollowsPlayer()) {
			ballonMoovset.setBallonFollowsPlayer(false);
			ballonMoovset.launch();
			pivot = false;

		}
		if (ballon.getVecteurPosition().getY()>calcul.getScreenHeight()-90) {
			ballon.getTerrain().resetGravityBallon();
			ballon.changeCollidedY();
			ballonMoovset.getBallon().getTerrain().setVecteurGravitéBallon(ballonMoovset.getBallon().getTerrain().getVecteurGravitéBallon().lambda(uBallon));
		}
		
		if (ballon.getVecteurPosition().getX() <  vecteurPositionArceau.getX()+10*dx && ballon.getVecteurPosition().getX() >  vecteurPositionArceau.getX()-80*dx && ballon.getVecteurPosition().getY() <  vecteurPositionArceau.getY() + 120*dy && ballon.getVecteurPosition().getY() >  vecteurPositionArceau.getY()+80*dy  && isCounted == false) {
		    compteur1++;
		    isCounted = true;

		    System.out.println("Score : " + compteur1);
		    System.out.println("Fin du jeu.");

		    // Ferme la fenêtre principale (Swing)
		    java.awt.Window[] windows = java.awt.Window.getWindows();
		    for (java.awt.Window window : windows) {
		        window.dispose();
		    }

		    // Arrête complètement le programme
		    System.exit(0);
		}



		if (ballon.getVecteurPosition().getX()>calcul.getScreenWidth()+offSet.norme()|| ballon.getVecteurPosition().getX()<0-offSet.norme() ) {
			ballon.changeCollidedX();
		}
		if (ballon.getVecteurPosition().getY()>calcul.getScreenHeight()-80) {
			ballon.getVecteurPosition().setY(calcul.getScreenHeight()-70);
			ballon.getTerrain().setVecteurGravitéBallon(ballon.getTerrain().getVecteurGravitéBallon());
		}


		if (ballonMoovset.getForce().norme()!=0 && !ballonMoovset.isBallonFollowsPlayer()) {
			ballonMoovset.moov(terrain);
		}

		if (ballonMoovset.isBallonFollowsPlayer()) {
			ballon.setVecteurPosition(joueur1.getVecteurPosition().addition(offSet));
		}

		if (!ballonMoovset.isBallonFollowsPlayer() && ballon.getVecteurPosition().compare_intervalle(joueur1.getVecteurPosition(),32,32)) {
			ballonMoovset.setBallonFollowsPlayer(true);
		}

		if (ballon.getVecteurPosition().getX()>calcul.getScreenWidth()+offSet.norme()) {
			ballon.getVecteurPosition().setX(calcul.getScreenWidth()-20);

		}
		if (ballon.getVecteurPosition().getX()<0-offSet.norme()) {
			ballon.getVecteurPosition().setX(0);;
		}

	}





	//accesseurs

	public Vector getVecteurPositionPanier() {
		return vecteurPositionPanier;
	}

	public void setVecteurPositionPanier(Vector vecteurPositionPanier) {
		this.vecteurPositionPanier = vecteurPositionPanier;
	}

	public int getLargeurPanier() {
		return largeurPanier;
	}

	public void setLargeurPanier(int largeurPanier) {
		this.largeurPanier = largeurPanier;
	}

	public int getLongueurPanier() {
		return longueurPanier;
	}

	public void setLongueurPanier(int longueurPanier) {
		this.longueurPanier = longueurPanier;
	}

	public int getCompteur1() {
		return compteur1;
	}

	public void setCompteur1(int compteur1) {
		this.compteur1 = compteur1;
	}

	public boolean isCounted() {
		return isCounted;
	}

	public void setCounted(boolean isCounted) {
		this.isCounted = isCounted;
	}

	public Controller getCalcul() {
		return calcul;
	}

	public void setCalcul(Controller calcul) {
		this.calcul = calcul;
	}

	public KeyHandler getKeyH() {
		return keyH;
	}

	public void setKeyH(KeyHandler keyH) {
		this.keyH = keyH;
	}

	public int getCharPosX() {
		return charPosX;
	}

	public void setCharPosX(int charPosX) {
		this.charPosX = charPosX;
	}

	public int getCharPosY() {
		return charPosY;
	}

	public void setCharPosY(int charPosY) {
		this.charPosY = charPosY;
	}

	public int getCharVit() {
		return charVit;
	}

	public void setCharVit(int charVit) {
		this.charVit = charVit;
	}

	public int getJump() {
		return jump;
	}

	public void setJump(int jump) {
		this.jump = jump;
	}

	public Vector getNulle() {
		return nulle;
	}

	public void setNulle(Vector nulle) {
		this.nulle = nulle;
	}

	public Vector getGravity() {
		return gravity;
	}

	public void setGravity(Vector gravity) {
		this.gravity = gravity;
	}

	public Vector getAccGravity() {
		return accGravity;
	}

	public void setAccGravity(Vector accGravity) {
		this.accGravity = accGravity;
	}

	public int getAccJump() {
		return accJump;
	}

	public void setAccJump(int accJump) {
		this.accJump = accJump;
	}

	public int getInitGravity() {
		return initGravity;
	}

	public void setInitGravity(int initGravity) {
		this.initGravity = initGravity;
	}

	public boolean isAsBeenPressed() {
		return asBeenPressed;
	}

	public void setAsBeenPressed(boolean asBeenPressed) {
		this.asBeenPressed = asBeenPressed;
	}

	public ImageIcon getImageBallon() {
		return imageBallon;
	}

	public void setImageBallon(ImageIcon imageBallon) {
		this.imageBallon = imageBallon;
	}

	public Vector getVecteurPositionBallon() {
		return vecteurPositionBallon;
	}

	public void setVecteurPositionBallon(Vector vecteurPositionBallon) {
		this.vecteurPositionBallon = vecteurPositionBallon;
	}

	public double getVitesseBallon() {
		return vitesseBallon;
	}

	public void setVitesseBallon(double vitesseBallon) {
		this.vitesseBallon = vitesseBallon;
	}

	public double getuBallon() {
		return uBallon;
	}

	public void setuBallon(double uBallon) {
		this.uBallon = uBallon;
	}

	public double getDiamètreBallon() {
		return diamètreBallon;
	}

	public void setDiamètreBallon(double diamètreBallon) {
		this.diamètreBallon = diamètreBallon;
	}

	public Vector getGravityBallon() {
		return gravityBallon;
	}

	public void setGravityBallon(Vector gravityBallon) {
		this.gravityBallon = gravityBallon;
	}

	public Vector getAccGravityBallon() {
		return accGravityBallon;
	}

	public void setAccGravityBallon(Vector accGravityBallon) {
		this.accGravityBallon = accGravityBallon;
	}

	public PlayerData getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(PlayerData joueur1) {
		this.joueur1 = joueur1;
	}

	public PlayerMoovset getJoueur1Moovset() {
		return joueur1Moovset;
	}

	public void setJoueur1Moovset(PlayerMoovset joueur1Moovset) {
		this.joueur1Moovset = joueur1Moovset;
	}

	public BasketBallCourt getTerrain() {
		return terrain;
	}

	public void setTerrain(BasketBallCourt terrain) {
		this.terrain = terrain;
	}

	public Ballon getBallon() {
		return ballon;
	}

	public void setBallon(Ballon ballon) {
		this.ballon = ballon;
	}

	public BallonMoovSet getBallonMoovset() {
		return ballonMoovset;
	}

	public void setBallonMoovset(BallonMoovSet ballonMoovset) {
		this.ballonMoovset = ballonMoovset;
	}

	public Vector getOffSet() {
		return offSet;
	}

	public void setOffSet(Vector offSet) {
		this.offSet = offSet;
	}

	public boolean isPivot() {
		return pivot;
	}

	public void setPivot(boolean pivot) {
		this.pivot = pivot;
	}
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
}



