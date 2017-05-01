/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.Scanner;

import trabalhopratico.Game;

/**
 *
 * @author Bruno Santos
 */
public class UI {
    private Game game;
    private Scanner s;
   
    void UI() throws IOException{
        this.game= new Game();
        s = new Scanner(System.in);
    }
    
    public int chooseMerch(){
     System.out.println("MERCHANT");
        return s.nextInt();
    };
    
    public void setupbeginning(){
        int dif, area;
        System.out.println("Dificuldade?");
        System.out.println("0-Easy"); //blablabla
        dif=s.nextInt();
        System.out.print("area?");
        area=s.nextInt();
        game.setDificulty(dif, area);
    }
    public int chooseCard(int i){
        System.out.println("Which card? 1-UP or 2-DOWN?");
        return s.nextInt();
    }
    
    public void run(){    
        
        //while(!(game.getState() instanceof IGameOver)){
        System.out.println("teste "+ game.rolldice());

            /*if(game.getState() instanceof IBeginning)
            {   
                setupbeginning();
            }
            if(game.getState() instanceof IAwaitAction)
            {   
                if(game.getIndex()==0 ||game.getIndex()==3)
                {
                    game.addIndex(chooseCard(game.getIndex()));
                }else{
                    game.addIndex(1);                   
                }
                game.getState().start();
            }
            if(game.getState() instanceof IMerchAwait){
                game.getState().merchBuy(chooseMerch());
            }
            */
        }
    //}
    
    
}
