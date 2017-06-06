/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitFeat;
import trabalhopratico.IEstates.ICombat;

/**
 *
 * @author Bruno Santos
 */
class CombatPanel extends JPanel implements Observer{

ObservableGame game;
    JLabel Text;
    JButton yesButton;
    JButton noButton;

    public CombatPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setupComponents();
        setVisible(false);

        repaint();
        
    }

    private void setupComponents() {
        JPanel p = new JPanel();
        Text= new JLabel("Want to feat?");
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        p.add(Text);
        p.add(yesButton);
                    yesButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    if(game.getState() instanceof ICombat){
                        game.commitopt(1);
                    }
                }
            });
        p.add(noButton);
                    noButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    if(game.getState() instanceof ICombat){
                        game.commitopt(2);
                    }
                }
            });
        add(p);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        setVisible(game.getState() instanceof ICombat);
        repaint();
    }
    
}
    

