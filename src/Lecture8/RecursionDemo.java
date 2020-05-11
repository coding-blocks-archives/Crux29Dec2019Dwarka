package Lecture8;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PD(5);
		// PI(5);

		System.out.println(fact(5));
		System.out.println(power(2, 5));

		System.out.println(fib(6));

		System.out.println(pbetter(2, 10));
		System.out.println(friendPairing(6));
		System.out.println(moveAllxAtEnd("abxhfxfgxxxghsxxd"));

	}

	public static void PD(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PD(n - 1);
	}

	public static void PI(int n) {
		if (n == 0) {
			return;
		}

		PI(n - 1);
		System.out.println(n);
	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		int fnm1 = fact(n - 1);
		int fn = n * fnm1;
		return fn;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int xnm1 = power(x, n - 1);
		int xn = x * xnm1;
		return xn;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);
		int fibn = fnm1 + fnm2;
		return fibn;
	}

	public static void PDISkip(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 1) {
			System.out.println(n);
		}
		PDISkip(n - 1);
		if (n % 2 == 0) {
			System.out.println(n);
		}

	}

	public static boolean isSorted(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}
		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean restans = isSorted(arr, si + 1);
			return restans;
		}
	}

	public static int firstIndex(int[] arr, int si, int data) {
		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == data) {
			return si;
		} else {
			int restans = firstIndex(arr, si + 1, data);
			return restans;
		}
	}

	public static int pbetter(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 1;
		int pnb2 = pbetter(x, n / 2);
		if (n % 2 == 0) {
			ans = pnb2 * pnb2;
		} else {
			ans = x * pnb2 * pnb2;
		}

		return ans;
	}

	public static int friendPairing(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int s = friendPairing(n - 1);
		int d = (n - 1) * friendPairing(n - 2);
		return s + d;
	}

	public static String moveAllxAtEnd(String str) {
		if (str.length() == 0) {
			return "";
		}
		char cc = str.charAt(0);
		String ans = "";
		if (cc == 'x') {
			String restans = moveAllxAtEnd(str.substring(1));
			ans = restans + 'x';
		} else {
			String restans = moveAllxAtEnd(str.substring(1));
			ans = cc + restans;
		}

		return ans;
	}

	

}
