package cache;

import java.util.*;

public class HashSet<T> {
	private ArrayList<ArrayList<T>> store;
	private int size;
	private int currentSize = 0;
	
	private void fillList(ArrayList<ArrayList<T>> list, int num){
		while(num > 0){
			list.add(new ArrayList<T>());
			num--;
		}
	}
	
	public HashSet(int size){
		this.store = new ArrayList<ArrayList<T>>();
		fillList(store, size);
		this.size = size;
	}
	
	public void delete(T val){
		if(contains(val)){
			ArrayList<T> bucket = getBucket(val);
			bucket.remove(val);
		}
		
	}
	
	public boolean contains(T val){
		boolean res = false;
		ArrayList<T> bucket = getBucket(val);
		if(bucket.contains(val)){
			res = true;
		}
		return res;
	}
	
	public void insert(T val){
		ArrayList<T> bucket = getBucket(val);
		fillBucket(bucket, val);
		if(currentSize == size){
			resize();
		}

	}
	
	private void resize(){
		size *= 2;
		currentSize = 0;
		ArrayList<ArrayList<T>> oldStore = store;
		store = new ArrayList<ArrayList<T>>(size);
		fillList(store, size);
		for(ArrayList<T> list : oldStore){
			for(T el : list){
				insert(el);
			}
		}
		
	}
	
	private void fillBucket(ArrayList<T> bucket, T val){
		if(!bucket.contains(val)){
			bucket.add(val);
			currentSize++;
		}
	}

	private ArrayList<T> getBucket(T val){
		int bucket = hash(val) % size;
		return store.get(bucket);
	}

	private int hash(T el){
		return el.hashCode();
	}
	
	public String toString(){
		return store.toString();
	}
}
