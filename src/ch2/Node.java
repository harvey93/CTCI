package ch2;

public class Node {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((prev == null) ? 0 : prev.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (prev == null) {
			if (other.prev != null)
				return false;
		} else if (!prev.equals(other.prev))
			return false;
		return true;
	}

	private Integer data;
	private Node next;
	private Node prev;
	
	public Node(Integer data){
		this.data = data;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Integer getData(){
		return this.data;
	}
	
	public void setData(Integer data){
		this.data = data;
	}
	
	public Node getPrev(){
		return this.prev;
	}
	
	public void setPrev(Node prev){
		this.prev = prev;
	}
	
	public String toString(){
		return "Data: " + this.data;
	}
}
