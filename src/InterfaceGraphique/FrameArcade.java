package InterfaceGraphique;
import javax.swing.SwingUtilities;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;*/
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Test_codeur.GamePanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
public class FrameArcade extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel gamearcade; // Déclaré ici
	private JPanelDessin paint;
	private JLabel scoreImageLabel;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameArcade frame = new FrameArcade();
					frame.setVisible(true);
					 frame.getPaint().requestFocusInWindow(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameArcade() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(screenSize);
		setContentPane(layeredPane);

		paint = new JPanelDessin();
		paint.setBounds(0, 0, screenSize.width, screenSize.height);
		layeredPane.add(paint, Integer.valueOf(0)); // couche 0

	    gamearcade = new GamePanel(paint, this);
	    paint.setGp(gamearcade);
	    gamearcade.start();

	    // *** Register the key listener here ***
	    paint.addKeyListener(gamearcade.getKeyH());
	    // Ensure panel can get focus
	    paint.setFocusable(true);
	    // Request focus once the UI is up
	    paint.requestFocusInWindow();

	    
	    scoreImageLabel = new JLabel(new javax.swing.ImageIcon("images/chiffre0.png"));
	    scoreImageLabel.setBounds(50, 50, 100, 100); // taille et position
	    layeredPane.add(scoreImageLabel, Integer.valueOf(1));
	    SwingUtilities.invokeLater(() -> paint.requestFocusInWindow());
		
		JButton btnNewButton = new JButton(" ← ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonRetourMenu();
			}
		});
		layeredPane.add(btnNewButton, Integer.valueOf(1)); // couche supérieure
		btnNewButton.setOpaque(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		
		paint.requestFocusInWindow();
		gamearcade.requestFocusInWindow();

		
	}
	public void requestFocusToGamePanel() {
	    if (gamearcade != null) {
	        gamearcade.requestFocusInWindow();
	    }
	}
	
	
	 public void clicBoutonRetourMenu() {
		 
		 this.dispose();
	        
	        menu1ereVersion obj = new menu1ereVersion();
	        obj.main(null);
	    }

		// Méthode pour mettre à jour le score affiché
	 public void updateScore(int score) {
		    if (score >= 0 && score <= 4) {
		        scoreImageLabel.setIcon(new javax.swing.ImageIcon("images/chiffre" + score + ".png"));
		    }
		}
		
		public JPanelDessin getPaint() {
		    return this.paint;
		}

}
