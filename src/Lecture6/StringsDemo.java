package Lecture6;

import java.util.Scanner;

public class StringsDemo {
	public static void main(String[] args) {
		// Part 1
		String str;
		// System.out.println(str); //because it is null

		// Part 2
		str = "Hello";
		System.out.println(str.length());
		// System.out.println("********************************");
		//
		// // Part 3
		System.out.println(str.charAt(0));
		// System.out.println(str.charAt(str.length()));
		System.out.println(str.charAt(str.length() - 1));
		// System.out.println("********************************");
		//
		// // Part 4
		System.out.println(str.substring(2, 4));
		System.out.println(str.substring(2, 3));
		System.out.println(str.substring(2, 2));
		// System.out.println(str.substring(2, 1));
		System.out.println(str.substring(2, 5));
		// System.out.println(str.substring(2, 6));
		System.out.println(str.substring(2));
		System.out.println("********************************");
		// //
		// //
		// // // Part 5
		System.out.println(str.indexOf("el"));
		System.out.println(str.indexOf("eL"));
		System.out.println("********************************");
		// //
		// // // Part 6
		System.out.println(str.startsWith("He"));
		System.out.println(str.startsWith("he"));
		System.out.println("********************************");
		// //
		// // // Part 7
		Scanner s = new Scanner(System.in);
	//	String mystring = s.next();
		String s1 = "Hello";
		String s2 = s1;
		String s3 = "Hello";
		String s4 = new String("Hello");
		String s5 = "Hello";
//////		// //
//////		// s5="Hi";
		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));
//////		//
		System.out.println((s1 == s5));
		System.out.println((s5 == s4));
////
	//	 System.out.println(mystring == s1);
	//	 System.out.println(mystring == s4);
//
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.toString());
		
		System.out.println(sb.length());
	//	sb.setCharAt(3, 'a');
		sb.append("Hello");
		System.out.println(sb);
		System.out.println(sb.toString());
		sb.append('y');
		System.out.println(sb.toString());
//////		//
		sb.setCharAt(2, 'i');
		System.out.println(sb.charAt(0));
		System.out.println(sb.toString());
		sb.setCharAt(4, 't');
		System.out.println(sb.toString());
		sb.insert(3, 'k');
		System.out.println(sb.toString());
		
		sb.deleteCharAt(3);
		System.out.println(sb);
		
		

	}

}
