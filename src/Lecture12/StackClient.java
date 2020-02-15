package Lecture12;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      StackUsingArrays stack=new StackUsingArrays(5);
      for(int i=1;i<=5;i++) {
    	  stack.push(i*10);
      }
     
      stack.display();
     // stack.push(60);
      System.out.println(stack.size());
      while(!stack.isEmpty()) {
    	  System.out.println(stack.pop());
      }
      System.out.println(stack.size());
      
    //  stack.pop();
      
      
	}
	


}
