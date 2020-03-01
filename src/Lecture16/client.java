package Lecture16;

import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 50 true 25 true 40 false false true 57 false false true 75 true 63 false false true 87 false false
		Scanner s = new Scanner(System.in);
		Trees tree = new Trees();
		tree.display();
		
		System.out.println(tree.size2());
		System.out.println(tree.max());
		System.out.println(tree.min());
		System.out.println(tree.height());

		System.out.println(tree.find(25));
	}

}
