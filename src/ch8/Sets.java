package ch8;
import java.util.*;

public class Sets {

	public static ArrayList<String> printPerms(String s){
		HashMap<Character, Integer> table = buildFreqTable(s);
		ArrayList<String> result = new ArrayList<>();
		printPerms(result, "", table, s.length());
		return result;
	}
	
	public static void printPerms(ArrayList<String> result, String prefix, HashMap<Character, Integer> table, int rem) {
		if(rem == 0) {
			result.add(prefix);
			return;
		}
		
		for(Character c : table.keySet()) {
			int count = table.get(c);
			if(count > 0) {
				table.put(c, count - 1);
				printPerms(result, prefix + c, table, rem - 1);
				table.put(c, count);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<String> printPerms(String s){
//		ArrayList<String> result = new ArrayList<>();
//		HashMap<Character, Integer> map = buildFreqTable(s);
//		
//		printPerms(map, "", result, s.length());
//		return result;
//	}
//	
//	public static void printPerms(HashMap<Character, Integer> map, String prefix, ArrayList<String> result, int remainder){
//		if(remainder == 0){
//			result.add(prefix);
//			return;
//		}
//		
//		for(Character c : map.keySet()){
//			int count = map.get(c);
//			if(count > 0){
//				map.put(c, count - 1);
//				printPerms(map, prefix + c, result, remainder - 1);
//				map.put(c, count);
//			}
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<String> printPerms(String s){
//		ArrayList<String> list = new ArrayList<>();
//		HashMap<Character, Integer> map = buildFreqTable(s);
//		System.out.println(map);
//		printPerms(map, "", s.length(), list);
//		return list;
//	}
//	
//	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remainder, ArrayList<String> result){
//		if(remainder == 0){
//			result.add(prefix);
//			return;
//		}
//		
//		for(Character c : map.keySet()){
//			int count = map.get(c);
//			if(count > 0){
//				map.put(c, count - 1);
//				printPerms(map, prefix + c, remainder - 1, result);
//				map.put(c, count);
//			}
//		}
//		
//	}
	
	
	public static HashMap<Character, Integer> buildFreqTable(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<String> printPerms(String s){
//		ArrayList<String> list = new ArrayList<>();
//		HashMap<Character, Integer> map = buildFreqTable(s);
//		printPerms(map, "", s.length(), list);
//		
//		return list;
//	}
//	
//	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remainder, ArrayList<String> result){
//		if(remainder == 0){
//			result.add(prefix);
//			return;
//		}
//		
//		for(Character c : map.keySet()){
//			int count = map.get(c);
//			if(count > 0){
//				map.put(c, count - 1);
//				printPerms(map, prefix + c, remainder - 1, result);
//				map.put(c, count);
//			}
//		}
//	}
	
			

	
	public static HashSet<String> permString(String s) {
		HashSet<String> set = new HashSet<String>();

		if(s.length() == 1) {
			set.add(s);
			return set;
		}
		
		char last = s.charAt(s.length() - 1);
		HashSet<String> prev = permString(s.substring(0, s.length() - 1));
		
		
		
		for(String sub : prev) {
			StringBuilder newSub = new StringBuilder(sub);

			for(int j = 0; j <= newSub.length(); j++) {
				newSub.insert(j, last);
				set.add(newSub.toString());
				newSub.deleteCharAt(j);
			}
		}
		
		return set;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static HashSet<String> permString(String s){
//		HashSet<String> set = new HashSet<>();
//		if(s.length() <= 1){
//			set.add(s);
//			return set;
//		}
//		String last = new Character(s.charAt(s.length() - 1)).toString();
//		HashSet<String> prevPerms = permString(s.substring(0,  s.length() - 1));
//		
//		for(String sub : prevPerms){
//			for(int i = 0; i <= sub.length(); i++){
//				StringBuilder newSub = new StringBuilder(sub);
//				newSub.insert(i, last);
//				set.add(newSub.toString());
//			}
//		}
//		
//		return set;
//		
//	}

	
	
	
	public static ArrayList<ArrayList<Integer>> perms(ArrayList<Integer> list){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(list.size() <= 1){
			res.add(list);
			return res;
		}
		
		Integer last = list.remove(list.size() - 1);
		ArrayList<ArrayList<Integer>> prevPerms = perms(list);
		for(ArrayList<Integer> sub : prevPerms){
			for(int i = 0; i < sub.size(); i++){
				ArrayList<Integer> newSub = (ArrayList<Integer>) sub.clone();
				newSub.add(last);
				swap(newSub, i, newSub.size() - 1);
				res.add(newSub);
			}
			ArrayList<Integer> newSub = (ArrayList<Integer>) sub.clone();
			newSub.add(last);
			res.add(newSub);

		}
		return res;
	}
	
	public static void swap(ArrayList<Integer> list, int i, int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	
	
	public static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> list){
		if(list.size() == 0) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			res.add(new ArrayList<>());
			return res;
		}
		
		Integer last = list.remove(list.size() - 1);
		
		ArrayList<ArrayList<Integer>> prev = subSets(list);
		ArrayList<ArrayList<Integer>> newSubs = new ArrayList<>();
		
		for(ArrayList<Integer> a : prev) {
			ArrayList<Integer> arr = (ArrayList<Integer>) a.clone();
			arr.add(last);
			newSubs.add(arr);
		}
		prev.addAll(newSubs);
		return prev;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> list){
//		if(list.size() == 0){
//			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//			res.add(new ArrayList<Integer>());
//			return res;
//		}
//		
//		Integer last = list.remove(list.size() - 1);
//		
//		
//		ArrayList<ArrayList<Integer>> prevList = subSets(list);
//		ArrayList<ArrayList<Integer>> newSubs = new ArrayList<>();
//		
//		for(ArrayList<Integer> prevSub : prevList){
//			ArrayList<Integer> sub = new ArrayList<>();
//			for(Integer s : prevSub){
//				sub.add(s);
//			}
//			newSubs.add(sub);
//		}
//		
//		
//		for(ArrayList<Integer> sub : newSubs){
//			sub.add(last);
//		}
//		for(ArrayList<Integer> newSub : newSubs){
//			prevList.add(newSub);
//		}
//		
//		
//		return prevList;
//	}

}
