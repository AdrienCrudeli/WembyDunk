import javax.swing.*;

public class ClassePrincipale {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Déplacements");
		Mouvements_ballon mouvementsBallon = new Mouvements_ballon();
		Deplacements personnage = new Deplacements(mouvementsBallon);
		Affichage affichage = new Affichage(personnage, mouvementsBallon);

		frame.add(affichage);
		frame.setSize(1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		affichage.requestFocus();

		Timer timer = new Timer(12, e -> {
			mouvementsBallon.mettreAJourBallon(); // Mise à jour du ballon
			personnage.getKeyAdapter();
			affichage.repaint(); // Redessine l'écran
			
		});

		timer.start();
	}
}
