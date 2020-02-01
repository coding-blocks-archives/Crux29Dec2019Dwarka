package Lecture9;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abc";
//		char[] arr = str.toCharArray();
//
//		char[] ch = new char[5];
//		printSS("abc", "");
//		printPermutations("abc", "");
//		pbp(10, 0, "");
//		pmp(2, 2, 0, 0, "");
//
//		ppws(arr, 0, 2);
//		
		codesOfString("1234","");
	}

	public static void printSS(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		char c = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, res);
		printSS(ros, res + c);
	}

	public static void printPermutations(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, res + cc);
		}
	}

	public static void pbp(int end, int curr, String res) {
		if (curr == end) {
			System.out.println(res);
			return;
		}

		if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			pbp(end, curr + dice, res + dice);
		}
	}

	public static void pmp(int er, int ec, int cr, int cc, String res) {
		if (cr == er && cc == ec) {
			System.out.println(res);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		pmp(er, ec, cr, cc + 1, res + "H");
		pmp(er, ec, cr + 1, cc, res + "V");
	}

	public static void ppws(char[] arr, int front, int back) {

		if (front == back) {
			display(arr);
		}

		for (int i = front; i <= back; i++) {
			swap(arr, front, i);
			ppws(arr, front + 1, back);
			swap(arr, front, i);

		}

	}

	private static void swap(char[] arr, int front, int i) {
		char ch = arr[front];
		arr[front] = arr[i];
		arr[i] = ch;

	}

	private static void display(char[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	public static void codesOfString(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		String fc = str.substring(0, 1);
		String ros1 = str.substring(1);
		char code1 = getcode(fc);
		codesOfString(ros1, res + code1);

		if (str.length() >= 2) {
			String dc = str.substring(0, 2);
			String ros2 = str.substring(2);
			if (Integer.valueOf(dc) <= 26) {
				char code2 = getcode(dc);
				codesOfString(ros2, res + code2);
			}
		}

	}

	public static char getcode(String str) {
		int value = Integer.valueOf(str);
		int ascii = 96 + value;
		return (char) (ascii);

	}

}
