package ch4;

public class Node<T> {
	
	T data;
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	
	
	
	public void setLeft(Node<T> left) {
		left.parent = this;
		this.left = left;
	}

	public void setRight(Node<T> right) {
		right.parent = this;
		this.right = right;
	}

	public Node(T data){
		this.data = data;
	}

	public String toString(){
		return this.data == null ? "null" : this.data.toString();
	}
}
