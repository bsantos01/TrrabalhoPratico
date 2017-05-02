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
     System.out.println("MERCHANT");
        return s.nextInt();
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
        if(false){
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
    
    public void run(){    
            
        while(!(game.getState() instanceof IGameOver)){
   

            if(game.getState() instanceof IBeginning)
            {   
                setupbeginning();
            }
            if(game.getState() instanceof IAwaitAction)
            {   
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
                if(game.getIndex()==0 ||game.getIndex()==3)
                {
                    game.addIndex(chooseCard());
                }else{
                    if(game.getIndex()==1 ||game.getIndex()==4)game.addIndex(2);
                    else game.addIndex(1);
                }
                game.getState().start();
            }
            if(game.getState() instanceof IMerchAwait){
                game.getState().merchBuy(chooseMerch());
                System.out.println("MERCH ;)");
            }
            
        }
    }
    
    
}
