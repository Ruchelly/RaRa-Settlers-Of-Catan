package hexTileTester;

public class HexTile {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~Properties~~~~~~~~~~~~~~~~~~~ */
	private int resourceYield; // Holds the type of resource tile will yield
								// if numRoll is rolled
	private int numRoll; // Number if rolled, resources yielded
	private Intersection[] intersections; // Corner nodes for each corner of the
											// HexTile
	private Border[] borders; // Border nodes for six sides
	private boolean coast; // Determines whether HexTile will contain port or
							// not
	private boolean robber; // is robber currently on tile?
	private boolean center; // center has no yield

	// Will remove if not needed, but might be nice?
	public static enum resources {
		BRICK, LUMBER, ORE, WHEAT, WOOL
	};

	/* ~~~~~~~~~~~~~~~~~~~~~~~Constructors~~~~~~~~~~~~~~~~~~~ */
	HexTile() {
		setResourceYield();
		setNumRoll();
		setIntersections(new Intersection[6]);
		setBorders(new Border[6]);
		setCoast(false);
		setRobber(false);
		setCenter(false);
	}

	// Same as above, but with predetermined corners
	HexTile(Intersection[] corners) {
		setResourceYield();
		setNumRoll();
		setBorders(new Border[6]);
		setCoast(false);
		setRobber(false);
		setCenter(false);
		
		setIntersections(corners);
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~Methods~~~~~~~~~~~~~~~~~~~ */

	public int getResourceYield() {
		return this.resourceYield;
	}

	// randomly assigns index value of resources array as resourceYield
	public void setResourceYield() {
		int rand = getRandInt(0, 4);
		this.resourceYield = rand;
	}

	public int getNumRoll() {
		return numRoll;
	}

	// numRoll must be between 2 and 12 (double dice roll), but not 7 (robber)
	public void setNumRoll() {
		int randInt = getRandInt(2, 12);

		while (randInt == 7) {
			randInt = getRandInt(2, 12);
		}
		numRoll = randInt;
	}

	public boolean isCoast() {
		return coast;
	}

	// will be “manually” called on specific hexTiles
	public void setCoast(boolean coast) {
		this.coast = coast;
	}

	public boolean hasRobber() {
		return robber;
	}

	// called when robber is moved on (true) or off (false)
	public void setRobber(boolean robber) {
		this.robber = robber;
	}

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	public void yieldResources() {
		// Tiles with robber and center tile do not yield resources
		if (!this.hasRobber() && !this.isCenter()) {
			// For each intersection in array of intersections, give the occupying player(s) (if any) resources
			for (Intersection intersection : getIntersections()) {
				if (intersection.isOccupied()) {
					// This complicated looking line first finds the player occupying the intersection in question
					// It then uses the number of that player to get the player object itself
					// It then opens the resources array of that player and adds "type" to it
					// (One for settlement, two for city)
					GameManager.getPlayers()[intersection.getPlayer()].getResources()[resourceYield] += intersection.getType();
				}
			}
		}
	}

	public static int getRandInt(int min, int max) {
		int random;

		// Math.random() returns a double in [0, 1)
		// multiplying this by one more than the difference between min and max
		// yields a double in [min, max)
		// typecast to int and return
		random = min + (int) (Math.random() * ((max - min) + 1));

		return random;
	}

	public Border[] getBorders() {
		return borders;
	}

	public void setBorders(Border[] borders) {
		this.borders = borders;
	}

	public Intersection[] getIntersections() {
		return intersections;
	}

	public void setIntersections(Intersection[] intersections) {
		this.intersections = intersections;
	}

}
