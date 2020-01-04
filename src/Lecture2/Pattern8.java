package Lecture2;

public class Pattern8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n=6;
       int row=1;
       int incvalues=1;
       int decvalues=0;
       int nsp=n-1;
       
       while(row<=n) {
    	   int csp=1;
    	   while(csp<=nsp) {
    		   System.out.print("\t");
    		   csp++;
    	   }
    	   
    	   int value=row;
    	   int cst=1;
    	   while(cst<=incvalues) {
    		   System.out.print(value+"\t");
    		   value++;
    		   cst++;
    	   }
    	   
    	   value=value-2;
    	   cst=1;
    	   while(cst<=decvalues) {
    		   System.out.print(value+"\t");
    		   value--;
    		   cst++;
    	   }
    	   System.out.println();
    	   incvalues++;
    	   nsp--;
    	   decvalues++;	   
    	   row++;
       }
	}

}
