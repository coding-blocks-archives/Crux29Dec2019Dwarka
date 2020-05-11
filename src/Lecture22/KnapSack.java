package Lecture22;

//This questions is the standard dp problem
public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts =    { 1,2,3 };
		int[] values = { 10,1,5 };
		int capacity = 5;
		int[][] strg = new int[wts.length][capacity + 1];
		System.out.println(knapsack(wts, values, capacity, 0));
		System.out.println(knapsackRS(wts, values, capacity, 0, strg));
		System.out.println(knapsackIS(wts, values, capacity));
	}

	public static int knapsack(int[] wts, int[] values, int capacity, int index) {
		if (index == wts.length || capacity <= 0) {
			return 0;
		}
		int ans = 0;
		int include = 0;
		int exclude = 0;
		if (wts[index] < capacity) {
			include = values[index] + knapsack(wts, values, capacity - wts[index], index + 1);
			exclude = knapsack(wts, values, capacity, index + 1);
		}else {
			exclude=knapsack(wts, values, capacity, index+1);
		}
		ans = Math.max(include, exclude);
		return ans;
	}

	public static int knapsackRS(int[] wts, int[] values, int capacity, int index, int[][] strg) {
		if (index == wts.length || capacity <= 0) {
			return 0;
		}
		if (strg[index][capacity] != 0) {
			return strg[index][capacity];
		}
		int ans = 0;
		int include = 0;
		int exclude = 0;
		if (wts[index] < capacity) {
			include = values[index] + knapsackRS(wts, values, capacity - wts[index], index + 1, strg);
			exclude = knapsackRS(wts, values, capacity, index + 1, strg);

		}else {
			exclude=knapsackRS(wts, values, capacity, index+1,strg);
		}

		ans = Math.max(include, exclude);
		strg[index][capacity] = ans;
		return ans;
	}

	public static int knapsackIS(int[] wts, int[] values, int capacity) {
		int[][] strg = new int[wts.length + 1][capacity + 1];
		for (int i = 1; i <= wts.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (wts[i - 1] <= j) {
					strg[i][j] = Math.max(strg[i - 1][j], values[i - 1] + strg[i - 1][j - wts[i - 1]]);
				} else {
					strg[i][j] = strg[i - 1][j]; 
				}
			}
		}

		
		for(int i=0;i<strg.length;i++) {
			for(int j=0;j<strg[i].length;j++) {
				System.out.print(strg[i][j]+" ");
			}
			System.out.println();
		}
		return strg[wts.length][capacity];

	}

}
