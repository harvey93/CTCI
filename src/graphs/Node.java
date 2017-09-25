package graphs;
import java.util.*;

public class Node<T> {
	
	String label;
	T data;
	HashSet<Edge> inEdges = new HashSet<>();
	HashSet<Edge> outEdges = new HashSet<>();
	
	public Node(String label, T data) {
		this.label = label;
		this.data = data;
	}
	
	public String toString() {
		return "Label: " + this.label + "\nData: " + this.data;
	}
}
