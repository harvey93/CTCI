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
	
	public static int multOpt(int a, int b) {
		if(b == 0) {
			return 0;
		}
		
		if(b == 1) {
			return a;
		}
		
		if(b % 2 == 0) {
			return multOpt(a, b / 2) + multOpt(a, b /2);
		}else {
			return multOpt(a, (b - 1) / 2) + multOpt(a, (b - 1)/2) + a;
		}
	}
}
