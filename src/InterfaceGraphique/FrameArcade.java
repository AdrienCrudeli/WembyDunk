package InterfaceGraphique;
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

public class FrameArcade extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel gamearcade; // Déclaré ici
	private JPanelDessin paint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameArcade frame = new FrameArcade();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);*/
		
		setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour bien gérer l'affichage

        paint = new JPanelDessin();
        paint.setOpacity(1.0f);
        // Ajout du GamePanel à la Frame
        
        getContentPane().add(paint, BorderLayout.CENTER);
        add(paint, BorderLayout.CENTER); // Ajout du panel dans la fenêtre
        
        gamearcade.startGameThread(); // Lancement du thread de jeu
		
		JButton btnNewButton = new JButton(" ← ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonRetourMenu();
			}
		});
		btnNewButton.setOpaque(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		
	}
	
	
	 public void clicBoutonRetourMenu() {
		 
		 this.dispose();
	        
	        FrameMenuTest obj = new FrameMenuTest();
	        obj.main(null);
	    }


}
