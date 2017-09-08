package ch16;

public class FactorialZeroes {
	
	public static int calc(int n) {
		int count = 0;
		for(int i = 2; i <= n; i++) {
			count += factorsOf5(i);
		}
		
		return count;
		
	}
	
	public static int factorsOf5(int n) {
		int count = 0;
		while(n % 5 == 0) {
			count++;
			n /= 5;
		}
		return count;
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}

}
