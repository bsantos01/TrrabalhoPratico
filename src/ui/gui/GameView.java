/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
public class GameView extends JFrame implements Observer{

    ObservableGame game;
    GamePanel panel;
    Starting start;
    //ScorePanel scorePanel;
    
    public GameView(){
        super("Mini Rogue");
        this.game= new ObservableGame();
        game.addObserver(this);
        start=new Starting(game);
        panel= new GamePanel(game);
        
        addComponents();
        
        setVisible(true);
        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        
    }

    private void addComponents() {
        Container cp= getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(panel, BorderLayout.CENTER);
        cp.add(start, BorderLayout.NORTH);
        
        
    }
    
    
}
