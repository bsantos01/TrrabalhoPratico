/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;


import java.util.Random;
import trabalhopratico.Spells.*;
import trabalhopratico.Spells.Spell;
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
    private int[] dices;
    
    

    public Dugeon() {
        area=1;
        lvl=1;
        
        player = new Player();
       
    }

// FIM CONSTRUTORES */
    public void update(){
        this.checkNextRank();
        if(cards.isEnd()){
            if (this.haveBoss())
                lvl++;
            area++;
            cards = new Area(this);
        }
    }
    public void BossReward(){
        switch(lvl){
            case 1:
            case 2:
                player.addGold(2);
                break;
            case 3:
            case 4:
                player.addGold(3);
                break;
        }        
    }
    
    public void WinRandSpell(){
        Spell temp=new Spell();
        Random ran = new Random();
        int x = ran.nextInt(4)+1;
        switch(x){
            case 1:
                temp=new Fireball();
                break;
            case 2:
                temp=new Ice();
                break;
            case 3:
                temp=new Poison();
                break;
            case 4:
                temp=new Healing();
                break;
        }
        this.LoseRandSpell();
        player.addSpell(temp);
    }
    public void LoseRandSpell(){
        Random ran = new Random();
        int x = ran.nextInt(2);
        player.rmSpell(x);
    }
    public int[] getRDices(){
        this.dices = new int[this.player.getRank()];        
        for (int i=0; i<this.player.getRank(); i++)
            dices[i]= this.rolldice();        
        return dices;
    }
    public int[] getDices(){      
        return dices;
    }
    public int getDamage(){      
        int dmg=0;
        for (int i=0; i<dices.length; i++)
            if (dices[i]!=1)
                dmg+=dices[i];        
        return dmg;
    }
    public String SpellToString(){
        return player.SpellToString();
    }
    public Spell GetSpell(int i){
     return player.GetSpell(i);
    }
    public void rmSpell(int i){
        player.rmSpell(i);
    }

    public void rerollCrit(int i){
        int temp=this.rolldice();
        if (temp!=1)
            dices[i]+=temp;
        else
            dices[i]=temp;
    }
    public int GetRank(){
        return player.getRank();
    }
    public void rerollSingle(int i){
        dices[i]=this.rolldice();
    }
    public boolean haveBoss(){
        if(area==2 || area==4 || area ==7 || area == 10 || area==14)return true;
        return false;
    }
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
    public int getPlayerHP(){
        return player.getHp();
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

    public String getDataPlayer() {
        return player.getData();
    }

    public void setMkill() {
        player.setMkill(true);
    }
    
}
