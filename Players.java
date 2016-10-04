package hexTileTester;

// Skeleton for testing

public class Players {
		// array of integers holds value of each resource
		private int resources[];
		
		Players(){
			resources = new int[5];
			for (int r:resources){
				r = 0;
			}
		}
		
		public int[] getResources() {
			return resources;
		}

		public void setResources(int resources[]) {
			this.resources = resources;
		}
}
