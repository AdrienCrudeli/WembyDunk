import javax.swing.ImageIcon;

public class Ballon {
    private ImageIcon imageBallon;
    private int largeur, hauteur;
	private double x, y;
	private double vitesseX, vitesseY, mu;
	
    public Ballon(int largeur, int hauteur, int x, int y, double vitesseX, double vitesseY, double mu) {
        this.largeur = largeur;
        this.hauteur = hauteur;
		this.x = 0;
		this.y = 0;
		this.vitesseX = 20;
		this.vitesseY = -15;
		this.mu = 0.8;
        this.imageBallon = new ImageIcon("ballon.png");
    }

    public ImageIcon getImage() {
        return imageBallon;
    }

    public int getLargeur() {
        return largeur;
    }

    public ImageIcon getImageBallon() {
		return imageBallon;
	}

	public void setImageBallon(ImageIcon imageBallon) {
		this.imageBallon = imageBallon;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
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

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getHauteur() {
        return hauteur;
    }
}
