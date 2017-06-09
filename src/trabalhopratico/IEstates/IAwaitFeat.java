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
    public IStates doFeat()
    {
        this.getDataGame().unlockDices();
        return new IAwaitSpells(this.getDataGame(), this.npc);
    }
    
    @Override
    public Dugeon doFeat(int opt, int i){ 
        if(opt==1){
            this.getDataGame().rmXP(1);
        }
        else this.getDataGame().rmHP(2);
        this.getDataGame().setDice(i);
        this.getDataGame().lockDice(i);
        return this.getDataGame();
    }
    @Override
    public Monster GetMonster(){
        return npc;
    }
    @Override
    public int rerollCrit(int i){
        return this.getDataGame().rerollCrit(i);        
    }
    @Override
    public IStates start(){
        return this;
    };
}
