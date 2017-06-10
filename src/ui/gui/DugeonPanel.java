/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
class DugeonPanel extends JPanel{

   static private BufferedImage dugeon= null;
   static private BufferedImage button= null;
   static private BufferedImage button2= null;
    
    ObservableGame game;
    public static BufferedImage getdugeon(){
        return dugeon;
    }
    
    static{
        try{
            dugeon=ImageIO.read(Resources.getResourceFile("Images/dugeon.png"));
            button=ImageIO.read(Resources.getResourceFile("Images/button.png"));
            button2=ImageIO.read(Resources.getResourceFile("Images/button.png"));
        } catch(IOException e){
            System.out.println("ERROR LOADING IMAGE");
        }
    }
    
    DugeonPanel(ObservableGame game) {
        this.game=game;
        setPreferredSize(new Dimension(250, 300));
        setBorder(BorderFactory.createLineBorder(Color.black));
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
        int y = (int) (getHeight()*(0.91-y1*0.081));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.95)), (int) (getHeight() - (getHeight()*0.95)), null);
        
        int b = game.getLevel();
        int x2= game.getArea() -1;
        int y2=b-1;
        if(b==2)x2 -= 2;
        if(b==3)x2 -= 4;
        if(b==4)x2 -= 7;
        if(b==5)x2 -= 10;
        int xb = (int) (getWidth()*(0.10 + x2*0.115));
        int yb = (int) (getHeight()*(0.39+y2*0.125));
        g.drawImage(button2, xb,  yb, (int) (getWidth() - (getWidth()*0.95)), (int) (getHeight() - (getHeight()*0.95)), null);
    }
    
}
