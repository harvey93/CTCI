package ch8;
import java.util.*;

public class Parens {
	
	
	public static ArrayList<String> generateParens(int n){
		ArrayList<String> result = new ArrayList<>();
		
		generateParens(result, n, n, new char[n * 2], 0);
		return result;
	}
	
	public static void generateParens(ArrayList<String> result, int left, int right, char[] chars, int index){
		if(right < left || left < 0){
			return;
		}

		
		if(left == 0 && right == 0){
			result.add(String.copyValueOf(chars));
			return;
		}
		
		chars[index] = '(';
		generateParens(result, left - 1, right, chars, index + 1);
		
		chars[index] = ')';
		generateParens(result, left, right - 1, chars, index + 1);
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<String> generateParens(int n){
//		ArrayList<String> list = new ArrayList<>();
//		generateParens(list, n, n, new char[n * 2], 0);
//		return list;
//	}
//	
//	
//	public static void generateParens(ArrayList<String> result, int leftRem, int rightRem, char[] arr, int index){
//		
//		if(leftRem < 0 || rightRem < leftRem){
//				return;
//		}
//		
//		if(leftRem == 0 && rightRem == 0){
//			result.add(String.copyValueOf(arr));
//		}else {
//			arr[index] = '(';
//			generateParens(result, leftRem - 1, rightRem, arr, index + 1);
//			
//			
//			arr[index] = ')';
//			generateParens(result, leftRem, rightRem - 1, arr, index + 1);
//		}
//		
//		
//		
//	}
	
}
