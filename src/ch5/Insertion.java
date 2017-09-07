package ch5;

public class Insertion {
	
	public static int insert(int n, int m, int i, int j){
		int cleared = clearBits(n, i, j); 
		int mShifted = m << i;
//		System.out.println(Integer.toBinaryString(cleared));
//		System.out.println(Integer.toBinaryString(mShifted));
		return cleared | mShifted;
	}
	
	public static int clearBits(int n, int i , int j){
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = (1 << i) - 1;
//		System.out.println(Integer.toBinaryString(left));
//		System.out.println(Integer.toBinaryString(left | right));
		int mask = left | right;
		return n & mask;
	}

}
