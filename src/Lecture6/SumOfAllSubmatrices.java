package Lecture6;

public class SumOfAllSubmatrices {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1 }, { 1, 1 } };
		System.out.println(approach1(arr));
		System.out.println(approach2(arr));

	}

	public static int approach1(int[][] arr) {
		int sum = 0;
		int m = arr.length;
		int n = arr[0].length;
		for (int tli = 0; tli < m; tli++) {
			for (int tlj = 0; tlj < n; tlj++) {
				for (int bri = tli; bri < m; bri++) {
					for (int brj = tlj; brj < n; brj++) {
						for (int i = tli; i <= bri; i++) {
							for (int j = tlj; j <= brj; j++) {
								sum = sum + arr[i][j];
							}
						}

					}
				}
			}
		}
		return sum;
	}

	public static int approach2(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int tl = (i + 1) * (j + 1);
				int br = (m - i) * (n - j);
				sum = sum + (tl * br) * arr[i][j];
			}
		}
		return sum;
	}
}
