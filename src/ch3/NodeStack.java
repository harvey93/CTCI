package ch3;


public class NodeStack<T> {

	private Node<T> head;
	private int size;
	private Node<T> current;
	
	
	public NodeStack(){
		this.head = null;
		this.current = null;
		this.size = 0;
	}
	
	public Node<T> pop() throws StackEmptyException{
		if(getSize() == 0){
			throw new StackEmptyException("Can't perform pop. Stack is empty.");
		}else if(getSize() == 1){
			this.head = null;
		}
		
		Node<T> res = this.current;
		this.current = this.current.getPrev();
		
		if(this.current != null){
			this.current.setNext(null);
		}
		
		this.size--;
		return res;
	}
	
	public Node<T> peek() throws StackEmptyException{
		return this.current;
	}
	
	public void push(T el){
		Node<T> newNode = new Node<T>(el);
		newNode.setPrev(this.current);
		
		if(getSize() == 0){
			this.head = newNode;	
		}else if(getSize() == 1){
			this.head.setNext(newNode);
			this.current.setNext(newNode);
			
		}else {
			this.current.setNext(newNode);		
		}
		
		this.current = newNode;
		
		this.size++;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public String toString(){
		String result = "{";
		Node<T> current = this.head;
		
		while(current != null){
			result += " " + current.getData();
			current = current.getNext();
		}
		
		result += " }";
		
		return result;
	}
}
