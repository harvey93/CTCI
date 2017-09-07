package ch4;
import java.util.*;

//Graph<String> graph = new Graph<>();
//
//graph.addNode("f", "F");
//graph.addNode("c", "C");
//graph.addNode("b", "B");
//graph.addNode("a", "A");
//graph.addNode("e", "E");
//
//graph.addNode("d", "D");
//graph.addNode("g", "G");
//
//graph.addEdge("f", "c", 10);
//graph.addEdge("f", "b", 10);
//graph.addEdge("f", "a", 10);
//
//graph.addEdge("c", "a", 10);
//graph.addEdge("b", "a", 10);
//graph.addEdge("b", "e", 10);
//
//graph.addEdge("a", "e", 10);
//
//graph.addEdge("d", "g", 10);

public class Test {

	public static void main(String[] args) {
		
		
		Node<Integer> node1 = new Node<>(10);
		
		Node<Integer> node2 = new Node<>(5);
		Node<Integer> node3 = new Node<>(-3);
		
		
		Node<Integer> node4 = new Node<>(3);
		Node<Integer> node5 = new Node<>(2);
		
		
		Node<Integer> node6 = new Node<>(11);
		
		Node<Integer> node7 = new Node<>(3);
		Node<Integer> node8 = new Node<>(-2);
		
		Node<Integer> node9 = new Node<>(1);
		
		
		
		
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		
		node3.setRight(node6);
		
		node4.setLeft(node7);
		node4.setRight(node8);
		
		node5.setRight(node9);
		
		ArrayList<Node<Integer>> list = new ArrayList<>();
		treeList(node1, list);
		System.out.println(list);
		System.out.println(countPathsWithSum(node1, 8));		
		
	}
	
	public static int countPathsWithSum(Node<Integer> node, int sum){
		if(node == null){
			return 0;
		}
		
		int pathsFromRoot = countPathsWithSum(node, sum, 0);
		
		int pathsOnLeft = countPathsWithSum(node.left, sum, 0);
		int pathsOnRight = countPathsWithSum(node.right, sum, 0);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
		
		
	}
	
	public static int countPathsWithSum(Node<Integer> node, int targetSum, int currentSum){
		if(node == null){
			return 0;
		}
		
		currentSum += node.data;
		int totalPaths = 0;
		if(currentSum == targetSum){
			totalPaths++;
		}
		
		totalPaths += countPathsWithSum(node.left, targetSum, currentSum);
		totalPaths += countPathsWithSum(node.right, targetSum, currentSum);
		return totalPaths;
		
	}

	
	
	
	
	public static void treeList(Node<Integer> node, ArrayList<Node<Integer>> list){
		if(node == null){
			list.add(null);
			return;
		}
		list.add(node);
		treeList(node.left, list);
		treeList(node.right, list);
	}
	
	public static boolean checkSideDP(Node<Integer> current, Node<Integer> node, HashMap<Node<Integer>, String> map){
		boolean left = false;
		boolean right = false;
		if(current == node){
			return true;
		}
		if(current.left != null){
			if(map.containsKey(current.left)){
				String side = map.get(current.left);
				if(side.equals("left")){
					right = true;
				}
			}else{
				left = checkSideDP(current.left, node, map);
				if(left){
					map.put(current.left, "left");
				}else {
					map.put(current.left, "right");
				}
			}

		}
		if(current.right != null){
			if(map.containsKey(current.right)){
				String side = map.get(current.right);
				if(side.equals("right")){
					right = true;
				}
			}else{
				right = checkSideDP(current.right, node, map);
				if(right){
					map.put(current.right, "right");
				}else {
					map.put(current.right, "left");

				}
			}
		}
		return left || right;
		
	}

	
	public static Node<Integer> commonAncestorDP(Node<Integer> root, Node<Integer> node1, 
			Node<Integer> node2, HashMap<Node<Integer>, String> map1, HashMap<Node<Integer>, String> map2){
		if(checkSideDP(root.left, node1, map1) && checkSideDP(root.left, node2, map2)){
			return commonAncestorDP(root.left, node1, node2, map1, map2);
		}else if(checkSideDP(root.right, node1, map1) && checkSideDP(root.right, node2, map2)){
			return commonAncestorDP(root.right, node1, node2, map1, map2);
		}else{
			return root;
		}
	}
	
