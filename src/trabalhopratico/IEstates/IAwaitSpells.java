/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.Spells.*;
import trabalhopratico.cards.BossMonster;
import trabalhopratico.cards.Monster;

/**
 *
 * @author Bruno Santos
 */
public class IAwaitSpells extends StateAdapter{
    
     Monster npc;
    
    public IAwaitSpells(Dugeon dataGame, Monster m) {
        super(dataGame);
        npc=m;
    }
    @Override
    public Monster GetMonster(){
        return npc;
    }
    @Override
    public IStates start() {
        return this;
    }
    @Override
    public IStates comitOpt(int opt){
       Spell temp;        
       int damage=this.getDataGame().getDamage();
       if(opt!=(-1)){
        temp=this.getDataGame().GetSpell(opt);
        
        if (temp instanceof Fireball)
           damage+=8;
        if (temp instanceof Ice)
           this.GetMonster().setIce();
        if (temp instanceof Poison)
           this.GetMonster().setPoison();
        if (temp instanceof Healing)
           this.getDataGame().addHP(8);

        this.getDataGame().rmSpell(opt);

       }
       npc.setHp(damage);
       if(npc.getHp()<=0){ //Monstro morto
           if (npc instanceof BossMonster){
               if(this.getDataGame().getarea()==14)//se derrotar o ultimo boss há vitoria
                   return new IGameOver(this.getDataGame());
               this.getDataGame().BossReward();
               this.getDataGame().WinRandSpell();
            }
           this.getDataGame().addxp(npc.getReward());   
           this.getDataGame().setMkill();//define para true a variavel do user ja ter morto um monstro
           return new IAwaitAction(this.getDataGame());
       }
       if(npc.tradeIce()){
           return new ICombat(this.getDataGame(), this.npc);
       }
        this.getDataGame().rmHP(npc.getDmg()-this.getDataGame().getArmor()); //damage do monstro menos a armor do player
        if(this.getDataGame().getPlayerHP()<=0) //se player morto
            return new IGameOver(this.getDataGame());
        return new ICombat(this.getDataGame(), this.npc);
    }
    
}
