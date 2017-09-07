package ch2;

import java.util.Stack;

public class ListSum {
	
	public static Node forwardSum(Node first, Node second){
		Node firstRev = reverseList(first);
		Node secondRev = reverseList(second);
		Node sum = backwardSum(firstRev, secondRev);
		return reverseList(sum);
	}
	
	public static Node reverseList(Node head){
		Stack<Node> stack = new Stack<>();
		Node current = head;
		while(current != null){
			stack.push(current);
			current = current.getNext();
		}
		Node newHead = new Node(stack.pop().getData());
		Node newCurrent = newHead;
		while(!stack.isEmpty()){
			Node next = new Node(stack.pop().getData());
			
			newCurrent.setNext(next);
			newCurrent = newCurrent.getNext();
		}
//		System.out.println(stack);
		
		return newHead;
	}
	
	public static Node backwardSum(Node first, Node second){
		Node last = null;
		Node head = null;
		int carry = 0;
		while(first != null || second != null){
			int currentSum = carry;
			int firstVal;
			int secondVal;
			
			if(first == null){
				firstVal = 0;
			}else {
				firstVal = first.getData();
				first = first.getNext();
			}
			
			if(second == null){
				secondVal = 0;
			}else {
				secondVal = second.getData();
				second = second.getNext();
			}
			
			currentSum += firstVal;
			currentSum += secondVal;
			carry = currentSum / 10;
			currentSum = currentSum % 10;
			
			if(last == null){
				head = new Node(currentSum);
				last = head;
			}else{
				Node next = new Node(currentSum);
				last.setNext(next);
				last = next;
			}
		}
		
		return head;
	}

}
