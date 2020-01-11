package Lecture4;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		// System.out.println(arr);

		arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		arr[1] = 20;
		arr[2] = 30;
//	      for(int i=0;i<arr.length;i++) {
//	    	  System.out.println(arr[i]);
//	      }

		System.out.println(arr.length);

		// System.out.println(arr[arr.length]);
		System.out.println(arr[arr.length - 1]);

		arr[1] = 10;
		arr[2] = 20;
		int i = 1, j = 2;
		System.out.println(arr[i] + " " + arr[j]);
		swap(arr, i, j);
		System.out.println(arr[i] + " " + arr[j]);
		
		System.out.println(arr);

	}

	public static void swap(int[] arr, int i, int j) {
		System.out.println(arr[i] + " " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		System.out.println(arr[i] + " " + arr[j]);
	}

}
