/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IBeginning;

/**
 *
 * @author migue
 */
public class Starting extends JPanel implements Observer {
    ObservableGame game;
    JButton start;
    JLabel Welcome;
    JLabel DifLabel;
    JLabel AreaLabel;
    JTextField setDif;
    JTextField setArea;
    String sdif[] ={
        "0","1","2","3"
    };
    JComboBox cbd;
    String sarea[] ={
        "1","2","3","4","5","6","7","8","9","10","11","12","13","14"
    };
    JComboBox cba;
    public Starting(ObservableGame game) {
        this.game = game;

        game.addObserver(this);
        setupComponents();
        setupLayout();

        
        setVisible(game.getState() instanceof IBeginning);

    }

    private void setupComponents() {
        cbd = new JComboBox(sdif);
        cba = new JComboBox(sarea);
        Welcome = new JLabel("Mini Rogue");
        DifLabel = new JLabel("Difficulty:");
        AreaLabel = new JLabel("Area:");
        start = new JButton("START");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dif= Integer.parseInt(cbd.getSelectedItem().toString());
                int area= Integer.parseInt(cba.getSelectedItem().toString());
                game.start(dif, area);
                
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof IBeginning);
    }
    
    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (game.getState() instanceof IBeginning) {    
            
        
        AreaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        AreaLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        DifLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        Welcome.setAlignmentX(Component.CENTER_ALIGNMENT); 
        start.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        add(Box.createVerticalStrut(80));
        add(Welcome);
              
      
        cbd.setMaximumSize(new Dimension(120,20));
        cba.setMaximumSize(new Dimension(120,20));

        AreaLabel.setOpaque(false);
        DifLabel.setOpaque(false);
        
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createVerticalBox();
        Box box4 = Box.createVerticalBox();
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        box1.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        box2.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        box3.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        box4.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        box4.add(Box.createVerticalGlue());
        box3.add(Box.createVerticalGlue());
        box4.add(Box.createVerticalGlue());
        box3.add(Box.createVerticalGlue());
        box3.add(AreaLabel);
        box3.add(Box.createVerticalGlue());
        box4.add(cba);
        box4.add(Box.createVerticalGlue());
        box3.add(DifLabel);
        box4.add(cbd);
        box4.add(Box.createVerticalGlue());
        box3.add(Box.createVerticalGlue());
        box4.add(Box.createVerticalGlue());
        box3.add(Box.createVerticalGlue());
        
        box2.add(box3);
        box2.add(box4);
        box1.add(box2);
        box1.add(Box.createVerticalGlue());
        box1.add(start);
        box1.add(Box.createVerticalGlue());
        
        add(box1);
        validate();
            
        }

        
   
    }
}
