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

	public KeyAdapter getKeyAdapter() {
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT)
					seDeplacerGauche();
				else if (keyCode == KeyEvent.VK_RIGHT)
					seDeplacerDroite();
				else if (keyCode == KeyEvent.VK_UP)
					sauter();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_RIGHT && enSaut) {
					lancerBallon();
				}
			}
		};
	}
}
