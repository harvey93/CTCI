package trees;

public class Node<T>{
	
	Node left;
	Node right;
	T data;
	
	public Node(T data){
		this.data = data;
	}
	
	public String toString(){
		return data.toString();
	}

}
