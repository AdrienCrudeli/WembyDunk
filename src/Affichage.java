import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
     Deplacements personnage;
     Mouvements_ballon mouvementsBallon;
     Controlleur joueur;
     
    public Affichage(Deplacements personnage, Mouvements_ballon mouvementsBallon) {
        this.personnage = personnage;
        this.mouvementsBallon = mouvementsBallon;
        setFocusable(true);
        addKeyListener(joueur.getKeyAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        // Dessiner le personnage CLASSE IMAGE
        g.setColor(Color.GREEN);
        g.fillRect(personnage.getX(), personnage.getY(), 50, 50);

        // Dessiner le ballon CLASSE IMAGE
        Ballon ballon = mouvementsBallon.getBallon();
        if (ballon != null) {
            g.drawImage(ballon.getImage().getImage(), mouvementsBallon.getX(), mouvementsBallon.getY(), ballon.getLargeur(), ballon.getHauteur(), this);
        }
        
    }
}
