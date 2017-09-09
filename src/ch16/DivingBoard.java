package ch16;
import java.util.*;

public class DivingBoard {

	public static HashSet<Integer> allLengths(int k, int shorter, int longer){
		HashSet<Integer> result = new HashSet<>();
		allLengths(k, 0, shorter, longer, result);
		return result;
	}
	
	public static void allLengths(int k, int total, int shorter, int longer, HashSet<Integer> result) {
		if(k == 0) {
			result.add(total);
			return;
		}
		String key = k + "-" + total;
		allLengths(k - 1, total + shorter, shorter, longer, result);
		allLengths(k - 1, total + longer, shorter, longer, result);
	}
}
