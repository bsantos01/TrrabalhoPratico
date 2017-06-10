/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IRestAwait;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class OptRest extends JPanel implements Observer{
    int row, col;
    ObservableGame game;
    JLabel i;
    JLabel name;
    JLabel description;
    
    public OptRest(final ObservableGame game, int r, int c, final String name, String des, int i) {
        row = r;
        col = c;
        this.game = game;
        this.game.addObserver(this);
        setPreferredSize(new Dimension(300, 50));

        setupComponents(name, des, i);
        setupLayout();
        
    }

    private void setupComponents(String name, String des, int i) {
        this.i= new JLabel("  " +i);
        this.name = new JLabel(" " + name);
        this.description = new JLabel(des);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                if(game.getState() instanceof IRestAwait){
                    game.commitopt(i);
                }
            }
        });
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(i);
        add(name);
        add(description);
    }

    @Override
    public void paintBorder(Graphics g) {
        super.paintBorder(g);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
    }

    @Override
    public void update(Observable o, Object arg) {
     setVisible(game.getState() instanceof IRestAwait);
     repaint();
    }
    
}
    

