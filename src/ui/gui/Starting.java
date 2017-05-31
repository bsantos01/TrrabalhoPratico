/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import com.sun.org.apache.xalan.internal.templates.Constants;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.annotation.Resources;
import javax.imageio.ImageIO;
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
    
    public Starting(ObservableGame game) {
        this.game = game;

        game.addObserver(this);
        setupComponents();
        setupLayout();

        setVisible(game.getState() instanceof IBeginning);

    }
    
    private void setupComponents() {
        
        Welcome = new JLabel("MICROSPACE EMPIRE");
        start = new JButton("START");

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                game.start();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof IBeginning);
    }
    
    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        start.setAlignmentY(Component.CENTER_ALIGNMENT);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (game.getState() instanceof IBeginning) {
            //try {
                start.add(new JLabel(/*new ImageIcon(ImageIO.read(Resources.getResourceFile(Constants.BACKGROUND_LOGO)))*/));
            //} catch(IOException ex){
                
            //}
        }
        
        add(Box.createVerticalStrut(20));
        add(start);
        add(Box.createVerticalStrut(20));
        
        validate();
    }
}
