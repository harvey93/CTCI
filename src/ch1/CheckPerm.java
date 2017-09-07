package ch1;

import java.util.*;
import java.util.Collections;


public class CheckPerm {
	
	
	public static boolean checkHash(String str1, String str2){
		boolean res = false;
		HashMap<Character, Integer> map1 = fillMap(str1);
		HashMap<Character, Integer> map2 = fillMap(str2);
		
		if(map1.equals(map2)){
			res = true;
		}
		
		return res;
	}
	
	public static HashMap<Character, Integer> fillMap(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if(map.containsKey(current)){
				int currentCount = map.get(current);
				map.put(current, ++currentCount);
			}else {
				map.put(current, 1);
			}
		}
		return map;
	}
	
	public static boolean checkSort(String str1, String str2){
		boolean res = false;
		
//		List<String> list1 = Arrays.asList(str1.split(""));
//		List<String> list2 = Arrays.asList(str2.split(""));
//		Collections.sort(list1);
//		Collections.sort(list2);
		
//		if(list1.equals(list2)){
//			res = true;
//		}
		String[] arr1 = str1.split(""); 
		Arrays.sort(arr1);
		
		String[] arr2 = str2.split("");
		Arrays.sort(arr2);
		
//		if(String.join("", arr1).equals(String.join("", arr2))){
//			res = true;
//		}
		
		if(Arrays.asList(arr1).equals(Arrays.asList(arr2))){
			res = true;
		}
		
		return res;
	}
}
