package Lecture27;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
        quicksort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
	}

	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int pindex = partition(arr, start, end);
		quicksort(arr, start, pindex - 1);
		quicksort(arr, pindex + 1, end);
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end]; // end index element
		int pindex = start;
		for (int i = start; i <= end - 1; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pindex);
				pindex++;
			}
		}

		swap(arr, pindex, end);
		return pindex;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
