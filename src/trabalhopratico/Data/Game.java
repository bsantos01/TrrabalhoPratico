/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import trabalhopratico.IEstates.*;
import java.util.Random;
import trabalhopratico.cards.Monster;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Game implements Serializable{
    
    private Dugeon gamedata;
    private IStates state;
    

    
    public Game(){
    
        gamedata = new Dugeon();
        state = new IBeginning(gamedata);
    }
    public IStates commitopt(int i){
        return state.comitOpt(i);
    }
    public IStates Do(){
        return state.Do();
    }
    public IStates DoFeat(int [] i){
            return state.doFeat(i);
    }
    public int getDamage(){ 
        return gamedata.getDamage();
    }
    public Monster GetMonster(){
        return state.GetMonster();
    }
    public void getRDices(){
        gamedata.RDices();
    }
    public String SpellToString(){
        return gamedata.SpellToString();
    }
    
    public int[] getDices(){
        return gamedata.getDices();
    }
    public boolean rerollCrit(int i){
        return state.rerollCrit(i);
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
    public int getLvl(){
        return gamedata.getlvl();
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
    
    public IStates setupGame(int d, int a){
        return state.setupGame(d, a);
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
    public void saveGame(String name) throws FileNotFoundException, IOException{
        ObjectOutputStream oout=null;
        try{
            oout= new ObjectOutputStream(new FileOutputStream(name));
            oout.writeObject(this);
        } finally{
            if (oout!=null)
                oout.close();
        }
    }
    public static Game loadGame(String name) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream oin=null;
        Game g;
        try{
            oin= new ObjectInputStream(new FileInputStream(name));
            g = (Game)oin.readObject();
            return g;
        } finally{
            if (oin!=null)
                oin.close();
        }
    }

    public String getLog() {
        return gamedata.getLog();
    }
    
    public void refreshLog() {
        gamedata.refreshLog();
    }

    public void feat(int opt, int i) {
        gamedata=state.doFeat(opt, i);
    }
}
