package ch2;
import java.util.*;

public class Test {
	static Integer i;
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		six.setNext(seven);
		seven.setNext(eight);
		eight.setNext(five);
		
		
		System.out.println("----------------");
//		System.out.println(ListLoop.loopDetect(one));
		
		
		
	}
	
	public static void printList(Node head){
		Node current = head;
		while(current != null){
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	
	public static Node createList(int[] arr){
		Node head = new Node(arr[0]);
		Node current = head;
		for(int i = 1; i < arr.length; i++){
			Node nextNode = new Node(arr[i]);
			current.setNext(nextNode);
			nextNode.setPrev(current);
			current = nextNode;
		}
		return head;
	}
}
