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
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitFeat;
import trabalhopratico.IEstates.IAwaitSpells;
import trabalhopratico.IEstates.ICombat;

/**
 *
 * @author Bruno Santos
 */
class DicePanel extends JPanel implements Observer{
        Dice dices1;
        Dice dices2;
        Dice dices3;
        Dice dices4;
        JLabel damage;
        ObservableGame game;

    DicePanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setupComponents();
        setupLayout();
    }
    
    void setupComponents(){
    
        dices1 = new Dice(game, 0);
        dices2 = new Dice(game, 1);
        dices3 = new Dice(game, 2);
        dices4 = new Dice(game, 3);
        damage = new JLabel();
        
    }
    private void setupLayout() {
        damage.setForeground(Color.white);
        Box MainBox = Box.createVerticalBox();
        MainBox.setPreferredSize(new Dimension(120,320));
            MainBox.add(Box.createVerticalStrut(5));
            MainBox.add(dices1); 
            MainBox.add(Box.createVerticalStrut(10));
            MainBox.add(dices2);
            MainBox.add(Box.createVerticalStrut(10));
            MainBox.add(dices3);
            MainBox.add(Box.createVerticalStrut(10));
            MainBox.add(dices4);
            MainBox.add(Box.createVerticalGlue());
            MainBox.add(damage);
            add(MainBox);
    }

       @Override
    public void paintBorder(Graphics g) {
        super.paintBorder(g);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void update(Observable o, Object arg) {
        if((game.getState() instanceof ICombat)||(game.getState() instanceof IAwaitFeat) || (game.getState() instanceof IAwaitSpells)){
            damage.setText("Damage: "+game.GetDataGame().getDamage());
        }else{
            damage.setText(" ");
        }
        repaint();
    }
}
