public class Mouvements_ballon {
	private Ballon ballon;
	private int x, y;
	private double vitesseX, vitesseY, mu;
	private boolean lanceBallon = false;
	
	public Mouvements_ballon() {
		this.ballon = null;
		this.x = 0;
		this.y = 0;
		this.vitesseX = 20;
		this.vitesseY = -15;
		this.mu = 0.8;

	}

	public Ballon getBallon() {
		return ballon;
	}

	// Méthode pour lancer le ballon
	public void lancerBallon(int x, int y) {
		if (ballon == null) {
			lanceBallon = true;
			this.x = x;
			this.y = y;
			this.ballon = new Ballon(50, 50); // Crée un nouveau ballon avec la taille souhaitée
		}
	}

	// Méthode pour mettre à jour la position du ballon
	public void mettreAJourBallon() {
		if (ballon != null) {
			vitesseY += 0.5 ; // Gravité
			x += vitesseX;
			y += vitesseY;

			// Gestion des rebonds
			if (x <= 0 || x + ballon.getLargeur() >= 1500)
				vitesseX = -vitesseX * mu; // Rebond sur les murs
			if (y <= 0 || y + ballon.getHauteur() >= 750)
				vitesseY = -vitesseY * mu; // Rebond sur le sol/plafond
		}
	}

	public double getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(double vitesseX) {
		this.vitesseX = vitesseX;
	}

	public double getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(double vitesseY) {
		this.vitesseY = vitesseY;
	}

	public double getMu() {
		return mu;
	}

	public void setMu(double mu) {
		this.mu = mu;
	}

	public void setBallon(Ballon ballon) {
		this.ballon = ballon;
	}

	public void setLanceBallon(boolean lanceBallon) {
		this.lanceBallon = lanceBallon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public boolean getLanceBallon() {
		return lanceBallon;
	}
	public void setX(int Xp) {
		x=Xp;
	}
	public void setY(int Yp) {
		y=Yp;
	}
	
	public void resetLanceBallon() {
		lanceBallon = false;
	}
}