	public static Node<Integer> commonAncestorDP(Node<Integer> root, Node<Integer> node1, Node<Integer> node2){
		HashMap<Node<Integer>, String> map1 = new HashMap<>();
		HashMap<Node<Integer>, String> map2 = new HashMap<>();
		Node<Integer> res = commonAncestorDP(root, node1, node2, map1, map2);
		return res;
	}
	

	

	
	public static boolean isSubTree(Node<Integer> node1, Node<Integer> node2){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		treeString(node1, sb1);
		treeString(node2, sb2);
		
		return sb1.indexOf(sb2.toString()) != -1;
		
	}
		
	public static void treeString(Node<Integer> node, StringBuilder sb){
		if(node == null){
			sb.append("X");
			return;
		}
		sb.append(node.data);
		treeString(node.left, sb);
		treeString(node.right, sb);
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(Node<Integer> node){
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
		
		if(node == null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for(LinkedList<Integer> left : leftSeq){
			for(LinkedList<Integer> right : rightSeq){
				
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				
				weaveLists(left, right, weaved, prefix);
				
				result.addAll(weaved);
			}
		}
		
		return result;
	}
	
	
	
	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, 
			ArrayList<LinkedList<Integer>> results,	LinkedList<Integer> prefix){
//		System.out.println(results);
		if(first.size() == 0 || second.size() == 0){
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
		
	}
	
	public static Node<Integer> commonAncestor2(Node<Integer> root, Node<Integer> node1, Node<Integer> node2){
		
		if(checkSide(root.left, node1) && checkSide(root.left, node2)){
			return commonAncestor2(root.left, node1, node2);
		}else if(checkSide(root.right, node1) && checkSide(root.right, node2)){
			return commonAncestor2(root.right, node1, node2);
		}else{
			return root;
		}
		
	}
	
	public static boolean checkSide(Node<Integer> current, Node<Integer> node){
		boolean left = false;
		boolean right = false;
		if(current == node){
			return true;
		}
		if(current.left != null){
			left = checkSide(current.left, node);
		}
		if(current.right != null){
			right = checkSide(current.right, node);
		}
		return left || right;
		
	}
		
	
	public static Node<Integer> commonAncestor(Node<Integer> node1, Node<Integer> node2){
		Node<Integer> res = null;
		HashSet<Node<Integer>> set = new HashSet<>();
		Node<Integer> current1 = node1;
		while(current1 != null){
			set.add(current1);
			current1 = current1.parent;
		}
		
		
		Node<Integer> current2 = node2;
		while(current2 != null){
			if(set.contains(current2)){
				res = current2;
				break;
			}
			current2 = current2.parent;
		}
		
		return res;
	}
	
	public static ArrayList<GNode<String>> topoSort(Graph<String> graph){
		 ArrayList<GNode<String>> list = new ArrayList<>();
		 HashMap<String, GNode<String>> map = graph.getNodeMap();
		 HashSet<GNode<String>> visited = new HashSet<>();
		 
		 while(visited.size() < map.size()){
			 for(String s1 : map.keySet()){
				 GNode<String> currentNode = map.get(s1);
				 if(currentNode.inEdges.isEmpty() && !visited.contains(currentNode)){
					 
					 for(String s2 : currentNode.outEdges.keySet()){
						 Edge e = currentNode.outEdges.get(s2);
						 String dest = e.destLabel;
						 GNode<String> edgeNode = map.get(dest);
						 edgeNode.inEdges.remove(s1);
					 }
					 list.add(currentNode);
					 visited.add(currentNode);
				 }
			 }
		 }
		 
		 return list;
	}

	
	public static Node<Integer> successor(Node<Integer> node){
		Node<Integer> current = null;
		if(node.right != null){
			current = node.right;
			while(current.left != null){
				current = current.left;
			}	
			return current;
		}else {
			current = node;
			while(current.parent != null){
				if(isLeftChild(current.parent, current)){
					break;
				}
				current = current.parent;
			}
			return current == null ? null : current.parent;
		}
		
	}
	
	public static boolean isLeftChild(Node<Integer> parent, Node<Integer> child){
		return parent.left == child;
	}
	
	
	public static boolean checkBST(Node<Integer> node){
		return checkBST(node, null, null);
	}
	
	public static boolean checkBST(Node<Integer> node, Integer min, Integer max){
		if(node == null){
			return true;
		}
		
		if(min != null && node.data < min){
			return false;
		}
		
		if(max != null && node.data > max){
			return false;
		}
		
		return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
	}
	
	public static int checkHeight(Node<Integer> node){
		if(node == null){
			return 0;
		}
		
		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE){
			return Integer.MAX_VALUE;
		}
		
		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE){
			return Integer.MAX_VALUE;
		}

		
		if(Math.abs(leftHeight - rightHeight) > 1){
			return Integer.MIN_VALUE;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean checkBalanced2(Node<Integer> node){
		return checkHeight(node) != Integer.MIN_VALUE;
	}
	
	public static int getHeight(Node<Integer> node){
		if(node == null){
			return 0;
		}else {
			return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
		
	}
	
	public static boolean checkBalanced(Node<Integer> node){
		if(node == null){
			return true;
		}
		int heightDiff = getHeight(node.left) - getHeight(node.right);
		if(heightDiff > 1){
			return false;
		}
		
		return checkBalanced(node.left) && checkBalanced(node.right);
	}
	
	public static ArrayList<LinkedList<Node<Integer>>> depthListBFS(Node<Integer> node){
		ArrayList<LinkedList<Node<Integer>>> lists = new ArrayList<>();
		LinkedList<Node<Integer>> currentList = new LinkedList<>();
		currentList.add(node);
		while(currentList.size() > 0){
			lists.add(currentList);
			LinkedList<Node<Integer>> parents = currentList;
			currentList = new LinkedList<Node<Integer>>();
			for(Node<Integer> parent: parents){
				if(parent.left != null){
					currentList.add(parent.left);
				}
				if(parent.right != null){
					currentList.add(parent.right);
				}
			}
		}
		
		return lists;

	}
	
	public static ArrayList<LinkedList<Node<Integer>>> depthListDFS(Node<Integer> node){
		ArrayList<LinkedList<Node<Integer>>> lists = new ArrayList<>();
		depthListDFS(node, lists, 0);
		return lists;
	}
	
	public static void depthListDFS(Node<Integer> node, 
		ArrayList<LinkedList<Node<Integer>>> lists, int level){
		LinkedList<Node<Integer>> list = null;
		
		if(node == null){
			return;
		}
		
		if(level < lists.size()){
			list = lists.get(level);
		}else {
			list = new LinkedList<>();
			lists.add(list);
		}
		
		list.add(node);
		depthListDFS(node.left, lists, level + 1);
		depthListDFS(node.right, lists, level + 1);
	
		
		
	}
	
	public static Node<Integer> buildBST(int [] arr){
		return buildBST(arr, 0, arr.length - 1);
	}
	
	public static Node<Integer> buildBST(int[] arr, int start, int end){
		if(end < start){
			return null;
		}
		
		int mid = (end + start) / 2;
		
		Node<Integer> node = new Node(arr[mid]);
		node.left = buildBST(arr, 0, mid - 1);
		node.right = buildBST(arr, mid + 1, end);
		return node;
	
		
	}
	
	public static boolean BFS(String label1, String label2, Graph graph){
		boolean res = false;
		LinkedList<GNode> queue = new LinkedList<>();
		HashMap<String, GNode> visited = new HashMap<>();
		
		GNode destNode = graph.getNode(label2);
		
		queue.add(graph.getNode(label1));
		
		while(!queue.isEmpty()){
			GNode currentNode = queue.removeFirst();
			if(currentNode.data == destNode.data){
				res = true;
				break;
			}
			HashMap<String, Edge> edges = currentNode.outEdges;
			
			for(String s : edges.keySet()){
				Edge e = edges.get(s);
				GNode currentConnection = graph.getNode(e.destLabel);
				queue.addLast(currentConnection);
			}
		}
		
		return res;
	}
}
