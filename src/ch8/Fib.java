package ch8;
import java.util.*;

public class Fib {
	
	public static int fibRec(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibRec(n - 1) + fibRec(n - 2);
	}
	
	public static int fibTopDown(int n){
		HashMap<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 0);
		memo.put(1, 1);
		return fibTopDown(n, memo);
	}
	
	public static int fibTopDown(int n, HashMap<Integer, Integer> memo){
		int res;
		if(memo.containsKey(n)){
			res = memo.get(n);
		}else {
			int n1 = fibTopDown(n - 1, memo);
			int n2 = fibTopDown(n - 2, memo);
			res = n1 + n2;
			memo.put(n, res);
		}
		return res;
	}
	
	public static int fibBottomUp(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1; 
		}
		HashMap<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 0);
		memo.put(1, 1);
		int i = 2;
		
		while(i <= n){
			int a = memo.get(i - 1);
			int b = memo.get(i - 2);
			memo.put(i, a + b);
			i++;
		}
		return memo.get(n);
	}

}
