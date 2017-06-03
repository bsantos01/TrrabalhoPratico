/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

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
class CharPanel extends JPanel {
    
    
    static private BufferedImage charstat= null;
    
    ObservableGame game;
    public static BufferedImage getCharstats(){
        return charstat;
    }
    
    static{
        try{
            charstat=ImageIO.read(Resources.getResourceFile("Images/CHARSTATS.png"));
        } catch(IOException e){
            System.out.println("ERROR LOADING IMAGE");
        }
    }
    
    CharPanel(ObservableGame game) {
        this.game=game;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(getCharstats(), 0, 0,230,649, this);
    
    }
}
