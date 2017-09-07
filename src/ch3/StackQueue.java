package ch3;

import java.util.Stack;

public class StackQueue<T> {

	Stack<T> pushStack;
	Stack<T> popStack;
	public StackQueue(){
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>();
	}
	
	public void queue(T el){
		this.pushStack.push(el);
	}
	
	public void dequeue() throws StackEmptyException{
		if(isEmpty()){
			throw new StackEmptyException("Stack is empty. Cannot perform pop.");
		}
		if(this.popStack.isEmpty()){
			fillPopStack();
		}
		this.popStack.pop();
	}
	
	private void fillPopStack(){
		while(!this.pushStack.isEmpty()){
			this.popStack.push(this.pushStack.pop());
		}
	}
	
	public boolean isEmpty(){
		return this.pushStack.isEmpty() && this.popStack.empty();
	}
	
	public String toString(){
		return this.pushStack.toString() + " " + this.popStack.toString();
	}
	
}
