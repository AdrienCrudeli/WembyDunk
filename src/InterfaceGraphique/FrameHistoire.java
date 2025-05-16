package InterfaceGraphique;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class FrameHistoire extends JFrame {

    private static final long serialVersionUID = 1L;
    private Clip clip;
    private JPanel contentPane;
    private JLabel imageLabel;
    private JTextArea textArea;
    private JButton nextButton;
    private JButton menuButton;
    private int index = 0;

    private String[] imagePaths = {"images/imageHistoire1.png", "images/imageHistoire2.png", "images/imageHistoire3.png"};
    private String[] texts = {
        "Depuis tout petit, je passe mes journées à dribbler sur le bitume.\nChaque lancer est un pas de plus vers mon rêve : devenir un grand joueur de basket.\nInspiré par les légendes du jeu, je sais que le chemin sera long… mais je suis prêt à tout donner.",
        "Un jour, alors que je joue un match intense sur mon terrain habituel,\nun recruteur me remarque. « Tu as du potentiel », me dit-il.\nUne invitation à un camp d’entraînement de jeunes talents change tout. C’est ma chance de prouver que j'ai ma place parmi les meilleurs.",
        "Le camp ne sera pas facile. Des joueurs talentueux, des défis physiques et mentaux…\nMais je suis prêt à me battre pour ma place. Chaque entraînement, chaque match est une occasion de briller.\nL’aventure commence maintenant !"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrameHistoire frame = new FrameHistoire();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrameHistoire() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanel();
        
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);

        playMusic("/musichistoire.wav");

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.BOLD, 18));
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE); 
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        textArea.setOpaque(true);
        /*panel.add(textArea, BorderLayout.SOUTH);*/
        
        
        /*textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        panel.add(textArea, BorderLayout.SOUTH);*/

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuButton = new JButton("←");
        menuButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clicBoutonRetourMenu();
        	}
        });
        menuButton.setPreferredSize(new Dimension(120, 30));
        topPanel.add(menuButton);
        contentPane.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
     // Texte à gauche (CENTER pour qu’il prenne l’espace restant)
        bottomPanel.add(textArea, BorderLayout.CENTER);
        nextButton = new JButton("Suivant");
       
        nextButton.setPreferredSize(new Dimension(150, 40));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(255, 140, 0)); // orange flashy
        nextButton.setFocusPainted(false);
        nextButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherImageSuivante();
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false); // transparence
        buttonPanel.add(nextButton);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        afficherImageSuivante();
    }

    private void afficherImageSuivante() {
    	if (index >= imagePaths.length) {
    	    if (clip != null && clip.isRunning()) {
    	        clip.stop();
    	    }
    	    this.dispose(); // fermer la FrameHistoire
    	    FrameArcade arcadeFrame = new FrameArcade();
    	    arcadeFrame.setVisible(true);
    	    return; // très important pour stopper la méthode ici
    	}
        ImageIcon icon = new ImageIcon(imagePaths[index]);
        imageLabel.setIcon(icon);
        textArea.setText(texts[index]);
        index++;
    }

    private void playMusic(String musicPath) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(musicPath);
            if (audioSrc == null) {
                throw new IllegalArgumentException("Fichier audio non trouvé : " + musicPath);
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clicBoutonRetourMenu() {
    	
    	if (clip != null && clip.isRunning()) {
            clip.stop();}
   	 	this.dispose();
   	
        FrameMenuTest obj = new FrameMenuTest();
        obj.setVisible(true);
   }
   
}
