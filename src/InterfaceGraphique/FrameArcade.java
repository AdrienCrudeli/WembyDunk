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
import java.awt.Dimension;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    paint = new JPanelDessin();
	    getContentPane().add(paint, BorderLayout.CENTER);

	    gamearcade = new GamePanel(paint);
	    paint.setGp(gamearcade);
	    gamearcade.start();

	    // *** Register the key listener here ***
	    paint.addKeyListener(gamearcade.getKeyH());
	    // Ensure panel can get focus
	    paint.setFocusable(true);
	    // Request focus once the UI is up
		
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
	        
	        menu1ereVersion obj = new menu1ereVersion();
	        obj.main(null);
	    }


}
