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

	public Vector force = new Vector(0,0);
	final Vector forceInit = force;
	public int forceMax = calcul.getInitForceMax();

	//constructeur
	public BallonMoovSet(Ballon ballon) {
		super();
		this.ballon = ballon;

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


		double forceOrd = Math.round(zProportion*forceMax-sProportion*forceMax);

		double forceAbs = -Math.round(dProportion*forceMax-qProportion*forceMax);
		int forceOrdInt = (int) forceOrd;
		int forceAbsInt = (int) forceAbs;
		System.out.println(zProportion);
		System.out.println(dProportion);
		System.out.println(qProportion);
		System.out.println(sProportion);


		force.setX(forceAbsInt);
		force.setY(forceOrdInt);


		deCharge();
		System.out.println("vector force reset : " + force.toString());
	}

	public void moov(BasketBallCourt terrain) {
		if (ballon.collidedX) {
			force.symetryX();
			terrain.getVecteurGravitéBallon().symetryX();
		}
		if (ballon.collidedY) {
			force.symetryY();
			terrain.getVecteurGravitéBallon().symetryY();
		}
		ballon.setVecteurPosition(ballon.getVecteurPosition().addition(force.lambda(-1)));
		setForce(force.addition(force.lambda(-ballon.getU())));
		terrain.applieBallongravity(ballon);
		System.out.println(force.toString());
		
	}


	//assesseurs

	public void resetForce() {
		force = forceInit;
		ballon.setCollidedX(false);
		ballon.setCollidedY(false);
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
