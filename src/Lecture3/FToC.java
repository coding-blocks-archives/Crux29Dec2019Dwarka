package Lecture3;

public class FToC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fmin = 0;
		int fmax = 300;
		int step = 20;

		while (fmin <= fmax) {
			int celsius = (int) ((5.0 / 9) * (fmin - 32));
			System.out.println(fmin + "\t" + celsius);
			fmin = fmin + step;
		}

	}

}
