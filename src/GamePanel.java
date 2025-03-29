import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GamePanel extends JPanel implements Runnable,WindowListener{

	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();

///Initialisation//////////////////////////////////////////////////////////////////


	Thread gameThread; //start ou stop, s'occupe de la clock



// variable dans controller
	
	public int charPosX = calcul.getInitCharPosX();
	public int charPosY = calcul.getInitCharPosY();
	public int charVit = calcul.getInitVitChar(); 
	public int jump = calcul.getInitSaut();
	Vector nulle = new Vector(0,0);

	public int gravity = calcul.getGravity();
	public int accGravity = calcul.getAccGravity();
	public int accJump=calcul.getAccJump();
	public int initGravity = gravity;

	boolean asBeenPressed = false;
/////////////////////////////////////////////////////////////////////////////////////

	
	//joueur

// toutes les objets de classes/////////////////////////////////////////////////////
	
	PlayerData joueur1 = new PlayerData(charPosX,charPosY, charVit, jump,accJump);
	PlayerMoovset joueur1Moovset = new PlayerMoovset(joueur1);
	BasketBallCourt terrain = new BasketBallCourt(accGravity,gravity);
	
////Code////////////////////////////////////////////////////////////////
	
	public GamePanel() {
		System.out.println("started");
		this.setPreferredSize(new Dimension(calcul.getScreenWidth(),calcul.getScreenHeight()));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //paramètre pour optimisation
		this.addKeyListener(keyH); //reconnait keyH comme donneur d'entrée
		this.setFocusable(true);
	}

	public void startGameThread() { //Game Thread
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() { //créer par le thread, gameloop
		// TODO Auto-generated method stub
		
		double drawInterval= 1000000000/calcul.getFPS(); //méthode des deltas pour faire attendre
		double delta = 0; // on est en train de créer le séquencage
		long lastTime = System.nanoTime();
		long currentTime;
		while(gameThread != null) {

			currentTime = System.nanoTime();
			delta+= (currentTime - lastTime)/drawInterval;
			lastTime=currentTime;

			if (delta>=1) {
				//update
				update();

				//dessine
				repaint();

				delta --;
			}
		}
	}
	
	public void update() { //classe qui met à jour

		//Pour corriger le code
		
System.out.println(joueur1Moovset.getDiviseur());
System.out.println(joueur1.getVecteurVitesse().toString());
		
		//Paramétrage des clés pour partie joueur
		if (keyH.qPressed == true) { //aller à gauche
			joueur1Moovset.moovLeft();
		}

		if(keyH.sPressed) { //aller en bas
			joueur1Moovset.moovDown();

		}
		
		if (keyH.dPressed) { //aller à droite
			joueur1Moovset.moovRight();
		}
		
		if(keyH.spacePressed && !joueur1Moovset.isInjump()) { //sauter
			joueur1Moovset.jumpCondition();
			joueur1Moovset.setDiviseur(calcul.getDividedVit());
			

		}
		
		if(keyH.spaceReleased) {
		}
		
		//managment de la gravité
		if (joueur1.getVecteurPosition().getY()<=calcul.getScreenHeight()-106) {
			terrain.applieGravity(joueur1Moovset); //si le joueur en l'air, on active la gravité
			
			if (!joueur1Moovset.isInjump() || joueur1Moovset.getJoueur().getVecteurSaut().getY()<=0) {  
				terrain.addAccGrav(); //accélération liée à la gravité si en saut 
			System.out.println("passé");
			}
		}
		
		if(joueur1.getVecteurPosition().getY()>=calcul.getScreenHeight()-100) { //on reset la gravity les effets de l'accélération une ois au sol
			terrain.resetGravity();

		}
		
		if (joueur1Moovset.isInjump()) { // on a besoin de cette condition pour appliquer les différentes accélérations
			joueur1Moovset.jump();


			if (joueur1.getVecteurSaut().norme()>0) { //on ajoute une vecteur négatif jusqu'a atteindre 0 pour simuler l'accélération
				joueur1Moovset.getJoueur().getVecteurSaut().addition(joueur1Moovset.getJoueur().getVecteurAccJump().lambda(-1));
				terrain.applieGravity(joueur1Moovset);
				}
		}
		
		if (joueur1.getVecteurSaut().norme()==0 && joueur1.getVecteurPosition().getY()>=calcul.getScreenHeight()-106) {
			joueur1.resetJump(); //on reset les effets liés au jump
			joueur1.resetVitesse();
			joueur1Moovset.setDiviseur(1);
			joueur1Moovset.setInJump(false);

		}
		
		if (joueur1.getVecteurPosition().getY()>calcul.getScreenHeight()-110) { //impose ligne collision

			terrain.imposeCollision(joueur1);
		}
	}

	//Partie Ballon





	public void paintComponent(Graphics g) { //classe qui repaint
		super.paintComponent(g); //classe parental
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(joueur1.getVecteurPosition().getX(),joueur1.getVecteurPosition().getY(),calcul.getTileSize(),calcul.getTileSize());
		g2.dispose(); //aide pour le calcul en abandonnant les tache
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
}



