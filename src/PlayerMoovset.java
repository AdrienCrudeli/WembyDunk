
public class PlayerMoovset {
	public boolean injump = false;
	public PlayerData joueur;
	
	



	public PlayerMoovset(PlayerData joueur) {
		super();
		this.joueur = joueur;
	}
	
	public void moovLeft() {
		joueur.setVecteurVitesse(0,-joueur.charVit);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
	}
	public void moovDown() {
		joueur.setVecteurVitesse(-joueur.charVit,0);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
		
	}
	public void moovRight() {
		joueur.setVecteurVitesse(0,joueur.charVit);
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(joueur.vecteurVitesse));
	}
	public void jumpCondition() {
		injump=true;
		joueur.setCharVit(joueur.getCharVit()/joueur.getDividedVit());

	}
	public void jump() {
		joueur.setVecteurPosition(joueur .getVecteurPosition().addition(joueur.getVecteurSaut().lambda(-1)));
		if (joueur.getVecteurSaut().norme()>0) {
			joueur.setVecteurSaut(joueur.getVecteurSaut().addition(joueur.getVecteurSaut().lambda(-1)));
		}
	}

	public void resetJump() {
		joueur.setVecteurSaut(joueur.getVecteurSautInit());
		joueur.setCharVit(joueur.getCharVitInit());

	}	
	public void solveCollisionImprecision(double yGround) {
		Vector vecteur = new Vector(joueur.getVecteurPosition().toTab()[0],yGround); 
		joueur.setVecteurPosition(vecteur);
	}

	
	






	//assesseurs 
	public boolean isInjump() {
		return injump;
	}
	public void setInjump(boolean injump) {
		this.injump = injump;
	}

	public PlayerData getJoueur() {
		return joueur;
	}

	public void setJoueur(PlayerData joueur) {
		this.joueur = joueur;
	}



}
