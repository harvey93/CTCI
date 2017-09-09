package ch16;

public class ContiguousSequence {

	public static int calc(int [] arr) {
		int sum = 0;
		int currentSum = 0;
		int max = arr[0];
		for(int a : arr) {
			if(a > max) {
				max = a;
			}
			
			currentSum += a;
			if(currentSum < 0) {
				currentSum = 0;
			}
			
			if(currentSum > sum) {
				sum = currentSum;
			}
			
		}
		if(sum == 0) {
			sum = max;
		}
		return sum;
	}
}
