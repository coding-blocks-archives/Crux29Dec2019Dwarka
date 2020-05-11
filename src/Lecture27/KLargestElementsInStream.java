package Lecture27;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElementsInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PriorityQueue<Integer> minheap=new PriorityQueue<>();
       Scanner s=new Scanner(System.in);
       int k=s.nextInt();
       
       int count=0;
       while(true) {
    	   int n=s.nextInt();
    	   if(n==-1) {
    		   PrintKLargest(minheap);
    		   break;
    	   }else if(count<k) {
    		   minheap.add(n);
    		   count++;
    	   }else {
    		   if(minheap.peek()<n) {
    			   minheap.poll();
    			   minheap.add(n);
    		   }
    	   }
       }
	}
	
	public static void PrintKLargest(PriorityQueue<Integer> minheap) {
		while(!minheap.isEmpty()) {
			System.out.println(minheap.poll());
		}
	}

}
