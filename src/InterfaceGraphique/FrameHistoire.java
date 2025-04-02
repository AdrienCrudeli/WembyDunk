package InterfaceGraphique;
import java.awt.*;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

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
    private int index = 0;

    // Tableau contenant les chemins des images et les textes associés
    private String[] imagePaths = {"images/image1modehistoire.png", "images/image2modehistoire.png", "images/image3modehistoire.png"};
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

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        contentPane.add(panel, BorderLayout.CENTER);
        
        // Démarrer la musique de fond
        playMusic("/musichistoire.wav");
   

        // Label pour afficher l'image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Zone de texte pour afficher le texte sur plusieurs lignes
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        panel.add(textArea, BorderLayout.SOUTH);

        // Bouton pour passer à l'image suivante
        nextButton = new JButton("Suivant");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherImageSuivante();
            }
        });
        contentPane.add(nextButton, BorderLayout.SOUTH);

        // Afficher la première image et texte
        afficherImageSuivante();
    }

    private void afficherImageSuivante() {
        // Met à jour l'image et le texte
        if (index >= imagePaths.length) {
            index = 0; // Revenir à la première image si on dépasse
        }
        ImageIcon icon = new ImageIcon(imagePaths[index]);
        imageLabel.setIcon(icon);
        textArea.setText(texts[index]);
        index++;
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
