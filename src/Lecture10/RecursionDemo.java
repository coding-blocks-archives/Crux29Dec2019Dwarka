package Lecture10;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printKeypad("12", "");

		int[][] arr = { { 0, 0, 9, 0 }, { 0, 0, 9, 0 }, { 9, 0, 0, 0 }, { 0, 9, 0, 0 } };
		printMazePathWithhurdle(arr, 3, 3, 0, 0);
		
		TOH(3,"src","dest","helper");
		
		int n=4;
		boolean[][] board=new boolean[n][n];
		System.out.println(countNQueens(board, 0));
		

	}

	public static void printKeypad(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		String code = codes(ch);
		for (int i = 0; i < code.length(); i++) {
			char gc = code.charAt(i);
			printKeypad(ros, res + gc);
		}

	}

	public static String codes(char ch) {
		if (ch == '1') {
			return "abc";
		}
		if (ch == '2') {
			return "def";
		}
		if (ch == '3') {
			return "ghi";
		}
		if (ch == '4') {
			return "jkl";
		}
		if (ch == '5') {
			return "mno";
		}
		if (ch == '6') {
			return "pqr";
		}
		if (ch == '7') {
			return "stu";
		}
		if (ch == '8') {
			return "vwx";
		}
		if (ch == '9') {
			return "yz";
		}

		return null;

	}

	public static void printMazePathWithhurdle(int[][] arr, int er, int ec, int cr, int cc) {
		if (er == cr && cc == ec) {
			arr[cr][cc] = 1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("********************");
			return;

		}
		if (cr > er || cc > ec) {
			return;
		}
		if (arr[cr][cc] == 9) {
			return;
		}

		arr[cr][cc] = 1;
		printMazePathWithhurdle(arr, er, ec, cr, cc + 1);
		printMazePathWithhurdle(arr, er, ec, cr + 1, cc);
		arr[cr][cc] = 0;

	}

	public static void TOH(int n, String src, String dest, String helper) {
		if (n == 0) {
			return;
		}

		TOH(n - 1, src, helper, dest);
		System.out.println("Move " + n + "th disc from " + src + " to " + dest);
		TOH(n - 1, helper, dest, src);
	}
	
	
	public static int countNQueens(boolean[][] board, int row) {
        if(row==board.length) {
       	 return 1;
        }
		
		int count=0;
		for(int col=0;col<board.length;col++) {
			if(isItSafe(board, row, col)) {
				board[row][col]=true;
				count=count+countNQueens(board, row+1);
				board[row][col]=false;
			}
		}
		
		return count;
	}
	
	public static boolean isItSafe(boolean[][] board,int row,int col) {
		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}
	
	

}
