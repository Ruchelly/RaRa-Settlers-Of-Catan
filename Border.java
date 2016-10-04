package hexTileTester;

// Unnecessary for testing and also incomplete

public class Border {
	private Intersection startPoint;
	private Intersection endPoint;
	private boolean hasRoad;
	private int playerOwning;
	
	
	public Intersection getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Intersection startPoint) {
		this.startPoint = startPoint;
	}
	public Intersection getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Intersection endPoint) {
		this.endPoint = endPoint;
	}
	public boolean isHasRoad() {
		return hasRoad;
	}
	public void setHasRoad(boolean hasRoad) {
		this.hasRoad = hasRoad;
	}
	public int getPlayerOwning() {
		return playerOwning;
	}
	public void setPlayerOwning(int playerOwning) {
		this.playerOwning = playerOwning;
	}
}
