/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico;

import java.io.IOException;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.*;
import java.util.Random;

/**
 *
 * @author Bruno Santos
 */
public class Game {
    
    private Dugeon gamedata;
    private IStates state;
    

    
    public Game(){
    
        gamedata = new Dugeon();
        state = new IBeginning(gamedata);
    }
    
    public int[] getRDices(){
        return gamedata.getRDices();
    }
    public String SpellToString(){
        return gamedata.SpellToString();
    }
    public int[] getDices(){
        return gamedata.getDices();
    }
    public void rerollCrit(int i){
        gamedata.rerollCrit(i);
    }
    public void rerollSingle(int i){
        gamedata.rerollSingle(i);
    }
    public int GetPlayerHP(){
        return gamedata.getPlayerHP();
    }
    public int GetRankPlayer(){
        return gamedata.GetRank();
    }
   
    public boolean haveBoss(){
        return gamedata.haveBoss();
    }
    
    public IStates getState(){
        return state;
    }
    
    public int getIndex(){
        return gamedata.getIndex();
    }
    public int getArea(){
        return gamedata.getarea();
    }
    public void addIndex(int i){
        gamedata.addIndex(i);
    }
    
    public void setDificulty(int d, int a){
        gamedata.setup(d, a);
        state= new IAwaitAction(gamedata);
    }
    
    public void setState(IStates s){
        state = s;
    }
    
    public int rolldice(){
        Random randomGenerator= new Random();
        int v= randomGenerator.nextInt(6)+1;       
        return v;
    };

    public String getNameCard(int i) {
        return gamedata.getNameCard(i);
    }

    public String getDataPlayer() {
        return gamedata.getDataPlayer();
    }
    public Dugeon getDataGame(){
        return gamedata;
    }
}
