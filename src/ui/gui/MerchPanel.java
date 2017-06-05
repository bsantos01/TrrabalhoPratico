/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IMerchAwait;

/**
 *
 * @author Bruno Santos
 */
class MerchPanel extends JPanel {

 ObservableGame game;

    public MerchPanel(ObservableGame game) {
        this.game = game;
        
        setupComponents();
        this.setVisible(true);
        repaint();
    }

    private void setupComponents() {
        JPanel p = new JPanel();

        p.setLayout(new GridLayout(6, 2, 10, 10));

        p.add(new OptMerch(game, 0, 0, "Ration", "-1G", " +1 Food", 1));
        p.add(new OptMerch(game, 0, 1, "Health Potion", "-1G", "+1 HP", 2));
        p.add(new OptMerch(game, 1, 0, "Big Health Potion", "-3G", " +4 HP", 3));
        p.add(new OptMerch(game, 1, 1, "Armor Piece", "-6G", " +1 Armor", 4));
        p.add(new OptMerch(game, 2, 0, "Any Spell", "-8G", " Buy a random spell", 5));
        p.add(new OptMerch(game, 2, 1, "Sell Armor", "+3G", " Sell 1 Armor piece",6));
        p.add(new OptMerch(game, 3, 0, "Sell Spell", "+4G", " Sell a random spell",7));
        p.add(new OptMerch(game, 3, 1, "Skip", " ", " Skip card",8));

        add(p);
    }
    
}
