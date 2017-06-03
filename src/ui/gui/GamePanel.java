/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IBeginning;

/**
 *
 * @author Bruno Santos
 */
class GamePanel extends JPanel implements Observer{
    
    ObservableGame game;
    CharPanel charP;
    DugeonPanel dugP;
    CardPanel cardP;
    DicePanel diceP;
    OptionsPanel optP;
    LogPanel logP;
    

    public GamePanel(ObservableGame game) {
        this.game=game;
        game.addObserver(this);
        
        setupComponents();
        setupLayout();
        setVisible(!(game.getState() instanceof IBeginning));
    }

    
    
    @Override
    public void update(Observable o, Object o1) {
       
        setVisible(!(game.getState() instanceof IBeginning));
    }

    private void setupComponents() {
        charP = new CharPanel(game);
        dugP = new DugeonPanel(game);
        /*
        cardP = new CardPanel(game);
        diceP = new DicePanel(game);*/
        optP = new OptionsPanel(game);
        logP = new LogPanel(game);
    }

    private void setupLayout() {
                JPanel pLeft, pRight,pRightCenter,pRightNorth, pRightNorthEast;

        setLayout(new BorderLayout());

        pLeft = new JPanel();
        pLeft.setLayout(new BorderLayout());
        
        pLeft.setPreferredSize(new Dimension(230,650));
        charP.setPreferredSize(new Dimension(230,650));
        dugP.setPreferredSize(new Dimension(230,320));
        pLeft.setBackground(Color.GREEN);
        pLeft.add(charP, BorderLayout.NORTH);
        pLeft.add(dugP, BorderLayout.SOUTH);
        add(pLeft, BorderLayout.WEST);
      
       // add(charP, BorderLayout.WEST);
        //add(dugP, BorderLayout.WEST);

        pRight = new JPanel();
        pRight.setLayout(new BorderLayout());
        pRight.setBackground(Color.RED);
            pRightCenter=new JPanel();
            pRightCenter.setLayout(new BorderLayout());
                pRightCenter.setPreferredSize(new Dimension(230,650));
                pRightCenter.setBackground(Color.BLUE);
                        pRightCenter.add(optP);
                        pRightNorthEast=new JPanel();
                        pRightNorthEast.setPreferredSize(new Dimension(350,230));
                        pRightNorthEast.setBackground(Color.PINK);
             pRightCenter.add(pRightNorthEast, BorderLayout.EAST);
            pRightNorth=new JPanel();
                    pRightNorth.setPreferredSize(new Dimension(800,600));
                    pRightNorth.setBackground(Color.ORANGE);
        pRight.add(pRightCenter, BorderLayout.CENTER);
        pRight.add(pRightNorth, BorderLayout.NORTH);
        
       /* pCenter.add(cardsInUsePanel, BorderLayout.NORTH);

        pCenter.add(middlePanel, BorderLayout.CENTER);*/
        
       
        pRight.add(logP, BorderLayout.SOUTH);
        add(pRight, BorderLayout.CENTER);

        validate();
    }

  
    
}
