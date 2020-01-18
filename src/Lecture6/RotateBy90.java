package Lecture6;

public class RotateBy90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16, 17} };
		rotate(arr);
	}

	public static void rotate(int[][] arr) {
		int n = arr.length;
	
		for (int i = 0; i < (int) Math.floor(n/2); i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n-1-j][i];
				arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
				arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
				arr[j][n - 1 - i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
