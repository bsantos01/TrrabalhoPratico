/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IAwaitFeat;
import trabalhopratico.IEstates.IBeginning;
import trabalhopratico.IEstates.ICombat;
import trabalhopratico.cards.Merchant;
import trabalhopratico.cards.Resting;
import static ui.gui.CardG.images;

/**
 *
 * @author Bruno Santos
 */
class Dice extends JPanel implements Observer{
    ObservableGame game = null;
    int i;
    static Map<Integer, Image>images; 
    static{    
        images = new HashMap<>();
        try{
        images.put(1, ImageIO.read(Resources.getResourceFile("Images/dice1.png")));
        images.put(2, ImageIO.read(Resources.getResourceFile("Images/dice2.png")));
        images.put(3, ImageIO.read(Resources.getResourceFile("Images/dice3.png")));
        images.put(4, ImageIO.read(Resources.getResourceFile("Images/dice4.png")));
        images.put(5, ImageIO.read(Resources.getResourceFile("Images/dice5.png")));
        images.put(6, ImageIO.read(Resources.getResourceFile("Images/dice6.png")));
        images.put(0, ImageIO.read(Resources.getResourceFile("Images/diceN.png")));

        } catch(IOException e){}
    }
    
    Dice(final ObservableGame gameo, int i) {
        
        this.game = gameo;
        this.i=i;
        this.game.addObserver(this);
        setPreferredSize(new Dimension(75,73));           
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        if((game.getState() instanceof ICombat)||(game.getState() instanceof IAwaitFeat)){
            setVisible(true);
        }
       addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                if((game.getState() instanceof ICombat)||(game.getState() instanceof IAwaitFeat)){
                    if(game.getDice(i)==6)
                        game.reCritical(i);
                }
            }
 
        });
      
       paintComponent(this.getGraphics());
       repaint();
    }
    
    @Override
    public void paintBorder(Graphics g) {
        super.paintBorder(g);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        setBackground(Color.LIGHT_GRAY);
        
        try {
            if(game.getDice(i)>6)
                g.drawImage(images.get(game.getDice(i)-6), 0, 0, getWidth() - 1, getHeight() - 1, null);
            else
                g.drawImage(images.get(game.getDice(i)), 0, 0, getWidth() - 1, getHeight() - 1, null);
        } catch (IndexOutOfBoundsException e) {
        }
        

    }
    
}
