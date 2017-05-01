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
    
    public IStates getState(){
        return state;
    }
    
    public int getIndex(){
        return gamedata.getIndex();
    }
    public void addIndex(int i){
        gamedata.addIndex(i);
    }
    
    public void setDificulty(int d, int a){
        gamedata.setup(d, a);
        state= new IAwaitAction(gamedata);
    }
    
    public int rolldice(){
        Random randomGenerator= new Random();
        int v= randomGenerator.nextInt(6)+1;       
        return v;
    };
}
