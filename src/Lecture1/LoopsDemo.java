package Lecture1;

public class LoopsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=5;i++) {
        	System.out.println(i);
        }
        
        int i=1;
        while(i<=5) {
        	System.out.println(i);
        	i++;
        }
        
        i=10;
        do {
        	System.out.println(i);
        	i++;
        }while(i<=5);
	}

}
