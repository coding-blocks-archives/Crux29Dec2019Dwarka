package Lecture14;

public class GreaterThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {2,4,5,7,10};
        int k=12;
        
        System.out.println(greater(arr, k));
	}
	
	public static int greater(int[] arr,int k) {
			
		int left=0,right=arr.length-1;
		int count=0;
		while(left<=right) {
			if(arr[left]+arr[left]+arr[right]>=k) {
				count= count+(right-left)+1;
				right--;
			}else {
				left++;
			}
		}
		
		return count;
	}

}
