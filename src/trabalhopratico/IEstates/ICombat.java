/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.cards.Monster;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class ICombat extends StateAdapter{

      Monster npc;

    public ICombat(Dugeon dataGame, Monster m) {
        super(dataGame);
        npc=m;
    }
    @Override
    public Monster GetMonster(){
        return npc;
    };
    
    @Override
    public IStates start() {
        
        return super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
