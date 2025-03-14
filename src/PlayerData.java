
public class PlayerData {
	
	
	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //start ou stop, s'occupe de la clock
	
	public int charPosX = calcul.getInitCharPosX();
	public int charPosY = calcul.getInitCharPosY();
	public int charVit = calcul.getInitVitChar(); 
	public int jump = calcul.getInitSaut();

	public double initGravity = 9.81;
	public double accGravity = 1;
	public double accJump=5;
	public double gravity=initGravity;

	public boolean injump = false;
	
	final int originalTileSize = 64; //taille originale des cellules importés
	final int scale = 1;

	final int tileSize = originalTileSize * scale; //taille cellules après fonction échelle
	final int maxScreenColumn = 16; //combien de cellule on affiche en colonne
	final int maxScreenRow = 12; //combien de cellule on affiche en ligne
	final int screenWidth = tileSize * maxScreenColumn;
	
	final int screenHeight = tileSize * maxScreenRow;
	

	public PlayerData(int charPosX, int charPosY, int charVit, int jump) {
		super();
		this.charPosX = charPosX;
		this.charPosY = charPosY;
		this.charVit = charVit;
		this.jump = jump;
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

	public double getInitGravity() {
		return initGravity;
	}

	public void setInitGravity(double initGravity) {
		this.initGravity = initGravity;
	}

	public double getAccGravity() {
		return accGravity;
	}

	public void setAccGravity(double accGravity) {
		this.accGravity = accGravity;
	}

	public double getAccJump() {
		return accJump;
	}

	public void setAccJump(double accJump) {
		this.accJump = accJump;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public boolean isInjump() {
		return injump;
	}

	public void setInjump(boolean injump) {
		this.injump = injump;
	}
	
	
}
