package ch8;
import java.util.*;

public class BooleanEvaluation {
	
	public static int countEval(String s, boolean result){
		HashMap<String, Integer> memo = new HashMap<>();
		return countEval(s, result, memo);
	}
	
	public static int countEval(String s, boolean result, HashMap<String, Integer> memo){
		if(s.length() == 1){
			return result == evalString(s) ? 1 : 0; 
		}
		
		String key = result + s;
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		
		int ways = 0;
		
		for(int i = 1; i < s.length(); i+= 2){
			char c = s.charAt(i);
			
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			
			
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			
			if(c == '^'){
				totalTrue+= (leftTrue * rightFalse) + (leftFalse * rightTrue);
			}else if (c == '&'){
				totalTrue+= leftTrue * rightTrue;
			}else if(c == '|'){
				totalTrue+= (leftTrue * rightFalse) + (leftFalse * rightTrue) + leftTrue * rightTrue;
			}
			
			ways += result ? totalTrue : total - totalTrue;
		}
		
		memo.put(key, ways);
		return ways;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean evalString(String s){
		return s.equals("1") ? true : false;
	}

	
//	public static int evaluate(String s, boolean result){
//		HashMap<String, Integer> memo = new HashMap<>();
//		return evaluate(s, result, memo);
//	}
//
//	public static int evaluate(String s, boolean result, HashMap<String, Integer> memo){
//
//		if(s.length() == 0){
//			return 0;
//		}
//		
//		if(s.length() == 1){
//			return evalString(s) == result ? 1 : 0;
//		}
//		
//		if(memo.containsKey(result + s)){
//			return memo.get(result + s);
//		}
//		
//		int ways = 0;
//		
//		for(int i = 1; i < s.length(); i += 2){
//
//			char c = s.charAt(i);
//			String left = s.substring(0, i);
//			String right = s.substring(i + 1, s.length());
//			
//			int leftTrue = evaluate(left, true);
//			int leftFalse = evaluate(left, false);
//			
//			int rightTrue = evaluate(right, true);
//			int rightFalse = evaluate(right, false);
//			
//			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse); 
//			  
//
//			int totalTrue = 0;
//			if(c == '^'){
//				totalTrue = leftTrue * rightFalse + rightTrue * leftFalse;
//			}else if(c == '&'){
//				totalTrue = leftTrue * rightTrue;
//			}else if (c == '|'){
//				totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + rightTrue * leftFalse;
//			}
//			
//			int subways = result ? totalTrue : total - totalTrue;
//			ways += subways;
//		}
//		
//		memo.put(result + s, ways);
//		
//		return ways;
//		
//	}
//	

}
