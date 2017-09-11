package ch8;

public class Staircase {
	
	public static int tripleStep(int n) {
		if(n == 1) {
			return 1;
		}
		
		if(n == 2) {
			return 2;
		}
		
		if(n == 3) {
			return 4;
		}
		
		return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
	}
	
	public static int tripleStepDP(int n) {
		if(n == 1) {
			return 1;
		}
		
		if(n == 2) {
			return 2;
		}
		
		if(n == 3) {
			return 4;
		}
		
		int a = 1;
		int b = 2;
		int c = 4;
		int total = 7;
		
		while(n > 3) {
			total = a + b + c;
			a = b;
			b = c;
			c = total;
			n--;
		}
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static int tripleStep(int n){
//		if(n == 1){
//			return 1;
//		}
//		if(n == 2){
//			return 2;
//		}
//		if(n == 3){
//			return 4;
//		}
//		
//		return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
//	}
//	
//	public static int tripleStepDP(int n){
//		if(n == 1){
//			return 1;
//		}
//		if(n == 2){
//			return 2;
//		}
//		if(n == 3){
//			return 4;
//		}
//		int a = 1;
//		int b = 2;
//		int c = 4;
//		int current = 4;
//		while(current <= n){
//			int temp = a + b + c;
//			a = b;
//			b = c;
//			c = temp;
//			current++;
//		}
//		return c;
//	}

}

