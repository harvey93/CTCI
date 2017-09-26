package graphs;
import java.util.*;

public class Graph<T> {
	HashMap<String, Node<T>> nodes = new HashMap<>();
	
	public void addNode(String label, T data) {
		Node<T> node = new Node<>(label, data);
		nodes.put(label, node);
	}
	
	public void addEdge(String start, String end, int weight) {
		Node<T> node1 = nodes.get(start); 
		Node<T> node2 = nodes.get(end);
		Edge outEdge = new Edge(weight, end);
		Edge inEdge = new Edge(weight, start);
		node1.outEdges.add(outEdge);
		node2.inEdges.add(inEdge);
	}
	
	public String toString() {
		return nodes.toString();
	}
	
}
