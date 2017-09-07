package ch1;
import java.util.*;

public class IsUnique {
	
	public static boolean uniqueHash(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		boolean res = true;
		for(int i = 0; i < str.length(); i++){
			if(map.containsKey(str.charAt(i))){
				int count = map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		for(Character key : map.keySet()){
			if(map.get(key) > 1){
				res = false;
				break;
			}
		}

		return res;
	}
	
	public static boolean uniqueSet(String str){
		HashSet<Character> set= new HashSet<>();
		boolean res = true;
		for(int i = 0; i < str.length(); i++){
			if(set.contains(str.charAt(i))){
				res = false;
				break;
			}else {
				set.add(str.charAt(i));
			}
		}
		
		return res;
	}
}
