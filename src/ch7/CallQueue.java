package ch7;
import java.util.*;

public class CallQueue {
	private PriorityQueue<CallCenterEmployee> store;
	public CallQueue(){
		this.store = new PriorityQueue<>(new Comparator<CallCenterEmployee>(){

			@Override
			public int compare(CallCenterEmployee a, CallCenterEmployee b) {
				// TODO Auto-generated method stub
				return a.compareTo(b);
			}
			
		});
	}
	
	public void enqueue(CallCenterEmployee e){
		this.store.add(e);
	}
	
	public CallCenterEmployee dequeue(){
		return this.store.poll();
	}
}
