package ch2;

import java.util.HashSet;

public class ListLoop {
	
	
	public static Node loopDetect(Node node){
		Node res = null;
		HashSet<Integer> set = new HashSet<>();
		Node current = node;
		
		while(node != null){
			if(set.contains(current.getData())){
				res = current;
				break;
			}
			set.add(current.getData());
			current = current.getNext();
		}
		
		return res;
	}

	public static boolean isIntersect(Node node1, Node node2){
		boolean res = false;
		int oneSize = listLength(node1);
		int twoSize = listLength(node2);
		if(oneSize > twoSize){
			node1 = pushStart(node1, oneSize - twoSize);
		}else if(twoSize > oneSize){
			node2 = pushStart(node2, twoSize - oneSize);
		}
		
		while(node1 != null){
			if(node1.equals(node2)){
				res = true;
				break;
			}
			node1 = node1.getNext();
			node2 = node2.getNext();
		}
		
		return res;
	}
	
	public static int listLength(Node node){
		int count = 0;
		Node current = node;
		while(current != null){
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public static Node pushStart(Node node, int i){
		while(i > 0){
			node = node.getNext();
			i--;
		}
		return node;
	}
}
