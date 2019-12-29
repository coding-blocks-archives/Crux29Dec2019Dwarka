package Lecture1;

public class NthFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;

		int fn = 0;
		int sn = 1;
		int counter = 1;

		while (counter <= n) {
			int next = fn + sn;
			fn = sn;
			sn = next;
			counter=counter+1;
		}

		System.out.println(fn);
	}

}
