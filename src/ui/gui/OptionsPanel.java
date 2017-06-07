/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
    Box box;
    ObservableGame game;
    JLabel state;
    MerchPanel merchP;
    RestPanel restP;
    SpellPanel SpellP;
    FeatPanel FeatP;
    ChoseCardPanel CcardP;
    CombatPanel combatP;
    

    public OptionsPanel(ObservableGame game) {
        this.game = game;
        game.addObserver(this);

        setupComponents();
        setupLayout();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {
        if(game.getState() instanceof IMerchAwait){
            box.add(merchP, BorderLayout.CENTER);
        }
        else{
            box.remove(merchP);
        }
        if(game.getState() instanceof ICombat){
            box.add(combatP, BorderLayout.CENTER);
        }
        else{
            box.remove(combatP);
        }
        if(game.getState() instanceof IRestAwait){
            box.add(restP, BorderLayout.CENTER);
        }
        else{
            box.remove(restP);
        }
        if(game.getState() instanceof IAwaitFeat){
            box.add(FeatP, BorderLayout.CENTER);
        }
        else{
            box.remove(FeatP);
        }
        if(game.getState() instanceof IAwaitSpells){
            box.add(SpellP, BorderLayout.CENTER);
        }
        else{
            box.remove(SpellP);
        }
        repaint();
    }

    private void setupComponents() {
        merchP = new MerchPanel(game);
        restP = new RestPanel(game);
        FeatP = new FeatPanel(game);
        combatP = new CombatPanel(game);
        SpellP = new SpellPanel(game);
        /*  CcardP = new ChoseCardPanel(game);*/
    }

    private void setupLayout() {
        box = Box.createVerticalBox();
        add(box);
        /*
        Box box = Box.createHorizontalBox();
        add(box);
        box.add(merchP);
        box.add(restP);
        box.add(FeatP);
        box.add(combatP);
        box.add(SpellP);
        */
    }
    
}
