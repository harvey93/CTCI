package ch17;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6};
		Shuffler.shuffle(arr);
		System.out.println(Arrays.toString(arr));
	}

}
