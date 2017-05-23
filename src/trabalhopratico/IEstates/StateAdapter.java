/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.IEstates;

import java.io.Serializable;
import trabalhopratico.Data.Dugeon;
import trabalhopratico.cards.Monster;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class StateAdapter implements IStates, Serializable {
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
    public IStates comitOpt(int opt){
        return this;
    };
    @Override
    public Monster GetMonster(){
        return null;
    };

    @Override
    public boolean rerollCrit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public IStates doFeat(int []i){
        return this;
    }
    @Override
    public IStates Do() {
        return this;
    }

    @Override
    public IStates setupGame(int d, int a) {
        return this;
    }

}
