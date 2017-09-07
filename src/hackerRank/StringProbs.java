package hackerRank;

import java.awt.Checkbox;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class StringProbs {
	
	
	public static String longestSubstring(String s1, String s2){
//		HashSet<String> result = new HashSet<>();
		String result = "";
		int[][] table = new int[s1.length()][s2.length()];
		int longest = 0;
		int row = 0;
		
		for(int i = 0; i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++){
				if(s1.charAt(i) != s2.charAt(j)){
					continue;
				}
				
				if(i == 0 || j == 0){
					table[i][j] = 1;
				}else {
					table[i][j] = 1 + table[i - 1][j - 1];
				}
				
				if(longest < table[i][j]){
					longest = table[i][j];
					row = i;
//					longestSub = s1.substring(i - longest + 1, i + 1);
//					result.add(s1.substring(i - longest + 1, i + 1));

				}
								
				
			}
		}
		
		result = s1.substring(row - longest + 1, row + 1);
		return result;
	}

	public int numbersNeeded(String first, String second){
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		fillMap(first, map1);
		fillMap(second, map2);
		int count = checkMap(map1, map2);
		count += checkMap(map2, map1);
		return count;
	}
	
	public int checkMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
		int count = 0;
		for(Character key : map1.keySet()){
			Integer map1Count = map1.get(key);
			if(map2.containsKey(key)){
				Integer map2Count = map2.get(key);
				count += Math.abs(map1Count - map2Count);
				map1.put(key, 0);
				map2.put(key, 0);

			}else {
				count += map1Count;
			}
			
		}
		return count;
	}
	
	public void fillMap(String str, HashMap<Character, Integer> map){
		for(int i = 0; i < str.length(); i++){
			Character currentChar = str.charAt(i);
			if(map.containsKey(currentChar)){
				Integer currentCount = map.get(currentChar);
				map.put(currentChar, ++currentCount);
			}else{
				map.put(currentChar, 1);
			}
		}
	}
}
