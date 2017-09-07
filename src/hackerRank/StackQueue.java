package hackerRank;

import java.util.Stack;

public class StackQueue<T> {

	Stack<T> pushStack;
	Stack<T> popStack;
	public StackQueue() {
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>();
	}
	
	public void enqueue(T el){
		this.pushStack.push(el);
	}
	
	public T dequeue(){
		if(!this.popStack.isEmpty()){
			return this.popStack.pop();
		}else {
			fillPopStack();
			return this.popStack.pop();
		}
	}
	
	private void fillPopStack(){
		while(!this.pushStack.isEmpty()){
			this.popStack.push(this.pushStack.pop());
		}
	}
	
	public T peek(){
		if(!this.popStack.isEmpty()){
			return this.popStack.peek();
		}else if(!this.pushStack.isEmpty()){
			fillPopStack();
			return this.popStack.peek();
		}else {
			return null;
		}
	}
}
