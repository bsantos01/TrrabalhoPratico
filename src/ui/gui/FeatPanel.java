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

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
class FeatPanel extends JPanel implements Observer{

ObservableGame game;
    JLabel dices;
    JButton okButton;

    public FeatPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setupComponents();
        setVisible(game.getState() instanceof IAwaitFeat);

        repaint();
    }

    private void setupComponents() {
        JPanel p = new JPanel();
        okButton = new JButton("Skip");
        
        p.setLayout(new GridLayout(6, 2, 10, 10));
        
        p.add(new OptFeat(game, 0, 0, "FeatDice 1", 0));
        p.add(new OptFeat(game, 0, 1, "FeatDice 2", 1));
        p.add(new OptFeat(game, 0, 1, "FeatDice 3", 2));
        p.add(new OptFeat(game, 0, 1, "FeatDice 4", 3));
        add(p);
        add(okButton);
                    okButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    if(game.getState() instanceof IAwaitFeat){
                        game.DoFeat();
                    }
                }
            });

        
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof IAwaitFeat);
        repaint();
    }
    
}
