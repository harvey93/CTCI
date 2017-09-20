package ch17;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6, 7, 8, 9};
		int [] res = RandomSet.getSet(arr, 4);
		System.out.println(Arrays.toString(res));
	}

}
