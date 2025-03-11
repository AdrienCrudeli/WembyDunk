import javax.swing.ImageIcon;

public class Ballon {
	
	//Initialisation
    public ImageIcon imageBallon = new ImageIcon("Ballon.png"); //Image importé pointée via nom de fichier
	public int x = 0; //Position Ballon
	public int y = 0;
	public double vitesseX = 0; //Vitesse Ballon instant t
	public double vitesseY = 0;
	public double u = 0; //Coefficient viscosité dynamique
	public double diamètre = 24.19*Math.pow(10, -2); //Diamètre du Ballon
	
	
    public Ballon(int a_x,int a_y,double a_vitesseX,double a_vitesseY,double a_u,double a_diamètre,String a_fichier) { //constructeur
    	
        x=a_x;
        y=a_y;
        vitesseX=a_vitesseX;
        vitesseY=a_vitesseY;
        u=a_u;
        diamètre = a_diamètre;
        this.imageBallon = new ImageIcon(a_fichier);
    }
//assesseurs

	public ImageIcon getImageBallon() {
		return imageBallon;
	}


	public void setImageBallon(ImageIcon imageBallon) {
		this.imageBallon = imageBallon;
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


	public double getU() {
		return u;
	}


	public void setU(double u) {
		this.u = u;
	}


	public double getDiamètre() {
		return diamètre;
	}


	public void setDiamètre(double diamètre) {
		this.diamètre = diamètre;
	}
    
}


