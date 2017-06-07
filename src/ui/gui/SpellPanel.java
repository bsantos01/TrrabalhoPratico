/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitFeat;
import trabalhopratico.IEstates.IAwaitSpells;
import trabalhopratico.IEstates.IMerchAwait;

/**
 *
 * @author Bruno Santos
 */
class SpellPanel  extends JPanel implements Observer{
    Box box;
    JButton okButton;
    JLabel Spell1;
    JLabel Spell2;
    ObservableGame game;
    
    SpellPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setVisible(game.getState() instanceof IAwaitSpells);
        Spell1 = new JLabel("Spell 1:" );
        Spell2 = new JLabel("Spell 2:" );
        okButton = new JButton("Skip");
   
        setupLayout();
    }

    
    private void setupComponents() {
        
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                if(game.getState() instanceof IAwaitSpells){
                    game.commitopt(-1);
                }
            }
        });
        Spell1.setText("Spell 1:" + game.SpellToStringI(0));
        Spell1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                if(game.getState() instanceof IAwaitSpells){
                   game.commitopt(0);
                }
            }
        });
        Spell2.setText("Spell 2:" + game.SpellToStringI(1));
        Spell2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                if(game.getState() instanceof IAwaitSpells){
                   game.commitopt(1);
                }
            }
        });
    }
    
    private void setupLayout() {
        box = Box.createVerticalBox();
        add(box);
        box.setAlignmentY(this.CENTER_ALIGNMENT);
        box.add(Spell1);
        box.add(Spell2);
        box.add(okButton);
        
    }   
    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof IAwaitSpells);
        setupComponents();
    }
    
    
    
}
