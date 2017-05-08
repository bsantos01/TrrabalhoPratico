/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.Scanner;

import trabalhopratico.Game;
import trabalhopratico.IEstates.*;

/**
 *
 * @author Bruno Santos
 */
public class UI {
    private Game game;
    private Scanner s;
   
    public UI(){
        game= new Game();
        s = new Scanner(System.in);
    }
   
    
    public int chooseMerch(){
        int v;
        System.out.println("MERCHANT");
        System.out.println("1: -1G Ration: +1 Food");
        System.out.println("2: -1G Health Potion: +1 HP");
        System.out.println("3: -3G Big Health Potion: +4 HP");
        System.out.println("4: -6G Armor Piece: +1 Armor");
        System.out.println("5: +8G Any Spell");
        System.out.println("6: +3G Sell 1 Armor Piece");
        System.out.println("7: +4G Sell Any Spell");
        System.out.println("8: Skip");
        do
            v=s.nextInt();
        while (v<1||v>8);
        return v;
    };
    public int chooseRest(){
        int v;
        System.out.println("RESTING");
        System.out.println("1: Reinforce Weapon: +1 XP");
        System.out.println("2: Search for Ration: +1 HP");
        System.out.println("3: Health: +2 HP");
        do
            v=s.nextInt();
        while (v<1||v>3);
        return v;
    };
    
    public void setupbeginning(){
        int dif, area;
        s = new Scanner(System.in);
        System.out.println("Dificuldade?");
        System.out.println("0-Easy"); //blablabla
        
            dif=s.nextInt();
        System.out.print("area?");
        area=s.nextInt();
        game.setDificulty(dif, area);
    }
    
    public int chooseCard(){
        System.out.println("Which card? 1-UP or 2-DOWN?");
        return s.nextInt();
    }
    
    public void printArena(){
        //Se for arena final
        if(game.haveBoss()){
            System.out.println("\n\n\n");
            System.out.println("\t\t\t-----------------\t\t\t\t-----------------");
            System.out.println("\t\t\t|"+game.getNameCard(1)+"|\t\t\t\t|"+game.getNameCard(4)+"|");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("-----------------\t|\t\t|\t-----------------\t|\t\t|\t-----------------");
            System.out.println("|" + game.getNameCard(0)+"|\t-----------------\t|" + game.getNameCard(3)+"|\t-----------------\t|" + game.getNameCard(6)+"|");
            System.out.println("|\t\t|\t\t\t\t|\t\t|\t|\t\t|");
            System.out.println("|\t\t|\t-----------------\t|\t\t|\t-----------------\t|\t\t|");
            System.out.println("----------------\t|"+game.getNameCard(2)+"|\t-----------------\t|"+game.getNameCard(5)+"|\t-----------------");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("\t\t\t-----------------\t\t\t\t-----------------");
                   
        }
        //Senão
        else{
            System.out.println("\n\n\n");
            System.out.println("\t\t\t-----------------\t\t\t\t-----------------");
            System.out.println("\t\t\t|"+game.getNameCard(1)+"|\t\t\t\t|"+game.getNameCard(4)+"|");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("-----------------\t|\t\t|\t-----------------\t|\t\t|");
            System.out.println("|" + game.getNameCard(0)+"|\t-----------------\t|" + game.getNameCard(3)+"|\t-----------------");
            System.out.println("|\t\t|\t\t\t\t|\t\t|");
            System.out.println("|\t\t|\t-----------------\t|\t\t|\t-----------------");
            System.out.println("----------------\t|"+game.getNameCard(2)+"|\t-----------------\t|"+game.getNameCard(5)+"|");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("\t\t\t|\t\t|\t\t\t\t|\t\t|");
            System.out.println("\t\t\t-----------------\t\t\t\t-----------------");
               
        }
    }
    public void printDataPlayer(){
        System.out.println("\nDados Player:\n" + game.getDataPlayer());
        System.out.println("\nArea:\n" + game.getArea());
    }
    public void run(){    
            
        while(!(game.getState() instanceof IGameOver)){
   

            if(game.getState() instanceof IBeginning)
            {   
                setupbeginning();
            }
            if(game.getState() instanceof IAwaitAction)
            {   
                printArena();
                printDataPlayer();
                if(game.getIndex()==0 ||game.getIndex()==3)
                {
                    game.addIndex(chooseCard());
                }else{
                    if(game.getIndex()==1 ||game.getIndex()==4)game.addIndex(2);
                    else game.addIndex(1);
                }
                System.out.println("Vai o Start");
                game.setState(game.getState().start());
                System.out.println("Fim IAwaitAction");
            }
            if(game.getState() instanceof IMerchAwait){
               game.setState(game.getState().comitOpt(chooseMerch()));
            }
            if(game.getState() instanceof IRestAwait){
               game.setState(game.getState().comitOpt(chooseRest()));
            }            
            if(game.getState() instanceof ICombat){
               game.setState(game.getState().comitOpt(chooseRest()));
            }  
        }
    }
    
    
}
