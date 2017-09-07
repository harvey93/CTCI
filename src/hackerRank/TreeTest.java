package hackerRank;


public class TreeTest {
	
	public boolean checkBST(Node node){
		
		return (checkBST(node.left, node.data, Integer.MIN_VALUE) &&
				checkBST(node.right, Integer.MAX_VALUE, node.data));
		
	}
	
	public boolean checkBST(Node node, Integer max, Integer min){
		if(node == null){
			return true;
		}
		if(node.data > min && node.data < max){
			return (checkBST(node.left, node.data, min) && 
						checkBST(node.right, max, node.data));		
		}else {
			return false;
		}
		

	}


}

class Node {
    int data;
    Node left;
    Node right;
 }
