package ch2;

public class MiddleDelete {
	
	public static void remove(Node node){
		Node nextNode = node.getNext();
		node.setData(nextNode.getData());
		node.setNext(nextNode.getNext());
	} 
	
	public static void partition(Node node, int val){
		Node first = null;
		Node middleStart = null;
		Node end = null;
		while(node != null){
			if(node.getData() < val){
				if(first == null){
					first = node;
				}else {
					first.setNext(node);
					first = first.getNext();
				}
			}else{
				if(end == null){
					end = node;
					middleStart = node;
				}else {
					end.setNext(node);
					end = end.getNext();
				}
			}
			node = node.getNext();
		}
		
		if(first.getNext() != null && first.getNext().getData() >= val){
			first.setNext(null);
		}
		
		if(end.getNext() != null && end.getNext().getData() < val){
			end.setNext(null);
		}
		
		first.setNext(middleStart);
		
		
	}
}
