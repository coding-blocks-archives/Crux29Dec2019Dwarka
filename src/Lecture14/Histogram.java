package Lecture14;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {6,2,5,4,1,5};
       Stack <Integer> stack = new Stack<>();
       int iter = 0;
       int max_area=0;
       int popped_bar = 0;
       int area = 0;
       while(iter<arr.length) {
    	   if(stack.isEmpty() || arr[iter]>=arr[stack.peek()]) {
    		   stack.push(iter++);
    	   }else {
    		   popped_bar = stack.peek();
    		   stack.pop();
    		   area = stack.isEmpty() ? arr[popped_bar]*iter : arr[popped_bar]*(iter-stack.peek()-1);
    		   if(area>=max_area) {
    			   max_area = area;
    		   }
    	   }
       }
       while(!stack.isEmpty()) {
           popped_bar = stack.peek();
		   stack.pop();
		   area = stack.isEmpty() ? arr[popped_bar]*iter : arr[popped_bar]*(iter-stack.peek()-1);
		   if(area>=max_area) {
			   max_area = area;
		   }
       }
       System.out.println(max_area);
	}

}
