/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import trabalhopratico.Data.Dugeon;

/**
 *
 * @author Bruno Santos
 */
public class Area {
    int index;
    ArrayList<Card> area;
    
    public Area(Dugeon gamedata){
        index=-1;
        Card [] temp= {new Event(), new Monster(gamedata, false), new Merchant(), new Resting(), new Treasure()};
        area= new ArrayList<Card>(Arrays.asList(temp));
        long seed=System.nanoTime();
        Collections.shuffle(area, new Random(seed));
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
}
