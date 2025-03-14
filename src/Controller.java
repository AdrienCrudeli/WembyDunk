import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller{

	//variable initiale
	
	public int initPosX =0;
	public int initPosY = 0;
	public double initVitY = 0;
	public double initVitX = 0;
	public double initMhu = 0.5;
	public double initDiameter = 0.2419;
	public String initImage = "Ballon.png";
	public Ballon ballon = new Ballon(initPosX,initPosY,initVitX,initVitY,initMhu,initDiameter,initImage);
	public int initCharPosX = 100;
	public int initCharPosY = 100;
	public int initVitChar = 15;
	public int initSaut = 75;
	
	//valeur modifier par le programme
	











		//assesseurs
		public int getInitPosX() {
			return initPosX;
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


	}



