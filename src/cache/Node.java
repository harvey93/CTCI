package cache;

public class Node<Key, Value> {

	Key key;
	Value value;
	Node next;
	Node prev;
	
	public Node(Key key, Value value){
		this.value = value;
		this.key = key;
	}
	
	public String toString(){
		String keyString = key == null ? "null" : key.toString();
		String valueString = value == null ? "null" : value.toString();
		return "< Key: " + keyString + " | " + " Value: " + valueString + " >";
	}
}
