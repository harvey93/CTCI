package graphs;
import java.util.*;

public class Graph<T> {
	HashMap<String, Node<T>> nodes = new HashMap<>();
	
	public void addNode() {
	}
	
	public String toString() {
		return nodes.toString();
	}
	
}
