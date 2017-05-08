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
public class IAwaitFeat extends StateAdapter{

    public IAwaitFeat(Dugeon dataGame) {
        super(dataGame);
    }
    
    @Override
    public IStates comitOpt(int opt){
        
        this.getDataGame().rerollSingle(opt);
        this.getDataGame().rmXP(1);
        this.getDataGame().rmHP(2);
        return new IAwaitFeat(this.getDataGame());
    }
    
    @Override
    public IStates start(){
        return this;
    };
}
