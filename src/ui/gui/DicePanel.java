/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitFeat;
import trabalhopratico.IEstates.IAwaitSpells;
import trabalhopratico.IEstates.IBeginning;
import trabalhopratico.IEstates.ICombat;

/**
 *
 * @author Bruno Santos
 */
class DicePanel extends JPanel implements Observer{
        JLabel dices;
        ObservableGame game;

    DicePanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        
            setVisible(false);

        setupComponents();
        setupLayout();
    }
    
    void setupComponents(){
    
        dices = new JLabel(game.getDice(0) +game.getDice(1) + game.getDice(2)+ game.getDice(3));
    }
    private void setupLayout() {
        add(dices);

    }

       @Override
    public void paintBorder(Graphics g) {
        super.paintBorder(g);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
    }

    @Override
    public void update(Observable o, Object arg) {
                
        if(!(game.getState() instanceof IBeginning)){
            setVisible(true);
            System.out.println("cabron");
            dices.setText(game.getDice(0) +game.getDice(1) + game.getDice(2)+ game.getDice(3));
        }else
            setVisible(false);
        repaint();
    }


}
