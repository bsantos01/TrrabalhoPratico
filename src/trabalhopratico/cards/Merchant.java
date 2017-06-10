/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import java.io.Serializable;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IMerchAwait;
import trabalhopratico.IEstates.IStates;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Merchant extends Card implements Serializable {
    public void Merchant(){
       
        this.descricao="Merchant";
    }
    
    @Override
    public IStates inicia(Dugeon act){
        
        return new IMerchAwait(act);
    }
    
    @Override
    public IStates accao(int opt, Dugeon act){
      
        switch(opt){
            case 1:
                if(!act.maxfood())
                    if(act.rmGold(1))
                        act.addfood();   
            break;
            case 2:
                if(!act.maxHP())
                    if(act.rmGold(1))
                        act.addHP(1);
            break;
            case 3:
                if(!act.maxHP())
                    if(act.rmGold(3))
                        act.addHP(4);
            break;       
            case 4:
                if(!act.maxArmor())
                    if(act.rmGold(6))
                        act.addArmor(1);
            break;
         
            case 5:
                if(act.rmGold(8))
                    act.WinRandSpell();
            break;
            case 6:
                if(act.rmArmor(1))
                    act.addGold(3);   
            break;
            case 7:
                if(act.LoseRandSpell()){
                    act.addGold(4);                   
                }
            break;
        }
        return new IMerchAwait(act);
    }
    
    
     @Override
    public String getname(){
         return "Merchant \t";
     }
}
