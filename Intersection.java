package hexTileTester;

// Skeleton of intersection created only for testing HexTile

public class Intersection {
	
	// Only variables needed for testing
	private int type;
	private boolean occupied;
	private int test;		// Specifically for testing static arrays between GameManager and HexTile
	
	Intersection(){
		type = 1;
		occupied = true;
	}
	
	Intersection(int type, boolean occupied){
		this.setType(type);
		this.setOccupied(occupied);
	}

	public int getPlayer() {
		return 0;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

}
