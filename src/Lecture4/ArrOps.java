package Lecture4;

public class ArrOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 10, 40, 150, 60 };
		System.out.println(max(arr));
		// reverse(arr);
		// display(arr);

		System.out.println(linearSearch(arr, 150));
//		bubbleSort(arr);
//		display(arr);
		System.out.println();
//		selectionSort(arr);
//		display(arr);
		
		insertionSort(arr);
		display(arr);

	}

	public static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;

	}

	public static void reverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;

		}

	}

	public static int linearSearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 1; i <= arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			int min_value = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min_value) {
					min = j;
					min_value = arr[j];
				}
			}

			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0&&arr[j]<arr[j-1];j--) {
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}
		}
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	

}
