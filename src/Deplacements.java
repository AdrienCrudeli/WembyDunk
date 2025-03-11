import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Deplacements {
	private int x = 0;
	private int y = 700;
	private int hauteurSaut = 50;
	private boolean enSaut = false;
	private Mouvements_ballon mouvementsBallon;

	public Deplacements(Mouvements_ballon mouvementsBallon) {
		this.mouvementsBallon = mouvementsBallon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void seDeplacerGauche() {
		if (!enSaut && x != 0)
			x -= 25;
	}

	public void seDeplacerDroite() {
		if (!enSaut && x!= 1400)
			x += 25;
	}

	public void sauter() {
		if (enSaut)
			return;
		enSaut = true;

		new Thread(() -> {
			for (int i = 0; i < hauteurSaut; i++) {
				y -= 5;
				try {
					Thread.sleep(7);
				} catch (InterruptedException e) {
				}
			}
			for (int i = 0; i < hauteurSaut; i++) {
				y += 5;
				try {
					Thread.sleep(7);
				} catch (InterruptedException e) {
				}
			}
			enSaut = false;
		}).start();
	}

	public void lancerBallon() {
		if (!enSaut)
			return;
		if (mouvementsBallon.getBallon() == null) {
			mouvementsBallon.lancerBallon(x + 25, y); // Lancer le ballon pendant le saut
		}
	}

	public int getHauteurSaut() {
		return hauteurSaut;
	}

	public void setHauteurSaut(int hauteurSaut) {
		this.hauteurSaut = hauteurSaut;
	}

	public boolean isEnSaut() {
		return enSaut;
	}

	public void setEnSaut(boolean enSaut) {
		this.enSaut = enSaut;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
