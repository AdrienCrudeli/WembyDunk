package InterfaceGraphique;
import java.awt.*;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/// SORTE DE DOUBLE "INUTILE" DE MENU1EREVERSION MAIS ON LE GARDE AU CAS OU POUR L'INSTANT CAR IL FONCTIONNNE 



public class FrameMenuTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Clip clip;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrameMenuTest frame = new FrameMenuTest();
                

                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrameMenuTest() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanelImageMenu("imageMenu2.png"); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        // Panel central avec un sous-panel pour centrer les boutons
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        innerPanel.setOpaque(false);

        JButton histoireButton = new JButton("HISTOIRE");
        histoireButton.setIcon(new ImageIcon("images/imageModeHistoire2.png"));
        histoireButton.setActionCommand("histoire");
        histoireButton.setBorderPainted(false);
        histoireButton.setPreferredSize(new Dimension(240, 100));
        histoireButton.setBackground(new Color(153, 0, 255));
        JButton arcadeButton = new JButton("ARCADE");
        arcadeButton.setIcon(new ImageIcon("images/imageModeArcade.png"));
        arcadeButton.setBorderPainted(false);
        arcadeButton.setPreferredSize(new Dimension(240, 100));
        arcadeButton.setBounds(new Rectangle(0, 0, 124, 127));
        arcadeButton.setBackground(new Color(204, 0, 0));

        histoireButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));
        arcadeButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));

        innerPanel.add(histoireButton);
        innerPanel.add(arcadeButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(innerPanel, gbc);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Panel bas pour les boutons "Paramètres" et "Son"
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JButton parametreButton = new JButton("");
        parametreButton.setIcon(new ImageIcon("images/boutonParametres3.png"));
        parametreButton.setBorderPainted(false);
        parametreButton.setPreferredSize(new Dimension(180, 50));
        parametreButton.setBounds(new Rectangle(0, 0, 124, 127));
        parametreButton.setBackground(new Color(204, 0, 0));
        innerPanel.add(parametreButton);

        
        JButton sonButton = new JButton("");
        sonButton.setIcon(new ImageIcon("images/boutonSon.png"));
        sonButton.setBorderPainted(false);
        sonButton.setPreferredSize(new Dimension(100, 100));
        sonButton.setBounds(new Rectangle(0, 0, 124, 127));
        sonButton.setBackground(new Color(204, 0, 0));
        innerPanel.add(sonButton);
        

        parametreButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));
        sonButton.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));

        bottomPanel.add(parametreButton, BorderLayout.WEST);
        bottomPanel.add(sonButton, BorderLayout.EAST);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // Ajout des actions
        histoireButton.addActionListener(e -> clicBoutonHistoire());
        arcadeButton.addActionListener(e -> clicBoutonArcade());
        parametreButton.addActionListener(e -> clicBoutonParametres());
        sonButton.addActionListener(e -> clicBoutonSon());

        
        // Démarrer la musique de fond
        
        playMusic("/music_arcade.wav");
    }

    public void clicBoutonHistoire() {
    	// Fermer la fenêtre actuelle (menu)
    	
        this.dispose();  // Ferme le menu
        
        FrameHistoire obj = new FrameHistoire();
        obj.main(null);
        
        // Arrêter la musique en cours
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Arrêter la musique
        }
    }

    public void clicBoutonArcade() {
    	// Fermer la fenêtre actuelle (menu)
    	
        this.dispose();  // Ferme le menu
        
        FrameArcade obj = new FrameArcade();
        obj.main(null);
        
        // Arrêter la musique en cours
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Arrêter la musique
        }
    }

    public void clicBoutonParametres() {
    	// Fermer la fenêtre actuelle (menu)
    	
        this.dispose();  // Ferme le menu
        
        FrameParametres obj = new FrameParametres();
        obj.main(null);
        
        // Arrêter la musique en cours
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Arrêter la musique
            }
    }

    public void clicBoutonSon() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        } else {
            clip.start();
        }
    }


    
    private void playMusic(String musicPath) {
        try {
            // Chargement du fichier depuis le classpath
            InputStream audioSrc = getClass().getResourceAsStream(musicPath);
            if (audioSrc == null) {
                throw new IllegalArgumentException("Fichier audio non trouvé : " + musicPath);
            }

            // Transformer le flux en AudioInputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
