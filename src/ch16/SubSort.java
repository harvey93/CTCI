package ch16;
import java.util.*;

public class SubSort {
	
	public static String subSort(int [] arr) {
		int[] sortedArr = Arrays.copyOf(arr, arr.length);
		Integer first = null;
		Integer second = null;
		Arrays.sort(sortedArr);
		System.out.println(Arrays.toString(sortedArr));
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			int val1 = arr[i];
			int val2 = sortedArr[i];
			if(first == null && val1 != val2) {
				first = i;
			}
			
			if(val1 != val2) {
				second = i;
			}
		}
		return first + "-" + second;
	}

}
