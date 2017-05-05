/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;
import trabalhopratico.IEstates.IStates;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IAwaitAction;
import trabalhopratico.IEstates.IRestAwait;



/**
 *
 * @author Bruno Santos
 */
public class Resting extends Card {
    
    public void Resting(){

        this.descricao="Resting";
            
            }
    
    @Override
    public IStates accao(int opt, Dugeon act){
        
        switch(opt){
            case 1:
                act.addxp(1);
            break;
            case 2:
                act.addfood();
            break;
            case 3:
                act.addHP(2);
            break;
            case 4:
                break;
        }
        return new IAwaitAction(act); 
    }

    @Override
     public IStates inicia(Dugeon act)
     {
             return new IRestAwait(act);
     } 
     
     
     @Override
     public String getname(){
         return "Resting \t";
     }
}
