package Lecture22;

import java.util.ArrayList;
import java.util.Scanner;

public class WineProblem {

	public static ArrayList<Integer> priceList = new ArrayList<>();
	  public static int[][] cache = new int[1000][1000];

	  public static int wineProblemRecursiveBackTrack(int day, int be, int en) {

	    if (be > en) {
	      return 0;
	    }

	    return Math.max(wineProblemRecursiveBackTrack(day + 1, be + 1, en) + day * priceList.get(be),
	        wineProblemRecursiveBackTrack(day + 1, be, en - 1) + day * priceList.get(en));
	  }

	  // Reduced state space by removing redundant day variable and calculating it
	  // inside the function itself.
	  public static int wineProblemRecursive(int be, int en) {

	    if (be > en) {
	      return 0;
	    }

	    // en - be + 1 are the number of unsold bottles.
	    int day = priceList.size() - (en - be + 1) + 1;
	    return Math.max(wineProblemRecursive(be + 1, en) + day * priceList.get(be),
	        wineProblemRecursive(be, en - 1) + day * priceList.get(en));
	  }

	  public static int wineProblemRecursiveBackTrackMemoization(int day, int be, int en) {
	    if (be > en) {
	      return 0;
	    }

	    if (cache[be][en] != -1) {
	      return cache[be][en];
	    }
	    cache[be][en] = Math.max(wineProblemRecursiveBackTrackMemoization(day + 1, be + 1, en) + day * priceList.get(be),
	        wineProblemRecursiveBackTrackMemoization(day + 1, be, en - 1) + day * priceList.get(en));
	    return cache[be][en];
	  }

	  public static int wineProblemRecursiveMemoization(int be, int en) {

	    if (be > en) {
	      return 0;
	    }

	    if (cache[be][en] != -1) {
	      return cache[be][en];
	    }

	    int day = priceList.size() - (en - be + 1) + 1;
	    cache[be][en] = Math.max(wineProblemRecursiveMemoization(be + 1, en) + day * priceList.get(be),
	        wineProblemRecursiveMemoization(be, en - 1) + day * priceList.get(en));
	    return cache[be][en];
	  }

	  public static int wineProblemBottomUp(int n) {

	    for (int en = n; en >= 0; en--) {
	      for (int be = 0; be <= n; be++) {
	        int day = priceList.size() - (be - en + 1) + 1;
	        if (be == en) {
	          cache[en][be] = day * priceList.get(en);
	        } else if (en < be) {
	          cache[en][be] = Math.max(priceList.get(en) * day + cache[en + 1][be],
	              priceList.get(be) * day + cache[en][be - 1]);
	        }
	      }
	    }
	    return cache[0][n];
	  }

	  public static void main(String[] args) {

		
	    Scanner s = new Scanner(System.in);
	    int numberOfBottles = s.nextInt();
	    for (int i = 0; i < numberOfBottles; i++) {
	      int price = s.nextInt();
	      priceList.add(price);
	    }
	    // int answer = wineProblemRecursiveBackTrack(1, 0, numberOfBottles - 1);
	    // System.out.println(answer);

	    // answer = wineProblemRecursive(0, numberOfBottles - 1);
	    // System.out.println(answer);

	    for (int i = 0; i < cache.length; i++) {
	      for (int j = 0; j < cache.length; j++) {
	        cache[i][j] = -1;
	      }
	    }

	    // answer = wineProblemRecursiveBackTrackMemoization(1, 0, numberOfBottles - 1);
	    // System.out.println(answer);
	    int answer = wineProblemBottomUp(numberOfBottles - 1);
	    for(int i=0;i<numberOfBottles;i++) {
	    	for(int j=0;j<numberOfBottles;j++) {
	    		System.out.print(cache[i][j]);
	    	}
	    	System.out.println();
	    }
	    System.out.println(answer);
	  }

}
