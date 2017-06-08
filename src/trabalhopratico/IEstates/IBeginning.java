/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.cards.Area;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class IBeginning extends StateAdapter{
    
        public IBeginning(Dugeon gamedata){
            super(gamedata);
        }
        
        @Override
        public IStates setupGame(int d, int a) {
                    this.getDataGame().setarea(a); 
        switch(a){
            case 1:
            case 2:
                this.getDataGame().setlvl(1);
                break;
            case 3:
            case 4:
                this.getDataGame().setlvl(2);
                break;     
            case 5:
            case 6:
            case 7:
                this.getDataGame().setlvl(3);
                break;
            case 8:
            case 9:
            case 10:
                this.getDataGame().setlvl(4);
                break;
            case 11:
            case 12:
            case 13:
            case 14:
                this.getDataGame().setlvl(5);
                break;
        }
        this.getDataGame().setDifPlayer(d);//ACABAR
        this.getDataGame().newArena();
        return new IAwaitAction(this.getDataGame());
        }
        @Override
        public IStates comitOpt(int opt){
            this.getDataGame().setDifPlayer(1);
            return(new IAwaitAction(this.getDataGame()));
        }
        
}
