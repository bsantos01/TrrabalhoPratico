/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.cards.Treasure;

/**
 *
 * @author Bruno Santos
 */
public class IAwaitAction extends StateAdapter{
 
    
    public IAwaitAction(Dugeon gamedata){
     super(gamedata);
    }
    
    @Override
    public IStates start(){
        
      
            //this.getDataGame().GetActualCard().inicia();
        
        
        return this;
    
    };
}

