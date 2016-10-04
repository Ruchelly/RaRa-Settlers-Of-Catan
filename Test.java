package hexTileTester;

public class Test {
	public static void main(String[] args){
		System.out.println("Creating HexTile object for testing");
		HexTile hexTest = new HexTile();
		
		System.out.println("Proof of concept for connecting static array in GameManager for corner handling");
		System.out.println("Initialize GameManager.grid");
		GameManager.getGrid()[0] = new Intersection();
		GameManager.getGrid()[0].setTest(5);
		GameManager.getPlayers()[0] = new Players();
		
		System.out.println("Setting hexTest array equal to GameManager array");
		hexTest.getIntersections()[0] = GameManager.getGrid()[0];
		
		System.out.println("hexTest test = " + hexTest.getIntersections()[0].getTest());
		System.out.println("GameManager test = " + GameManager.getGrid()[0].getTest() + "\n");

		System.out.println("Changing via GameManager");
		GameManager.getGrid()[0].setTest(7);
		
		System.out.println("hexTest test = " + hexTest.getIntersections()[0].getTest());
		System.out.println("GameManager test = " + GameManager.getGrid()[0].getTest() + "\n");
		
		System.out.println("Changing via HexTile");
		hexTest.getIntersections()[0].setTest(2);
		
		System.out.println("hexTest test = " + hexTest.getIntersections()[0].getTest());
		System.out.println("GameManager test = " + GameManager.getGrid()[0].getTest() + "\n");
		
		System.out.println("Creating new HexTile using HexTile(Intersection[])");
		HexTile altConstructor = new HexTile(GameManager.getGrid());
		
		System.out.println("Ensuring all three intersection arrays are equal, including new tile with argument constructor");
		System.out.println("hexTest test = " + hexTest.getIntersections()[0].getTest());
		System.out.println("GameManager test = " + GameManager.getGrid()[0].getTest());
		System.out.println("altConstructor test = " + altConstructor.getIntersections()[0].getTest() + "\n");
		
		System.out.println("Changing via new HexTile");
		altConstructor.getIntersections()[0].setTest(8);
		
		System.out.println("Ensuring all three intersection arrays are still equal, including new tile with argument constructor");
		System.out.println("hexTest test = " + hexTest.getIntersections()[0].getTest());
		System.out.println("GameManager test = " + GameManager.getGrid()[0].getTest());
		System.out.println("altConstructor test = " + altConstructor.getIntersections()[0].getTest() + "\n");
		
		System.out.println("Testing getResource on initial default HexTile");
		System.out.println("Should return a different int in [0,4] each time");
		System.out.println("yield = " + altConstructor.getResourceYield());
		System.out.println("This also proves that setResource() is working and assigning values properly\n");
		
		System.out.println("Testing default setCoast on initial default HexTile");
		System.out.println("Should return false");
		System.out.println("isCoast = " + altConstructor.isCoast());
		System.out.println("Changing to true");
		altConstructor.setCoast(true);
		System.out.println("isCoast = " + altConstructor.isCoast());
		System.out.println("Proves getter and setter for coast works\n");
		
		System.out.println("Testing default setRobber on initial default HexTile");
		System.out.println("Should return false");
		System.out.println("robber? = " + altConstructor.hasRobber());
		System.out.println("Changing to true");
		altConstructor.setRobber(true);
		System.out.println("robber? = " + altConstructor.hasRobber());
		System.out.println("Proves getter and setter for robber works\n");
		altConstructor.setRobber(false);
		
		System.out.println("Testing default setCenter on initial default HexTile");
		System.out.println("Should return false");
		System.out.println("center? = " + altConstructor.isCenter());
		System.out.println("Changing to true");
		altConstructor.setCenter(true);
		System.out.println("center? = " + altConstructor.isCenter());
		System.out.println("Proves getter and setter for center works\n");
		altConstructor.setCenter(false);
		
		System.out.println("Testing yieldResources() method");
		System.out.println("Old Value: " + GameManager.getPlayers()[hexTest.getIntersections()[0].getPlayer()].getResources()[altConstructor.getResourceYield()]);

		altConstructor.yieldResources();
		System.out.println("New Value: " + GameManager.getPlayers()[hexTest.getIntersections()[0].getPlayer()].getResources()[altConstructor.getResourceYield()]);

	}
}
