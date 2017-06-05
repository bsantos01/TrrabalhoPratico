/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import trabalhopratico.Data.ObservableGame;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IBeginning;

/**
 *
 * @author Bruno Santos
 */
class CardG extends JPanel implements Observer{

    ObservableGame game = null;
    int i;
    
    static Map<String, Image>images; 
    static{    
        images = new HashMap<>();
        try{
        images.put("Merchant", ImageIO.read(Resources.getResourceFile("Images/Merch.jpg")));
        images.put("BossMonster", ImageIO.read(Resources.getResourceFile("Images/bossM.jpg")));
        images.put("Event", ImageIO.read(Resources.getResourceFile("Images/event.jpg")));
        images.put("Monster", ImageIO.read(Resources.getResourceFile("Images/Monster.jpg")));
        images.put("Resting", ImageIO.read(Resources.getResourceFile("Images/event.jpg")));
        images.put("Trap", ImageIO.read(Resources.getResourceFile("Images/Trap.jpg")));
        images.put("Treasure", ImageIO.read(Resources.getResourceFile("Images/treasure.jpg")));
        images.put("NULL", ImageIO.read(Resources.getResourceFile("Images/NULL.png")));
        } catch(IOException e){}
    }
    
    
    CardG(final ObservableGame gameo, int i) {
        
        this.game = gameo;
        this.i=i;
        this.game.addObserver(this);
        setPreferredSize(new Dimension(100, 150));
        
                    addMouseListener(new MouseAdapter() {
                        
                        @Override
                        public void mousePressed(MouseEvent ev) {
                            
                            if(!(game.getState() instanceof IBeginning)){
                                    System.out.println("cabron1");                        

                                if((game.getState() instanceof IAwaitAction)){
                                    System.out.println("cabron2");
                                    if(game.isClickable(i))
                                        if(i==0 || i== 3)
                                            game.commitopt(1);
                                        else
                                            game.commitopt(2);
                                    
                                }
                            }
                        }
                    });
                
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
            
            if (game.getCard(i)==null){ //se carta for virada para baixo
                g.drawImage(images.get("NULL"), 0, 0, getWidth() - 1, getHeight() - 1, null);
            }else{ //senao
                //vai buscar a descricao da carta para atribuir a imagem
                 g.drawImage(images.get(game.getCard(i).GetDesc()), 0, 0, getWidth() - 1, getHeight() - 1, null); 
            }
        } catch (IndexOutOfBoundsException e) {
        }
        

    }

    public void up(){

    }

    @Override
    public void update(Observable o, Object arg) {
        if(game.getState() instanceof IAwaitAction && game.getCard(i)!=null)
            repaint();
    }
 }
