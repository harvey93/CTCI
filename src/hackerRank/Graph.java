package hackerRank;

import java.util.*;

public class Graph {
	private HashMap<Integer, Node> nodeLookUp= new HashMap<>();
	
		
	public static class Node{
		private int id;
		LinkedList<Node> adjacent = new LinkedList<>();
		private Node(int id){
			this.id = id;
		}
	}
	
	public void addNode(int id){
		Node node = new Node(id);
		nodeLookUp.put(id, node);
	}
	
	private Node getNode(int id){
		return nodeLookUp.get(id);
	}
	
	public void addEdge(int source, int dest){
		Node s = getNode(source);
		Node d = getNode(dest);
		s.adjacent.add(d);
	}
	
	public boolean hasPathBFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<>();
		return hasPathBFS(s, d, visited);
	}
	
	private boolean hasPathBFS(Node source, Node destination, HashSet<Integer> visited){
		boolean res = false;
		
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.add(source);
		while(!queue.isEmpty()){
			Node current = queue.removeFirst();
			if(current == destination){
				res = true;
				break;
			}

			if(visited.contains(current.id)){
				continue;
			}
			
			visited.add(current.id);

			current.adjacent.forEach(el -> queue.add(el));
			
		}
		
		return res;
	}

	
	public boolean hasPathDFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDFS(s, d, visited);
	}
	
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		
		if(source == destination){
			return true;
		}
		
		for(Node child : source.adjacent){
			if(hasPathDFS(child, destination, visited)){
				return true;	
			}
		}
		
		return false;
		
	}

}
