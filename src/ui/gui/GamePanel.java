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
    JLabel cenas;

    public GamePanel(ObservableGame game) {
        this.game=game;
        game.addObserver(this);
        
        setupComponents();
        setupLayout();
        setVisible(!(game.getState() instanceof IBeginning));
    }

    
    
    @Override
    public void update(Observable o, Object o1) {
        if (game.getState() instanceof IBeginning)
            System.out.println("IBeginning");
        else
            System.out.println("imprime crl");
        setVisible(!(game.getState() instanceof IBeginning));
    }

    private void setupComponents() {
        /*charP = new CharPanel(game);
        dugP = new DugeonPanel(game);
        cardP = new CardPanel(game);
        diceP = new DicePanel(game);
        optP = new OptionsPanel(game);*/
        logP = new LogPanel(game);
    }

    private void setupLayout() {
                JPanel pLeft, pRight;

        setLayout(new BorderLayout());

        pLeft = new JPanel();
        //pLeft.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        cenas= new JLabel("teste");
     
       // pLeft.add(cenas, BorderLayout.NORTH);
       // add(pLeft, BorderLayout.WEST);
        
      
       // add(charP, BorderLayout.WEST);
        //add(dugP, BorderLayout.WEST);

        pRight = new JPanel();
        pRight.setLayout(new BorderLayout());
       /* pCenter.add(cardsInUsePanel, BorderLayout.NORTH);

        pCenter.add(middlePanel, BorderLayout.CENTER);*/
        
        pRight.add(logP, BorderLayout.SOUTH);
        add(pRight, BorderLayout.CENTER);

        validate();
    }

  
    
}
