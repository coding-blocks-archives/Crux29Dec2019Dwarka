package Lecture12;

import java.util.Queue;

public class QueueClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		QueueUsingArrays q=new QueueUsingArrays();
		for(int i=1;i<=5;i++) {
			q.enqueue(i*10);
		}
		q.display();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue(60);
		q.enqueue(70);
		q.display();
		while(!q.isEmpty()) {
			System.out.println(q.front());
			q.dequeue();
		}
		System.out.println(q.size());

	}

}
