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
public class IAwaitFeat extends StateAdapter{

    Monster npc;
     
    public IAwaitFeat(Dugeon dataGame, Monster m) {
        super(dataGame);
        npc=m;
    }
    
    @Override
    public IStates doFeat(int []i)
    {
        this.getDataGame().setDices(i);
        return new IAwaitSpells(this.getDataGame(), this.npc);
    }
    
    @Override
    public int doFeat(int opt, int i){ 
        if(opt==1){
            this.getDataGame().rmXP(1);
        }
        else this.getDataGame().rmHP(2);
        this.getDataGame().setDice(i);
        return this.getDataGame().rolldice();
    }
    @Override
    public Monster GetMonster(){
        return npc;
    }
    @Override
    public boolean rerollCrit(int i){
        return this.getDataGame().rerollCrit(i);        
    }
    @Override
    public IStates start(){
        return this;
    };
}
