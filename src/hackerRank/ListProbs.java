package hackerRank;
import java.util.*;

public class ListProbs {

	public static ListNode<Integer> findMid(ListNode<Integer> head){
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;
		while(fast != null){
			if(fast.next != null){
				
				if(fast.next.next != null){
					fast = fast.next.next;
					slow = slow.next;
				}else {
					break;
				}
			}else {
				break;
			}
		}
		return slow;
	}
}

class ListNode<T>{
	T data;
	ListNode next;
	
	public ListNode(T data){
		this.data = data;
	}
	
	public String toString(){
		return data.toString();
	}
}

