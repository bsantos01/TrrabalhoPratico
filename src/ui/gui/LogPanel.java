/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
class LogPanel extends JPanel implements Observer{
     ObservableGame game;
     JLabel log;

    public LogPanel(ObservableGame g) {
        this.game=g;
        game.addObserver(this);
        
        setupComponents();
        setupLayout();
    }

    @Override
    public void update(Observable o, Object arg) {  
        log.setText("log: "+ game.getLog());
        repaint();
    }

    private void setupComponents() {
        log= new JLabel("log: " + game.getLog());
    }

    private void setupLayout() {
          
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));

        add(log);
        validate();
    }

     
    
    
}
