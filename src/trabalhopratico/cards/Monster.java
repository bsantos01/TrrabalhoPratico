/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.ICombat;
import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos
 */
public class Monster extends Card{
        
    int dmg;
    int hp;
    int reward;
    
    public Monster(Dugeon act, boolean event){
    
        hp=act.getarea()+act.rolldice();

        if(event)
            reward=2;
        else
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
       
        
    }
     @Override
     public IStates accao(int opt, Dugeon act)
     {
          dmg = act.getlvl()*2;
             return new IAwaitAction(act);
     } 
     
         @Override
     public IStates inicia(Dugeon act){
        
        return new ICombat(act, false);
    }
}
