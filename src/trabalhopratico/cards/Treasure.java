/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos
 */
public class Treasure extends Card{
    
     @Override
     public IStates accao(int opt, Dugeon act)
     {
         if(act.getMkill())
            act.addGold(2);
         else
             act.addGold(1);
         
         switch(act.rolldice()){
             case 1:
                 act.addArmor(1);
                 break;
             case 2:
                 act.addxp(2);
                 break;
             case 3:
                 //add spell fireball
                 break;
             case 4:
                 //add spell icespell
                 break;
             case 5:
                 //add spell poison
                 break;
             case 6:
                 //add spell healing
                 break;
            }
        return new IAwaitAction(act);
     }
     
     @Override
     public IStates inicia(Dugeon act)
     {
             return accao(0, act);
     }
     
     @Override
     public String getname(){
         return "Treasure\t";
     }
    
}
