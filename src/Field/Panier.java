package Field;

import Calculator.Vector;

public class Panier {
	
	public Vector vecteurPosition;
	public boolean collidedX = false;
	public boolean collidedY = false;
	public double largeur;
	public double longueur;
	public Panier(Vector vecteurPosition, double largeur, double longueur) {
		super();
		this.vecteurPosition = vecteurPosition;
		this.largeur = largeur;
		this.longueur = longueur;
	}


	public Vector getVecteurPosition() {
		return vecteurPosition;
	}
	public void setVecteurPosition(Vector vecteurPosition) {
		this.vecteurPosition = vecteurPosition;
	}
	public boolean isCollidedX() {
		return collidedX;
	}
	public void setCollidedX(boolean collidedX) {
		this.collidedX = collidedX;
	}
	public boolean isCollidedY() {
		return collidedY;
	}
	public void setCollidedY(boolean collidedY) {
		this.collidedY = collidedY;
	}

	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
}

