package Field;

public class Panier {

	public int x;
	public int y;
	public double largeur;
	public double longueur;
	public Panier(int x, int y, double largeur, double longueur) {
		super();
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.longueur = longueur;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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

