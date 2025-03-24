
public class PlayerData {


	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //start ou stop, s'occupe de la clock

	public double accJump;
	public Vector vecteurAccélérationJump = new Vector(0,-accJump);
	public double dividedVit;
	public double jump;
	public Vector vecteurPosition;
	public Vector vecteurSaut = new Vector(0,jump);
	public double charVit;

	
	final public Vector vecteurSautInit = new Vector(vecteurSaut.getX(),vecteurSaut.getY());
	final public double charVitInit = charVit;
	Vector vecteurVitesse = new Vector(0,0);





	public PlayerData(double charPosX,double charPosY, double charVit, double jump,double dividedVit,double accJump) {
		super();
		vecteurPosition = new Vector(charPosX,charPosY);
		this.accJump = jump;
		this.charVit = charVit;
		this.accJump = accJump;

	}
	//assesseurs
	
	

	public double getDividedVit() {
		return dividedVit;
	}


	public double getCharVitInit() {
		return charVitInit;
	}



	public Vector getVecteurSautInit() {
		return vecteurSautInit;
	}



	public double getAccJump() {
		return accJump;
	}



	public void setAccJump(double accJump) {
		this.accJump = accJump;
	}



	public Vector getVecteurAccélérationJump() {
		return vecteurAccélérationJump;
	}



	public void setVecteurAccélérationJump(Vector vecteurAccélérationJump) {
		this.vecteurAccélérationJump = vecteurAccélérationJump;
	}



	public double getCharVit() {
		return charVit;
	}



	public void setCharVit(double charVit) {
		this.charVit = charVit;
	}



	public void setDividedVit(int dividedVit) {
		this.dividedVit = dividedVit;
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

	public void setDividedVit(double dividedVit) {
		this.dividedVit = dividedVit;
	}



	public Vector getVecteurVitesse() {
		return vecteurVitesse;
	}



	public void setVecteurVitesse(double x, double y) {
		this.vecteurVitesse.setX(x);
		this.vecteurVitesse.setX(y);
		
	}






}
