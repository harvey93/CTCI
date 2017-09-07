package hackerRank;

import java.util.HashMap;

public class Trie {

	private TrieNode head;
	
	public Trie(){
		this.head = new TrieNode(null);
	}
	
	public boolean find(String str){
		boolean res = false;
		int i = 0;
		TrieNode current = head;
		while(i < str.length()){
			Character c = str.charAt(i);
			if(current.children.containsKey(c)){
				current = current.children.get(c);
			}else {
				break;
			}
			
			if ((i == str.length() - 1) && current.isWord) {
				res = true;
			}

			i++;		
		}
		return res;

	}
	
	public int wordStart(String str){
		int res = 0;
		int i = 0;
		TrieNode current = head;
		while(i < str.length()){
			Character c = str.charAt(i);
			if(current.children.containsKey(c)){
				current = current.children.get(c);
			}else {
				break;
			}
			
			if ((i == str.length() - 1)) {
				res = current.wordCount;
			}

			i++;		
		}

		return res;
	}
	
	public void addString(String str){
		int i = 0;
		TrieNode current = head;
		while(i < str.length()){
			Character c = str.charAt(i);
			current.wordCount++;
			if(current.children.containsKey(c)){
				current = current.children.get(c);
			}else {
				current = addNode(current, c);
			}
			
			if (i == str.length() - 1) {
				current.isWord = true;
			}

			i++;		
		}
	}

	
	private TrieNode addNode(TrieNode node, char c){
		TrieNode newNode = new TrieNode(c);
		node.children.put(c, newNode);
		return newNode;
	}
	
	public String toString(){
		return head.toString();
	}
	
}

class TrieNode{
	Character data;
	HashMap<Character, TrieNode> children;
	boolean isWord;
	int wordCount;
	
	public TrieNode(Character data){
		this.children = new HashMap<>();
		this.data = data;
	}
	
	public String toString(){
		if(data == null){
			return "Data: null | Children: " + children.toString();
		}
		return "Data: " + data.toString() + "| Children: " + children.toString();
	}
}
