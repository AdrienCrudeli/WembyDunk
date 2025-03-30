import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Controller{

	//paramètre affichage/////////////////////////////////////////////////////////////////////////////////////

	final int originalTileSize = 64; //taille originale des cellules importés
	final int scale = 1;

	final int tileSize = originalTileSize * scale; //taille cellules après fonction échelle
	final int maxScreenColumn = 16; //combien de cellule on affiche en colonne
	final int maxScreenRow = 12; //combien de cellule on affiche en ligne
	final int screenWidth = tileSize * maxScreenColumn;
	final int screenHeight = tileSize * maxScreenRow;

	//FPS
	int FPS = 60;

	//paramètre personnage/////////////////////////////////////////////////////////////////////////////////////

	public int initCharPosX = 100;
	public int initCharPosY = 100;
	public int initVitChar = 15;
	public int initSaut = 75;
	public int accJump=5;
	public double dividedVit = 3; //vitesse diviseur dans le saut

	//paramètre Ballon/////////////////////////////////////////////////////////////////////////////////////

	public Vector initVecteurPositionBallon = new Vector(0,0);
	public int initVit = 0;
	public double initMhu = 0.5;
	public double initDiameter = 0.2419;
	public ImageIcon imageBallon = new ImageIcon("Ballon.png");
	public int initForceMax = 100;
	public int gravitéBallon = 10;
	public int accGravitéBallon = 2;
	public Vector accGravityBallon = new Vector(0,-accGravitéBallon);
	public Vector gravityBallon = new Vector(0,-gravitéBallon);

	//Paramètre terrain/////////////////////////////////////////////////////////////////////////////////////

	public int initGravity = 10;
	public int accGravity = 3;
	public int gravity=initGravity;
	public Vector vecteurGravité = new Vector(0,initGravity);
	public Vector vecteurAccGravité = new Vector(0,accGravity);

	//Calculs bruts

	//assesseurs
	
	

	public int getFPS() {
		return FPS;
	}
	public Vector getVecteurGravité() {
		return vecteurGravité;
	}
	public void setVecteurGravité(Vector vecteurGravité) {
		this.vecteurGravité = vecteurGravité;
	}
	public Vector getVecteurAccGravité() {
		return vecteurAccGravité;
	}
	public void setVecteurAccGravité(Vector vecteurAccGravité) {
		this.vecteurAccGravité = vecteurAccGravité;
	}
	public int getGravitéBallon() {
		return gravitéBallon;
	}
	public void setGravitéBallon(int gravitéBallon) {
		this.gravitéBallon = gravitéBallon;
	}
	public int getAccGravitéBallon() {
		return accGravitéBallon;
	}
	public void setAccGravitéBallon(int accGravitéBallon) {
		this.accGravitéBallon = accGravitéBallon;
	}
	public Vector getAccGravityBallon() {
		return accGravityBallon;
	}
	public void setAccGravityBallon(Vector accGravityBallon) {
		this.accGravityBallon = accGravityBallon;
	}
	public Vector getGravityBallon() {
		return gravityBallon;
	}
	public void setGravityBallon(Vector gravityBallon) {
		this.gravityBallon = gravityBallon;
	}
	public void setFPS(int fPS) {
		FPS = fPS;
	}
	public int getInitCharPosX() {
		return initCharPosX;
	}
	public void setInitCharPosX(int initCharPosX) {
		this.initCharPosX = initCharPosX;
	}
	public int getInitCharPosY() {
		return initCharPosY;
	}
	public void setInitCharPosY(int initCharPosY) {
		this.initCharPosY = initCharPosY;
	}
	public int getInitVitChar() {
		return initVitChar;
	}
	public void setInitVitChar(int initVitChar) {
		this.initVitChar = initVitChar;
	}
	public int getInitSaut() {
		return initSaut;
	}
	public void setInitSaut(int initSaut) {
		this.initSaut = initSaut;
	}
	public int getAccJump() {
		return accJump;
	}
	public void setAccJump(int accJump) {
		this.accJump = accJump;
	}
	public double getDividedVit() {
		return dividedVit;
	}
	public void setDividedVit(double dividedVit) {
		this.dividedVit = dividedVit;
	}
	
	public Vector getInitVecteurPositionBallon() {
		return initVecteurPositionBallon;
	}
	public void setInitVecteurPositionBallon(Vector initVecteurPositionBallon) {
		this.initVecteurPositionBallon = initVecteurPositionBallon;
	}
	public int getInitForceMax() {
		return initForceMax;
	}
	public void setInitForceMax(int initForceMax) {
		this.initForceMax = initForceMax;
	}
	public int getInitVit() {
		return initVit;
	}
	public void setInitVit(int initVit) {
		this.initVit = initVit;
	}
	public double getInitMhu() {
		return initMhu;
	}
	public void setInitMhu(double initMhu) {
		this.initMhu = initMhu;
	}
	public double getInitDiameter() {
		return initDiameter;
	}
	public void setInitDiameter(double initDiameter) {
		this.initDiameter = initDiameter;
	}
	public ImageIcon getImageBallon() {
		return imageBallon;
	}
	public void setImageBallon(ImageIcon imageBallon) {
		this.imageBallon = imageBallon;
	}
	public int getInitGravity() {
		return initGravity;
	}
	public void setInitGravity(int initGravity) {
		this.initGravity = initGravity;
	}
	public int getAccGravity() {
		return accGravity;
	}
	public void setAccGravity(int accGravity) {
		this.accGravity = accGravity;
	}
	public int getGravity() {
		return gravity;
	}
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}
	public int getOriginalTileSize() {
		return originalTileSize;
	}
	public int getScale() {
		return scale;
	}
	public int getTileSize() {
		return tileSize;
	}
	public int getMaxScreenColumn() {
		return maxScreenColumn;
	}
	public int getMaxScreenRow() {
		return maxScreenRow;
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}

}
