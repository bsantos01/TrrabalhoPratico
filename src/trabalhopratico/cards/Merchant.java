/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IMerchAwait;
import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos
 */
public class Merchant extends Card {
    public void Merchant(){
       
        this.descricao="Merchant";
    }
    
    @Override
    public IStates accao(int opt, Dugeon act){
      
        switch(opt){
            case 1:
                if(act.rmGold(1))
                    act.addfood();   
            break;
            case 2:
                if(act.rmGold(1))
                    act.addHP(1);
            break;
            case 3:
                if(act.rmGold(3))
                    act.addHP(4);
            break;
        
            case 4:
                if(act.rmGold(6))
                    act.addArmor(1);
            break;
         
            case 5:
                if(act.rmGold(8))
                    //act.addSpell();
            break;
            case 7:
                if(act.rmArmor(1))
                    act.addGold(3);   
            break;
            case 6:
                //if()
                    //act.rmSpell();
            break;
        }
        return new IMerchAwait(act);
    }
    
    @Override
     public IStates inicia(Dugeon act)
     {
        return new IMerchAwait(act);
     }
}
