package Ballon;
import Calculator.Controller;
import Calculator.Vector;
import Field.BasketBallCourt;

public class BallonMoovSet {

	public Ballon ballon;
	public Controller calcul = new Controller();

	public double timeZPressed = 0; //on prends le tempds des touches nécessaire pour dessiner notre vecteur en fonction des proportions
	public double timeDPressed = 0;
	public double timeSPressed = 0;
	public double timeQPressed = 0;
	public double timeTot = 0;

	public boolean zPivot = false; //on veut que le released return que une fois, donc on s'assure de le faire passer que sur une boucle du run
	public boolean qPivot = false;
	public boolean sPivot = false;
	public boolean dPivot = false;

	public double zProportion;
	public double dProportion;
	public double sProportion;
	public double qProportion;

	public boolean ballonFollowsPlayer=true;
	public boolean ballauch = false;


	public Vector force = new Vector(0,0);
	public Vector forceInt = new Vector(0,0);
	final Vector forceInit = force;
	final Vector forceIntInit = force;
	public int forceMax = calcul.getInitForceMax();
	double forceOrd = 0;
	double forceAbs = 0;
	 



	//constructeur
	public BallonMoovSet(Ballon ballon) {
		super();
		this.ballon = ballon;
		this.forceOrd = 0;
		this.forceAbs = 0;

		zProportion=0;
		dProportion=0;
		sProportion=0;
		qProportion=0;


	}

	public void chargeTot() {
		timeTot+=1;
	}

	public void chargeZ() {
		timeZPressed +=1;
	}

	public void chargeD() {
		timeDPressed +=1;
	}

	public void chargeS() {
		timeSPressed +=1;
	}

	public void chargeQ() {
		timeQPressed +=1;
	}
	public void deCharge() {

		timeZPressed =0;
		timeDPressed =0;
		timeSPressed =0;
		timeQPressed =0;
		

		timeTot=0;
		ballon.getTerrain().resetGravityBallon();

	}

	public void launch() {

		zProportion = (double) timeZPressed/timeTot;
		dProportion = (double) timeDPressed/timeTot;
		sProportion = (double) timeSPressed/timeTot;
		qProportion = (double) timeQPressed/timeTot;


		this.forceOrd = -zProportion*forceMax+sProportion*forceMax;
		this.forceAbs = +dProportion*forceMax-qProportion*forceMax;
		
		int forceOrdInt = (int) forceOrd;
		int forceAbsInt = (int) forceAbs;
		

	
		forceInt.setX(forceAbsInt);
		forceInt.setY(forceOrdInt);
		setBallauch(true);

		deCharge();

	}

	public void moov(BasketBallCourt terrain) {
		if (ballon.collidedX) {
			force.symetryX();
			terrain.getVecteurGravitéBallon().symetryX();
			ballon.setCollidedX(false);
		}
		if (ballon.collidedY) {
			force.symetryY();
			terrain.resetGravityBallon();
			ballon.setCollidedY(false);
		}
		
		int forceOrdInt = (int) forceOrd;
		int forceAbsInt = (int) forceAbs;
		forceInt.setX(forceAbsInt);
		forceInt.setY(forceOrdInt);
		
		if (force.norme()!=0) {
	    forceAbs += -ballon.getU()*forceAbs;
		forceOrd += -ballon.getU()*forceOrd;
		
		}
		
		if (force.norme()<1) {
			force.nulle();
		}
	
		terrain.applieBallongravity(ballon);
		ballon.setVecteurPosition(ballon.getVecteurPosition().addition(force.lambda(1)));

		
	}


	//assesseurs

	public void resetForce() {
		forceInt = forceIntInit;
		force = forceInit;
		ballon.setCollidedX(false);
		ballon.setCollidedY(false);
		forceAbs=0;
		forceOrd=0;

	}
	public boolean isBallauch() {
		return ballauch;
	}

	public void setBallauch(boolean ballauch) {
		this.ballauch = ballauch;
	}

	public Vector getForce() {
		return force;
	}

	public boolean isBallonFollowsPlayer() {
		return ballonFollowsPlayer;
	}

	public void setBallonFollowsPlayer(boolean ballonFollowsPlayer) {
		this.ballonFollowsPlayer = ballonFollowsPlayer;
	}

	public void setForce(Vector force) {
		this.force = force;
	}

	public Ballon getBallon() {
		return ballon;
	}

	public void setBallon(Ballon ballon) {
		this.ballon = ballon;
	}
	public double getTimeZPressed() {
		return timeZPressed;
	}
	public void setTimeZPressed(int timeZPressed) {
		this.timeZPressed = timeZPressed;
	}
	public double getTimeDPressed() {
		return timeDPressed;
	}
	public void setTimeDPressed(int timeDPressed) {
		this.timeDPressed = timeDPressed;
	}
	public double getTimeSPressed() {
		return timeSPressed;
	}
	public void setTimeSPressed(int timeSPressed) {
		this.timeSPressed = timeSPressed;
	}
	public double getTimeQPressed() {
		return timeQPressed;
	}
	public void setTimeQPressed(int timeQPressed) {
		this.timeQPressed = timeQPressed;
	}


}
