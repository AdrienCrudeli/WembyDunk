package InterfaceGraphique;
import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class menu1ereVersion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clip;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu1ereVersion frame = new menu1ereVersion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menu1ereVersion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanelImageMenu("unnamed.png"); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		

		JPanel panel_1 = new JPanel(); 
		panel_1.setOpaque(false);
		contentPane.add(panel_1, BorderLayout.CENTER);




		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_1.add(panel, "1, 2, fill, center");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("HISTOIRE");
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 10));
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonHistoire();
			}
		});


		JButton btnNewButton_1 = new JButton("ARCADE");
		btnNewButton_1.setFont(new Font("Eras Bold ITC", Font.PLAIN, 10));
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonArcade();
			}
		});

		JButton btnNewButton_2 = new JButton("PARAMETRES");
		btnNewButton_2.setFont(new Font("Eras Bold ITC", Font.PLAIN, 10));
		panel_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonParametres();
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		contentPane.add(panel_4, BorderLayout.EAST);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{95, 0};
		gbl_panel_4.rowHeights = new int[]{253, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_4.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{52, 0};
		gbl_panel_6.rowHeights = new int[]{21, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);



		JButton btnNewButton_3 = new JButton("SON");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(true); 
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBoutonSon();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		panel_6.add(btnNewButton_3, gbc_btnNewButton_3);

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		

		// Démarrer la musique de fond
		playMusic("C:/Users/Emili/Downloads/music_arcade.wav");
	}

	public void clicBoutonHistoire() {
		FrameHistoire obj = new FrameHistoire();
		obj.main(null);
	}

	public void clicBoutonArcade() {
		FrameArcade obj = new FrameArcade();
		obj.main(null);
	}

	public void clicBoutonParametres() {
		FrameParametres obj = new FrameParametres();
		obj.main(null);
	}

	public void clicBoutonSon() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
		else {
			clip.start();
		}
	}

	private void playMusic(String filePath) {
		try {
			File file = new File("C:/Users/Emili/Downloads/music_arcade.wav"); // Chemin absolu
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
