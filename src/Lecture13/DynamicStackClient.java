package Lecture13;

import Lecture12.StackUsingArrays;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      StackUsingArrays stack=new DynamicStack(5);
      for(int i=1;i<=5;i++) {
    	  stack.push(i*10);
      }
     
      stack.display();
      stack.push(60);
      for(int i=11;i<=15;i++) {
    	  stack.push(i*10);
      }
      stack.display();
//      System.out.println(stack.size());
//      while(!stack.isEmpty()) {
//    	  System.out.println(stack.pop());
//      }
//      System.out.println(stack.size());
//      
//    //  stack.pop();
      
      
	}
	

}
