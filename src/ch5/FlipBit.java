package ch5;
import java.util.*;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class FlipBit {
	
	public static int flip(int n){
		String bString = BinaryToString.bToString(n);
		ArrayList<int[]> list = new ArrayList<>();
		int [] arr = new int[2];
		char c = bString.charAt(0);
		String s = new Character(c).toString();
		arr[0] = Integer.parseInt(s);
		arr[1] = 1;
		list.add(arr);
		for(int i = 1; i < bString.length(); i++){
			c = bString.charAt(i);
			s = new Character(c).toString();
			int val = Integer.parseInt(s);
			if(arr[0] == val){
				arr[1]++;
			}else {
				arr = new int[2];
				arr[0] = val;
				arr[1] = 1;
				list.add(arr);
			}
		}
		
		int max = 0;
		for(int i = 0; i < list.size(); i++){
			
			int val = list.get(i)[0];
			int count = list.get(i)[1];
			if(val == 1 || count > 1){
				continue;
			}
			int prevCount = 0;
			int nextCount = 0;
			if(i - 1 >= 0){
				int prevVal = list.get(i - 1)[0];
				if(prevVal == 1){
					prevCount = list.get(i - 1)[1];
				}
				
			}
			
			if(i + 1 < list.size()){
				int nextVal = list.get(i + 1)[0];
				if(nextVal == 1){
					nextCount = list.get(i + 1)[1];
				}
			}
			
			int sum = prevCount + nextCount + 1;
			if(sum > max){
				max = sum;
			}
		}
		
		return max;
	}

}
