import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controlleur {
	public Controlleur(Mouvements_ballon mouvementsBallon ,Deplacements personnage) {
		this.mouvementsBallon = mouvementsBallon;
		this.personnage = personnage;
	}
	Mouvements_ballon mouvementsBallon = new Mouvements_ballon();
	Deplacements personnage = new Deplacements(mouvementsBallon);
	
	public KeyAdapter getKeyAdapter() {//Classe CONTROLLEUR
		return new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT)
					personnage.seDeplacerGauche();
				else if (keyCode == KeyEvent.VK_RIGHT)
					personnage.seDeplacerDroite();
				else if (keyCode == KeyEvent.VK_UP)
					personnage.sauter();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_RIGHT && personnage.isEnSaut()) {
					personnage.lancerBallon();
				}
			}
		};
	}
}
