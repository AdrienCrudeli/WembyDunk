import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GamePanel extends JPanel implements Runnable,WindowListener{

	//paramètre affichage
	final int originalTileSize = 64; //taille originale des cellules importés
	final int scale = 1;

	final int tileSize = originalTileSize * scale; //taille cellules après fonction échelle
	final int maxScreenColumn = 16; //combien de cellule on affiche en colonne
	final int maxScreenRow = 12; //combien de cellule on affiche en ligne
	final int screenWidth = tileSize * maxScreenColumn;
	final int screenHeight = tileSize * maxScreenRow;



	//FPS
	int FPS = 60;

	Controller calcul = new Controller();
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; //start ou stop, s'occupe de la clock


	public int charPosX = calcul.getInitCharPosX();
	public int charPosY = calcul.getInitCharPosY();
	public int charVit = calcul.getInitVitChar(); 
	public int jump = calcul.getInitSaut();

	public double initGravity = 9.81;
	public double accGravity = 1;
	public double accJump=5;
	public double gravity=initGravity;


	public GamePanel() {
		System.out.println("started");
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //paramètre pour optimisation

		this.addKeyListener(keyH); //reconnait keyH comme donneur d'entrée

		this.setFocusable(true);

	}



	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();



	};

	@Override
	public void run() { //créer par le thread, gameloop
		// TODO Auto-generated method stub

		double drawInterval= 1000000000/FPS; //méthode des deltas pour faire attendre
		double delta = 0;
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
		System.exit(0);
	}
	public void update() { //classe qui met à jour
		//Partie joueur
		boolean injump =false;
		if (keyH.qPressed == true) {

			charPosX -= charVit;
		}
		if(keyH.sPressed) {
			charPosY += charVit;

		}
		if (keyH.dPressed) {
			charPosX += charVit;
		}
		if(keyH.spacePressed && injump==false) {
			injump = true;
			charVit/=2;

		}
		if(keyH.spaceReleased) {

		}
		//gravité
		if (charPosY<=screenHeight-106) {

			charPosY+=gravity;
			if (!injump || jump==0) {
			gravity+=accGravity;

			}
			
		
		}
		if(charPosY>=screenHeight-100) {
			gravity=initGravity;
	
		}
		if (injump) {
			charPosY-=(jump);
			System.out.println(jump);
			
			
			if (jump>0) {
				jump-=accJump;
				charPosY+=gravity;
				
			}
			
		}
		if (jump==0 && charPosY>=screenHeight-106) {
			jump=calcul.initSaut;
			charVit=calcul.initVitChar;
			injump=false;
		}
		if (charPosY>screenHeight-110) { //impose ligne collision
			charPosY=screenHeight-106;
		}
		System.out.println(charVit);
//Partie Ballon
		
		
		

	}
	public void paintComponent(Graphics g) { //classe qui repaint
		super.paintComponent(g); //classe parental
		Graphics2D g2 = (Graphics2D)g;

		Controller calcul = new Controller();

		g2.setColor(Color.white);
		g2.fillRect(charPosX,charPosY, tileSize,tileSize);

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




