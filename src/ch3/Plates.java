package ch3;

import java.util.ArrayList;
import java.util.Stack;

public class Plates<T>{
	
	private ArrayList<Stack<T>> store;
	private final int maxPlates;
	
	public Plates(int maxPlates){
		this.store = new ArrayList<>();
		this.maxPlates = maxPlates;
	}
	
	public void push(T el){
		if (this.store.isEmpty() || currentStack().size() == this.maxPlates) {
			addPlate();
		}
		currentStack().add(el);
	}
	
	public boolean isEmpty(){
		return this.store.isEmpty();
	}
	
	public T pop() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException("Stack is empty. Cannot perform pop.");
		}
		
		T result = currentStack().pop();
		if(currentStack().isEmpty()){
			removePlate();
		}
		return result;
	}
	
	private void removePlate(){
		this.store.remove(currentIndex());
	}
	
	
	private void addPlate(){
		this.store.add(new Stack<T>());
	}
	
	private Stack<T> currentStack(){
		return this.store.get(this.store.size() - 1);
	}
	
	private int currentIndex(){
		return this.store.size() - 1;
	}
	
	public int size(){
		int result =  currentStack().size();
		if (currentIndex() != 0) {
			result += this.maxPlates * currentIndex();
		}
		return result;
	}
	
	public String toString() {
		return this.store.toString();
	}
	

}
