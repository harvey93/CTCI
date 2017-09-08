package ch16;

public class Operations {

	public static int multiply(int a, int b) {
		if(b == 0) {
			return 0;
		}
		if(b == 1) {
			return a;
		}
		
		return a + multiply(a, b - 1);
	}
}
