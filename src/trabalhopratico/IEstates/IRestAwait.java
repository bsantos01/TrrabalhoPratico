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
public class IRestAwait extends StateAdapter {

    public IRestAwait(Dugeon dataGame) {
        super(dataGame);
    }

    @Override
    public IStates start() {
        return super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates RestOpt(int opt){
            this.getDataGame().GetActualCard().accao(opt, this.getDataGame());
            return new IAwaitAction(this.getDataGame()); 
    }
}
