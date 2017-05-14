/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import java.io.Serializable;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.ICombat;
import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Monster extends Card implements Serializable{
        
    int dmg;
    int hp;
    int reward;
    boolean ice;
    boolean poison;
    
    public int getDmg() {
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int damage) {
        this.hp -= damage;
        if (poison==true)
            this.hp-=5;
    }

    public int getReward() {
        return reward;
    }

    public Monster(Dugeon act, boolean event){
  
       dmg = act.getlvl()*2;
       hp=act.getarea()+act.rolldice();
        if(event)
            reward=2;
        else{
            reward=0;
        }
            
       ice=false;
       poison=false;
    }
    

    public void setPoison(){
        poison=true;
    }
    public void setIce(){
        ice=true;
    }
 
     @Override
     public IStates inicia(Dugeon act){
       dmg = act.getlvl()*2;
       hp=act.getarea()+act.rolldice();
       if (reward==0)
            switch(act.getlvl()){
                case 1:
                case 2:
                    reward=1;
                    break;
                case 3:
                case 4:
                    reward=2;
                    break;
                case 5:
                    reward=3;
                    break;
            }
       return new ICombat(act, this);
    }

     @Override
     public String getname(){
         return "Monster \t";
     }

    @Override
    public IStates accao(int opt, Dugeon act) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean tradeIce() {
        if(ice){
            ice=false;
            return true;
        }
        else return false;
    }

}
