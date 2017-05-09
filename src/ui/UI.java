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
   
    public void getdiceopt(){
       
        int []dices=game.getRDices();
        printDice();
        
        for (int i=0;i<dices.length; i++)
            if(dices[i]==6)
            Critical(i);
        
    }
    public void Critical(int i){    
            int opt;
                System.out.println("Critical damage on dice "+ (i+1) +". Want to re-roll? 1-YES 2-NO");
                opt=s.nextInt();
                if (opt==1)
                    game.rerollCrit(i);
                printDice();
    }
    
    public void printDice(){
        int []dices=game.getDices();
        for (int i=0; i<dices.length; i++)
            System.out.println("Dice " + (i+1) +": "+ dices[i]);  
    }
    public void doFeat(){
        int opt;
        int []dices=game.getDices();
        System.out.println("Do Feat");
        if (game.GetPlayerHP()<=2){
            System.out.println("Insuficient HP to perform Feats.");
        }else{
            System.out.println("Wich dice?");
            do{
                opt=s.nextInt();
            }while (opt<=0 || opt>dices.length);
            game.getState().comitOpt(opt-1);
           
            if(dices[opt-1]==6)
                Critical(opt-1);      
        }
    }
    public int doSpells(){
        printDice();
        System.out.println("Damage: "+ game.getDamage());
        int opt;
        if(game.SpellToString()!=null){
            System.out.println("You have the following Spells: "+ game.SpellToString());
            System.out.println("Which one do you want to choose? 3-SKIP");
            do
                opt=s.nextInt();
            while(opt<=0 || opt>3);
            if(opt==3)
                return -1;
            return (opt-1);
        }
            System.out.println("You have no spells available.");
            return -1;
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
        System.out.println("\nArea: " + game.getArea());
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
              
                game.setState(game.getState().start());
                
            }
            if(game.getState() instanceof IMerchAwait){
               game.setState(game.getState().comitOpt(chooseMerch()));
            }
            if(game.getState() instanceof IRestAwait){
               game.setState(game.getState().comitOpt(chooseRest()));
            }            
            if(game.getState() instanceof ICombat){
                
                System.out.println("\nA WILD MONSTER APPEARS!!! OH MY GOD!!!\n");
                System.out.println("Monster HP: " + game.GetMonster().getHp()+ "\tPlayer HP: "+ game.GetPlayerHP());
                getdiceopt();//ROLL inicial e verificação de criticals, actualizando os dados no gamedata
               
                System.out.println("Satisfied? You can still use Feats. 1-YES 2-NO");
                if (s.nextInt()==1)
                    game.setState(new IAwaitFeat(game.getDataGame(), game.GetMonster())); //passa para os feats
                else
                    game.setState(new IAwaitSpells(game.getDataGame(), game.GetMonster())); //senao pretender feats vai para os spells
            }
            if(game.getState() instanceof IAwaitFeat){
                printDice();
                doFeat();
                game.setState(new IAwaitSpells(game.getDataGame(), game.GetMonster()));
            }
            if(game.getState() instanceof IAwaitSpells){
                game.setState(game.getState().comitOpt(doSpells()));
            }
            if(game.getState() instanceof IGameOver){
            
                System.out.println("JA FOSTE CABRÃO!!!!");
            }
            
        }
    }
    
    
}
