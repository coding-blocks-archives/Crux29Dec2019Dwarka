package Lecture13;

public class first_negative {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] arr = { 3, -1, -5, 6, 8, 7 };
		int k = 3;
		first_negative(arr, k);
	}

	public static void first_negative(int[] arr, int k) throws Exception {
		int i = 0;
		DynamicQueue q = new DynamicQueue();
		for (i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}
		
		for(;i<arr.length;i++) {
			if(!q.isEmpty()) {
				System.out.println(arr[q.front()]);
			}else {
				System.out.println("0");
			}
			
			while(!q.isEmpty()&&q.front()<=i-k) {
				q.dequeue();
			}
			if(arr[i]<0) {
				q.enqueue(i);
			}
		}
		
		if(!q.isEmpty()) {
			System.out.println(arr[q.front()]);
		}else {
			System.out.println("0");
		}

	}

}
