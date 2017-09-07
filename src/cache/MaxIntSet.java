package cache;

import java.util.Arrays;

public class MaxIntSet {
	
	private boolean [] store;
	private int maxIndex;
	public MaxIntSet(int max){
		this.store = new boolean[max + 1];
		this.maxIndex = max;
	}
	
	public void insert(int val) throws ExceedMaxException{
		error(val);
		store[val] = true;
	}
	
	public boolean contains(int val) throws ExceedMaxException{
		error(val);
		boolean res = false;
		if(store[val]){
			res = true;
		}
		return res;
	}
	
	public void delete(int val) throws ExceedMaxException{
		error(val);
		store[val] = false;
	}
	
	public String toString(){
		return Arrays.toString(store);
	}
	
	private void error(int val) throws ExceedMaxException{
		if(val > maxIndex){
			throw new ExceedMaxException("Value exceeds max");
		}
	}
}

