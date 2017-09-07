package ch4;
import java.util.*;

public class Graph<T> {
	private HashMap<String, GNode<T>> nodeMap = new HashMap<>();
	
	public HashMap<String, GNode<T>> getNodeMap(){
		return nodeMap;
	}
	
	public GNode<T> getNode(String label){
		return nodeMap.get(label);
	}
		
	public void addEdge(String label1, String label2, int weight){
		GNode<T> node1 = nodeMap.get(label1);
		GNode<T> node2 = nodeMap.get(label2);
		Edge inEdge = new Edge(label1, weight);
		Edge outEdge = new Edge(label2, weight);
		node1.outEdges.put(label2, outEdge);
		node2.inEdges.put(label1, inEdge);
	}
	
	public void addNode(String label, T data){
		GNode<T> node = new GNode<>(label, data);
		nodeMap.put(label, node);
	}
	
	
	public String toString(){
		return nodeMap.toString();
	}

}

class GNode<T>{
	String label;
	T data;
	HashMap<String, Edge> inEdges = new HashMap<>();
	HashMap<String, Edge> outEdges = new HashMap<>();
	
	public GNode(String label, T data){
		this.label = label;
		this.data = data;
	}
	
	public String toString(){
		return data == null ? "null" : data.toString();
	}
}


class Edge{
	String destLabel;
	int weight;
	
	public Edge(String destLabel, int weight){
		this.destLabel = destLabel;
		this.weight = weight;
	}
	
	public String toString(){
		return "Connection: " + this.destLabel + " Weight: " + this.weight;
	}
}

