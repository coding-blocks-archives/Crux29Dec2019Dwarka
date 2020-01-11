package Lecture4;

public class maxsubarraysum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 3, -5, -1, 10, 4, 2 };
		int[] arr2= {-3,-2,-1,-4,-5};
		
		System.out.println(approach1(arr));
		System.out.println(approach1(arr2));
		
		System.out.println(approach2(arr));
		System.out.println(approach2(arr2));
		
		System.out.println(approach3(arr));
		System.out.println(approach3(arr2));
		

	}
	
	public static int approach1(int[] arr) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int sum=0;
				for(int k=i;k<=j;k++) {
					sum=sum+arr[k];
				}
				if(sum>max) {
					max=sum;
				}
				
			}
		}
		
		return max;
	}
	
	
	public static int approach2(int[] arr) {
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				sum=sum+arr[j];
				if(sum>max) {
					max=sum;
				}
			}
			sum=0;
		}
		
		return max;
		
	}
	
	public static int approach3(int[] arr) {
		int max=Integer.MIN_VALUE;
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum>max) {
				max=sum;
			}
			
			if(sum<0) {
				sum=0;
			}
		}
		
		return max;
	}
	
	

}
