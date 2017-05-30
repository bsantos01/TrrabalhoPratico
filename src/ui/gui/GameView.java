/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

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
    ScorePanel scorePanel;
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    
}
