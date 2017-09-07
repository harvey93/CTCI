package ch2;

public class ToLast {
	
	public static Node kthToLast(Node head, int k){
		Node current = head;
		Node res = head;
		while(current.getNext() != null){
			if(k > 0){
				k--;
			}else {
				res = res.getNext();
			}
			current = current.getNext();
		}
		
		return res;
	}
}
