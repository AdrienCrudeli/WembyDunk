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
	public int forceMax = calcul.getInitForceMax();
	
	
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

	}
	
	public void launch() {

		zProportion = (double) timeZPressed/timeTot;
		dProportion = (double) timeDPressed/timeTot;
		sProportion = (double) timeSPressed/timeTot;
		qProportion = (double) timeQPressed/timeTot;


		double forceAbs = Math.round(zProportion*forceMax-sProportion*forceMax);
		int forceAbsInt = (int) forceAbs;
		double forceOrd = Math.round(dProportion*forceMax-qProportion*forceMax);
		int forceOrdInt = (int) forceOrd;
		System.out.println(zProportion);
		System.out.println(timeZPressed);
		System.out.println(forceAbs);
		System.out.println(timeTot);
		force.setX(forceAbsInt);
		force.setY(forceOrdInt);
		deCharge();
	}
	
	public void moov(BasketBallCourt terrain) {
		ballon.setVecteurPosition(ballon.getVecteurPosition().addition(force));
		ballon.setVecteurPosition(ballon.getVecteurPosition().addition(ballon.getVecteurPosition().lambda(-ballon.getU())));
		terrain.applieBallongravity(ballon);
	}
	//constructeur
	
	
	
	
	public BallonMoovSet(Ballon ballon) {
		super();
		this.ballon = ballon;
	}
	
	//assesseurs
	
	
	
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
