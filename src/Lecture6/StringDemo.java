package Lecture6;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str="Hello";
       printchars(str);
       printSS(str);
       
       System.out.println(asciidiff("acf"));
       
	}
	
	public static void printchars(String str) {
		for(int i=0;i<str.length();i++) {
			System.out.println(str.charAt(i));
		}
	}
	
	public static void printSS(String str) {
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}
	
	public static String asciidiff(String str) {
		StringBuilder sb=new StringBuilder();
		char prev=str.charAt(0);
		for(int i=1;i<str.length();i++) {
			char cc=str.charAt(i);
			int diff=cc-prev;
			sb.append(prev);
			sb.append(diff);
			prev=cc;
		}
		sb.append(prev);
		return sb.toString();
	}

}
