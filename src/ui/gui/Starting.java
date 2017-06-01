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
    
    public Starting(ObservableGame game) {
        this.game = game;

        game.addObserver(this);
        setupComponents();
        setupLayout();

        
        setVisible(game.getState() instanceof IBeginning);

    }



    private void setupComponents() {
        
        Welcome = new JLabel("Mini Rogue");
        DifLabel = new JLabel("Difficulty:");
        AreaLabel = new JLabel("Area:");
        setDif = new JTextField();
        setArea = new JTextField();
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
                int dif= Integer.parseInt(setDif.getText());
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
            Box TopBox = Box.createHorizontalBox();
            TopBox.add(Box.createHorizontalGlue());
            TopBox.add(this.Welcome);
            TopBox.add(Box.createHorizontalGlue());
            TopBox.setBorder(new LineBorder(Color.BLACK));
            Box CenterBox = Box.createVerticalBox();
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.add(this.AreaLabel);
            CenterBox.add(this.setArea);
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.add(this.DifLabel);
            CenterBox.add(this.setDif);
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.add(this.start);
            CenterBox.add(Box.createVerticalGlue());
            CenterBox.setBorder(new LineBorder(Color.BLACK));
           
            setLayout(new BorderLayout());
            
            add(TopBox, BorderLayout.NORTH);
            add(CenterBox,BorderLayout.CENTER);
        }

        
        validate();
    }
}
