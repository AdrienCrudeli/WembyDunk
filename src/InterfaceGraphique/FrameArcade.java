package InterfaceGraphique;
import java.awt.EventQueue;


import javax.swing.JFrame;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;*/
import java.awt.BorderLayout;
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
		setSize(new Dimension(500, 300));
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

		
	}
	
	



}
