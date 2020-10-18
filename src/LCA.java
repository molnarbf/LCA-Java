import java.util.ArrayList;
import java.util.List; 

// Java implementation for finding the Lowest Common Ancestor of two nodes in a Binary Tree

class Node {
	int data;
	Node left;
	Node right;

	public Node (int item) {
		data = item;
		left = null;
		right = null;
	}
}

public class LCA {
	Node root;
	private List<Integer> path = new ArrayList<Integer>();

	// function to find and store path from root node to given node
	private boolean findPath(Node root, Node node, List<Integer> path) {
		if(root == null) {
			return false;
		}

		// add node to path, will be removed later if it is not in the path from the root to node
		path.add(root.data);
		// check if the root is the same as node
		if(root.data == node.data ) {
			return true;
		}

		if(root.left != null && findPath(root.left, node, path)) {
			return true; 
		} 
		if(root.right != null && findPath(root.right, node, path)) {
			return true;
		}
		
		// if not present in subtree rooted with the root node, remove the root from the path list
		path.remove(path.size()-1);
		return false;
	}
}


