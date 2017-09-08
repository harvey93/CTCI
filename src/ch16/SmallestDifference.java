package ch16;

public class SmallestDifference {

	public static int getDiffBF(int [] arr1, int [] arr2) {
		int diff = Integer.MAX_VALUE;
		for(int a : arr1) {
			for(int b : arr2) {
				int currentDiff = Math.abs(a - b);
				if(currentDiff < diff) {
					diff = currentDiff;
				}
			}
		}
		return diff;
	}
}
