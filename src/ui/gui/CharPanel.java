/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.Spells.*;

/**
 *
 * @author Bruno Santos & Miguel Almeida
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
        //Armor
        setBorder(BorderFactory.createLineBorder(Color.black));
        g.drawImage(getCharstats(), 0, 0,230,649, this);
        int a =game.getArmor();
        int x1=0;
        int y1=a;
        int x = (int) (getWidth()*(0.09+x1*0.20));
        int y = (int) (getHeight()*(0.07+y1*0.0435));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        
//Spells
        Spell spell1 =game.getSpell(0);
        Spell spell2 =game.getSpell(1);
        int yo=0;
        if(spell1 instanceof Fireball)y1=6;
        if(spell1 instanceof Ice)y1=8;
        if(spell1 instanceof Poison)y1=10;
        if(spell1 instanceof Healing)y1=12;
        if(spell2 instanceof Fireball)yo=6;
        if(spell2 instanceof Ice)yo=8;
        if(spell2 instanceof Poison)yo=10;
        if(spell2 instanceof Healing)yo=12;
        if(yo==y1)yo++;
        if(spell1!=null){
            y = (int) (getHeight()*(0.07+y1*0.0435));
            g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        }
        if(spell2!=null){
            y = (int) (getHeight()*(0.07+yo*0.0435));
            g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        }
        
//Food
        int food =game.getFood();
        x1=0;
        y1=food + 14;
        x = (int) (getWidth()*(0.09+x1*0.20));
        y = (int) (getHeight()*(0.07+y1*0.0435));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        //HP
        int hp =game.getHP();
        int x2=1;
        int y2=hp;
        int xhp = (int) (getWidth()*(0.09+x2*0.20));
        int yhp = (int) (getHeight()*(0.07+y2*0.0435));
        g.drawImage(button, xhp,  yhp, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        //Gold
        int gold =game.getGold();
        x1=2;
        y1=gold;
        x = (int) (getWidth()*(0.09+x1*0.20));
        y = (int) (getHeight()*(0.07+y1*0.0435));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
        //XP
        int xp =game.getXP();
        if(game.getRank()==2)xp+=6;
        if(game.getRank()==3)xp+=18;
        if(game.getRank()==4)xp+=36;
        x1=0;
        y1=xp;
        if(xp>20){
            x1=1;
            y1-=20;
        }
        x = (int) (getWidth()*(0.82-x1*0.12));
        y = (int) (getHeight()*(0.07+y1*0.0435));
        g.drawImage(button, x,  y, (int) (getWidth() - (getWidth()*0.90)), (int) (getHeight() - (getHeight()*0.97)), null);
    }

    @Override
    public void update(Observable o, Object arg) {
        paintComponent(this.getGraphics());
        repaint();
    }
}
