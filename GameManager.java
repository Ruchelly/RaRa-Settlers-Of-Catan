package hexTileTester;

public class GameManager {
	private static Intersection[] grid = new Intersection[1];
	private static Players[] players = new Players[1];

	public static Intersection[] getGrid() {
		return grid;
	}

	public static void setGrid(Intersection[] grid) {
		GameManager.grid = grid;
	}

	public static Players[] getPlayers() {
		return players;
	}

	public static void setPlayers(Players[] players) {
		GameManager.players = players;
	}

}
