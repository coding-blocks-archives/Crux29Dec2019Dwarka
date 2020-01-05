package Lecture3;

public class Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int ans=(int)(Math.pow(3, 4));
//		System.out.println(ans);
		System.out.println(decToBin(32));
		System.out.println(BinToDec(100000));
		System.out.println(AnyToDec(37, 8));
		System.out.println(DecToAny(31, 8));
		// int ans=(int)(Math.pow(3, 4));

	}

	public static int decToBin(int dec) {
		int tenpower = 1;
		int bin = 0;
		while (dec != 0) {
			int rem = dec % 2;
			bin = bin + rem * tenpower;
			dec = dec / 2;
			tenpower = tenpower * 10;
		}

		return bin;
	}

	public static int BinToDec(int bin) {
		int twopower = 1;
		int dec = 0;
		while (bin != 0) {
			int rem = bin % 10;
			dec = dec + rem * twopower;
			twopower = twopower * 2;
			bin = bin / 10;
		}
		return dec;
	}

	public static int AnyToDec(int num, int sb) {
		int sbpower = 1;
		int dec = 0;
		while (num != 0) {
			int rem = num % 10;
			dec = dec + rem * sbpower;
			sbpower = sbpower * sb;
			num = num / 10;
		}
		return dec;
	}

	public static int DecToAny(int dec, int db) {
		int tenpower = 1;
		int ans = 0;
		while (dec != 0) {
			int rem = dec % db;
			ans = ans + rem * tenpower;
			dec = dec / db;
			tenpower = tenpower * 10;
		}

		return ans;
	}
	
	

}
