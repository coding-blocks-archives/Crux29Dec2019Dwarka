package Lecture26;

public class DC1 {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			int[] one = {3,5,7};
//			int[] two = {1,2,6,8};
//			int[] ans = merge(one, two);
//			for (int i = 0; i < ans.length; i++) {
//				System.out.print(ans[i] + " ");
//			}

//			int[] arr = { 3, 5, 2, 4, 7, 1 };
//			int[] ans = mergeSort(arr, 0, arr.length - 1);
//			for (int i = 0; i < ans.length; i++) {
//				System.out.print(ans[i] + " ");
//			}

	}
	
	
	public static int[] merge(int[] one, int[] two) {

		int[] ans = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				j++;
				k++;
			}

		}

		while (i < one.length) {
			ans[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			ans[k] = two[j];
			j++;
			k++;
		}

		return ans;
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}
		int mid = (low + high) / 2;
		int[] one = mergeSort(arr, low, mid);
		int[] two = mergeSort(arr, mid + 1, high);
		int[] sorted = merge(one, two);
		return sorted;

	}

}
