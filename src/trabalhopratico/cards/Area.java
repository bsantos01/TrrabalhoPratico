/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import trabalhopratico.Data.Dugeon;

/**
 *
 * @author Bruno Santos & Miguel Almeida
 */
public class Area implements Serializable{
    int index;
    ArrayList<Card> area;
    
    public Area(Dugeon gamedata){

        index = -1;
        Card [] temp= {new Event(), new Monster(gamedata, false), new Merchant(), new Resting(), new Treasure(), new Trap()};
        area= new ArrayList<Card>(Arrays.asList(temp));
                
        /*long seed=System.nanoTime();
        Collections.shuffle(area, new Random(seed));*/
        if(gamedata.haveBoss())area.add(new BossMonster(gamedata, false));
    }
    public void rmBoss(){
        area.remove(6);
    }
    public boolean isEnd(){
        if(area.size()<index+1)
            return true;
        return false;
    }
    public Card GetCard(int i){
        return area.get(i);
    }
    public Card GetActualCard(){
        return area.get(index);
    }
    public int getIndex(){
        return index;
    };
    
    public void addIndex(int i){
       this.index+=i;
    }

    public String getNameCard(int i) {
        if(index<0)
            if(i==0)
                return area.get(i).getname();
            else
                return "\t\t";
        if(index==0)
            if(i<3)
                return area.get(i).getname();
            else
                return "\t\t";
       if(index==2 || index==1)
            if(i<4)
                return area.get(i).getname();
            else
                return "\t\t";
       if(index==3)
            if(i<6)
                return area.get(i).getname();
            else
                return "\t\t";
        if(index==4||index==5)
            if(i<=6)
                return area.get(i).getname();
            else
                return "\t\t";
       return "\t\t";
    }

    public Card getCard(int i) {
        if(index<0)
            if(i==0)
                return area.get(i);
            else
                return null;
        if(index==0)
            if(i<3)
                return area.get(i);
            else
                return null;
       if(index==2 || index==1)
            if(i<4)
                return area.get(i);
            else
                return null;
       if(index==3)
            if(i<6)
                return area.get(i);
            else
                return null;
        if(index==4||index==5)
            if(i<=6)
                return area.get(i);
            else
                return null;
       return null;
    }
}
