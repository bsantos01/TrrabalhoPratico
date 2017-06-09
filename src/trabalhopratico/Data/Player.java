/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import trabalhopratico.Spells.Spell;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Player implements Serializable{
    
//character
    private int xp;
    private int hp;
    private int armor;
    private int food;
    private int gold;
    private int rank;
    private boolean mKill;
    ArrayList <Spell> spells;

    
    
    public void Difficulty(int difficulty) {
        spells=new ArrayList<>(); 
        this.xp = 0;
        this.rank = 1;
        this.mKill=false;
        switch (difficulty){
            case 0:
                this.hp = 300;
                this.armor = 1;
                this.food = 6;
                this.gold = 5;
            break;
            case 1:
                this.hp = 5;
                this.armor = 0;
                this.food = 6;
                this.gold = 3;
            break;
            case 2:
                this.hp = 4;
                this.armor = 0;
                this.food = 5;
                this.gold = 2;
            break;
            case 3:
                this.hp = 3;
                this.armor = 0;
                this.food = 3;
                this.gold = 1;
            break;     
        }          
    }
    
    //GETTERS / SETTERS    
    public int getXp() {
        return xp;
    }
    
    public String SpellToString(){
       if (spells.isEmpty())
                return null;
       StringBuilder s = new StringBuilder();
       
       for(int i=0;i<spells.size();i++){
        s.append("\n"+(i+1) + ": "+ spells.get(i).GetNome());
       }
        
        return s.toString();
    }
    public String SpellToStringI(int i){
        if(spells.size()>i)
            return spells.get(i).GetNome();
        else
            return "No spell in this slot";  
    }
    public void rmSpell(int i){
        spells.remove(i);
    }
    public Spell GetSpell(int i){
        if(spells.size()>i)
            return spells.get(i);
        return null;
    }
    public void addSpell(Spell e){
        spells.add(e);
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public boolean getMkill() {
        return mKill;
    }

    public void setMkill(boolean op) {
        this.mKill = op;
    }
    
    public void checkNextRank(){
        
        if(this.xp>=6 && rank == 1){
            rank=2;
            xp=0;
        }else  if(this.xp>=12 && rank == 2){
            rank=3;
            xp=0;
        }else  if(this.xp>=18 && rank == 3){
            rank=4;
            xp=0;
        }                       
    }
    
    public void addxp(int v){
        if (rank!=4)
            xp+=v;
        else
            this.food+=1;
                this.checkNextRank();
    }  
    public void rmXP(int v){
        if(xp-v<=0){
            switch (rank) {
                case 2:
                    rank--;
                    xp = 6 + (xp - v);
                    break;
                case 3:
                    rank--;
                    xp=12 +(xp-v);
                    break;
                case 4:
                    rank--;
                    xp=18 +(xp-v);
                    break;
                default:
                    break;
            }
        }else{
            xp-=v;
        }   
    }
    
    
    public boolean rmGold(int v){
    
        if (this.gold>=v){
            gold-=v;
            return true;
        }else{
            return false;
        }
    }
    
    public void addGold(int v){
        this.gold+=v;
    }
    public void addArmor(int v){
        this.armor+=v;
    }
    public boolean rmArmor(int v){
        if (this.armor>0){
            this.armor-=v;
            return true;
        }
        return false;
    }

    String getData() {
        return "HP: " +hp+ "\t\tArmor: "+armor+ "\tFood: "+food +"\t\tGold: " + gold +"\t\tRank: "+rank +"\t\tXP: " + xp;
    }

    void consumeFood() {
        
        if(food<0)
            hp-=2;
        food--;
    }
}
