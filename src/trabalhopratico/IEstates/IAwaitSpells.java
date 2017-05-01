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
public class IAwaitSpells extends StateAdapter{

    public IAwaitSpells(Dugeon dataGame) {
        super(dataGame);
    }

    @Override
    public IStates start() {
        return this;
    }
    
}
