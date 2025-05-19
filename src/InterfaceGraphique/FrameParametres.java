package InterfaceGraphique;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrameParametres extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrameParametres frame = new FrameParametres();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrameParametres() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanelImageMenu("imageParametre2.png");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Bouton retour menu en haut à gauche
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.setOpaque(false);
        JButton btnNewButton = new JButton("←");
        btnNewButton.addActionListener(e -> clicBoutonRetourMenu());
        topLeftPanel.add(btnNewButton);
        contentPane.add(topLeftPanel, BorderLayout.NORTH);

        // Panel central pour la difficulté
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblNewLabel = new JLabel("DIFFICULTE");
        lblNewLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 40));
        lblNewLabel.setForeground(new Color(128, 255, 255));
        centerPanel.add(lblNewLabel, gbc);

        gbc.gridy++;
        JRadioButton rdbtnFacile = new JRadioButton("Facile");
        rdbtnFacile.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
        rdbtnFacile.setForeground(new Color(128, 255, 255));
        rdbtnFacile.setOpaque(false);
        centerPanel.add(rdbtnFacile, gbc);

        gbc.gridy++;
        JRadioButton rdbtnIntermediaire = new JRadioButton("Intermediaire");
        rdbtnIntermediaire.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
        rdbtnIntermediaire.setForeground(new Color(128, 255, 255));
        rdbtnIntermediaire.setOpaque(false);
        centerPanel.add(rdbtnIntermediaire, gbc);

        gbc.gridy++;
        JRadioButton rdbtnDifficile = new JRadioButton("Difficile");
        rdbtnDifficile.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
        rdbtnDifficile.setForeground(new Color(128, 255, 255));
        rdbtnDifficile.setOpaque(false);
        centerPanel.add(rdbtnDifficile, gbc);

        contentPane.add(centerPanel, BorderLayout.CENTER);
    }

    public void clicBoutonRetourMenu() {
        this.dispose();
        FrameMenuTest obj = new FrameMenuTest();
        obj.main(null);
    }
}
