package ch3;

import java.sql.Array;
import java.util.Arrays;

public class ArrStack<T> {
	
	private T[] store;
	private int size;
	
	
	@SuppressWarnings("unchecked")
	public ArrStack(){
		this.store = (T[])new Object[4];
	}
	
	public void push(T el){
		if(this.size == capacity()){
			resize();
		}
		store[this.size] = el;
		size++;
	}
	
	private void resize(){
		@SuppressWarnings("unchecked")
		T[] newStore = (T[])new Object[capacity() * 2];
		for(int i = 0; i < this.store.length; i++){
			newStore[i] = this.store[0];
		}
		this.store = newStore;
	}
	
	public T pop() throws StackEmptyException{
		if(size == 0){
			throw new StackEmptyException("Can't perform pop. Stack is empty.");
		}
		size--;
		T result = this.store[this.size];
		this.store[this.size] = null;
		return result;
	}
	
	public int getSize(){
		return this.size;
	}
	
	private int capacity(){
		return this.store.length;
	}
	
	public String toString(){
		return Arrays.toString(this.store);
	}
	

}
