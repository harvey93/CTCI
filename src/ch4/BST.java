package ch4;
import java.util.*;

public class BST{
	Node root;
	int size = 0;
	LinkedList<Integer> list = new LinkedList<>();
	HashMap<Integer, Node> map = new HashMap<>(); 
	
	private void insertIntoMap(Node node){
		map.put(++size, node);
		
	}
	
	public Node getRandom(){
		int i = (int)(Math.random() * size) + 1;
		System.out.println(i);
		return map.get(i);
	}
	
	public String preOrder(){
		ArrayList<Integer> list = new ArrayList<>();
		preOrder(root, list);
		return list.toString();
	}
	
	public void preOrder(Node node, ArrayList<Integer> list){
		if(node == null){
			list.add(null);
			return;
		}
		list.add(node.data);
		preOrder(node.left, list);
		preOrder(node.right, list);
	}
	
	public void insert(Integer data){
		Node node = new Node(data);
		if(root == null){
			root = node;
		}else {
			Node current = root;
			while(current != null){
				if(node.data < current.data){
					if(current.left != null){
						current = current.left;
					}else {
						current.left = node;
						break;
					}
				}else {
					if(current.right != null){
						current = current.right;
					}else {
						current.right = node;
						break;
					}
				}
				
			}
		}
		insertIntoMap(node);
		
	}
	
	 
	
	private class Node{
		Integer data;
		Node left;
		Node right;
		Node parent;
		
		public Node(Integer data){
			this.data = data;
		}
		
		public String toString(){
			return data.toString();
		}
	}
	
	

}
