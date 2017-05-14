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
public class Event extends Card implements Serializable{
    
     @Override
     public IStates accao(int opt, Dugeon act)
     {
         int v= act.rolldice();
         switch (v){
             case 1:
                 act.addfood();
             break;
             case 2:
                 act.addHP(2);
             break;
             case 3:
                 act.addGold(2);
             break;
             case 4:
                 act.addxp(2);
             break;
             case 5:
                 act.addArmor(1);
             break;
             case 6:
                 Monster m= new Monster(act, true);
                 return new ICombat(act, m);
         }
             return new IAwaitAction(act);
     }
     
     @Override
     public IStates inicia(Dugeon act)
     {
        return accao(0,act);
     }
     
     
     @Override
     public String getname(){
         return "Event\t\t";
     }
}
