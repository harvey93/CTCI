package ch3;

import java.util.Stack;

public class SortStack{

	private Stack<Integer> store;
	private Stack<Integer> tempStack;
	
	public SortStack(){
		this.store = new Stack<>();
		this.tempStack = new Stack<>();
	}
	
	public void push(Integer el){
		fillStacks(el);
		this.store.push(el);
		dumpToStore();
	}
	
	public Integer pop() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException("Stack is Empty. Cannot perform pop action.");
		}
		return this.store.pop();
	}
	
	public Integer peek() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException("Stack is Empty. Cannot perform peek action.");
		}
		return this.store.peek();
	}
	
	private void dumpToStore(){
		while(!this.tempStack.isEmpty()){
			this.store.push(this.tempStack.pop());
		}
	}
	
	private void fillStacks(Integer el){
		while(!isEmpty()){
			if(this.store.peek() < el){
				this.tempStack.push(this.store.pop());
			}else {
				break;
			}
		}
	}
	
	public boolean isEmpty(){
		return this.store.isEmpty();
	}
	

	public String toString(){
		
		return this.store.toString();
	}
	
}
