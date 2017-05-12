/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;
import java.io.Serializable;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.IEstates.IStates;
/**
 *
 * @author Bruno Santos
 */
public abstract class Card implements Serializable{
  
    protected String descricao;
    
    abstract public IStates accao(int opt, Dugeon act);
    abstract public IStates inicia(Dugeon act);
    abstract public String getname();
    
    public String GetDesc(){return descricao;}
    
}



