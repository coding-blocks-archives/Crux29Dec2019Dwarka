package Lecture7;

public class BitManipulation {
	public static void main(String[] args) {
		System.out.println(1 ^ 2);
		System.out.println((1 | 2));
		System.out.println(1 & 2);
		System.out.println(~1);

		int x = 16;
		int num = x >> 2;

		System.out.println(num);

		int num2 = x << 3;
		System.out.println(num2);

		System.out.println(powerOfTwo(16));
		System.out.println(extract_bit(6, 2));
		System.out.println(right_most_set_bit(6));
		System.out.println(set_bit(4, 2));
		missing_two();
	}

	public static boolean powerOfTwo(int n) {

		if (n != 0) {

			if ((n & (n - 1)) == 0) {
				return true;
			}
		}

		return false;

	}

	public static int extract_bit(int num, int bit) {
		int mask = 1;

		mask = mask << bit - 1;

		int ans = (mask & num) == 0 ? 0 : 1;
		return ans;

	}

	public static int right_most_set_bit(int n) {
		int count = 1;
		int mask = 1;
		while ((n & mask) == 0) {
			mask = mask << 1;
			count++;
		}

		return count;
	}

	public static int set_bit(int n, int bit) {
		int mask = 1;
		mask = mask << bit - 1;
		n = n | mask;
		return n;
	}

	public static void missing_two() {
		// TODO Auto-generated method stub
		int n = 9;
		int[] arr = { 1, 3, 5, 9, 6, 8, 7 };
		int z = 0;
		for (int i = 0; i < arr.length; i++) {
			z = z ^ arr[i];
		}

		for (int i = 1; i <= n; i++) {
			z = z ^ i;
		}
		System.out.println(z);
		int set_bit = z & ~(z - 1);
		// System.out.println(set_bit);

		int group1 = 0, group2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & set_bit) == set_bit) {
				group1 = group1 ^ arr[i];
			} else {
				group2 = group2 ^ arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & set_bit) == set_bit) {
				group1 = group1 ^ i;
			} else {
				group2 = group2 ^ i;
			}
		}

		System.out.println("The first number missing is " + group1);
		System.out.println("The second number missing is " + group2);

	}

}
