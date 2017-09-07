package ch16;
import java.util.*;

public class wordFreq {
	
	public static int freqOne(String[] book, String word) {
		int count = 0;
		for(String s : book) {
			if(s.equals(word)) {
				count++;
			}
		}
		return count;
	}
	
	public static HashMap<String, Integer> allWords(String[] book){
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : book) {
			if(!map.containsKey(s)) {
				map.put(s, 0);
			}
			map.put(s, map.get(s) + 1);
		}
		return map;
	}

}
