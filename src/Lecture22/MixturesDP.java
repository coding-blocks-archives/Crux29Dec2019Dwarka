package Lecture22;


public class MixturesDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 40, 60, 20 };
		System.out.println(mixtureNormal(arr, 0, arr.length - 1));

		int[][] strg = new int[arr.length][arr.length];
		System.out.println(mixtureNormalRStrg(arr, 0, arr.length - 1, strg));
		
		System.out.println(mixturesBU(arr));
	}

	public static int mixtureNormal(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = si; i <= ei - 1; i++) {
			int m1 = mixtureNormal(arr, si, i);
			int m2 = mixtureNormal(arr, i + 1, ei);
			int m1andm2 = color(arr, si, i) * color(arr, i + 1, ei);
			int tot_smoke = m1 + m2 + m1andm2;
			if (tot_smoke < ans) {
				ans = tot_smoke;
			}
		}

		return ans;
	}

	public static int mixtureNormalRStrg(int[] arr, int si, int ei, int[][] strg) {
		if (si == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = si; i <= ei - 1; i++) {
			int m1 = mixtureNormalRStrg(arr, si, i, strg);
			int m2 = mixtureNormalRStrg(arr, i + 1, ei, strg);
			int m1andm2 = color(arr, si, i) * color(arr, i + 1, ei);
			int tot_smoke = m1 + m2 + m1andm2;
			if (tot_smoke < ans) {
				ans = tot_smoke;
				strg[si][ei] = ans;
			}

		}

		return strg[si][ei];
	}

	public static int mixturesBU(int[] arr) {
		int n=arr.length;
		int[][] strg = new int[arr.length][arr.length];
		
		for(int slide=1;slide<=n-1;slide++) {
			for(int si=0;si<=n-slide-1;si++) {
				int ei=si+slide;
				int ans=Integer.MAX_VALUE;
				for(int k=si;k<=ei-1;k++) {
					int m1=strg[si][k];
					int m2=strg[k+1][ei];
					int m1andm2=color(arr, si, k)*color(arr, k+1, ei);
					int tot_smoke=m1+m2+m1andm2;
					if(tot_smoke<ans) {
						ans=tot_smoke;
					}
				}
				strg[si][ei]=ans;
			}
		}
		
		return strg[0][arr.length-1];
	}

	public static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum = sum + arr[i];
		}

		return sum % 100;
	}

}
