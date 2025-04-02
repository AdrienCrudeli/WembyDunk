package Ballon;
import javax.swing.ImageIcon;

import Calculator.Vector;

public class Ballon {
	

	
	//Initialisation
    public ImageIcon imageBallon; //Image importé pointée via nom de fichier
	public Vector vecteurPosition; //Position Ballon

	public double vitesse ; //Vitesse Ballon instant t

	public double u ; //Coefficient viscosité dynamique
	public double diamètre; //Diamètre du Ballon
	
	
	
	public ImageIcon getImageBallon() {
		return imageBallon;
	}
	public void setImageBallon(ImageIcon imageBallon) {
		this.imageBallon = imageBallon;
	}
	public Vector getVecteurPosition() {
		return vecteurPosition;
	}
	public void setVecteurPosition(Vector vecteurPosition) {
		this.vecteurPosition = vecteurPosition;
	}
	public double getVitesse() {
		return vitesse;
	}
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
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
	public Ballon(ImageIcon imageBallon, Vector vecteurPosition, double vitesse, double u, double diamètre) {
		super();
		this.imageBallon = imageBallon;
		this.vecteurPosition = vecteurPosition;
		this.vitesse = vitesse;
		this.u = u;
		this.diamètre = diamètre;
	}
	
	
	
}
	
	




