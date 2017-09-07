package hackerRank;

import java.util.HashMap;

public class Fibonacci {
	
	public static int fibRec(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}
		return fibRec(n - 1) + fibRec(n - 2);
	}
	
	public static double fibMemo(double n){
		HashMap<Double, Double> map = new HashMap<>();
		map.put(0.0, 0.0);
		map.put(1.0, 1.0);
		return fibMemo(n, map);
	}
	
	public static double fibMemo(double n, HashMap<Double, Double> map){
		if(map.containsKey(n)){
			return map.get(n);
		}else {
			map.put(n - 1, fibMemo(n - 1, map));
			map.put(n - 2, fibMemo(n - 2, map));
			return map.get(n - 1) + map.get(n - 2);
		}
		
		
	}

}
