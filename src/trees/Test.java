package trees;

public class Test {

	public static void main(String[] args) {
	
		Node<Integer> node1 = new Node<>(6);
		
		Node<Integer> node2 = new Node<>(3);
		Node<Integer> node3 = new Node<>(4);
		
		Node<Integer> node4 = new Node<>(7);
		Node<Integer> node5 = new Node<>(3);
		Node<Integer> node6 = new Node<>(8);
		Node<Integer> node7 = new Node<>(1);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		
		node3.left = node6;
		node3.right = node7;
		
		TreeOps.inOrderTraversal(node1);
		System.out.println("----------------");
		TreeOps.reverseTree(node1);
		TreeOps.inOrderTraversal(node1);
		
		
	}
}
