/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import trabalhopratico.Data.*;
import trabalhopratico.IEstates.*;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class UI {
    private Game game;
    private Scanner s;
   
    public UI() throws IOException{
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
            int opt; boolean flag;
            do{
                System.out.println("Critical damage on dice "+ (i+1) +". Want to re-roll? 1-YES 2-NO");
                do
                    opt=s.nextInt();
                while(opt<1 || opt>2);
                if (opt==1)
                    flag=game.rerollCrit(i);
                else
                    flag=false;
                printDice();
            }while(flag==true);
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
      
            for(int i=0; i<dices.length; i++){
                
                if(game.GetPlayerHP()<=2)
                    break;
                System.out.println("Dice "+(i+1)+": " + dices[i]);
                System.out.println("Want to feat this dice? 1-YES 2-NO");
                do
                    opt=s.nextInt();
                while(opt<1 || opt>2);
                if(opt==1){
                    game.getState().comitOpt(i);
                    if(dices[i]==6)
                       Critical(i);       
                }               
            }
            if (game.GetPlayerHP()<=2){
            System.out.println("Insuficient HP to perform Feats.");
           
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
        System.out.println("2: Search for Ration: +1 Food");
        System.out.println("3: Health: +2 HP");
        do
            v=s.nextInt();
        while (v<1||v>3);
        return v;
    };
    
    public boolean SaveGame(){
        BufferedReader bin= new BufferedReader(new InputStreamReader(System.in));
        String opt, name= "MiniRogue.txt";
        System.out.println("Default file name: "+ name);
        try{
            opt=bin.readLine();
            if(opt.length()>=1)
                name=opt;
        }catch(IOException e){
            return false;
        }
        try{
            game.saveGame(name);
            System.out.println("Game Saved\n");
            return true;
        } catch(IOException e){
            System.out.println("Error trying to save game in file: "+ name);
            System.out.println(e);
            return false;
        }
    }
    public boolean LoadGame() throws FileNotFoundException, ClassNotFoundException{
        BufferedReader bin= new BufferedReader(new InputStreamReader(System.in));
        String opt, name= "MiniRogue.txt";
        System.out.println("Default file name: "+ name);
        try{
            opt=bin.readLine();
            if(opt.length()>=1){
                if (!new java.io.File(name).exists()){
                    System.out.println("File "+name+" does not exist.");
                    return false;
                }
                    name=opt;
            }
        }catch(IOException e){
            return false;
        }
        try{
            game = Game.loadGame(name);
            System.out.println("Load completed\n");
            return true;
        }catch(IOException e){
            System.out.println("Error trying to load game from: "+ name);
            System.out.println(e);
            return false;
        }
    }
    public void setupbeginning() throws FileNotFoundException, ClassNotFoundException{
        int dif, area, opt;
        s = new Scanner(System.in);
        System.out.println("MiniRogue");
        System.out.println("1-NewGame");
        System.out.println("2-LoadGame");
        do
            opt=s.nextInt();
        while(opt<0 || opt>2);
        if(opt==1){
            System.out.println("DIFICULTY");
            System.out.println("0-Easy 1-Normal 2-Hard 3-Impossible"); 
            do
             dif=s.nextInt();
            while(dif<0 || dif>3);
            System.out.print("Wich area to start?");
            do
                area=s.nextInt();
            while(area<1 || area>14);
            game.setDificulty(dif, area);
        }else{
            LoadGame();
            
        }
    }
    
    public int chooseCard(){
        int opt;
        System.out.println("Which card? 1-UP or 2-DOWN? 3->SaveGame");
        do{
            opt= s.nextInt();
            if(opt==3)
                this.SaveGame();
        }while(opt<1 || opt>2);
        return opt;
    }
    public void resolvFeat(){
        int opt;
        System.out.println("Satisfied? You can still use Feats. 1-YES 2-NO");
        do
            opt=s.nextInt();
        while(opt<1 || opt>2);
        if (opt==1)
            game.setState(new IAwaitFeat(game.getDataGame(), game.GetMonster())); //passa para os feats
        else
            game.setState(new IAwaitSpells(game.getDataGame(), game.GetMonster())); //senao pretender feats vai para os spells

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
        System.out.println(game.getLog());
        game.refreshLog();
    }
    public void cls(){
        for (int i = 0; i < 100; ++i)  
           System.out.println(); 
    }
    public void printDataPlayer(){
        System.out.println("\nDados Player:\n" + game.getDataPlayer());
        System.out.println("\nArea: " + game.getArea() +"\tLevel: "+ game.getLvl());
    }
    public void run() throws FileNotFoundException, FileNotFoundException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException{    
            
        while(!(game.getState() instanceof IGameOver)){
   

            if(game.getState() instanceof IBeginning)
            {   
                setupbeginning();
            }
            if(game.getState() instanceof IAwaitAction)
            {   
                cls();
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
                s.nextLine();
            }
            if(game.getState() instanceof IMerchAwait){
               game.setState(game.getState().comitOpt(chooseMerch()));
            }
            if(game.getState() instanceof IRestAwait){
               game.setState(game.getState().comitOpt(chooseRest()));
            }            
            if(game.getState() instanceof ICombat){
                
                if(game.getIndex()!=6)
                    System.out.println("\nA WILD MONSTER APPEARS!!! OH MY GOD!!!\n");
                else
                    System.out.println("\nOh! A BOSS MONSTER APPEARS!!! TO BATTLE!! \n");
                System.out.println("Monster HP: " + game.GetMonster().getHp()+ "\tPlayer HP: "+ game.GetPlayerHP());
                System.out.println("Monster Reward: " + game.GetMonster().getReward());
                getdiceopt();//ROLL inicial e verificação de criticals, actualizando os dados no gamedata
                resolvFeat();
            }
            if(game.getState() instanceof IAwaitFeat){
               
                doFeat();
                game.setState(new IAwaitSpells(game.getDataGame(), game.GetMonster()));
            }
            if(game.getState() instanceof IAwaitSpells){
                game.setState(game.getState().comitOpt(doSpells()));
            }
            if(game.getState() instanceof IGameOver){
            
               if (game.GetPlayerHP()<=0){
                   System.out.println("YOU LOSER!!!");
               }
               if (game.GetPlayerHP()>0 || game.getArea()==14){
                   System.out.println("Congratulations!! The Og's Blood is yours!!!");    
               }
               int opt;
               System.out.println("1-LoadGame 2-Try again 3-Exit");
               do   
                opt=s.nextInt();
               while(opt<1 || opt>3);
               if(opt==2)
                       game=new Game(); 
               if(opt==1)
                   LoadGame();
               cls();
               
            }
            
        }
    }
    
    
}
