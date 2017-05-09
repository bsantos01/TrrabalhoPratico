package trabalhopratico.IEstates;

import trabalhopratico.cards.Monster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno Santos
 */
public interface IStates 
{
    //todas as funções que retornam um estado
    IStates start();
    IStates comitOpt(int opt);
    public Monster GetMonster();
        
    
    
}
