/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import trabalhopratico.Data.Dugeon;

import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos
 */
public class BossMonster extends Monster {
    
    public BossMonster(Dugeon act, boolean event) {
        super(act, false);

            switch(act.getlvl()){
                case 1:
                    hp=10;
                    dmg=3;
                    reward=2;
                case 2:
                    hp=15;
                    dmg=5;
                    reward=3;
                    break;
                case 3:
                    hp=20;
                    dmg=7;
                    reward=4;
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
       ice=false;
       poison=false;
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
