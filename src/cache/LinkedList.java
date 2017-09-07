package cache;

public class LinkedList<Key, Value>{

	private Node<Key, Value> head = new Node<>(null, null);;
	private Node<Key, Value> tail = new Node<>(null, null);;
	
	public LinkedList(){
		head.next = tail;
		tail.prev = head;
	}
	
	
	public Node<Key, Value> add(Key key,  Value value){
		Node<Key, Value> newNode = new Node<>(key, value);
		Node<Key, Value> currentEnd;
		
		if(isEmpty()){
			currentEnd = head;
		}else {
			currentEnd = last();
		}
		
		currentEnd.next = newNode;
		newNode.prev = currentEnd;
		
		newNode.next = tail;
		tail.prev = newNode;
		return newNode;
	}
	
	public Node<Key, Value> get(Key key){
		Node<Key, Value> res = null;
		Node<Key, Value> current = head;
		while(current != null){
			if(current.key == key){
				res = current;
			}
			current = current.next;
		}
		return res;
	}
	
	public Node<Key, Value> remove(Key key){
		Node<Key, Value> node = get(key);
		
		if(node != null){
			Node<Key, Value> prevNode = node.prev;
			Node<Key, Value> nextNode = node.next;
			
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
		
		return node;
	}
	
	public Node<Key, Value> remove(Node<Key, Value> node){
		if(node != null){
			Node<Key, Value> prevNode = node.prev;
			Node<Key, Value> nextNode = node.next;
			
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
		
		return node;

	}
	
	public Node<Key, Value> removeFirst(){
		Node<Key, Value> res = null;
		if(!isEmpty()){
			Node<Key, Value> first = first();
			res = remove(first.key);
		}
		return res;
	}

	
	public boolean contains(Key key){
		boolean res = false;
		Node<Key, Value> node = get(key);
		if(node != null){
			res = true;
		}
		return res;
	}
	
	public Node<Key, Value> update(Key key, Value value){
		Node<Key, Value> node = null;
		if(contains(key)){
			node = get(key);
			node.value = value;
		}
		return node;
	}
	
	
	
	public Node<Key, Value> last(){
		Node<Key, Value> res = null;
		if(!isEmpty()){
			res = tail.prev;
		}
		return res;

	}
	
	public Node<Key, Value> first(){
		Node<Key, Value> res = null;
		if(!isEmpty()){
			res = head.next;
		}
		return res;
	}
	
	public boolean isEmpty(){
		boolean res = false;
		if(head.next == tail){
			res = true;
		}
		return res;
	}
	
	public String toString(){
		String res = "";
		Node<Key, Value> current = head; 
		while(current != null){
			if(current.key != null){
				res += " " + current.toString();
			}else {
				res += "Sentinel";
			}
			res += "\n";
			current = current.next;

		}
		return res;
	}
}
