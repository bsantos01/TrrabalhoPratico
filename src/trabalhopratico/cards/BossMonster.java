/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.ICombat;

import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos
 */
public class BossMonster extends Monster {
    
    public BossMonster(Dugeon act, boolean event) {
        super(act, false);

            
      
    }
    
    @Override
     public IStates inicia(Dugeon act){
       switch(act.getlvl()){ //apenas quando é chamado é atribuido os dados, na medida que se cair num pit no nivel 2, passa para nivel 1 e terá que ter o monstro nivel 1
                case 1:
                    hp=10;
                    dmg=3;
                    reward=2;
                    break;
                case 2:
                    hp=15;
                    dmg=5;
                    reward=3;
                    break;
                case 3:
                    hp=20;
                    dmg=7;
                    reward=4;
                    break;
                case 4:
                    hp=25;
                    dmg=9;
                    reward=5;
                    break;
                case 5:
                    hp=30;
                    dmg=12;
                    break;
            }
       return new ICombat(act, this);
    }
    
     @Override
     public String getname(){
         return "MonsterBoss \t";
     }

    @Override
    public IStates accao(int opt, Dugeon act) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
