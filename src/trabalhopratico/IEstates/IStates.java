package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;
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

    public Dugeon doFeat(int opt, int i);

    int rerollCrit(int i);
    IStates Do();
    IStates doFeat();
    IStates setupGame(int d, int a);
        
    
    
}
