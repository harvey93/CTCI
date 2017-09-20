package ch17;


import java.util.*;

public class LettersAndNumbers {

	public static int[] getSub(int [] arr) {
		int[] ones = new int[arr.length];
		int[] zeroes = new int[arr.length];
		int[] difference = new int[arr.length];
		HashMap<Integer, Integer> table = new HashMap<>();
		
		int max = 0;
		int start = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(i != 0) {
				zeroes[i] = zeroes[i - 1];
				ones[i] = ones[i - 1];
			}
			if(arr[i] == 0) {
				zeroes[i]++;
			}else {
				ones[i]++;
			}
			
			difference[i] = zeroes[i] - ones[i];
			
		}
		
		for(int i = 0; i < difference.length; i++) {
			int diff = difference[i];
			if(table.containsKey(diff)) {
				if(i - table.get(diff) > max) {
					max = i - table.get(diff);
					start = table.get(diff);
				}
			}else {
				table.put(diff, i);
			}
		}
		int j = 0;
		int [] res = new int[max];
		int i = start + 1;
		while(j < max) {
			res[j] = arr[i];
			i++;
			j++;
		}
		return res;
	}
}
