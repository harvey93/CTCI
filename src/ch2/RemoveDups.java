package ch2;
import java.util.*;

public class RemoveDups {
	
	public static void removeDups(Node head){
		HashSet<Integer> set = new HashSet<>();
		Node last = null;
		while(head != null){
			if(set.contains(head.getData())){
				last.setNext(head.getNext());
			}else {
				last = head;
				set.add(head.getData());
				
			}
			head = head.getNext();
		}

		
	}
	
	public static HashMap<Integer, Integer> hashCount(Node head){
		HashMap<Integer, Integer> map = new HashMap<>();
		Node current = head;
		while(current != null){
			Integer currentData = current.getData();
			if(map.containsKey(currentData)){
				Integer currentCount = map.get(currentData);
				map.put(currentData, ++currentCount);
			}else{
				map.put(currentData, 1);
			}
			
			current = current.getNext();
		}
		
		return map;
	}
}
