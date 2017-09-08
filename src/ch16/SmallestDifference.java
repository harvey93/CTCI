package ch16;

import java.util.Arrays;
import java.util.Collections;

public class SmallestDifference {

	public static int getDiffBF(int [] arr1, int [] arr2) {
		int diff = Integer.MAX_VALUE;
		for(int a : arr1) {
			for(int b : arr2) {
				int currentDiff = Math.abs(a - b);
				if(currentDiff < diff) {
					diff = currentDiff;
				}
				
				if(diff == 0) {
					break;
				}
			}
		}
		return diff;
	}
	
	public static int getDiffOptimal(int [] arr1, int [] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int diff = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while(i < arr1.length || j < arr2.length) {
			int val1 = arr1[i];
			int val2 = arr2[j];
			int currentDiff = Math.abs(val1 - val2);
			if(currentDiff < diff) {
				diff = currentDiff;
			}
			
			if(val1 > val2) {
				j++;
				if(j == arr2.length) break;
			}else if(val1 < val2) {
				i++;
				if(i == arr1.length) break;
			}else {
				break;
			}
		}
		return diff;
	}
}
