package Lecture14;

import Lecture13.DynamicQueue;
import Lecture13.DynamicStack;

public class Questions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         DynamicStack stack=new DynamicStack();
         
         for(int i=1;i<=5;i++) {
        	 stack.push(i*10);
         }
         
         DynamicStack helper=new DynamicStack();
         
         
         stack.display();
         reverseStack(stack,helper,0);
         stack.display();
         
         DynamicQueue queue=new DynamicQueue();
         for(int i=1;i<=5;i++) {
        	 queue.enqueue(i*10);
         }
         
         queue.display();
         reverseQueue(queue);
         queue.display();
         
         
	}
	
	public static void reverseStack(DynamicStack stack,DynamicStack helper,int index) throws Exception {
		if(stack.isEmpty()) {
			return;
		}
		int item=stack.pop();
		reverseStack(stack, helper, index+1);
		helper.push(item);
		if(index==0) {
			while(!helper.isEmpty()) {
				stack.push(helper.pop());
			}
		}
	}
	
	public static void reverseQueue(DynamicQueue queue) throws Exception {
		if(queue.isEmpty()) {
			return;
		}
		int rv=queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(rv);
	}
	
	

}
