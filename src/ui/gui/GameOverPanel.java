/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitSpells;
import trabalhopratico.IEstates.IGameOver;

/**
 *
 * @author Bruno Santos
 */
class GameOverPanel extends JPanel implements Observer{
    Box box;
    JLabel msg;
    JButton newGame;
    JButton loadGame;
    JButton exitGame;
    ObservableGame game;

    GameOverPanel(ObservableGame game) {
         this.game = game;
         this.game.addObserver(this);
         setVisible(true);
         setupComponents();
         setupLayout();
    }
    
    private void setupComponents() {
       
  
        newGame= new JButton("New Game");
            newGame.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                       game.newgame();
                        //game.commitopt(0);

                }
            });
        loadGame= new JButton("Load Game");
            loadGame.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    
                        game= new ObservableGame();
                    
                }
            });
        exitGame = new JButton("Exit");
     
     }
    
     private void setupLayout() {
         msg = new JLabel();
        box = Box.createVerticalBox();
        add(box);
        box.setAlignmentY(this.CENTER_ALIGNMENT);
        box.add(Box.createVerticalStrut(20));
        box.add(msg);
        box.add(Box.createVerticalStrut(40));
        box.add(newGame);
        box.add(Box.createVerticalStrut(20));
        box.add(loadGame);
        box.add(Box.createVerticalStrut(20));
        box.add(exitGame);
     }

    @Override
    public void update(Observable o, Object arg) {
        if(game.getHP()<=0)
            msg.setText("Dead is comming to take you! \nGame Over");
        else
            msg.setText("Congratulations!! The Og's Blood is yours!!!");
    }
}
