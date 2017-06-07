/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import trabalhopratico.Data.ObservableGame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IBeginning;

/**
 *
 * @author Bruno Santos
 */
class CardPanel extends JPanel implements Observer {

    ObservableGame game;
    ArrayList<CardG> area;

    CardPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setVisible(true);
        setupComponents();
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.black));
        Box MainBox = Box.createHorizontalBox();
        Box CardBox1 = Box.createVerticalBox();
        Box CardBox2 = Box.createVerticalBox();
        Box CardBox3 = Box.createVerticalBox();
        Box CardBox4 = Box.createVerticalBox();
        Box CardBox5 = Box.createVerticalBox();
        
        MainBox.add(CardBox1);
        MainBox.add(Box.createHorizontalGlue());
        MainBox.add(CardBox2);
        MainBox.add(Box.createHorizontalGlue());
        MainBox.add(CardBox3);
        MainBox.add(Box.createHorizontalGlue());
        MainBox.add(CardBox4);
        MainBox.add(Box.createHorizontalGlue());
        MainBox.add(CardBox5);
        
        CardBox1.add(Box.createVerticalGlue());
        CardBox1.add(area.get(0));
        CardBox1.add(Box.createVerticalGlue());
        CardBox2.add(area.get(1));
        CardBox2.add(Box.createVerticalGlue());
        CardBox2.add(area.get(2));
        CardBox3.add(Box.createVerticalGlue());
        CardBox3.add(area.get(3));
        CardBox3.add(Box.createVerticalGlue());
        CardBox4.add(area.get(4));
        CardBox4.add(area.get(5));
      
        CardBox5.add(Box.createVerticalGlue());
        CardBox5.add(area.get(6));     
        CardBox5.add(Box.createVerticalGlue());
       
        
       add(MainBox);

        validate();
    }

    private void setupComponents() {
        area= new ArrayList<CardG>();
        area.add(new CardG(game,0));
        area.add(new CardG(game,1));
        area.add(new CardG(game,2));
        area.add(new CardG(game,3));
        area.add(new CardG(game,4));
        area.add(new CardG(game,5));
        area.add(new CardG(game,6));     
        
        
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(!(game.getState() instanceof IBeginning));
        if(game.getState() instanceof IAwaitAction)
            if(this.game.GetDataGame().getIndex()!= 0 && this.game.GetDataGame().getIndex()!= 3){
                
                game.commitopt(0);
            }
        repaint();
    }

}
    

