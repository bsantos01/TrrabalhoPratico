package trabalhopratico.IEstates;

import trabalhopratico.cards.Monster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public interface IStates  
{
    //todas as funções que retornam um estado
    IStates start();
    IStates comitOpt(int opt);
    Monster GetMonster();
    boolean rerollCrit(int i);
    IStates Do();
    IStates doFeat(int []i);
    IStates setupGame(int d, int a);
        
    
    
}
