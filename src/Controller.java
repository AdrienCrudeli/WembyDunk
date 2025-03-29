import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	public double dividedVit = 1.9; //vitesse diviseur dans le saut

	//paramètre Ballon/////////////////////////////////////////////////////////////////////////////////////

	public int initPosX =0;
	public int initPosY = 0;
	public double initVitY = 0;
	public double initVitX = 0;
	public double initMhu = 0.5;
	public double initDiameter = 0.2419;
	public String initImage = "Ballon.png";

	//Paramètre terrain/////////////////////////////////////////////////////////////////////////////////////
	
	public int initGravity = 10;
	public int accGravity = 3;
	public int gravity=initGravity;

	//Objet/////////////////////////////////////////////////////////////////////////////////////

	public Ballon ballon = new Ballon(initPosX,initPosY,initVitX,initVitY,initMhu,initDiameter,initImage);

	//assesseurs

	public int getInitPosX() {
		return initPosX;
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

	public int getAccJump() {
		return accJump;
	}

	public void setAccJump(int accJump) {
		this.accJump = accJump;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public void setInitPosX(int initPosX) {
		this.initPosX = initPosX;
	}

	public int getInitPosY() {
		return initPosY;
	}

	public void setInitPosY(int initPosY) {
		this.initPosY = initPosY;
	}

	public double getInitVitY() {
		return initVitY;
	}

	public void setInitVitY(double initVitY) {
		this.initVitY = initVitY;
	}

	public double getInitVitX() {
		return initVitX;
	}

	public void setInitVitX(double initVitX) {
		this.initVitX = initVitX;
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

	public String getInitImage() {
		return initImage;
	}

	public void setInitImage(String initImage) {
		this.initImage = initImage;
	}

	public Ballon getBallon() {
		return ballon;
	}

	public void setBallon(Ballon ballon) {
		this.ballon = ballon;
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

	public void setIntCharPosY(int initCharPosY) {
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

	public void setInitCharPosY(int initCharPosY) {
		this.initCharPosY = initCharPosY;
	}

	public int getFPS() {
		return FPS;
	}

	public void setFPS(int fPS) {
		FPS = fPS;
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

	public double getDividedVit() {
		return dividedVit;
	}

	public void setDividedVit(int dividedVit) {
		this.dividedVit = dividedVit;
	}
}



