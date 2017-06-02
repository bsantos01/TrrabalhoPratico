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
        Welcome = new JLabel("Mini Rogue",SwingConstants.CENTER);
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
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        if (game.getState() instanceof IBeginning) {    
            
            JPanel pNorth, outerp, pCenter;
            outerp= new JPanel(new BorderLayout());
            pNorth = new JPanel(new BorderLayout());
            pCenter = new JPanel(new BorderLayout());
            add(outerp);
            outerp.add(pNorth, BorderLayout.NORTH);
            outerp.add(pCenter);
            //outerp.setPreferredSize(new Dimension(500,100));
            pNorth.add(Welcome, BorderLayout.CENTER);
            
            Box right = Box.createVerticalBox();
            right.add(AreaLabel, BorderLayout.EAST);
            right.add(cba, BorderLayout.EAST);
            
            Box left = Box.createVerticalBox();
            left.add(DifLabel, BorderLayout.WEST);
            left.add(cbd, BorderLayout.WEST);
            
            
            pCenter.add(right, BorderLayout.CENTER);
            pCenter.add(left, BorderLayout.EAST);
            
            //outerp.add(pCenter, BorderLayout.CENTER);
            
        }

        
        validate();
    }
}
