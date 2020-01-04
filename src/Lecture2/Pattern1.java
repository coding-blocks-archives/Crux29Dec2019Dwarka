package Lecture2;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n=5;
       //prep for 1st row
       int row=1;
       int nst=n;
       while(row<=n) {
    	   int cst=1;//current work
    	   while(cst<=nst) {
    		   System.out.print("*");
    		   cst++;
    	   }
    	   nst=n; //prep for next row
    	   System.out.println();
    	   row++;
       }
	}

}
