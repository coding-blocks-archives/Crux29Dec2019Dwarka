package Lecture26;

public class Max_Blocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int blocks = 20;
		System.out.println(getmaxheight(blocks));

	}

	public static long getmaxheight(long blocks) {
		long l = 0;
		long r = blocks;

		long ans = -1;
		while (l <= r) {
			long height = l + (r - l) / 2;
			long blocksneeded = (height * (height + 1)) / 2;
			if (blocksneeded > blocks) {
				r = height - 1;
			} else {
				ans = height;
				l = height + 1;
			}
		}

		return ans;
	}

}
