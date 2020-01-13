package Lecture5;

public class TwoDArrayOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 11, 12, 13, 14 }, 
				        { 21, 22, 23, 24 }, 
				        { 31, 32, 33, 34 },
				        { 41, 42, 43, 44 } };
		display(arr);
		System.out.println("-----------------");
		wave_print(arr);
		System.out.println("\n-----------------");
		spiral_print(arr);
		
		int[] a= {3,1,4,5,5,7,3,1,7};
		System.out.println("\n"+findOne(a));
		
		System.out.println(searchInSorted(arr, 54));
		
		
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void wave_print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			} else {
				for (int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
	}

	public static void spiral_print(int[][] arr) {
		int top = 0, bottom = arr.length - 1, left = 0, right = arr[top].length - 1;
		int dir = 1;
		int count = (bottom + 1) * (right + 1);
		while (left <= right && bottom >= top) {
			if (count > 0) {
				if (dir == 1) {
					for (int i = left; i <= right; i++) {
						System.out.print(arr[top][i] + " ");
					}
				}
				top++;
				dir = 2;
			}

			if (count > 0) {
				if (dir == 2) {
					for (int i = top; i <= bottom; i++) {
						System.out.print(arr[i][right] + " ");
						count--;
					}
					dir = 3;
					right--;
				}
			}

			if (count > 0) {
				if (dir == 3) {
					for (int i = right; i >= left; i--) {
						System.out.print(arr[bottom][i] + " ");
						count--;
					}
					dir = 4;
					bottom--;
				}
			}

			if (count > 0) {
				if (dir == 4) {
					for (int i = bottom; i >= top; i--) {
						System.out.print(arr[i][left] + " ");
						count--;
					}
					dir = 1;
					left++;
				}
			}
		}
	}
	
	public static int findOne(int[] arr) {
	     int ans=0;
	     for(int i=0;i<arr.length;i++) {
	    	 ans=ans^arr[i];
	     }
	     
	     return ans;
	}
	
	public static boolean searchInSorted(int[][] arr,int data) {
		int i=0;
		int j=arr[0].length-1;
		
		while(i<arr.length&&j>=0) {
			if(arr[i][j]==data) {
				return true;
			}else if(data<arr[i][j]) {
				j--;
			}else {
				i++;
			}
		}
		
		return false;
		
		
	}

}
