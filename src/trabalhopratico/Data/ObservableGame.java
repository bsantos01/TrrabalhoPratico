/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import static trabalhopratico.Data.Game.loadGame;
import trabalhopratico.IEstates.IStates;
import trabalhopratico.Spells.Spell;
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
    public void newgame() {
        game= new Game();
                    setChanged();
                    notifyObservers();
    }
    public int getXP(){
        return game.getXP();
    }
    public int getHP(){
        return game.getHP();
    }
    public String SpellToStringI(int i){
        return game.SpellToStringI(i);
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

    public int getDice(int i) {
        return game.getDice(i);
    }
    
    public void feat(int opt, int i){
        game.feat(opt, i);
        setChanged();
        notifyObservers();
    }
    public void DoFeat(){
        game.DoFeat();
        setChanged();
        notifyObservers();
    }
    public int reCritical(int i){

        int flag=game.rerollCrit(i);
        setChanged();
        notifyObservers();
        return flag;
    }
        public boolean SaveGame(){
        String name= "MiniRogue.txt";

        try{
            game.saveGame(name);
            
            return true;
        } catch(IOException e){
            System.out.println("Error trying to save game in file: "+ name);
            System.out.println(e);
            return false;
        }
    }
        public boolean LoadGame() throws FileNotFoundException, ClassNotFoundException{
        String  name= "MiniRogue.txt";
                if (!new java.io.File(name).exists()){
                    System.out.println("File "+name+" does not exist.");
                    return false;
                }
                   

        try{
            game=loadGame(name);
            setChanged();
            notifyObservers();
            return true;
        }catch(IOException e){
            System.out.println("Error trying to load game from: "+ name);
            System.out.println(e);
            return false;
        }
    }

    public int getArmor() {
        return game.getArmor();
    }

    public int getMonsteHP() {
        if(game.GetMonster()==null)
            return 0;
        else  return game.GetMonster().getHp();
    }

    public int getLevel() {
        return game.getLvl();
    }

    public int getArea() {
        return game.getArea();
    }

    public int getFood() {
       return game.getFood();
    }

    public int getGold() {
        return game.getGold();
    }

    public int getRank() {
        return game.GetRankPlayer();
    }

    public Spell getSpell(int i) {
        return game.getSpell(i);
    }

    public boolean isLockDice(int j) {
        return game.isLockDice(j);
    }

    public void setLock(int j) {
        game.setLock(j);
    }
          
}
