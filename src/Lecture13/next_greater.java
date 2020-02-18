package Lecture13;

import java.util.ArrayList;
import java.util.Stack;

public class next_greater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {3,1,15,6,4,7};
       next_greater(arr);
	}
	
	public static void next_greater(int[] arr) {
		Stack<Integer> stack=new Stack<>();
		stack.push(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			while(!stack.isEmpty()&&stack.peek()<arr[i]) {
				int rv=stack.pop();
				System.out.println(rv+"=>"+arr[i]);
			}
			
			stack.push(arr[i]);
			
		}
		
		while(!stack.isEmpty()) {
			int rv=stack.pop();
			System.out.println(rv+"=>-1");
		}
	}

}
