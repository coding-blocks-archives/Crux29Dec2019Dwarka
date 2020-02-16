package Lecture13;

import Lecture12.QueueUsingArrays;

public class DynamicQueueClient {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		QueueUsingArrays q = new DynamicQueue(5);
		for (int i = 1; i <= 5; i++) {
			q.enqueue(i * 10);
		}
		q.display();
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
		System.out.println(q.size());
		q.enqueue(60);
		q.enqueue(70);
		q.display();
		while (!q.isEmpty()) {
			System.out.println(q.front());
			q.dequeue();
		}
		System.out.println(q.size());

	}

}
