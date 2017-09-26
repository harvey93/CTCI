package graphs;
import java.util.*;

public class Graph<T> {
	HashMap<String, Node<T>> nodes = new HashMap<>();
	
	public void addNode(String label, T data) {
		Node<T> node = new Node<>(label, data);
		nodes.put(label, node);
	}
	
	public void addEdge(String start, String end, int weight) {
		
	}
	
	public String toString() {
		return nodes.toString();
	}
	
}
