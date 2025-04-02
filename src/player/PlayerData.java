package player;
import KeyHandler;
import Calculator.Controller;
import Calculator.Vector;

public class PlayerData {

	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //start ou stop, s'occupe de la clock

	public Vector vecteurAccJump;
	public Vector vecteurPosition;
	public Vector vecteurSaut;
	public int charVit;
	public Vector initVecteurSaut;
	final public int charVitInit = charVit;
	public Vector vecteurVitesse ;
	Vector initVecteurVitesse;
	public Vector vecteurSautInit;

	public PlayerData(int charPosX,int charPosY, int charVit, int jump,int accJump) {
		super();
		vecteurPosition = new Vector(charPosX,charPosY);
		this.vecteurSaut = new Vector(0, jump);
		this.vecteurVitesse  = new Vector(0,charVit);
		this.vecteurAccJump = new Vector(0,accJump);
		initVecteurSaut = vecteurSaut ;
		this.charVit = charVit;
		this.vecteurSautInit = vecteurSaut;
		this.initVecteurVitesse = vecteurVitesse;
	}

	public void resetVitesse(){
		vecteurVitesse=initVecteurVitesse;
	}

	public void resetJump(){
		vecteurSaut=initVecteurSaut;
	}

	//assesseurs

	public int getCharVitInit() {
		return charVitInit;
	}

	public Vector getVecteurAccJump() {
		return vecteurAccJump;
	}

	public void setVecteurAccJump(Vector vecteurAccJump) {
		this.vecteurAccJump = vecteurAccJump;
	}

	public Vector getInitVecteurSaut() {
		return initVecteurSaut;
	}

	public void setInitVecteurSaut(Vector initVecteurSaut) {
		this.initVecteurSaut = initVecteurSaut;
	}

	public void setVecteurVitesse(Vector vecteurVitesse) {
		this.vecteurVitesse = vecteurVitesse;
	}

	public void setVecteurSautInit(Vector vecteurSautInit) {
		this.vecteurSautInit = vecteurSautInit;
	}

	public Vector getVecteurSautInit() {
		return vecteurSautInit;
	}

	public Vector getVecteurAccélérationJump() {
		return vecteurAccJump;
	}

	public void setVecteurAccélérationJump(Vector vecteurAccélérationJump) {
		this.vecteurAccJump = vecteurAccélérationJump;
	}

	public int getCharVit() {
		return charVit;
	}

	public void setCharVit(int charVit) {
		this.charVit = charVit;
	}

	public Vector getVecteurPosition() {
		return vecteurPosition;
	}

	public void setVecteurPosition(Vector vecteurPosition) {
		this.vecteurPosition = vecteurPosition;
	}

	public Vector getVecteurSaut() {
		return vecteurSaut;
	}

	public void setVecteurSaut(Vector vecteurSaut) {
		this.vecteurSaut = vecteurSaut;
	}

	public Vector getVecteurVitesse() {
		return vecteurVitesse;
	}

	public void setVecteurVitesse(int x, int y) {
		this.vecteurVitesse.setX(x);
		this.vecteurVitesse.setY(y);
	}
}
