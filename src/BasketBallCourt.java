
public class BasketBallCourt {


	public double accGravity;
	public double gravity;
	public Vector vecteurGravité = new Vector(0,-gravity);
	public double initGravity = gravity;
	



	public BasketBallCourt(double accGravity, double gravity) {
		super();
		this.accGravity = accGravity;
		this.gravity = gravity;
		
	}


	public void applieGravity(PlayerData joueur, PlayerMoovset joueurMoovset) {
		joueur.setVecteurPosition(joueur.getVecteurPosition().addition(vecteurGravité.lambda(-1)));
		if (!joueurMoovset.isInjump() || joueur.vecteurSaut.norme()==0) {
			gravity+=accGravity;

		}

	}
	
	public void resetGravity() {
		gravity=initGravity;
	}
	
	
}
