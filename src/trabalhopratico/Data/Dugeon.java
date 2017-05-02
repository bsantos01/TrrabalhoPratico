/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;


import java.util.Random;
import trabalhopratico.cards.Area;
import trabalhopratico.cards.Card;


/**
 *
 * @author Bruno Santos
 */



public class Dugeon {
//game
    private int area;
    private int lvl;
    private Player player;
    private Area cards;
    
    
    

    public Dugeon() {
        area=1;
        lvl=1;
        player = new Player();
        cards = new Area(this);
    }

// FIM CONSTRUTORES */

    public void setup(int difficulty, int area) {
        this.area=area;
        this.player.Difficulty(difficulty);
        this.cards = new Area(this);
    }
    
    public int rolldice(){
        Random randomGenerator= new Random();
        int v= randomGenerator.nextInt(6)+1;       
        return v;
    };
    
    public Card getACard(int i){
        return cards.GetCard(i);
    }
    public Card GetActualCard(){
        return cards.GetActualCard();
    }
    
    public int getarea() {
        return area;
    }

    public void setarea(int area) {
        this.area = area;
    }
    public int getlvl() {
        return lvl;
    }

    public void setlvl(int lvl) {
        this.lvl = lvl;
    }
    
    public int getIndex(){
       return cards.getIndex();
    }
    public void addIndex(int i){
       cards.addIndex(i);
    }
    
    
//FIM GETTERS / SETTERS
    public void checkNextRank(){
        player.checkNextRank();
    }

//ADDS AND REMOVES    
    public void addxp(int v){
        player.addxp(v);
    }
    
    public void rmXP(int v){
        player.rmXP(v);
    }
    
    public void rmfood(){
        player.setFood(player.getFood()-1);
    }
    public void addfood(){
        player.setFood(player.getFood()+1);
    }
    public void addHP(int v){
        player.setHp(player.getHp()+v);
    }
    public void rmHP(int v){
        player.setHp(player.getHp()-v);
        if (this.player.getHp()<=0){
            //DIEEEEEEEEE
        }
    }
    
    public boolean rmGold(int v){
        return player.rmGold(v);
    }
    public void addGold(int v){
        this.player.addGold(v);
    }
    public void addArmor(int v){
        this.player.addArmor(v);
    }
    public boolean rmArmor(int v){
        return this.player.rmArmor(v);
    }
     public boolean getMkill() {
        return player.getMkill();
    }

    public void setMkill(boolean op) {
        player.setMkill(op);
    }
// FIM ADDS AND REMOVES

    public String getNameCard(int i) {
        return cards.getNameCard(i);
    }
    
}
