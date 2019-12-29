package Lecture1;

import java.util.Scanner;

public class PrintReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       
       while(n!=0) {
    	   int rem=n%10;
    	   System.out.print(rem);
    	   n=n/10;
       }
	}

}
