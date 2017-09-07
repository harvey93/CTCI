package ch2;

import java.util.Stack;

public class Palindrome {

	public static boolean check1(Node node){
		boolean res = true;
		Node nodeRev = ListSum.reverseList(node);
		while(node != null){
			if (node.getData() != nodeRev.getData()) {
				res = false;
				break;
			}
			node = node.getNext();
			nodeRev = nodeRev.getNext();
		}
		return res;
	} 
	
	public static boolean check2(Node node) {
		boolean res = true;
		Stack<Node> stack = new Stack<>();
		
		Node walk = node;
		Node run = node;
		while(walk != null){
			if(run.getNext() == null){
				break;
			}else{
				run = run.getNext();
			}
			stack.push(walk);
			if(run.getNext() == null){
				break;
			}else {
				run = run.getNext();
			}
			
			walk = walk.getNext();
		}
		walk = walk.getNext();
		while(!stack.isEmpty()){
			Node stackCurrent = stack.pop();
			if(walk.getData() != stackCurrent.getData()){
				res = false;
				break;
			}
			walk = walk.getNext();
		}

		System.out.println(walk);
		return res;
	}
}
