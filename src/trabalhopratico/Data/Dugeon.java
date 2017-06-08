/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.Data;


import java.io.Serializable;
import java.util.Collections;
import java.util.Random;
import trabalhopratico.Spells.*;
import trabalhopratico.Spells.Spell;
import trabalhopratico.cards.Area;
import trabalhopratico.cards.Card;


/**
 *
 * @author Bruno Santos & Miguel Almeida
 */



public class Dugeon implements Serializable{
//game
    private int area;
    private int lvl;
    private final Player player;
    private Area cards;
    private int[] dices;
    private String log;
   
    
    public Dugeon() {
        this.area=1;
        this.lvl=1;
        this.player = new Player();
        this.log = "";
        dices= new int[this.player.getRank()];
        newArena();
    }

// FIM CONSTRUTORES */

    public void trapPit(){
        switch(area){
            case 1:
            case 2:
                //apenas perde o HP;
                break;
            case 3:    
            case 4:    
            case 5:    
            case 6:
                area-=2;
                lvl--;
                break;
            case 7:
                area=4;
                lvl--;
                break;
            case 8:    
            case 9:    
            case 10:
            case 11:
            case 12:
            case 13:
                area-=3;
                lvl--;
                break;
            case 14:
                area=10;
                lvl--;
                break;               
        }
    }
    public void update(){
        this.checkNextRank();
        
        if(cards.isEnd()){          
            if (this.haveBoss())
                lvl++;
            area++;
            cards = new Area(this);
            player.consumeFood();
            this.setLog("Passou para a area "+area + " de jogo! Muito bem!\n");
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
        Random ran = new Random();
        int x = ran.nextInt(4)+1;
        WinSpell(x);
    }
    
    
    public void WinSpell(int opt){
        Spell temp=new Spell();

        switch(opt){
            case 1:
                temp=new Fireball();
                this.log += "Adquiriu o Spell FireBall!\n";
                break;
            case 2:
                temp=new Ice();
                this.log += "Adquiriu o Spell Ice!\n";
                break;
            case 3:
                temp=new Poison();
                this.log += "Adquiriu o Spell Poison!\n";
                break;
            case 4:
                temp=new Healing();
                this.log += "Adquiriu o Spell Healing!\n";
                break;
        }
        if(player.spells.size()==2)
            this.LoseRandSpell();
        player.addSpell(temp);
    }
    public boolean LoseRandSpell(){
        Random ran = new Random();
        int x = ran.nextInt(1);
        if(player.spells.isEmpty())
            return false; 
        player.rmSpell(1);
        return true;
    }
    public void setDices(int []i){
        this.dices=i;
    }
    public void RDices(){
        this.dices = new int[this.player.getRank()];        
        for (int i=0; i<this.player.getRank(); i++)
            dices[i]= this.rolldice();        
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
    
    public String SpellToStringI(int i){
        return player.SpellToStringI(i);
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

    public int rerollCrit(int i){
        int temp=this.rolldice();
        
        if (temp!=1){
            dices[i]+=temp;
        }else{
            dices[i]=temp;
        }
        return temp;
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

    
    public int rolldice(){
        Random randomGenerator= new Random();
        int v= randomGenerator.nextInt(6)+1;       
        return v;
    };
    
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log += log;
    }
    
    public void refreshLog() {
        this.log = "";
    }
    
    public Card getACard(int i){
        return cards.GetCard(i);
    }
    public Card GetActualCard(){
        return cards.GetActualCard();
    }
    
    public int getarea() {
        return area;
    }
    public void setDifPlayer(int dif){
        player.Difficulty(dif);
    }
    public void newArena() {
        this.cards= new Area(this);
    }
    public void setarea(int area) {
        this.area = area;
        this.log += "Passou para a area " + area + " !\n";
    }
    public int getlvl() {
        return lvl;
    }

    public void setlvl(int lvl) {
        this.log += "Passou para o nível " + lvl + " !\n";
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
        this.log += "Ganhou " + v + " de XP!\n";
        player.addxp(v);
    }
    
    public void rmXP(int v){
        this.log += "Perdeu " + v + " de XP !\n";
        player.rmXP(v);
    }
    
    public void rmfood(){
        this.log += "Perdeu 1 de XP !\n";
        player.setFood(player.getFood()-1);
    }
    public void addfood(){
        this.log += "Ganhou 1 de Food !\n";
        player.setFood(player.getFood()+1);
    }
    public void addHP(int v){
        this.log += "Ganhou " + v + " de HP !\n";
        player.setHp(player.getHp()+v);
    }
    public void rmHP(int v){
        this.log += "Perdeu " + v + " de HP !\n";
        player.setHp(player.getHp()-v);
    }
    
    public boolean rmGold(int v){
        if(player.rmGold(v)){
            this.log += "Perdeu " + v + " de Gold !\n";
            return true;
        }
        return false;
    }
    public void addGold(int v){
        this.log += "Ganhou " + v + " de Gold !\n";
        this.player.addGold(v);
    }
    public void addArmor(int v){
        this.log += "Ganhou " + v + " de Armor !\n";
        this.player.addArmor(v);
    }
    public boolean rmArmor(int v){
        this.log += "Perdeu " + v + " de Armor !\n";
        return this.player.rmArmor(v);
    }
    public int getArmor(){
        return this.player.getArmor();
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

    public void setDice(int i) {
        this.dices[i]=rolldice();
    }

    public Card getCard(int i) {
        return cards.getCard(i);
    }

    public boolean isClickable(int i) {
        if(cards.getIndex()==0){
            if(i==1||i==2){
                return true;
            }
        }
        if(cards.getIndex() == 3){
            if(i==4||i==5){
                return true;
            }
        }
       return false;
    }

    public int getDice(int i) {
        if(dices==null)
            return 0;
        if(i < dices.length)
            return dices[i];
        else
            return 0;
    }

    public int getHP() {
        return player.getHp();
    }
    public int getXP(){
        return player.getXp();
    }
    
}
