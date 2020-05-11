package Lecture26;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {3,5,7,15,25,45};
       System.out.println(bs(arr, 25));
       
	}
	
	public static int bs(int[] arr,int data) {
		int l=0;
		int r=arr.length-1;
		
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(arr[mid]==data) {
				return mid;
			}else if(arr[mid]>data) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		
		return -1;
	}

}
