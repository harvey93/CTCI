package ch3;

import java.util.*;

public class MyStack<T> {
	
	private ArrayList<T> store;
	
	
	public MyStack(){
		this.store = new ArrayList<>();
	}
	
	public void push(T el){
		this.store.add(el);
	}
	
	public T pop(){
		return this.store.remove(size() - 1);
	}
	
	public int size(){
		return this.store.size();
	}
	
	public String toString(){
		return this.store.toString();
	}
	

}
