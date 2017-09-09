package ch16;
import java.util.*;

public class DivingBoard {

	public static HashSet<Integer> allLengths(int k, int shorter, int longer){
		HashSet<Integer> result = new HashSet<>();
		HashSet<String> visited = new HashSet<>();
		allLengths(k, 0, shorter, longer, result, visited);
		
		return result;
	}
	
	public static void allLengths(int k, int total, int shorter, int longer, HashSet<Integer> result, HashSet<String> visited) {
		if(k == 0) {
			result.add(total);
			return;
		}
		String key = k + "-" + total;
		if(visited.contains(key)) {
			
			return;
		}
		allLengths(k - 1, total + shorter, shorter, longer, result, visited);
		allLengths(k - 1, total + longer, shorter, longer, result, visited);
		visited.add(key);
	}
}
