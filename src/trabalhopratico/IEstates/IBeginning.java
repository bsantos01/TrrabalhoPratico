/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;

/**
 *
 * @author Bruno Santos
 */
public class IBeginning extends StateAdapter{
    
        public IBeginning(Dugeon gamedata){
            super(gamedata);
        }
        
        @Override
        public IStates start(){
            // Accao executada neste estado
            return new IAwaitAction(getDataGame());
        };

}
