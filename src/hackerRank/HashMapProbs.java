package hackerRank;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapProbs {

	public void ransomNoteSet(String[] ransom, String[] magazine){
		boolean res = true;
		HashSet<String> set = new HashSet<>();
		for(String key : magazine){
			set.add(key);
		}
		for(String key : ransom){
			if(!set.contains(key)){
				res = false;
				break;
			}
		}
		if(res == true){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	public void ransomNoteMap(String[] ransom, String[] magazine){
		boolean res = true;
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		fillMap(ransom, map1);
		fillMap(magazine, map2);
		
		for(String key : map1.keySet()){
			if(!map2.containsKey(key)){
				res = false;
				break;
			}
			if(map1.get(key) > map2.get(key)){
				res = false;
				break;
			}
		}
				
		if(res == true){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	public void fillMap(String [] arr, HashMap<String, Integer> map){

		for(String key : arr){
			if(map.containsKey(key)){
				Integer currentCount = map.get(key);
				map.put(key, ++currentCount);
			}else{
				map.put(key, 1);
			}
		}
	}
	
}
