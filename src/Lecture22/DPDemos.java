package Lecture22;

public class DPDemos {
	public static long start;
	public static long end;

	public static void start() {
		start = System.currentTimeMillis();
	}

	public static long end() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int[][] strg = new int[n + 1][n+1];
//		start();
//		System.out.println(fib(n));
//		System.out.println("Fib Normal " + end());
//		start();
//		System.out.println(fibRS(n, strg));
//		System.out.println("FibRS " + end());
//
//		start();
//		System.out.println(fibIS(n));
//		System.out.println("FibIS " + end());
//		
//		System.out.println(cbp(n, 0));
//		System.out.println(cbpRS(n, 0, strg));
//		System.out.println(cbpIS(n, 0));

		System.out.println(cmpIS(n, n, 0, 0));
		
		String s1="abbg",s2="abgg";
		System.out.println(editDistance(s1, s2));
		System.out.println(editDistanceIS(s1, s2));
		
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		return fibn;
	}

	public static int fibRS(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fibnm1 = fibRS(n - 1, strg);
		int fibnm2 = fibRS(n - 2, strg);
		int fibn = fibnm1 + fibnm2;
		strg[n] = fibn;
		return fibn;
	}

	public static int fibIS(int n) {
		int[] strg = new int[n + 1];
		// seed
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbp(end, curr + dice);
		}
		return count;
	}

	public static int cbpRS(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count = count + cbpRS(end, curr + dice, strg);
		}
		strg[curr] = count;
		return count;
	}

	public static int cbpIS(int end, int curr) {

		int[] strg = new int[end + 1];
		// seed
		strg[end] = 1;
		for (int i = end - 1; i >= 0; i--) {
			int count = 0;
			for (int dice = 1; dice <= 6 && dice + i < strg.length; dice++) {
				count = count + strg[dice + i];
			}
			strg[i] = count;
		}
		return strg[curr];
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		int count = 0;
		count = count + cmp(er, ec, cr, cc + 1);
		count = count + cmp(er, ec, cr + 1, cc);
		return count;

	}

	public static int cmpRS(int er, int ec, int cr, int cc, int[][] strg) {
		if (er == cr && ec == cc) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int count = 0;
		count = count + cmpRS(er, ec, cr, cc + 1, strg);
		count = count + cmpRS(er, ec, cr + 1, cc, strg);
		strg[cr][cc] = count;
		return count;
	}

	public static int cmpIS(int er, int ec, int cr, int cc) {
		int[][] strg = new int[er + 1][ec + 1];

		// seed
		strg[er][ec] = 1;
		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er || j == ec) {
					strg[i][j] = 1;
				} else {
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
				}
			}
		}

		return strg[cr][cc];
	}
	
	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}
		if (s2.length() == 0) {
			return s1.length();
		}
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = editDistance(ros1, ros2);
		} else {
			int f1 = 1 + editDistance(ros1, ros2);
			int f2 = 1 + editDistance(s1, ros2);
			int f3 = 1 + editDistance(ros1, s2);
			rv = Math.min(f1, Math.min(f2, f3));
		}

		return rv;
	}

	public static int editDistanceIS(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 2];
		strg[s1.length()][s2.length()] = 0;
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					strg[i][j] = s2.length() - j;
					continue;
				}
				if (j == s2.length()) {
					strg[i][j] = s1.length() - i;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					int f1 = 1 + strg[i + 1][j + 1];
					int f2 = 1 + strg[i + 1][j];
					int f3 = 1 + strg[i][j + 1];
					strg[i][j] = Math.min(f1, Math.min(f2, f3));
				}
			}
		}
		return strg[0][0];

	}

}
