import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    private final Deplacements personnage;
    private final Mouvements_ballon mouvementsBallon;

    public Affichage(Deplacements personnage, Mouvements_ballon mouvementsBallon) {
        this.personnage = personnage;
        this.mouvementsBallon = mouvementsBallon;
        setFocusable(true);
        addKeyListener(personnage.getKeyAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        // Dessiner le personnage
        g.setColor(Color.GREEN);
        g.fillRect(personnage.getX(), personnage.getY(), 50, 50);

        // Dessiner le ballon
        Ballon ballon = mouvementsBallon.getBallon();
        if (ballon != null) {
            g.drawImage(ballon.getImage().getImage(), mouvementsBallon.getX(), mouvementsBallon.getY(), ballon.getLargeur(), ballon.getHauteur(), this);
        }
    }
}
