package Lecture5;

public class TwoDArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr;
		// System.out.println(arr);

		arr = new int[3][4];
		System.out.println(arr);
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[0][2]);
		System.out.println(arr[0]);

	//	arr[0][0] = 100;
		arr[1][1]=200;
		
		arr[1]=new int[5];
		display(arr);

//		// arr=new int[][4];
//
//		arr = new int[3][];
//		System.out.println(arr);
//		System.out.println(arr[0]);
//		System.out.println(arr[0].length);
		
		

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
