package hackerRank;
import java.util.*;

public class WeightedGraph {
	private HashMap<String, Node> nodeMap = new HashMap<>();
	
	public HashMap<Node, Double> shortestPath(String id1, String id2){
		HashMap<Node, Double> nodes = new HashMap<>();
		HashSet<Node> visited = new HashSet<>();
		HashSet<Node> unvisited = new HashSet<>();
		Node currentNode = nodeMap.get(id1); 
		Node dest = nodeMap.get(id2);
		for(String key : nodeMap.keySet()){
			Node node = nodeMap.get(key);
			if(key == id1){
				nodes.put(node, 0.0);
			}else {
				nodes.put(node, Double.POSITIVE_INFINITY);
			}
			unvisited.add(node);
		}
		
		return shortestPath(currentNode, dest, visited, unvisited, nodes);
	}
	
	public HashMap<Node, Double> shortestPath(Node node, Node dest, HashSet<Node> visited, HashSet<Node> unvisited, HashMap<Node, Double> path){
		if(node == dest){
			return path;
		}else {
			visited.add(node);
			unvisited.remove(node);
		}
		for(String key : node.outEdges.keySet()){
			Double distanceToCurrentVisited = path.get(node);
			
			Node currentNode = nodeMap.get(key);
			
			Edge currentEdge = node.outEdges.get(key);
			Double currentDistance = path.get(currentNode);
			Double additionalDistance = currentEdge.size;
			
			
			if(currentDistance == Double.POSITIVE_INFINITY){
				path.put(currentNode, distanceToCurrentVisited + additionalDistance);
			}else if(distanceToCurrentVisited + additionalDistance < currentDistance){
				path.put(currentNode, distanceToCurrentVisited + additionalDistance);
			}
		}
		
		Node nextVisit = getMin(node, path, unvisited);
		
		
		return shortestPath(nextVisit, dest, visited, unvisited, path);
	}
	
	private Node getMin(Node node, HashMap<Node, Double> path, HashSet<Node> unvisited){
		Node res = null;
		for(String key : node.outEdges.keySet()){
			Node current = nodeMap.get(key);
			if(unvisited.contains(current)){
				if(res == null || path.get(res) > path.get(current)){
					res = current;
				}
			}
		}
		return res;
	}
	
	public ArrayList<Node> topoSort(){
		ArrayList<Node> nodes = new ArrayList<>();
		return topoSort(nodes);
	}
	
	public ArrayList<Node> topoSort(ArrayList<Node> nodes){
		if(nodeMap.isEmpty()){
			return nodes;
		}
		Node node = null;
		for(String key : nodeMap.keySet()){
			Node current = nodeMap.get(key);
			if(current.inEdges.isEmpty()){
				node = current;
				break;
			}
		}
		if(node == null){
			return nodes;
		}
		nodeMap.remove(node.id);
		clearOutEdges(node);
		nodes.add(node);
		return topoSort(nodes);
	}
	
	public void clearOutEdges(Node node){
		HashMap<String, Edge> edges = node.outEdges;
		for(String key : edges.keySet()){
			Node outNode = nodeMap.get(key);
			outNode.inEdges.remove(node.id);
		}
	}
	
	
	private class Node{
		private String id;
		private HashMap<String, Edge> inEdges = new HashMap<>();
		private HashMap<String, Edge> outEdges = new HashMap<>();
		private Node(String id){
			this.id = id;
		}
		public String toString(){
			return id;
		}
	}
	
	private class Edge{
		private String id;
		private Double size;
		private Edge(String id, double size){
			this.id = id;
			this.size = size;
		}
		public String toString(){
			return "Size: " + size;
		}

	}
	
	public void addEdge(String id1, String id2, int size){		
		if(nodeMap.containsKey(id2) && nodeMap.containsKey(id2)){
			Node node1 = nodeMap.get(id1);
			Node node2 = nodeMap.get(id2);
			
			Edge outEdge = new Edge(id2, size);
			node1.outEdges.put(id2, outEdge);
			
			Edge inEdge = new Edge(id1, size);
			node2.inEdges.put(id1, inEdge);
		}
		
	}
	
	
	public void addNode(String id){
		Node node = new Node(id);
		nodeMap.put(id, node);
	}
	
	public void nodeList(){
		System.out.println(nodeMap.toString());
	}
	
	public void edgeList(String id){
		if(nodeMap.containsKey(id)){
			Node node = nodeMap.get(id);
			System.out.println("In Edges: " + node.inEdges);
			System.out.println("Out Edges: " + node.outEdges);
		}
	}
	
	
}
