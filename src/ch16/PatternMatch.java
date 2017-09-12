package ch16;
import java.util.*;

public class PatternMatch {
	
	public static HashMap<String, Integer> buildFreqTable(String s){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("a", 0);
		map.put("b", 0);
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			String sub = c.toString();
			map.put(sub, map.get(sub) + 1);
		}
		return map;
	}
	
	public static boolean isMatchBF(String s1, String pattern) {
		boolean res = false;
		HashMap<String, Integer> table = buildFreqTable(pattern);
		Integer firstB = firstB(pattern);
		if(pattern.charAt(0) != 'a') {
			pattern = invert(pattern);
		}
		for(int i = 1; i <= s1.length(); i++) {
			String a = s1.substring(0, i);
			
			double bLen = getBLen(a, pattern, table, s1.length());
			
			if(bLen < 0) {
				break;
			}
			
			if(bLen != (int)bLen) {
				continue;
			}
			
			
			String b = getB(bLen, s1, firstB, a);
			if(checkForm(a, b, pattern, s1)) {
				res = true;
				break;
			}
		}
		
		return res;
	}
	
	public static boolean checkForm(String a, String b, String pattern, String s) {
		boolean res = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(c == 'a') {
				sb.append(a);
			}else {
				sb.append(b);
			}
		}
		if(sb.toString().equals(s)) {
			res = true;
		}
		return res;
	}

	
	public static Integer firstB(String pattern) {
		Integer index = null; 
		for(int i = 1; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			
			if(c == 'b') {
				index = i;
				break;
			}
		}
		return index;
	}

	
	public static String getB(double bLen, String s, Integer firstB, String a) {
		String b = "";
		int offset = firstB * a.length();
		
		b = s.substring(offset, offset + (int)bLen);
		return b;
	}
	
	public static String invert(String pattern) {
		StringBuilder newPattern = new StringBuilder();
		for(int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(c == 'a') {
				newPattern.append('b');
			}else {
				newPattern.append('a');
			}
		}
		return newPattern.toString();
	}
	
	public static double getBLen(String a, String pattern, HashMap<String, Integer> table, int totalLen) {
		double aRem = (double) (totalLen - (a.length() * table.get("a")));
		double bLen = ( aRem / table.get("b"));
		
		return bLen;
	}
}
	

