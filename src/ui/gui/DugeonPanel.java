/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos
 */
class DugeonPanel extends JPanel{

   static private BufferedImage dugeon= null;
   static private BufferedImage button= null;
    
    ObservableGame game;
    public static BufferedImage getdugeon(){
        return dugeon;
    }
    
    static{
        try{
            dugeon=ImageIO.read(Resources.getResourceFile("Images/dugeon.png"));
            button=ImageIO.read(Resources.getResourceFile("Images/button.png"));
        } catch(IOException e){
            System.out.println("ERROR LOADING IMAGE");
        }
    }
    
    DugeonPanel(ObservableGame game) {
        this.game=game;
        setPreferredSize(new Dimension(250, 300));
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(getdugeon(), 0, 0, getWidth() - 1, getHeight() - 1, null);
        int a = game.getMonsteHP();
        int x1=0;
        int y1=a;
        if(a>10){
            x1++;
            y1-=10;
        }
        if(a>20){
            x1++;
            y1-=10;
        }
        int x = (int) (getWidth()*(0.88-x1*0.12));
        int y = (int) (getHeight()*(0.91-y1*0.08));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.95)), (int) (getHeight() - (getHeight()*0.95)), null);
        
        
    }
    
}
