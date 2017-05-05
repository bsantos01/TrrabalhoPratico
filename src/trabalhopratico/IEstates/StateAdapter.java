/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import trabalhopratico.Data.Dugeon;

/**
 *
 * @author Bruno Santos
 */
public class StateAdapter implements IStates {
    private Dugeon gamedata;
    
    //Contrutores, Getter and Setter
    public StateAdapter(Dugeon dataGame)
    {
        this.gamedata = dataGame;
    }

    public Dugeon getDataGame()
    {
        return gamedata;
    }

    public void setDataGame(Dugeon dataGame)
    {
        this.gamedata = dataGame;
    }
    
    
    //Override das funções a chamar pelos estados
    @Override
    public IStates start(){
        return this;
    };
    @Override
    public IStates run(){
        return this;
    };
    @Override
    public IStates inicia(){
        return this;
    };
    @Override
    public IStates merchBuy(int opt){
        return this;
    };
    @Override
    public IStates RestOpt(int opt){
        return this;
    };
    
}
