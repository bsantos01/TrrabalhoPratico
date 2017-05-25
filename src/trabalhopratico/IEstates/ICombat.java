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
        this.getDataGame().RDices();
        npc=m;
    }
    @Override
    public Monster GetMonster(){
        return npc;
    };
    @Override
    public IStates comitOpt(int opt){
        if (opt==1)
           return new IAwaitFeat(this.getDataGame(), this.npc);
        else
           return new IAwaitSpells(this.getDataGame(), this.npc);
    
    }     
    @Override
    public IStates Do(){
        return new IAwaitFeat(getDataGame(),this.npc);    
     }
    @Override
    public boolean rerollCrit(int i){
        return this.getDataGame().rerollCrit(i);        
    }


    
    
}
