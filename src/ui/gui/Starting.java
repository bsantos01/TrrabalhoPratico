/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import com.sun.org.apache.xalan.internal.templates.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.annotation.Resources;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    String dif[] ={
        "1","2","3"
    };
    JComboBox cb;
    public Starting(ObservableGame game) {
        this.game = game;

        game.addObserver(this);
        setupComponents();
        setupLayout();

        
        setVisible(game.getState() instanceof IBeginning);

    }



    private void setupComponents() {
        cb = new JComboBox(dif);
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
                int dif= Integer.parseInt(cb.getActionCommand());
                int area= Integer.parseInt(setArea.getText());
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
            
            JPanel pNorth, pCenter;
            Box TopBox = Box.createHorizontalBox();
            TopBox.add(Box.createHorizontalGlue());
            TopBox.add(this.Welcome);
            TopBox.add(Box.createHorizontalGlue());
            TopBox.setBorder(new LineBorder(Color.BLACK));
            pNorth = new JPanel();
            pNorth.setLayout(new BorderLayout());
            pNorth.add(TopBox);
            add(pNorth, BorderLayout.NORTH);
            
            
            pCenter = new JPanel();
            Box CenterBox = Box.createVerticalBox();
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.add(this.AreaLabel);
            CenterBox.add(this.cb);
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.add(this.DifLabel, BorderLayout.CENTER);
            CenterBox.add(this.setDif, BorderLayout.CENTER);
            CenterBox.add(Box.createVerticalGlue(), BorderLayout.CENTER);
            CenterBox.add(this.start, BorderLayout.CENTER);
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.setBorder(new LineBorder(Color.BLACK));
            
            pCenter.setLayout(new BorderLayout());
            pCenter.add(CenterBox, BorderLayout.CENTER);
            add(pCenter, BorderLayout.CENTER);
            //setLayout(new BorderLayout());
            
            //add(TopBox, BorderLayout.NORTH);
            //add(CenterBox,BorderLayout.CENTER);
        }

        
        validate();
    }
}
