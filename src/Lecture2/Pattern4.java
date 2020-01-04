package Lecture2;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		// prep for 1st row
		int row = 1;
		int nst = 1;
		int value = 1;
		while (row <= n) {
			int cst = 1;
			while (cst <= nst) {
				System.out.print(value);
				value++;
				cst++;
			}
			System.out.println();
			nst++;
			row++;
		}
	}

}
