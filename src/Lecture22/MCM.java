package Lecture22;

public class MCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dims = { 10, 20, 30, 40, 50, 60 };
		System.out.println(mcm(dims, 0, dims.length - 1));
		//System.out.println(mcmRS(dims, 0, dims.length - 1, new int[dims.length][dims.length]));
		System.out.println(MCMBU(dims));

	}

	public static int mcm(int[] dims, int si, int ei) {
		if (ei - si == 1) {
			return 0;
		}
		int myans = Integer.MAX_VALUE;
		int tot_cost = 0;
		int cost1 = 0;
		int cost2 = 0;
		int cost3 = 0;
		for (int i = si; i < ei - 1; i++) {
			cost1 = mcm(dims, si, i + 1);
			cost2 = mcm(dims, i + 1, ei);
			cost3 = dims[si] * dims[i + 1] * dims[ei];
			tot_cost = cost1 + cost2 + cost3;
			myans = Math.min(myans, tot_cost);
		}
		return myans;
	}

	public static int mcmRS(int[] dims, int si, int ei, int[][] strg) {
		if (ei - si == 1) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int myans = Integer.MAX_VALUE;
		int tot_cost = 0;
		int cost1 = 0;
		int cost2 = 0;
		int cost3 = 0;
		for (int i = si; i < ei - 1; i++) {
			cost1 = mcmRS(dims, si, i + 1, strg);
			cost2 = mcmRS(dims, i + 1, ei, strg);
			cost3 = dims[si] * dims[i + 1] * dims[ei];
			tot_cost = cost1 + cost2 + cost3;
			myans = Math.min(myans, tot_cost);
		}
		strg[si][ei] = myans;
		return myans;
	}
	
	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 2; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// copy paste
				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k]; // arr[si]*arr[k]
					int sp = strg[k][ei]; // arr[k]*arr[ei]

					int tp= arr[si] * arr[k] * arr[ei];

					int total = fp + sp + tp;

					if (total < min) {
						min = total;
					}

				}

				strg[si][ei] = min;

			}

		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(strg[i][j]+"      ");
			}
			System.out.println();
		}

		return strg[0][n - 1];

	}

}
