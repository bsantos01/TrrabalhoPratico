package trabalhopratico.IEstates;

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
    IStates run();
    IStates merchBuy(int opt);
  
    
}
