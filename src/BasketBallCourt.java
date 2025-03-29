
public class BasketBallCourt {
	Controller calcul = new Controller();

	public Vector initVecteurGravité;
	public Vector vecteurGravité;
	public Vector vecteurAccGravité;

	public BasketBallCourt(int accGravity, int gravity) {
		super();
		this.vecteurGravité = new Vector(0,-gravity);
		this.vecteurAccGravité = new Vector(0,-accGravity);
		this.initVecteurGravité=vecteurGravité;
	}

	public void applieGravity(PlayerMoovset joueurMoovset) {
		joueurMoovset.getJoueur().setVecteurPosition(joueurMoovset.getJoueur().getVecteurPosition().addition(vecteurGravité.lambda(-1)));
		if (!joueurMoovset.isInjump() || joueurMoovset.getJoueur().vecteurSaut.norme()==0) {
			vecteurGravité.addition(vecteurAccGravité);
		}
	}

	public void imposeCollision(PlayerData joueur) {
		joueur.setVecteurPosition(new Vector(joueur.getVecteurPosition().getX(),calcul.getScreenHeight()-106));
	}

	public void addAccGrav() {
		vecteurGravité = vecteurGravité.addition(vecteurAccGravité);
	}

	public void resetGravity() {
		vecteurGravité=initVecteurGravité;
	}

	public Vector getInitVecteurGravité() {
		return initVecteurGravité;
	}

	public void setInitVecteurGravité(Vector initVecteurGravité) {
		this.initVecteurGravité = initVecteurGravité;
	}

	public Vector getVecteurGravité() {
		return vecteurGravité;
	}

	public void setVecteurGravité(Vector vecteurGravité) {
		this.vecteurGravité = vecteurGravité;
	}

	public Vector getVecteurAccGravité() {
		return vecteurAccGravité;
	}

	public void setVecteurAccGravité(Vector vecteurAccGravité) {
		this.vecteurAccGravité = vecteurAccGravité;
	}


}

