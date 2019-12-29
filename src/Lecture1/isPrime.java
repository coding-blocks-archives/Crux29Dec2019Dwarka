package Lecture1;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n=16;
       int divisor=2;
       while(divisor<n) {
    	   if(n%divisor==0) {
    		   System.out.println("not prime");
    		   return;
    	   }
    	   divisor=divisor+1;
       }
       
       System.out.println("Prime");
       
       
	}

}
