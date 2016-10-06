package catan;

/*
Game: Settlers of Catan
First draft: 1 resource class
by Ruchelly Almeida
Last modified on 9/28/16
CIT 285 (Adv. Java) - Prof. Miller
 */

public class Player {
    // number of buildings a player has
    private int nRoads;
    private int nCities;
    private int nSettlements;
    
    //points earned by players during the game. 1st player w/ 10 pts wins the game
    private int victoryPoints;
    private boolean receiveResources;
    
    // location of buildings owned
    private int[][] roadLocation;
    private int[][] citiesLocation;
    private int[][] settlementsLocation;
    
    // amount of resources owned
    private Resources playerDevelCard;
    private int lumber;
    private int brick;
    private int wool;
    private int grains;
    private int ore;
    
    Player(){
        // Each player starts w/ 2 roads and 2 settlements
        nRoads = 2;          // maximum 15
        nCities = 0;         // maximum  4
        nSettlements = 2;    // maximum  5
        victoryPoints = 2;   // each settlement is worth 1 victory point     
    }
    
    // Player buys a road
    public void addRoad(int road) {
        if (this.nRoads + road > 15) {
            System.out.println("You have exceeded the number of Roads.");
        } else {
            payLumber(1);
            payBrick(1);
            this.nRoads += road;
            // set road to location chosen
        }
    }
    
    public int getRoads(){
        return nRoads;
    }
    
    // method needs Location class
    public void setRoadLocation(int[][] roadLocation){
        this.roadLocation = roadLocation;
    }
    
    public int[][] getRoadLocation(){
        return roadLocation;
    }
 
    public void addCity(int city) {
        if (this.nCities + city > 4) {
            System.out.println("You have exceeded the number of Cities available.");
        } 
        else {
            payGrains(2);
            payOre(3);
            this.nCities += city;
            victoryPoints += 2;
        }
    }
    
    public int getCities(){
        return nCities;
    }
    
    public void setCityLocation(int[][] cityLocation){
        this.citiesLocation = cityLocation;
    }
    
    public int[][] getCityLocation(){
        return citiesLocation;
    }
    
    public void addSettlement(int settlement) {
        if (this.nSettlements + settlement > 4) {
            System.out.println("You have exeeded the number of Settlements available.");
        } 
        else {
            payLumber(1);
            payBrick(1);
            payGrains(1);
            payWool(1);
            this.nSettlements += settlement;
            victoryPoints += 1;
        }
    }
    
    public int getSettlement(){
        return nSettlements;
    }
    
    public void setSettlementLocation(int[][] settlementsLocation){
        this.settlementsLocation = settlementsLocation;
    }
    
    public int[][] getSettlementLocation(){
        return settlementsLocation;
    }
    
    public void addVictoryPoints(int points){
        this.victoryPoints += points;
        if(victoryPoints >= 10)
            System.out.println("You are the winner!!!");
    }
    
    public int getVictoryPoints(){        
        return victoryPoints;
    }
    
    // returns the sum of dice rolled by the player
    public int rollDice(){
        int dice1=(int)(Math.random()*6+1);
        int dice2=(int)(Math.random()*6+1);
        int sum = dice1 + dice2;
        
        return sum;
    } 
    
    // if player has a building next to the number rolled, will receive resource
    // depends on the Location class
    public boolean receivesResource(){
        return receiveResources;
    }
    
    public void setLumber(int lumber){
        this.lumber = lumber;
    }
    
    // adds lumber cards to player's resources
    public void addLumber(int lumber) {        
        this.lumber += lumber;
    }
    
    // subtract lumber cards from player's resources
    public void payLumber(int lumber){
        if (this.lumber < 1) 
            System.out.println("You do not have any lumber at this time.");
        else 
            this.lumber -= lumber;
    }
    
    public int getLumber(){
        return lumber;
    }
    
    public void setOre(int ore){
        this.ore = ore;
    }
    
    // adds ore cards to player's resources
    public void addOre(int ore){
        this.ore += ore;
    }
    
    // subtract ore cards from player's resources
    public void payOre(int ore){
        if (this.ore < 1) 
            System.out.println("You do not have any ore at this time.");
        else         
            this.ore -= ore;
    }
    
    public int getOre(){
        return ore;
    }
    
    public void setWool(int wool){
        this.wool = wool;
    }
    
    // adds wool cards to player's resources
    public void addWool(int wool){
        this.wool += wool;
    }
    
    // subtract wool cards from player's resources
    public void payWool(int wool){
        if (this.wool < 1) 
            System.out.println("You do not have any wool at this time.");
        else        
            this.wool -= wool;
    }
    
    public int getWool(){
        return wool;
    }
    
    public void setGrains(int grains){
        this.grains = grains;
    }
    
    // add grains cards to player's resources
    public void addGrains(int grains){
        this.grains += grains;
    }
    
    // subtract grains cards from player's resources
    public void payGrains(int grains){
        if (this.grains < 1) 
            System.out.println("You do not have any grains at this time.");
        else 
        this.grains -= grains;
    }
    
    public int getGrains(){
        return grains;
    }
    
    public void setBrick(int brick){
        this.brick = brick;
    }
    
    // adds brick cards to player's resources
    public void addBrick(int brick){
        this.brick += brick;
    }
    
    // subtract brick cards from player's resources
    public void payBrick(int brick){
        if (this.brick < 1) 
            System.out.println("You do not have any brick at this time.");
        else 
            this.brick -= brick;
    }
    
    public int getBrick(){
        return brick;
    }
    
    public void buyDevelopCard(){
        String developmentCard = playerDevelCard.drawDevelopmentCard();
        payGrains(1);
        payWool(1);
        payOre(1);
        
        if(null != developmentCard)  //check how many points the cards will give.
            switch (developmentCard) {
            case "knightCard":
                addVictoryPoints(1);
                break;
            case "universityCard":         
                addVictoryPoints(4);
                break;
            case "largestArmy":  
                addVictoryPoints(2);
                break;
            default:
                break;
        }                   
    }
}
