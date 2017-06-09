/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.*;

/**
 *
 * @author Bruno Santos
 */
class OptionsPanel extends JPanel implements Observer {
    
    ObservableGame game;
    JLabel state;
    MerchPanel merchP;
    RestPanel restP;
    SpellPanel SpellP;
    FeatPanel FeatP;
    CombatPanel combatP;
    GameOverPanel overP;
    

    public OptionsPanel(ObservableGame game) {
        this.game = game;
        game.addObserver(this);
        setupComponents();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {
        
        removeAll();

        if(game.getState() instanceof IMerchAwait){
            add(merchP, BorderLayout.CENTER);
        }
        if(game.getState() instanceof ICombat){
            add(combatP, BorderLayout.CENTER);
        }
        if(game.getState() instanceof IRestAwait){
            add(restP, BorderLayout.CENTER);
        }
        if(game.getState() instanceof IGameOver){
            add(overP, BorderLayout.CENTER);
        }
        if(game.getState() instanceof IAwaitFeat){
            add(FeatP, BorderLayout.CENTER);
        }
        if(game.getState() instanceof IAwaitSpells){
            add(SpellP, BorderLayout.CENTER);
        }
        repaint();
    }

    private void setupComponents() {
        merchP = new MerchPanel(game);
        restP = new RestPanel(game);
        FeatP = new FeatPanel(game);
        combatP = new CombatPanel(game);
        SpellP = new SpellPanel(game);
        overP = new GameOverPanel(game);
    }

    
}
