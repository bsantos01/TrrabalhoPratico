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
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IBeginning;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
class GamePanel extends JPanel implements Observer{
    
    ObservableGame game;
    CharPanel charP;
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
        repaint();
    }

    private void setupComponents() {
        charP = new CharPanel(game);
        cardP = new CardPanel(game);
        diceP = new DicePanel(game);
        optP = new OptionsPanel(game);
        logP = new LogPanel(game);
    }

    private void setupLayout() {
        JPanel pLeft, pRight,pRightCenter, pRightCenterEast;

        setLayout(new BorderLayout());

        //------->LEFT - CHARSTATS & DUGEONSTATS<-------
        pLeft = new JPanel();
        pLeft.setLayout(new BorderLayout());
        
        //Sizes
        pLeft.setPreferredSize(new Dimension(230,650));
        charP.setPreferredSize(new Dimension(230,650));
        
        
        //color
        pLeft.setBackground(Color.GREEN);
        
        //add
        pLeft.add(charP, BorderLayout.NORTH);
        add(pLeft, BorderLayout.WEST);


        //------>Right - CARDS(TOP) OPTIONS(CENTER)+DICES(CENTER EAST) + LOG(SOUTH) <-------
        pRight = new JPanel();
        pRight.setLayout(new BorderLayout());
        
        
        //------>OPTIONS(CENTER)+DICES(CENTER EAST)
        pRightCenter=new JPanel();
        pRightCenter.setLayout(new BorderLayout());
        pRightCenterEast=new JPanel();
        
        //size
        pRightCenter.setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pRightCenterEast.setPreferredSize(new Dimension(350,230));
        
        //color
        pRightCenter.setBackground(Color.BLUE);
        pRightCenterEast.setBackground(Color.DARK_GRAY);
        pRightCenterEast.add(diceP);
        //add
        pRightCenter.add(optP);
        
        
        pRightCenter.add(pRightCenterEast, BorderLayout.EAST);
            
        pRight.add(cardP, BorderLayout.NORTH);
        //------>LOG
        //add
        pRight.add(logP, BorderLayout.SOUTH);
        pRight.add(pRightCenter, BorderLayout.CENTER);
        
        add(pRight, BorderLayout.CENTER);

        validate();
    }

  
    
}
