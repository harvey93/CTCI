package ch3;

public class Node<T> {
	
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(T el){
		this.data = el;
		this.next = null;
		this.prev = null;
	}

	public Node<T> getPrev() {
		return this.prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public String toString(){
		String result = "";
		result += " "+ (this.data == null ? "null" : this.data);
		return result;
	}
	
	
}
