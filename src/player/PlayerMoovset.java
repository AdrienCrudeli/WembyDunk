package player;
import Calculator.Controller;
import Calculator.Vector;

public class PlayerMoovset {
	Controller calcul = new Controller();
	public boolean injump = false;
	public boolean moovRight = false;
	public boolean moovLeft = false;
	public PlayerData joueur;
	public double diviseur=1;

	public PlayerMoovset(PlayerData joueur) {
		super();
		this.joueur = joueur;
	}

	public void moovLeft() {
		int pivot = (int) Math.round(-joueur.charVit/diviseur);
		joueur.setVecteurVitesse(pivot,0);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
		moovRight = false;
		moovLeft = true;

	}

	public void moovDown() {
		int pivot = (int) Math.round(-joueur.charVit/diviseur)-50;
		joueur.setVecteurVitesse(0,-pivot);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
	}

	public void moovRight() {
		int pivot = (int) Math.round(joueur.charVit/diviseur);
		joueur.setVecteurVitesse(pivot,0);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
		moovRight = true;
		moovLeft = false;

	}

	public void jumpCondition() {
		injump=true;
	}

	public void jump() {
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.getVecteurSaut().lambda(-1)));
		if (joueur.getVecteurSaut().norme()>0) {
			joueur.setVecteurSaut(joueur.getVecteurSaut().addition(joueur.getVecteurAccélérationJump().lambda(-1)));
		}
	}

	public void resetJump() {
		joueur.setVecteurSaut(joueur.getVecteurSautInit());
		joueur.setCharVit(joueur.getCharVitInit());
	}

	public void solveCollisionImprecision(int yGround) {
		Vector vecteur = new Vector(joueur.getVecteurPosition().getX(),yGround); 
		joueur.setVecteurPosition(vecteur);
	}

	//assesseurs 
	
	

	public boolean isInjump() {
		return injump;
	}
	public boolean isMoovRight() {
		return moovRight;
	}

	public void setMoovRight(boolean moovRight) {
		this.moovRight = moovRight;
	}

	public boolean isMoovLeft() {
		return moovLeft;
	}

	public void setMoovLeft(boolean moovLeft) {
		this.moovLeft = moovLeft;
	}

	public double getDiviseur() {
		return diviseur;
	}

	public void setDiviseur(double diviseur) {
		this.diviseur = diviseur;
	}

	public void setInjump(boolean injump) {
		this.injump = injump;
	}

	public void setInJump(boolean injump) {
		this.injump = injump;
	}

	public PlayerData getJoueur() {
		return joueur;
	}

	public void setJoueur(PlayerData joueur) {
		this.joueur = joueur;
	}



}
