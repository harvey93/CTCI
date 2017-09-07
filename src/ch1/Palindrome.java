package ch1;
import java.util.*;

public class Palindrome {
	
	public static boolean isPerm(String str){
		boolean res = true;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if(current == ' '){continue;}
			if(map.containsKey(current)){
				int count = map.get(current);
				map.put(current, ++count);
			}else {
				map.put(current, 1);
			}
		}
		
		int oddCount = 0;
		for(char key : map.keySet()){
			if(map.get(key) % 2 == 1){
				oddCount++;
			}
			if(oddCount > 1){
				res = false;
				break;
			}
		}
		
		return res;
	}

}
