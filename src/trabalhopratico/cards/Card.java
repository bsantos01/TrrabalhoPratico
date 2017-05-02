/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IStates;
/**
 *
 * @author Bruno Santos
 */
public abstract class Card {
  
    protected String descricao;
    
    abstract public IStates accao(int opt, Dugeon act);
    abstract public IStates inicia(Dugeon act);
    
    public String GetDesc(){return descricao;}
    
}



