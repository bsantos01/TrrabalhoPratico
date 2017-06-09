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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitFeat;

/**
 *
 * @author Bruno Santos
 */
public class OptFeat extends JPanel implements Observer{
    int row, col;
    int j;
    boolean flag;
    ObservableGame game;
    JLabel i;
    JLabel name;
    JButton xpButton;
    JButton hpButton;
    
    public OptFeat(ObservableGame game,int r,int c, String name, int i) {
        row = r;
        col = c;
        j=i;
        this.game = game;
        this.game.addObserver(this);
        setPreferredSize(new Dimension(300, 50));

        setupComponents(name, i);
        setupLayout();
        
    }

    private void setupComponents(String name, int i) {
        this.i= new JLabel(""+i );
        this.name = new JLabel(" " + name);
        xpButton = new JButton("-1 XP");
        hpButton = new JButton("-2 HP");
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
         Box box = Box.createHorizontalBox();
        box.add(name);
        box.add(Box.createHorizontalGlue());
        box.add(xpButton);
            xpButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    if(game.getState() instanceof IAwaitFeat){
                        if(xpButton.isEnabled() && flag!=true){
                            game.feat(1,Integer.parseInt(i.getText()));
                            flag=true;
                            
                        }
                    }
                }
            });
            box.add(Box.createHorizontalGlue());
        box.add(hpButton);
            hpButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent ev) {
                    if(game.getState() instanceof IAwaitFeat){
                        if(hpButton.isEnabled() && flag!=true){
                            game.feat(2,Integer.parseInt(i.getText()));
                            flag=true;
                        }
                    }
                }
            });
        add(box);
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
        if(game.getDice(j)!=0){
            if(game.getXP()>1)
                xpButton.setEnabled(true);
            else
                xpButton.setEnabled(false);
            if(game.getHP()>2)   
                hpButton.setEnabled(true);
            else
                hpButton.setEnabled(false);
        }
        else{
            xpButton.setEnabled(false);
            hpButton.setEnabled(false);
        }
        
       /* if(flag==true){
            System.out.println("cabron");
            xpButton.setEnabled(false);
            hpButton.setEnabled(false);
        }*/
        setVisible(game.getState() instanceof IAwaitFeat);
        repaint();
    }
    
}