package ch17;

import java.util.Arrays;

public class RandomSet {

	public static int [] getSet(int [] arr, int size) {
		int [] copy = new int [arr.length];
		for(int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		
		int [] res = new int [size];
		
		int current = 0;
		
		for(int i = copy.length - 1; i < copy.length; i--) {
			int j = Shuffler.rand(i);
			int temp = copy[i];
			copy[i] = copy[j];
			copy[j] = temp;
			System.out.println(Arrays.toString(copy));
			res[current] = copy[i];
			current++;
			if(current >= res.length) {
				break;
			}
		}
		
		return res;
	}
}
