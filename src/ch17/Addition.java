package ch17;

public class Addition {
	
	public static int sum(int a, int b) {
		if (b == 0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return sum(sum, carry);
	}

}


//0101
//1100
//
//1001
//
//10001