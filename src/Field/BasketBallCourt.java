package Field;
import Ballon.Ballon;
import Ballon.BallonMoovSet;
import Calculator.Controller;
import Calculator.Vector;
import player.PlayerData;
import player.PlayerMoovset;

public class BasketBallCourt {
	Controller calcul = new Controller();

	public Vector initVecteurGravité;
	public Vector vecteurGravité;
	public Vector vecteurAccGravité;
	public Vector vecteurGravitéBallon;
	public Vector vecteurAccGravitéBallon;
	public Vector initVecteurGravitéBallon;



	public BasketBallCourt(Vector vecteurGravité, Vector vecteurAccGravité, Vector vecteurGravitéBallon,
			Vector vecteurAccGravitéBallon) {
		super();
		this.vecteurGravité = vecteurGravité;
		this.vecteurAccGravité = vecteurAccGravité;
		this.vecteurGravitéBallon = vecteurGravitéBallon;
		this.vecteurAccGravitéBallon = vecteurAccGravitéBallon;
		this.initVecteurGravité=this.vecteurGravité;
		this.initVecteurGravitéBallon = this.vecteurGravitéBallon;
	}
	public void applieGravity(PlayerMoovset joueurMoovset) {
		joueurMoovset.getJoueur().setVecteurPosition(joueurMoovset.getJoueur().getVecteurPosition().addition(vecteurGravité));
		if (!joueurMoovset.isInjump() || joueurMoovset.getJoueur().vecteurSaut.norme()==0) {
			setVecteurGravité(vecteurGravité.addition(vecteurAccGravité));
		}
	}
	public void applieBallongravity(Ballon ballon){

		ballon.setVecteurPosition(ballon.getVecteurPosition().addition(vecteurGravitéBallon.lambda(1)));
		setVecteurGravitéBallon(vecteurGravitéBallon.addition(vecteurAccGravitéBallon.lambda(-1)));
		System.out.println("Vecteur gravité ballon = "+vecteurGravitéBallon.toString());
		
	}

	public void imposeCollision(PlayerData joueur) {
		joueur.setVecteurPosition(new Vector(joueur.getVecteurPosition().getX(),calcul.getScreenHeight()-106));
		
	}
	public void imposeCollision(Ballon ballon) {
		ballon.setVecteurPosition(new Vector(ballon.getVecteurPosition().getX(),calcul.getScreenHeight()-106));
	}

	public void addAccGrav() {
		vecteurGravité = vecteurGravité.addition(vecteurAccGravité);
	}

	public void resetGravity() {
		this.vecteurGravité=this.initVecteurGravité;
	}
	public void resetGravityBallon() {
		this.vecteurGravitéBallon=this.initVecteurGravitéBallon;
		
	}

	public Vector getInitVecteurGravité() {
		return initVecteurGravité;
	}
	

	public Vector getVecteurGravitéBallon() {
		return vecteurGravitéBallon;
	}
	public void setVecteurGravitéBallon(Vector vecteurGravitéBallon) {
		this.vecteurGravitéBallon = vecteurGravitéBallon;
	}
	public Vector getVecteurAccGravitéBallon() {
		return vecteurAccGravitéBallon;
	}
	public void setVecteurAccGravitéBallon(Vector vecteurAccGravitéBallon) {
		this.vecteurAccGravitéBallon = vecteurAccGravitéBallon;
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

