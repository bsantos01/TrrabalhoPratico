/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
class CharPanel extends JPanel implements Observer{
    
    
    static private BufferedImage charstat= null;
    static private BufferedImage button= null;
    
    ObservableGame game;
    public static BufferedImage getCharstats(){
        return charstat;
    }
    
    static{
        try{
            charstat=ImageIO.read(Resources.getResourceFile("Images/CHARSTATS.png"));
            button=ImageIO.read(Resources.getResourceFile("Images/button.png"));
        } catch(IOException e){
            System.out.println("ERROR LOADING IMAGE");
        }
    }
    
    CharPanel(ObservableGame game) {
        this.game=game;
               game.addObserver(this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(getCharstats(), 0, 0,230,649, this);
        int a =game.getArmor();
        int x1=0;
        int y1=a;
        int x = (int) (getWidth()*(0.09+x1*0.20));
        int y = (int) (getHeight()*(0.07+y1*0.0435));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        int hp =game.getHP();
        int x2=1;
        int y2=hp;
        int xhp = (int) (getWidth()*(0.09+x2*0.20));
        int yhp = (int) (getHeight()*(0.07+y2*0.0435));
        g.drawImage(button, xhp,  yhp, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
    }

    @Override
    public void update(Observable o, Object arg) {
        paintComponent(this.getGraphics());
        repaint();
    }
}
