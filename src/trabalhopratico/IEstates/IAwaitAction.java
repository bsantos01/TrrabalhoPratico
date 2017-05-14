/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class IAwaitAction extends StateAdapter{
 
    
    public IAwaitAction(Dugeon gamedata){
     super(gamedata);
    }
    
    @Override
    public IStates start(){

       this.getDataGame().update();
        if (this.getDataGame().getPlayerHP()<=0)
            return new IGameOver(this.getDataGame());
        if(this.getDataGame().getIndex()<0)
           return new IAwaitAction(this.getDataGame());

       return this.getDataGame().GetActualCard().inicia(this.getDataGame());
    };
}

