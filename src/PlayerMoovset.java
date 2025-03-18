
public class PlayerMoovset {
	public boolean injump = false;


	public void moovLeft(PlayerData joueur,Vector vecteurVitesse) {
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(vecteurVitesse.lambda(-1)));
	}
	public void moovRight(PlayerData joueur, Vector vecteurVitesse) {
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(vecteurVitesse));
	}
	public void jumpConditon(PlayerData joueur) {
		injump=true;
		joueur.setCharVit(joueur.getCharVit()/joueur.getDividedVit());

	}
	public void jump(PlayerData joueur) {
		joueur.setVecteurPosition(joueur .getVecteurPosition().addition(joueur.getVecteurSaut().lambda(-1)));
		if (joueur.getVecteurSaut().norme()>0) {
			joueur.setVecteurSaut(joueur.getVecteurSaut().addition(joueur.getVecteurSaut().lambda(-1)));
		}
	}

	public void resetJump(PlayerData joueur) {
		joueur.setVecteurSaut(joueur.getVecteurSautInit());
		joueur.setCharVit(joueur.getCharVitInit());

	}	
	public void solveCollisionImprecision(PlayerData joueur,double yGround) {
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


}
