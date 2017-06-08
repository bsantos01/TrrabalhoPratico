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
    
    ObservableGame game;
    public static BufferedImage getdugeon(){
        return dugeon;
    }
    
    static{
        try{
            dugeon=ImageIO.read(Resources.getResourceFile("Images/dugeon.png"));
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
    
    }
    
}
