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
 * @author Bruno Santos
 */
public class ICombat extends StateAdapter{

    Monster npc;   

    public ICombat(Dugeon dataGame, boolean event) {
        super(dataGame);
        npc= new Monster(dataGame, event);
    }

    
    @Override
    public IStates start() {
        
        return super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
