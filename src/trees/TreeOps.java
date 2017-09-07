package trees;

import java.util.Stack;

public class TreeOps {
	
	public static void reverseTree(Node<Integer> node){
		if(node != null){
			Node<Integer> oldLeft = node.left;
			node.left = node.right;
			node.right = oldLeft;
			reverseTree(node.left);
			reverseTree(node.right);
		}
	}
	
	public static void postOrderTraversal(Node<Integer> node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node);
		}
	}
	
	public static void postOrderStack(Node<Integer> node){
		Stack<Node<Integer>> stack1 = new Stack<>();
		Stack<Node<Integer>> stack2 = new Stack<>();
		
		Node<Integer> current = node;
		stack1.push(current);
		
		while(!stack1.isEmpty()){
			Node<Integer> popped = stack1.pop();
			stack2.push(popped);
			if(popped.left != null){
				stack1.push(popped.left);
			}
			if(popped.right != null){
				stack1.push(popped.right);
			}
		}
		while(!stack2.isEmpty()){
			System.out.println(stack2.pop());
		}
	}
	
	public static void preOrderTraversal(Node<Integer> node){
		if(node != null){
			System.out.println(node);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public static void inOrderTraversal(Node<Integer> node){
		if(node != null){
			inOrderTraversal(node.left);
			System.out.println(node);
			inOrderTraversal(node.right);
		}

	}
	
	public static void inOrderStack(Node<Integer> node){
		
		Stack<Node<Integer>> stack = new Stack<>();
		
		Node<Integer> current = node;
		while(current != null){
			stack.push(current);
			current = current.left;
		}
		
		while(!stack.isEmpty()){
			current = stack.pop();
			System.out.println(stack);
			System.out.println(current);
			if(current.right != null){
				current = current.right;
				
				while(current != null){
					stack.push(current);
					current = current.left;
				}

			}
		}
	}

	

	
	public static void preOrderStack(Node<Integer> node){
		Stack<Node<Integer>> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node<Integer> current = stack.pop();
			if(current != null){
				System.out.println(current);
				stack.push(current.right);
				stack.push(current.left);
			
			}
		}
	}

}
