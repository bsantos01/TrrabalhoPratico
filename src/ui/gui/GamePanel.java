/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
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
        cardP = new CardPanel(game);
        //diceP = new DicePanel(game);
        optP = new OptionsPanel(game);
        logP = new LogPanel(game);
    }

    private void setupLayout() {
        JPanel pLeft, pRight,pRightCenter,pRightNorth, pRightCenterEast;

        setLayout(new BorderLayout());
        
        //------->LEFT - CHARSTATS & DUGEONSTATS<-------
        pLeft = new JPanel();
        pLeft.setLayout(new BorderLayout());
        
        //Sizes
        pLeft.setPreferredSize(new Dimension(230,650));
        charP.setPreferredSize(new Dimension(230,650));
        dugP.setPreferredSize(new Dimension(230,320));
        
        //color
        pLeft.setBackground(Color.GREEN);
        
        //add
        pLeft.add(charP, BorderLayout.NORTH);
        pLeft.add(dugP, BorderLayout.SOUTH);
        add(pLeft, BorderLayout.WEST);
        //add(charP, BorderLayout.WEST);
        //add(dugP, BorderLayout.WEST);

        //------>Right - CARDS(TOP) OPTIONS(CENTER)+DICES(CENTER EAST) + LOG(SOUTH) <-------
        pRight = new JPanel();
        pRight.setLayout(new BorderLayout());
        
        //pRight.setBackground(Color.RED);
        
        //------>OPTIONS(CENTER)+DICES(CENTER EAST)
        pRightCenter=new JPanel();
        pRightCenter.setLayout(new BorderLayout());
        pRightCenterEast=new JPanel();
        
        //size
        pRightCenter.setPreferredSize(new Dimension(230,650));
        pRightCenterEast.setPreferredSize(new Dimension(350,230));
        
        //color
        pRightCenter.setBackground(Color.BLUE);
        pRightCenterEast.setBackground(Color.PINK);
        
        //add
        pRightCenter.add(optP);
        pRightCenter.add(pRightCenterEast, BorderLayout.EAST);
            
        //------>CARDS(TOP)
        //cardP.setPreferredSize(new Dimension(pRight.getPreferredSize().width,500));
        //cardP.setLayout(new BoxLayout(cardP, BoxLayout.Y_AXIS));
        /* pCenter.add(cardsInUsePanel, BorderLayout.NORTH);
        pCenter.add(middlePanel, BorderLayout.CENTER);*/
        
        //------>LOG
        //add
        pRight.add(logP, BorderLayout.SOUTH);
        pRight.add(pRightCenter, BorderLayout.CENTER);
        pRight.add(cardP, BorderLayout.NORTH);
        add(pRight, BorderLayout.CENTER);

        validate();
    }

  
    
}
