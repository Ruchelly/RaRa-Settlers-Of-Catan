/*
Game: Settlers of Catan
First draft: 1 resource class
by Ruchelly Almeida
Last modified on 9/28/16
CIT 285 (Adv. Java) - Prof. Miller
 */
package catan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Resources {
    
    // special cards that will give extra victory points if bought
    String[] developmentCards = {"knightCard","universityCard", "largestArmy", "longestRoad"};
    private List<String> list = Arrays.asList(developmentCards);
    
    Resources(){}
      
    public String getDevelopmentCard(){
        return drawDevelopmentCard();
    }
    
    public String drawDevelopmentCard(){
        Collections.shuffle(list);       
        return list.get(0);
        // check how many development cards there are in the game.
        // and subtract each card drawn
    }    
}
