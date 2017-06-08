/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
class RestPanel extends JPanel{

ObservableGame game;

    public RestPanel(ObservableGame game) {
        this.game = game;
        
        setupComponents();
        this.setVisible(true);
    }

    private void setupComponents() {
        JPanel p = new JPanel();

        p.setLayout(new GridLayout(6, 2));

        p.add(new OptRest(game, 0, 0, "Reinforce Weapon", " +1 XP", 1));
        p.add(new OptRest(game, 0, 1, "Search for Ration", "+1 Food", 2));
        p.add(new OptRest(game, 1, 0, "Health", "+2 HP", 3));

        add(p);
    }
    
}
