package player;
import Calculator.Controller;
import Calculator.Vector;

public class PlayerMoovset {
	Controller calcul = new Controller();
	public boolean injump = false;
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
	}

	public void jumpCondition() {
		injump=true;
	}

	public void jump() {
		System.out.println("jump");
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
