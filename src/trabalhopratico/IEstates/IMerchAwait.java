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
public class IMerchAwait extends StateAdapter {

    public IMerchAwait(Dugeon dataGame) {
        super(dataGame);
    }

    @Override
    public IStates start() {
        return super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public IStates comitOpt(int opt){
        if(opt!=8){
            this.getDataGame().GetActualCard().accao(opt, this.getDataGame());
            return new IMerchAwait(this.getDataGame());
        }
        else
            return new IAwaitAction(this.getDataGame());
    }
    
}
