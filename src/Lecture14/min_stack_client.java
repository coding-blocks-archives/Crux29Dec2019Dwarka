package Lecture14;

public class min_stack_client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       min_stack stack=new min_stack();
       stack.push(10);
       stack.push(20);
       stack.push(30);
       stack.push(5);
       
       stack.display();
       System.out.println(stack.min());
       stack.push(5);
       System.out.println(stack.min());
       System.out.println("*****************");
       System.out.println(stack.pop());
       stack.display();
       System.out.println(stack.min());
       
	}

}
