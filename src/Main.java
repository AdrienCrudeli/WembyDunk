import javax.swing.*;

public class Main {
	public static void main(String[] args) {

		//affichage basique en x,y, notez qu'il faudra faire de la composition comme le tuto, on s'en sert juste pour testes
		JFrame window = new JFrame(); //on crée la fenêtre d'affichage
		window.setResizable(false); //avec le x,y on va bloquer les redimensionnement de fenêtre car trop compliqué à gérer
		window.setTitle("test");

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel); //on ajoute le panel à la fenètre existante

		window.pack();

		window.setLocationRelativeTo(null); //position de la fenêtre
		window.setVisible(true); //affiche la fenètre

		gamePanel.startGameThread();











	}


}
