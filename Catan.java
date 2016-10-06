/*
Game: Settlers of Catan
First draft: 1 resource class
by Ruchelly Almeida
Last modified on 9/28/16
CIT 285 (Adv. Java) - Prof. Miller
 */
 
package catan;

public class Catan { // will be transfered to javafx

    public static void main(String[] args) {
        
        Player yellow = new Player(); // create player 1
        Player blue = new Player();   // create player 2        
        Resources resources = new Resources();
        
        //Testing classes' methods
        yellow.addLumber(1);
        yellow.addBrick(1);
        yellow.addGrains(1);
        yellow.addWool(1);
        
        // Yellow's amount of lumber should be 1
        System.out.println("Yellow's amount of lumber: " + yellow.getLumber());  
        // Buy a settlement
        yellow.addSettlement(1);
        System.out.println("Yellow's number of settlements: " + yellow.getSettlement());
       
        // After buying a settlement, amount of lumber is 0
        System.out.println("Yellow's amount of lumber: " + yellow.getLumber());
        
        // Players will choose where to put the 2 initial roads (It needs Location class)
        //yellow.setRoadsLocation();        
        
        // Blue does not have enough resources to add a city
        // method will be called after checking for enough resources
        blue.addCity(1);
        System.out.println("Blue adding city: " + blue.getCities());
        
        // Yellow's turn to roll the dice
        System.out.println("Yellow rolls dice: " + yellow.rollDice());  
        System.out.println("Blue rolls dice: " + blue.rollDice());
        
        // displays how many roads Yellow has at the moment
        System.out.println("Yellow has " + yellow.getRoads() + " roads now.");
        System.out.println("Blue has " + blue.getSettlement() + " settlements now.");
        
        // Showing which resource card was drawn. 
        //This method will be called from buyDevelopCard() inside Player class
        System.out.println("Development card drawn: " + resources.drawDevelopmentCard());
        
        System.out.println("Yellow's victory points: " + yellow.getVictoryPoints());
        System.out.println("Blue's victory points: " + blue.getVictoryPoints());
    }    
}
