/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.BorderLayout;
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
        setDif = new JTextField("1");
        setArea = new JTextField("1");
        start = new JButton("START");
        
        start.setAlignmentY(Component.CENTER_ALIGNMENT);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        AreaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        setDif.setAlignmentX(Component.CENTER_ALIGNMENT);
        setArea.setMaximumSize(new Dimension( 200, 24 ) );
        setDif.setMaximumSize(new Dimension( 200, 24 ) );
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
        //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        if (game.getState() instanceof IBeginning) {    
            
            JPanel pNorth, pCenter, outerp;
            outerp= new JPanel(new BorderLayout());
            pNorth = new JPanel(new BorderLayout());
            //pCenter = new JPanel(new BorderLayout());
            
            outerp.setPreferredSize(new Dimension(500,100));
            pNorth.add(Welcome, BorderLayout.CENTER);
            
            Box right = Box.createVerticalBox();
            right.add(Box.createHorizontalGlue());
            right.add(AreaLabel, BorderLayout.CENTER);
            right.add(Box.createVerticalGlue());
            right.add(cba, BorderLayout.CENTER);
             right.add(Box.createVerticalGlue());
            
            Box left = Box.createVerticalBox();
            left.add(DifLabel, BorderLayout.CENTER);
            left.add(cbd, BorderLayout.CENTER);
            
            outerp.add(right, BorderLayout.EAST);
            outerp.add(left, BorderLayout.WEST);
            add(pNorth, BorderLayout.NORTH);
            //outerp.add(pCenter, BorderLayout.CENTER);
            add(outerp, BorderLayout.SOUTH);
        }

        
        validate();
    }
}
