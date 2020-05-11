package Lecture11;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 lexico(1000, 0);

//		int n = 7;
//		boolean[] primes = new boolean[n + 1];
//		for (int i = 2; i < primes.length; i++) {
//			if (isPrime(i)) {
//				primes[i] = true;
//			}
//		}
//
//		int[] ladders = new int[n + 1];
//		makeLadders(ladders, primes);

//		for(int i=2;i<ladders.length;i++) {
//			System.out.print(ladders[i]);
//		}
//		
//		boolean[][] board = new boolean[5][5];
//		System.out.println(countNknights(board, 0, 0, 0));

	//	printBoardPath(ladders, 7, 0, "");

//		int[] arr = { 40, 20, 80 };
//		System.out.println(mixtures(arr, 0, arr.length - 1));
		
		
		int[] dims = { 10, 20, 30, 40, 50, 60 };
		System.out.println(mcm(dims, 0, dims.length - 1));

	}

	public static void printBoardPath(int[] ladders, int end, int curr, String res) {
		if (curr == end) {
			System.out.println(res + " END");
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders[curr] != 0 && curr <= ladders[curr]) {
			printBoardPath(ladders, end, ladders[curr], res + curr);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				printBoardPath(ladders, end, curr + dice, res + curr);
			}

		}

	}

	public static void lexico(int end, int curr) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				lexico(end, curr * 10 + i);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				lexico(end, curr * 10 + i);
			}
		}
	}

	public static void makeLadders(int[] ladders, boolean[] primes) {
		int left = 0, right = primes.length - 1;
		while (left <= right) {
			while (primes[left] != true) {
				left++;
			}
			while (primes[right] != true) {
				right--;
			}

			ladders[left] = right;
			ladders[right] = left;
			left++;
			right--;
		}
	}

	public static boolean isPrime(int n) {
		int divisor = 2;
		while (divisor < n) {
			if (n % divisor == 0) {
				return false;
			}
			divisor = divisor + 1;
		}

		return true;
	}

	public static int countNknights(boolean[][] board, int row, int col, int placed) {
		if (placed == board.length) {
			return 1;
		}
		int count = 0;
		for (int c = col; c < board.length; c++) {
			if (isSafe(board, row, c)) {
				board[row][c] = true;
				count = count + countNknights(board, row, c + 1, placed + 1);
				board[row][c] = false;
			}
		}

		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				if (isSafe(board, r, c)) {
					board[r][c] = true;
					count = count + countNknights(board, r, c + 1, placed + 1);
					board[r][c] = false;
				}
			}
		}

		return count;

	}

	public static boolean isSafe(boolean[][] board, int row, int col) {

		if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1] == true) {
			return false;
		}

		if (row - 2 >= 0 && col + 1 < board.length && board[row - 2][col + 1] == true) {
			return false;
		}

		if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2] == true) {
			return false;
		}

		if (row - 1 >= 0 && col + 2 < board.length && board[row - 1][col + 2] == true) {
			return false;
		}

		return true;

	}

	public static int mixtures(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = si; i <= ei - 1; i++) {
			int left = mixtures(arr, si, i);
			int right = mixtures(arr, i + 1, ei);
			int left_and_right = color(arr, si, i) * color(arr, i + 1, ei);
			int myans = left + right + left_and_right;
			if (myans < ans) {
				ans = myans;
			}

		}

		return ans;
	}

	public static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum = sum + arr[i];
		}

		return sum % 100;
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
	
	
}
