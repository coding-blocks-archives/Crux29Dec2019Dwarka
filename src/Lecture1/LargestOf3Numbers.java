package Lecture1;

public class LargestOf3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a=10;
       int b=10;
       int c=5;
       
       if(a>=b&&a>=c) {
    	   System.out.println("a is largest");
       }else {
    	   if(b>=a&&b>=c) {
    		   System.out.println("b is largest");
    	   }else {
    		   System.out.println("c is largest");
    	   }
       }
	}

}
