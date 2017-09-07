package hackerRank;

import java.util.Stack;

public class StacksProbs {
	
	
	public static void stackSort(Stack<Integer> stack){
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> main = new Stack<>();
		
		while(!stack.isEmpty()){
			int val = stack.pop();
			add(main, temp, val);
		}
		
		while(!main.isEmpty()){
			stack.push(main.pop());
		}
		
//		System.out.println(main);
	}
	
	public static void add(Stack<Integer> main, Stack<Integer> temp, int val){
		while(!main.isEmpty() && main.peek() < val){
			temp.push(main.pop());
		}
		
		main.push(val);
		
		while(!temp.isEmpty()){
			main.push(temp.pop());
		}
		
	}
	
	public static char[][] TOKENS = {{'{','}'},{'[',']'},{'(',')'}};

	public static boolean isBalancedThree(String str){
		Stack<Character> stack = new Stack<>();
		for(char c : str.toCharArray()){
			if(isOpenTerm(c)){
				stack.push(c);
			}else {
				if(stack.isEmpty() || !matches(stack.pop(), c)){
					return false;
				}

			}
		}
		return stack.isEmpty();
	}
	
	public static boolean isOpenTerm(Character c){
		for(char [] arr : TOKENS){
			if(arr[0] == c){
				return true;
			}
		}
		return false;
	}
	
	public static boolean matches(Character openTerm, Character closedTerm){
		for(char [] arr : TOKENS){
			if(arr[0] == openTerm){
				return arr[1] == closedTerm;
			}
		}
		return false;
	}
	
	public static boolean isBalancedTwo(String str) {
		boolean res = true;
		Stack<Character> stack = new Stack<>();
		for(Character s : str.toCharArray()){
			if(s == '{'){
				stack.push('}');
			}else if(s == '('){
				stack.push(')');
			}else if(s == '['){
				stack.push(']');
			}else {
				if(stack.isEmpty() || s != stack.peek()){
					res = false;
					break;
				}
				stack.pop();
			}
		}

        if(!stack.isEmpty()){
        	res = false;
        }
		return res;
	}
	
	  public static boolean isBalanced(String str) {
	        boolean res = true;
	        String[] arr = str.split("");
	        
	        Stack<String> stack = new Stack<String>();
	        for(String s : arr){
	        	
	            if(s.equals("{") || s.equals("(") || s.equals("[")){
	                stack.push(s);
	            }else if(s.equals("}") || s.equals(")") || s.equals("]")){
	            	
	                if(stack.isEmpty()){
	                    res = false;
	                    break;
	                }
	                String currentPop = stack.pop();
	                if(s.equals("}") && !currentPop.equals("{")){
	                    res = false;
	                    break;
	                }
	                if(s.equals(")") && !currentPop.equals("(")){
	                    res = false;
	                    break;
	                }
	                if(s.equals("]") && !currentPop.equals("[")){
	                    res = false;
	                    break;
	                }
	            }
	        }

	        if(!stack.isEmpty()){
	        	res = false;
	        }
	        return res;
	    }

}
