/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.ICombat;

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
        repaint();
    }

    private void setupComponents() {
        
        merchP = new MerchPanel(game);
        restP = new RestPanel(game);
        FeatP = new FeatPanel(game);
        combatP = new CombatPanel(game);
        /*  SpellP = new SpellPanel(game);
        CcardP = new ChoseCardPanel(game);*/
    }

    private void setupLayout() {    
        
        add(merchP);
        add(restP);
        add(FeatP);
        add(combatP);
        /*add(SpellP);
        add(CcardP);
        */
    }
    
}
