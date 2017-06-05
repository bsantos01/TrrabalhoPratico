/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;

import java.util.Observable;
import trabalhopratico.IEstates.IStates;
import trabalhopratico.cards.Card;

/**
 *
 * @author Bruno Santos
 */
public class ObservableGame extends Observable{
    
    Game game;

    public ObservableGame() {
        game= new Game();
    }
    
    
    public boolean haveBoss(){
        return game.haveBoss();
    }
    public Card getCard(int i){
        return game.getCard(i);
    }
    
    public Game getGame(){
    return game;
    }
    
    public Dugeon GetDataGame(){
        return game.getDataGame();
    }
    
    public IStates getState(){
        return game.getState();
    }
    
    public void setGame(Game game){
        this.game= game;
        
        setChanged();
        notifyObservers();
    }
    
    public void start(int dif,int area){
        game.setupGame(dif, area);
        
        setChanged();
        notifyObservers();
    }

    public void commitopt(int i){
       game.commitopt(i);
       
        setChanged();
        notifyObservers();
    }
    public String getLog() {
        return game.getLog();
    }

    public boolean isClickable(int i) {
        return game.isClickable(i);
    }

           
}
